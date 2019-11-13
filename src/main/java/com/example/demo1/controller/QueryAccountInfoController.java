package com.example.demo1.controller;

import com.example.demo1.APIConstant;
import com.example.demo1.entity.BooleanResult;
import com.example.demo1.entity.UserAccount;
import com.example.demo1.repository.UserAccountRepository;
import org.springframework.data.domain.Example;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class QueryAccountInfoController {

//    private static final Logger log = LoggerFactory.getLogger(QueryAccountInfoController.class);

    private final UserAccountRepository userAccountRepository;

    public QueryAccountInfoController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @ResponseBody
    @RequestMapping(value = APIConstant.SCHEMA_V1 + "/queryAccount", method = RequestMethod.GET)
    public UserAccount queryAccount(@RequestParam("userName") String userName) {
        if (StringUtils.isEmpty(userName)) throw new IllegalArgumentException("The user name is null");
        UserAccount queryUserAccount = new UserAccount();
        queryUserAccount.setUserName(userName);
        Example<UserAccount> userAccountExample = Example.of(queryUserAccount);
        Optional<UserAccount> accountOptional = userAccountRepository.findOne(userAccountExample);
        if (accountOptional.isPresent()) return accountOptional.get();
        else throw new IllegalArgumentException("The user name not exist on the server");
    }

    @ResponseBody
    @RequestMapping(value = APIConstant.SCHEMA_V1 + "/queryAllAccounts", method = RequestMethod.GET)
    public List<UserAccount> queryAllAccounts() {
        return userAccountRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = APIConstant.SCHEMA_V1 + "/updateAccount", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public BooleanResult updateAccount(@RequestBody UserAccount userAccount) {
        userAccount.setLastLoginTime(new Date());
        userAccountRepository.save(userAccount);
        return new BooleanResult(true);
    }

    @ResponseBody
    @RequestMapping(value = APIConstant.SCHEMA_V1 + "/queryCardIsExpired", method = RequestMethod.GET)
    public BooleanResult queryCardIsExpired(@RequestParam("cardNumber") String cardNumber, @Nullable @RequestParam String bindNumber) {
        if (StringUtils.isEmpty(cardNumber)) throw new IllegalArgumentException("The card number is null");
        //if (StringUtils.isEmpty(bindNumber)) throw new IllegalArgumentException("The bind number is null");
        UserAccount queryUserAccount = new UserAccount();
        queryUserAccount.setCardNumber(cardNumber);
        queryUserAccount.setBindNumber(bindNumber);
        Example<UserAccount> userAccountExample = Example.of(queryUserAccount);
        Optional<UserAccount> accountOptional = userAccountRepository.findOne(userAccountExample);
        if (accountOptional.isPresent()) return new BooleanResult(accountOptional.get().isExpired());
        else throw new IllegalArgumentException("The card number or bind number not exist on the server");
    }
}
