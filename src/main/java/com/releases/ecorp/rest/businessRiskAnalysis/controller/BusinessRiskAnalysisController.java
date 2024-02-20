package com.releases.ecorp.rest.businessRiskAnalysis.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BusinessRiskAnalysisController.BASE_URL)
@AllArgsConstructor
public class BusinessRiskAnalysisController {

    public static final String BASE_URL = "/private/v1/businessRiskAnalysis";



}
