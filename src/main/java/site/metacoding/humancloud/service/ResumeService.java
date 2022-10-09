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
import site.metacoding.humancloud.web.dto.request.resume.SaveDto;


@RequiredArgsConstructor
@Service
public class ResumeService {

    private final ResumeDao resumeDao;
    private final RecruitDao recruitDao;
    private final CompanyDao companyDao;
    private final CategoryDao categoryDao;

    public void 이력서저장(SaveDto saveDto) {
        resumeDao.save(saveDto);
        for (String category : saveDto.getCategoryList()) {
            Category categoryElement = new Category(1,category);
            categoryDao.save(categoryElement);
        }


    }

    // 페이지 맨 위 추천 기업 리스트 : 매개변수-세션값
    public void 추천기업리스트보기(Integer userId){
        if(userId==null){
            최신순기업리스트();
        } else {
            추천순기업리스트(userId); // 로그인 후, 구독기업이 있으면 최신순 대신 구독기업을 보여줄까
        }
    }
    public void 최신순기업리스트(){
        List<Company> companies = new ArrayList<>();
        List<Recruit> recruitPS = recruitDao.orederByCreatedAt(); // 내림차순 작성일 정렬
        for(Recruit r : recruitPS){
            Company companyPS = companyDao.findById(r.getRecruitCompanyId());
            if(companies.size()>5){
                break;
            }
        }
        // return companies;
    }
    public void 추천순기업리스트(Integer userId){
        List<Category> categoryPS = categoryDao.findByUserId(userId);
        List<String> categoryName = new ArrayList<>();   

        for(Category c : categoryPS){
            categoryName.add( c.getCategoryName());
        }
        List<Company> companyList = new ArrayList<>();
        for(String c : categoryName){
            Company companies = categoryDao.findByCompanyCategory(c);
            companyList.add(companies);
        }
        // return companyList;
    }




    // 이력서 목록
    public List<Resume> 이력서목록보기(){
        return resumeDao.findAll();
    }

    public List<Recruit>  분류별이력서목록보기(String category){
        List<Category> categories = categoryDao.findByName(category);
        List<Recruit> recruits = new ArrayList<>();
        for(Category c : categories){
            recruits.add(recruitDao.findById(c.getCategoryCompanyId()));
        }
        return recruits;
    }
    public List<Resume> 경력순보기(){
        List<Resume> categories = resumeDao.orderByCareer();
        return categories;
    }
    public void 학력순보기(){}
    public void 추천순보기(Integer companyId){
        // 1. 로그인 하지 않으면 최신순?
        // 2. 로그인시 category에 해당하는 걸로
        List<Category> categories = categoryDao.findByCompanyId(companyId);
        List<Category> categoryUser = new ArrayList<>();
        for (Category category : categories) {
            
        }
    }
}
