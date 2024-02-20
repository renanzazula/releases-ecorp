package com.releases.ecorp.rest.rollbackInstructions.controller;

import com.releases.ecorp.rest.testCase.controller.TestCaseController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TestCaseController.BASE_URL)
@AllArgsConstructor
public class RollbackInstructionsController {

    public static final String TestCaseController = "/private/v1/rollbackInstructions";

}
