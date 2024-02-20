package com.releases.ecorp.rest.deploymentInstructions.controller;

import com.releases.ecorp.rest.testCase.controller.TestCaseController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DeploymentInstructionsController.BASE_URL)
@AllArgsConstructor
public class DeploymentInstructionsController {

    public static final String BASE_URL = "/private/v1/DeploymentInstructions";

}
