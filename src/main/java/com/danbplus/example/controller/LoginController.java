package com.danbplus.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.danbplus.example.domain.MEMBER;
import com.danbplus.example.domain.LOGIN;
import com.danbplus.example.service.MemberService;
import com.danbplus.example.service.LoginService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

  private final LoginService loginService;
  
  @Autowired
  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }
  
  @ResponseBody
  @RequestMapping("/LoginController/duplicateCheck.act")
  public int duplicateCheck(LOGIN login, Model model) {
    log.info("LoginController/duplicateCheck.act || model :: " + model);
    
    //화면에서 가져오는 id값을 넣어서 보낸다.
    String id = login.getId();
    int duplicateCheck = loginService.getDuplicateCheck(id);
    
    return duplicateCheck;
  }
  
  @ResponseBody
  @RequestMapping("/LoginController/join.act")
  public String join(LOGIN login, Model model) {
    log.info("LoginController/join.act || model :: " + model);
    
    String result = "회원가입이 정상적으로 처리되었습니다.";
    String errMsg = "";
    //회원가입
    try {
        loginService.join(login);
    } catch (Exception e) {
        errMsg = e.getMessage();
    }
    
    return result;
  }
  
  
}
