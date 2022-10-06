package site.metacoding.humancloud.service;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.category.Category;
import site.metacoding.humancloud.domain.category.CategoryDao;
import site.metacoding.humancloud.domain.company.Company;
import site.metacoding.humancloud.domain.resume.ResumeDao;
import site.metacoding.humancloud.domain.user.User;
import site.metacoding.humancloud.domain.user.UserDao;
import site.metacoding.humancloud.web.dto.user.JoinDto;
import site.metacoding.humancloud.web.dto.user.LoginDto;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserDao userDao;
    private final CategoryDao categoryDao;

    public int 회원가입(JoinDto joinDto){
        boolean checkUsername = 유저네임중복체크(joinDto.getUsername());
        if(checkUsername==true){
            userDao.save(joinDto);
            for(String category : joinDto.getCategoryList()){
                Category categoryElement = new Category(joinDto.getUserId(), category);
                categoryDao.save(categoryElement);
            }
            return 1;
        }
        return 0;
    }
    public boolean 유저네임중복체크(String username){
        User userPS = userDao.findByUsername(username);
        if(userPS==null){
            return true;
        } else{
            return false;
        }
    }

    public boolean 로그인(Integer userId, LoginDto loginDto){
        User userPS = userDao.findById(userId);
        if(loginDto.getUsername()!=userPS.getUsername()){
            return false;
        } else if (loginDto.getPassword()!=userPS.getPassword()){
            return false;
        }
        return true;
    }

    public void 메인페이지구성(){ // 깔끔하게 구현되면 컨트룰러로 옮길거
        //  기본 유저 정보
        유저정보보기(null);
        
        // 관심분야보기
        List<String> categoryList = 관심분야목록(null);

        // 관심 분야가 겹치는 기업 매칭(추천)
        List<Company> companyList = 기업매칭리스트(categoryList);

        // 이력서 내용 필요
        이력서보기();
    }











    
    // 서비스 내에서 사용하는 메서드

    public void 유저정보보기(Integer userId){
        // 유저 정보
        User userPS = userDao.findById(userId);

        // 전화번호 포매팅
        String fomat = "(\\d{3})(\\d{3,4})(\\d{4})";
        if(Pattern.matches(fomat, userPS.getPhoneNumber())){
            String result =userPS.getPhoneNumber().replaceAll(fomat, "$1-$2-$3");
            userPS.toPhoneNumber(result);
        }
    }

    public void 이력서보기(){
        // 열람 횟수 보기(리절트 타입 인트면 좋음)
        // int CountResume; // select sum(resume_readcount) from resume where resume_user_id=1;
        // 이력서 목록보기 (제목, 등록카테고리, 날짜 정도 필요)
        // resumeDao.findByUserId(userId); // 리절트 타입 : resume
    }

    public List<String> 관심분야목록(Integer userId){
        List<Category> categoryPS = categoryDao.findByUserId(userId);
        List<String> categoryName = new ArrayList<>();
        for(Category c : categoryPS){
            categoryName.add( c.getCategoryName());
        }
        return categoryName;
    }
    public List<Company> 기업매칭리스트(List<String> categoryList){
        List<Company> companyList = new ArrayList<>();
        for(String c : categoryList){
            Company companies = categoryDao.findByCompanyCategory(c);
            companyList.add(companies);
        }
        return companyList;
    }
}
