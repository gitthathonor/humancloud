package site.metacoding.humancloud.service;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.metacoding.humancloud.domain.category.Category;
import site.metacoding.humancloud.domain.category.CategoryDao;
import site.metacoding.humancloud.domain.company.Company;
import site.metacoding.humancloud.domain.company.CompanyDao;
import site.metacoding.humancloud.domain.recruit.Recruit;
import site.metacoding.humancloud.domain.recruit.RecruitDao;
import site.metacoding.humancloud.domain.resume.Resume;
import site.metacoding.humancloud.web.RecruitController;
import site.metacoding.humancloud.web.dto.request.recruit.SaveDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class RecruitService {

    private final RecruitDao recruitDao;
    private final CategoryDao categoryDao;
    private final CompanyDao companyDao;

    public Recruit 공고상세페이지(Integer recruitId) {
        Recruit recruitPS = recruitDao.findById(recruitId);
        Company companyPS = companyDao.findById(recruitPS.getRecruitCompanyId());
        List<Category> categoryList = categoryDao.findByRecruitId(recruitId);
        List<Recruit> recruitListByCompanyId = recruitDao.findByCompanyId(recruitPS.getRecruitCompanyId());
        recruitPS.setCategory(categoryList);
        recruitPS.setCompany(companyPS);
        recruitPS.setRecruitListByCompanyId(recruitListByCompanyId);
        return recruitPS;
    }

    @Transactional
    public void 구인공고작성(SaveDto saveDto) {

        recruitDao.save(saveDto);

        System.out.println(saveDto.getRecruitId());
        Category category = new Category(saveDto.getRecruitId(), null);

        for (String i : saveDto.getRecruitCategoryList()) {
            category.setCategoryName(i);
            categoryDao.save(category);
        }

        return;
    }

    public Map<String, Object> 채용공고목록보기() {
        Map<String, Object> recruitList = new HashMap<>();
        recruitList.put("recruit", recruitDao.findAll());
        recruitList.put("category", categoryDao.distinctName());
        return recruitList;
    }

    public List<Recruit> 분류별채용공고목록보기(String categoryName) {
        List<Category> categories = categoryDao.findByName(categoryName);

        List<Recruit> recruits = new ArrayList<>();

        for (Category c : categories) {
            if (c.getCategoryResumeId() != null) {
                recruits.add(recruitDao.findById(c.getCategoryRecruitId()));
            }
        }
        return recruits;
    }

    public List<Recruit> 정렬하기(String orderList) {
        if (orderList.equals("recent")) {
            return 최신순보기();
        } else if (orderList.equals("career")) {
            return 경력순보기();
        }
        // else {
        // return 추천순보기(companyId);
        // }
        return null;
    }

    public List<Recruit> 최신순보기() {
        return recruitDao.orderByCreatedAt();
    }

    public List<Recruit> 경력순보기() {
        return recruitDao.orderByCareer();
    }

    // 페이지 맨 위 추천 기업 리스트 : 매개변수-세션값
    public void 추천기업리스트보기(Integer userId) {
        if (userId == null) {
            최신순기업리스트();
        } else {
            추천순기업리스트(userId); // 로그인 후, 구독기업이 있으면 최신순 대신 구독기업을 보여줄까
        }
    }

    public void 최신순기업리스트() {
        List<Company> companies = new ArrayList<>();
        List<Recruit> recruitPS = recruitDao.orderByCreatedAt(); // 내림차순 작성일 정렬
        for (Recruit r : recruitPS) {
            Company companyPS = companyDao.findById(r.getRecruitCompanyId());
            if (companies.size() > 5) {
                break;
            }
        }
        // return companies;
    }

    public void 추천순기업리스트(Integer userId) {
        // List<Category> categoryPS = categoryDao.findByUserId(userId);
        // List<String> categoryName = new ArrayList<>();
        //
        // for(Category c : categoryPS){
        // categoryName.add( c.getCategoryName());
        // }
        // List<Company> companyList = new ArrayList<>();
        // for(String c : categoryName){
        // Company companies = categoryDao.findByCompanyCategory(c);
        // companyList.add(companies);
        // }
        // return companyList;
    }
}