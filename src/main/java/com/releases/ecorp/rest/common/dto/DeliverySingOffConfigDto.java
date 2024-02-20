package com.releases.ecorp.rest.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class DeliverySingOffConfigDto implements Serializable {

    private String id;

    private ReleaseDto  releaseVersion;
    private ApprovalDto releaseOwner;
    private ApprovalDto qualityAssurance;
    private ApprovalDto accountManagement;
    private ReleaseDetailsDto details;

}
