package site.metacoding.humancloud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.metacoding.humancloud.domain.subscribe.Subscribe;
import site.metacoding.humancloud.domain.subscribe.SubscribeDao;

@RequiredArgsConstructor
@Service
public class SubscribeService {

    private final SubscribeDao subscribeDao;

    public void 구독하기(Subscribe subscribe){
        Subscribe subscribe1 = new Subscribe(subscribe.getSubscribeUserId(), subscribe.getSubscribeCompanyId());
        subscribeDao.save(subscribe1);
    }
}
