package com.example.demo1.controller;

import com.example.demo1.APIConstant;
import com.example.demo1.entity.BooleanResult;
import com.example.demo1.entity.UserAccount;
import com.example.demo1.repository.UserAccountRepository;
import org.springframework.data.domain.Example;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
public class LoginController {


    private final UserAccountRepository userAccountRepository;

    public LoginController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @ResponseBody
    @RequestMapping(value = APIConstant.SCHEMA_V1 + "/login", method = RequestMethod.POST, produces = "application/json")
    public BooleanResult login(@RequestBody UserAccount userAccount) {
        BooleanResult booleanResult = new BooleanResult(false);
        if (StringUtils.isEmpty(userAccount.getUserName()) ||
                StringUtils.isEmpty(userAccount.getUserPassword())) return booleanResult;
        Example<UserAccount> userAccountExample = Example.of(userAccount);
        Optional<UserAccount> accountOptional = userAccountRepository.findOne(userAccountExample);
        if (accountOptional.isPresent()) {
            UserAccount dbUserAccount = accountOptional.get();
            dbUserAccount.setLastLoginTime(new Date());
            userAccountRepository.save(dbUserAccount);
            booleanResult.setResult(true);
        }
        return booleanResult;
    }
}
