package com.ahm.jx.ttm.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ahm.jx.ttm.dao.AccountDao;
import com.ahm.jx.ttm.entities.Account;

@Controller
@RequestMapping("/api/acct")
class acCont {

    private AccountDao accountRepository;

    @Autowired
    public acCont(AccountDao accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "current", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Account currentAccount(Principal principal) {
        //Assert.notNull(principal);
        return accountRepository.findOneByEmail("admin"); 
    }

    @RequestMapping(value = "search/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Account account(@PathVariable("id") Long id) {
        return accountRepository.findOne(id);
    }
}
