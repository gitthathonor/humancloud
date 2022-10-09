package site.metacoding.humancloud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.category.Category;
import site.metacoding.humancloud.domain.category.CategoryDao;
import site.metacoding.humancloud.domain.company.Company;
import site.metacoding.humancloud.domain.company.CompanyDao;
import site.metacoding.humancloud.domain.recruit.Recruit;
import site.metacoding.humancloud.domain.recruit.RecruitDao;
import site.metacoding.humancloud.domain.resume.Resume;
import site.metacoding.humancloud.domain.resume.ResumeDao;

@RequiredArgsConstructor
@Service
public class ResumeService {

    private final ResumeDao resumeDao;
    private final CategoryDao categoryDao;

    public void 이력서저장(Resume resume) {
        resumeDao.save(resume);
      }

    // 이력서 목록
    public Map<String, Object> 이력서목록보기(){
        Map<String, Object> resumeList = new HashMap<>();
        resumeList.put("resume", resumeDao.findAll());
        resumeList.put("category", categoryDao.distinctName());
        return resumeList;
    }

    public List<Resume> 분류별이력서목록보기(String category){
        List<Category> categories = categoryDao.findByName(category);

        List<Resume> resumes = new ArrayList<>();

        for(Category c : categories){
            if(c.getCategoryResumeId()!=null){
                resumes.add(resumeDao.findById(c.getCategoryResumeId()));
            }
        }
        return resumes;
    }

    public List<Resume> 정렬하기(String orderList, Integer companyId){
        if(orderList=="recent"){
            return 최신순보기();
        } else if (orderList=="career"){
            return 경력순보기();
        } else if (orderList=="education"){
            return 학력순보기();
        }
//        else {
//            return 추천순보기(companyId);
//        }
        return null;
    }

    public List<Resume> 최신순보기(){
        return resumeDao.orderByCreatedAt();
    }
    public List<Resume> 경력순보기(){
        return resumeDao.orderByCareer();
    }
    public List<Resume> 학력순보기(){
        return resumeDao.orderByEducation();
    }
    public void 추천순보기(Integer companyId){
        // 1. 로그인 하지 않으면 최신순?
        // 2. 로그인시 category에 해당하는 걸로

        // 기업의 이력서 목록에 해당되는 관심 이름 목록 불러오기
        List<Category> recruitList = categoryDao.joinRecruitCategory(companyId);

        // 그 기업에 해당하는 이력서 뽑아내기
        List<List<Resume>> resumeList = new ArrayList<>();
        for (Category c: recruitList) {
            resumeList.add(categoryDao.findByResumeCategory(c.getCategoryName()));
        }

        // 리스트 빈도수 카운트
        Map<Integer, Integer> countResume = new HashMap<>();
        for(List<Resume> x : resumeList){
            for(int i=0;i<x.size();i++){
                Integer count = countResume.get(x.get(i).getResumeId());
                if(count==null){
                    countResume.put(x.get(i).getResumeId(), 1);
                } else {
                    countResume.put(x.get(i).getResumeId(), countResume.get(x.get(i).getResumeId())+1);
                }
            }
        }

        System.out.println(countResume.get(1));

    }
}
