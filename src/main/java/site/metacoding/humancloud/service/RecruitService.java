package site.metacoding.humancloud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.metacoding.humancloud.domain.category.Category;
import site.metacoding.humancloud.domain.category.CategoryDao;
import site.metacoding.humancloud.domain.company.Company;
import site.metacoding.humancloud.domain.company.CompanyDao;
import site.metacoding.humancloud.domain.recruit.Recruit;
import site.metacoding.humancloud.domain.recruit.RecruitDao;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RecruitService {

    private final RecruitDao recruitDao;
    private final CompanyDao companyDao;
    private final CategoryDao categoryDao;

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
}
