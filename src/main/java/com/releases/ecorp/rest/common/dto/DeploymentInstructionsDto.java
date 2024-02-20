package com.releases.ecorp.rest.common.dto;

import com.releases.ecorp.rest.common.dto.ReleaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class DeploymentInstructionsDto implements Serializable {

    private ReleaseDto releaseVersion;
}
