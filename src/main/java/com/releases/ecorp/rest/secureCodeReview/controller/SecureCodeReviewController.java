package com.releases.ecorp.rest.secureCodeReview.controller;

import com.releases.ecorp.rest.testCase.controller.TestCaseController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TestCaseController.BASE_URL)
@AllArgsConstructor
public class SecureCodeReviewController {

    public static final String BASE_URL = "/private/v1/secureCodeReview";

}
