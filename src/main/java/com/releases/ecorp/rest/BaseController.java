package com.releases.ecorp.rest;

import com.releases.ecorp.rest.common.dto.ReleaseStepDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

public abstract class BaseController<TransactionObject extends ReleaseStepDto> implements BaseInterface<TransactionObject> {

    @Autowired
    protected HttpSession session;

    @Override
    public ResponseEntity<ReleaseStepDto> next(@RequestBody TransactionObject releaseStepDto) throws BindException {
        return null;
    }

    @Override
    public ResponseEntity<ReleaseStepDto> previous(@RequestBody TransactionObject releaseStepDto) throws BindException {
        return null;
    }

    @Override
    public ResponseEntity<ReleaseStepDto> save(@RequestBody TransactionObject releaseStepDto) throws BindException {
        return null;
    }


}
