package com.danbplus.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.danbplus.example.domain.MEMBER;
import com.danbplus.example.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {

  /* 의존성 필드주입은 선호하지 않는다. */
  /*@Autowired
    MemberService memberService;
   */
  private final MemberService memberService;

  /**
   * 의존성 생성자 주입
   * 의존관계가 어플리케이션 실행중에는 변동되는일이 거의 없으므로 해당 방식을 이용하자.
   * Spring Config에서 주입한 객체를 리턴받는다.
   * @param memberService
   */
  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }
  
  @RequestMapping("/dbtest") //userNo갑 requestparam에 담아옴
  public ModelAndView test(HttpServletRequest request, MEMBER member, Model model) {
    ModelAndView mv = new ModelAndView();
    int userNo = 1;
    List list = memberService.getName(userNo);
    log.info("결과 : " + list);
    mv.setViewName("/index");
    return mv;
  }
  
  @ResponseBody
  @RequestMapping("/MemberController/join.act") //userNo갑 requestparam에 담아옴
  public String join(MEMBER member, Model model) {
    String result = "정상적으로 처리되었습니다.";
    log.info("MemberController/join.act 실행중");
    int userNo = 1;
    
    List list = memberService.getName(userNo);
    log.info("결과 : " + list);
    return result;
  }
  
}
