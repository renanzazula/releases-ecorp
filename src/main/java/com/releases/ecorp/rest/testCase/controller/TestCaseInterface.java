package com.releases.ecorp.rest.testCase.controller;

import com.releases.ecorp.rest.common.dto.ReleaseStepDto;
import com.releases.ecorp.rest.common.dto.DeliverySingOffConfigDto;
import com.releases.ecorp.rest.common.dto.DeliverySingOffDto;
import com.releases.ecorp.rest.common.dto.FileUploadDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping(TestCaseController.BASE_URL)
public interface TestCaseInterface {

    @GetMapping("/config")
    ResponseEntity<DeliverySingOffConfigDto> config();

    @PostMapping("/next")
    ResponseEntity<ReleaseStepDto> next(@RequestBody DeliverySingOffDto releaseStepDto) throws BindException;

    @PostMapping("/save")
    ResponseEntity<ReleaseStepDto> save(@RequestBody DeliverySingOffDto releaseStepDto) throws BindException;

    @PostMapping("/import")
    ResponseEntity<FileUploadDto> importReleaseNotes(@RequestParam("file") MultipartFile multipartFile) throws IOException;


}
