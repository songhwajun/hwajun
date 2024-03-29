package com.danbplus.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.danbplus.example.domain.MEMBER;
import com.danbplus.example.domain.LOGIN;
import com.danbplus.example.service.MemberService;
import com.danbplus.example.service.LoginService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

  private final LoginService loginService;
  private final MemberService memberService;
  
  @Autowired
  public LoginController(LoginService loginService, MemberService memberService) {
    this.loginService = loginService;
    this.memberService = memberService;
  }
  
  //회원가입 페이지 출력 요청
  @RequestMapping("/join")
  public ModelAndView joinForm() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/join");
    return mv;
  }
  
//회원가입 페이지 출력 요청
  @RequestMapping("/login")
  public ModelAndView loginForm() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/login");
    return mv;
  }
  
  @ResponseBody
  @RequestMapping("/LoginController/duplicateCheck.act")
  public int duplicateCheck(LOGIN login, Model model) {
    log.info("LoginController/duplicateCheck.act");
    
    //화면에서 가져오는 id값을 넣어서 보낸다.
    String id = login.getId();
    int duplicateCheck = loginService.getDuplicateCheck(id);
    
    return duplicateCheck;
  }
  
  @ResponseBody
  @RequestMapping("/LoginController/join.act")
  public String join(LOGIN login, MEMBER member, Model model) {
    log.info("LoginController/join.act || model :: " + model);
    
    String result = "회원가입이 정상적으로 처리되었습니다.";
    String errMsg = "";
    //회원가입
    try {
        loginService.join(login);
    } catch (Exception e) {
        errMsg = e.getMessage();
    }
    
    //회원정보 insert
    try {
        memberService.newMember(member);
    } catch (Exception e) {
      errMsg = e.getMessage();
    }
    
    return result;
  }
  
  
}
