package com.releases.ecorp.rest.common.dto;

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
public class BusinessRiskAnalysisDto implements Serializable {

    private List<ReleaseNotesDto> releaseNotes;
}
