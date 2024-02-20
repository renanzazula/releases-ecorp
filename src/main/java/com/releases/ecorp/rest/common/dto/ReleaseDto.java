package com.releases.ecorp.rest.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseDto implements Serializable {

    private String releaseId;
    private String customer;
    private String requester;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate requestDate;
    private boolean urgent;


}
