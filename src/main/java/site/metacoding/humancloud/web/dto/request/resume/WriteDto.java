package site.metacoding.humancloud.web.dto.request.resume;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.humancloud.domain.resume.Resume;

@Getter
@Setter
public class WriteDto {
  private String resumeTitle;
  private String resumeEducation;
  private String resumeCareer;
  private String resumePhoto;
  private String resumeLink;

  public Resume toEntity(String resumePhoto) {
    Resume resume = new Resume(this.resumeTitle, this.resumeEducation, this.resumeCareer, resumePhoto,
        this.resumeLink);
    return resume;
  }
}
