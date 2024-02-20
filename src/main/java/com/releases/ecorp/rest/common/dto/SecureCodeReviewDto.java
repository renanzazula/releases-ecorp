package com.releases.ecorp.rest.common.dto;

import com.releases.ecorp.rest.common.dto.ReleaseDto;
import com.releases.ecorp.rest.common.dto.ApprovalDto;
import com.releases.ecorp.rest.common.dto.ReleaseNotesDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class SecureCodeReviewDto implements Serializable {

    private ReleaseDto releaseVersion;
    private ApprovalDto technicalLeader;
    private String comments;
    private List<ReleaseNotesDto> releaseNotes;

}
