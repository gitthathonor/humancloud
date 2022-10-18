package site.metacoding.humancloud.service;

import lombok.RequiredArgsConstructor;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import site.metacoding.humancloud.domain.company.Company;
import site.metacoding.humancloud.domain.subscribe.Subscribe;
import site.metacoding.humancloud.domain.subscribe.SubscribeDao;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SubscribeService {

    private final SubscribeDao subscribeDao;

    public void 구독취소(@Param("userId") Integer userId, @Param("companyId") Integer companyId){
        subscribeDao.deleteByUserCompany(userId, companyId);
    }

    public boolean 구독확인(Subscribe subscribe){
        if(subscribeDao.findById(subscribe.getSubscribeUserId(), subscribe.getSubscribeCompanyId())==null){
            구독하기(subscribe);
            return true;
        }
        return false;
    }

    public void 구독하기(Subscribe subscribe){
            subscribeDao.save(subscribe);
    }

    public List<Company> 구독기업보기(Integer userId){
        return subscribeDao.findCompanyByUserId(userId);
    }
}
