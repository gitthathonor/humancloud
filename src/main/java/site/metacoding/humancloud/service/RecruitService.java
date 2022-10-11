package site.metacoding.humancloud.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.category.Category;
import site.metacoding.humancloud.domain.category.CategoryDao;
import site.metacoding.humancloud.domain.company.Company;
import site.metacoding.humancloud.domain.company.CompanyDao;
import site.metacoding.humancloud.domain.recruit.Recruit;
import site.metacoding.humancloud.domain.recruit.RecruitDao;
import site.metacoding.humancloud.web.dto.request.recruit.SaveDto;

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
        recruitPS.setCategory(categoryList);
        recruitPS.setCompany(companyPS);
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
}
