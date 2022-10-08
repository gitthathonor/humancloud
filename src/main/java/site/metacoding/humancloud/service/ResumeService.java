package site.metacoding.humancloud.service;

import java.util.ArrayList;
import java.util.List;

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
    public List<Resume> 이력서목록보기(){
        return resumeDao.findAll();
    }

    public List<Resume>  분류별이력서목록보기(String category){
        List<Category> categories = categoryDao.findByName(category);
        List<Resume> resumes = new ArrayList<>();
        for(Category c : categories){
            resumes.add(resumeDao.findById(c.getCategoryUserId()));
        }
        return resumes;
    }
    public List<Resume> 경력순보기(){
        List<Resume> categories = resumeDao.orderByCareer();
        return categories;
    }
    public List<Resume> 학력순보기(){
        return resumeDao.orderByEducation();
    }
    public void 추천순보기(Integer companyId){
        // 1. 로그인 하지 않으면 최신순?
        // 2. 로그인시 category에 해당하는 걸로

        // 카테고리에서 이 기업이 관심 갖는 분야를 찾아내기
        List<Category> categories = categoryDao.findByCompanyId(companyId);

        // 그 기업에 해당하는 유저 뽑아내기
        List<Category> categoryUser = new ArrayList<>();
        for (Category category : categories) {
        }

        // 카운트 하기
    }
}
