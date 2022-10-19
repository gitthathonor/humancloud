package site.metacoding.humancloud.service;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.apache.ibatis.annotations.Param;
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
import site.metacoding.humancloud.web.dto.response.recruit.RecruitDetail;

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
    public void 구인공고업데이트(SaveDto saveDto) {
        // 영속화 : id 로 공고페이지 찾음
        Recruit recruitPS = recruitDao.findById(saveDto.getRecruitId());
        if (recruitPS != null) {
            recruitPS.recruitUpdate(saveDto);
        }

        Category category = new Category(saveDto.getRecruitId(), null, null);

        // 기존의 카테고리 없애고
        categoryDao.deleteByRecruitId(saveDto.getRecruitId());
        // 새로 수정된 사항대로 체크리스트 INSERT
        for (String i : saveDto.getRecruitCategoryList()) {
            category.setCategoryName(i);
            categoryDao.save(category);
        }

        recruitDao.update(recruitPS);
    }

    @Transactional
    public void 구인공고작성(SaveDto saveDto) {
        recruitDao.save(saveDto);
        Category category = new Category(saveDto.getRecruitId(), null, null);

        for (String i : saveDto.getRecruitCategoryList()) {
            category.setCategoryName(i);
            categoryDao.save(category);
        }

        return;
    }

    public Map<String, Object> 채용공고목록보기(String title) {

        if (title == null || title == "") {
            Map<String, Object> recruitList = new HashMap<>();
            recruitList.put("recruit", recruitDao.joinCompanyRecruit());
            recruitList.put("category", categoryDao.distinctName());
            return recruitList;
        }
        Map<String, Object> recruitList = new HashMap<>();
        recruitDao.findByTitle(title);
        recruitList.put("recruit", recruitDao.findByTitle(title));
        System.out.println("===============");
        System.err.println(title);
        System.out.println(recruitDao.findByTitle(title));
        System.out.println("===============");
        return recruitList;
    }

    public List<Recruit> 분류별채용공고목록보기(String categoryName) {
        List<Category> categories = categoryDao.findByName(categoryName);

        List<Recruit> recruits = new ArrayList<>();
        for (Category c : categories) {
            if (c.getCategoryRecruitId() != null) {
                recruits.add(recruitDao.findById(c.getCategoryRecruitId()));
            }
        }
        return recruits;
    }

    public List<Recruit> 정렬하기(@Param("orderList") String orderList, Integer userId) {
        if (orderList.equals("recent")) {
            return 최신순보기();
        } else if (orderList.equals("career")) {
            return 경력순보기();
        } else {
            return 추천순보기(userId);
        }
    }

    public List<Recruit> 최신순보기() {
        return recruitDao.orderByCreatedAt();
    }

    public List<Recruit> 경력순보기() {
        return recruitDao.orderByCareer();
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
    }

    public List<Recruit> 추천순보기(Integer userId) {
        return recruitDao.orderByrecommend(userId);
    }

    @Transactional
    public Integer 공고삭제하기(Integer recruitId) {
        Recruit recruitPS = recruitDao.findById(recruitId);
        if (recruitPS != null) {
            // 기존의 카테고리 없애고
            categoryDao.deleteByRecruitId(recruitId);
            recruitDao.deleteById(recruitId);

            return 1;
        }
        return 0;

    }
}