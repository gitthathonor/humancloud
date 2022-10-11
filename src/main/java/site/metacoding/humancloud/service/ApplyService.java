package site.metacoding.humancloud.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.apply.ApplyDao;

@RequiredArgsConstructor
@Service
public class ApplyService {

  private final ApplyDao applyDao;

  public void 지원하기() {
    applyDao.save();
  }
}
