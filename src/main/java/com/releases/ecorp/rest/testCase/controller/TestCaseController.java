package com.releases.ecorp.rest.testCase.controller;

import com.releases.ecorp.rest.BaseController;
import com.releases.ecorp.rest.common.dto.ReleaseDetailsDto;
import com.releases.ecorp.rest.common.dto.ReleaseDto;
import com.releases.ecorp.rest.common.dto.ReleaseStepDto;
import com.releases.ecorp.rest.common.dto.ApprovalDto;
import com.releases.ecorp.rest.common.dto.DeliverySingOffConfigDto;
import com.releases.ecorp.rest.common.dto.DeliverySingOffDto;
import com.releases.ecorp.rest.common.dto.FileUploadDto;
import com.releases.ecorp.services.importRelease.FileUploadUtil;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.UUID;


@RestController
@AllArgsConstructor
public class TestCaseController extends BaseController<DeliverySingOffDto> implements TestCaseInterface {

    public static final String BASE_URL = "/private/v1/testCase";

    @Override
    public ResponseEntity<DeliverySingOffConfigDto> config() {
        DeliverySingOffConfigDto deliverySingOffConfigDto = new DeliverySingOffConfigDto();

        ReleaseDto releaseVersion = new ReleaseDto();
        releaseVersion.setReleaseId(UUID.randomUUID().toString());
        releaseVersion.setCustomer("SNB - Saudi National Bank");
        releaseVersion.setRequester("Abdulelah Tariq Matboli");
        releaseVersion.setRequestDate(LocalDate.now());
        deliverySingOffConfigDto.setReleaseVersion(releaseVersion);

        ApprovalDto releaseOwner = new ApprovalDto();
        releaseOwner.setAuthorizedBy("Guillermo Rodriguez");
        releaseOwner.setJobTitle("PM");
        releaseOwner.setDate(LocalDate.now());
        deliverySingOffConfigDto.setReleaseOwner(releaseOwner);

        ApprovalDto qualityAssurance = new ApprovalDto();
        qualityAssurance.setAuthorizedBy("Manuel Garcia");
        qualityAssurance.setJobTitle("QA Manager");
        qualityAssurance.setDate(LocalDate.now());
        deliverySingOffConfigDto.setQualityAssurance(qualityAssurance);

        ApprovalDto accountManagement = new ApprovalDto();
        accountManagement.setAuthorizedBy("Manuel Garcia");
        accountManagement.setJobTitle("Acc Mg");
        accountManagement.setDate(LocalDate.now());
        deliverySingOffConfigDto.setAccountManagement(accountManagement);

        ReleaseDetailsDto releaseDetailsDto = new ReleaseDetailsDto();
        releaseDetailsDto.setApplication("New eCorp/Admin");
        releaseDetailsDto.setDate(LocalDate.now());
        deliverySingOffConfigDto.setDetails(releaseDetailsDto);return new ResponseEntity<>(deliverySingOffConfigDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ReleaseStepDto> next(DeliverySingOffDto releaseStepDto) throws BindException {
        return super.next(releaseStepDto);
    }

    @Override
    public ResponseEntity<ReleaseStepDto> save(DeliverySingOffDto releaseStepDto) throws BindException {
        return null;
    }

    @Override
    public ResponseEntity<FileUploadDto> importReleaseNotes(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        long size = multipartFile.getSize();
        String fileCode = FileUploadUtil.saveFile(fileName, multipartFile);
        FileUploadDto response = new FileUploadDto();
        response.setFileName(fileName);
        response.setSize(size);
        response.setDownloadUri("/downloadFile/" + fileCode);
        return new ResponseEntity<FileUploadDto>(response, HttpStatus.OK);
    }

}