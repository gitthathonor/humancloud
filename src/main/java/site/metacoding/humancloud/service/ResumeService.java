package site.metacoding.humancloud.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.humancloud.domain.resume.Resume;
import site.metacoding.humancloud.domain.resume.ResumeDao;

@RequiredArgsConstructor
@Service
public class ResumeService {

  private final ResumeDao resumeDao;

  public void 이력서저장(Resume resume) {
    resumeDao.save(resume);
  }
}
