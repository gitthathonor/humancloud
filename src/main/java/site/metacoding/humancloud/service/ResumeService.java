package site.metacoding.humancloud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.category.Category;
import site.metacoding.humancloud.domain.category.CategoryDao;
import site.metacoding.humancloud.domain.resume.Resume;
import site.metacoding.humancloud.domain.resume.ResumeDao;
import site.metacoding.humancloud.domain.user.UserDao;
import site.metacoding.humancloud.web.dto.request.resume.SaveDto;
import site.metacoding.humancloud.web.dto.request.resume.UpdateDto;
import site.metacoding.humancloud.web.dto.response.page.PagingDto;

@RequiredArgsConstructor
@Service
public class ResumeService {

    private final ResumeDao resumeDao;
    private final CategoryDao categoryDao;
    private final UserDao userDao;

    @Transactional(rollbackFor = RuntimeException.class)
    public void 이력서삭제(Integer resumeId) {
        resumeDao.deleteById(resumeId);
        categoryDao.deleteByResumeId(resumeId);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void 이력서수정(Integer resumeId, UpdateDto updateDto) {
        resumeDao.update(updateDto);
        categoryDao.deleteByResumeId(resumeId);
        for (String category : updateDto.getCategoryList()) {
            Category categoryElement = new Category(resumeId, category);
            categoryDao.save(categoryElement);
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void 이력서저장(SaveDto saveDto) {
        resumeDao.save(saveDto);
        for (String category : saveDto.getCategoryList()) {
            Category categoryElement = new Category(saveDto.getResumeId(), category);
            categoryDao.save(categoryElement);
        }
    }

    public Map<String, Object> 이력서상세보기(Integer resumeId, Integer userId) {
        Map<String, Object> resumeDetail = new HashMap<>();
        resumeDetail.put("resume", resumeDao.findById(resumeId));
        resumeDetail.put("category", categoryDao.findByResumeId(resumeId));
        resumeDetail.put("user", userDao.findById(userId));
        return resumeDetail;
    }

    // 이력서 목록
    public Map<String, Object> 이력서목록보기(Integer page) {
        if (page == null) {
			page = 0;
		}
		int startNum = page * 20;
		PagingDto paging = resumeDao.paging(page);
		paging.dopaging();

        Map<String, Object> resumeList = new HashMap<>();
        resumeList.put("paging", paging);
        resumeList.put("resume", resumeDao.findAll(startNum));
        resumeList.put("category", categoryDao.distinctName());
        return resumeList;
    }

    public List<Resume> 분류별이력서목록보기(String category) {
        List<Category> categories = categoryDao.findByName(category);

        List<Resume> resumes = new ArrayList<>();

        for (Category c : categories) {
            if (c.getCategoryResumeId() != null) {
                resumes.add(resumeDao.findById(c.getCategoryResumeId()));
            }
        }
        return resumes;
    }

    public List<Resume> 정렬하기(@Param("orderList") String orderList, @Param("companyId") Integer companyId) {
        if (orderList.equals("recent")) {
            return 최신순보기();
        } else if (orderList.equals("career")) {
            return 경력순보기();
        } else if (orderList.equals("education")) {
            return 학력순보기();
        } else {
            return 추천순보기(companyId);
        }
    }

    public List<Resume> 최신순보기() {
        return resumeDao.orderByCreatedAt();
    }

    public List<Resume> 경력순보기() {
        return resumeDao.orderByCareer();
    }

    public List<Resume> 학력순보기() {
        return resumeDao.orderByEducation();
    }

    public List<Resume> 추천순보기(Integer companyId) {
        return resumeDao.orderByRecommend(companyId);
    }

    public void 열람횟수증가(Integer resumeId){
        resumeDao.updateReadCount(resumeId);
    }
}
