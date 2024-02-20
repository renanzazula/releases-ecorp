package com.releases.ecorp.rest.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseStepDto implements Serializable {

    private UUID id;
    private List<StepEnum> currentStep;
    private ReleaseStepDto currentStepData;

    @JsonIgnore
    private HashMap<StepEnum, ReleaseStepDto> currentStepMapData;

}
