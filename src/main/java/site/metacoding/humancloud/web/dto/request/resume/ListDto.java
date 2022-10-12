package site.metacoding.humancloud.web.dto.request.resume;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListDto {
    private Integer resumeId;
    private String resumeTitle;
    private Integer resumeReadCount;
    private Timestamp resumeCreatedAt;
}
