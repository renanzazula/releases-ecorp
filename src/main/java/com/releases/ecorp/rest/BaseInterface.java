package com.releases.ecorp.rest;

import com.releases.ecorp.rest.common.dto.ReleaseStepDto;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;


@RequestMapping(produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
public interface BaseInterface<I extends ReleaseStepDto> {

    @PostMapping("/next")
    ResponseEntity<ReleaseStepDto> next(@RequestBody I ReleaseStep) throws BindException;

    @PostMapping("/previous")
    ResponseEntity<ReleaseStepDto> previous(@RequestBody I ReleaseStep) throws BindException;

    @PostMapping("/save")
    ResponseEntity<ReleaseStepDto> save(@RequestBody I ReleaseStep) throws BindException;

}
