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
public class ReleaseNotesDto implements Serializable {

    private String redmineIssue;
    private String status;
    private String subject;
    private String comments;


}
