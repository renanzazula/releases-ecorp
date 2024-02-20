package com.releases.ecorp.rest.common.dto;

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
public class DeliverySingOffDto extends ReleaseStepDto implements Serializable {

    private ReleaseDto release;
    private ReleaseDetailsDto details;
    private ApprovalDto releaseOwner;
    private ApprovalDto qualityAssurance;
    private ApprovalDto accountManagement;
    private String comments;
    private List<ReleaseNotesDto> releaseNotes;

}
