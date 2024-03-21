package com.danbplus.example.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
  
import com.danbplus.example.mybatis.MemberMapper;
import com.danbplus.example.service.MemberService;

@Controller
@RequiredArgsConstructor //MemberService에 대한 멤버를 사용 가능
public class MemberController {

  //회원가입 페이지 출력 요청
  @GetMapping("/join")
  public String joinForm() {
      return "join";
  }

  /*
  @PostMapping("/join")    // name값을 requestparam에 담아온다
  public String save(@ModelAttribute MemberDTO memberDTO) {
    System.out.println("MemberController.save");
    System.out.println("memberDTO = " + memberDTO);
    MemberService.save(memberDTO);
    return "index";
  }
  */
  
  @Autowired
  MemberService service;
  
  @RequestMapping("/test")
  public ModelAndView test() {
      ModelAndView mv = new ModelAndView();
      String name = service.getName("");
      
      mv.addObject("name", name);
      mv.setViewName("index");
      return mv;
  }
  
  
}
