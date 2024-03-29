package com.danbplus.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import lombok.extern.slf4j.Slf4j;
import com.danbplus.example.domain.BOARD;
import com.danbplus.example.service.BoardService;
import com.danbplus.example.service.LoginService;
import com.danbplus.example.service.MemberService;

@Slf4j
@Controller
public class HomeController {

  private final BoardService boardService;
  
  @Autowired
  public HomeController(BoardService boardService) {
    this.boardService = boardService;
  }
  
  
  //회원가입 페이지 출력 요청
  @RequestMapping("/")
  public ModelAndView index() {
    ModelAndView mv = new ModelAndView();
    
    //게시글 목록
    List<BOARD> boardList = boardService.boardList();        //게시글 목록조회
    log.info("" + boardList);
    
    mv.addObject("boardList", boardList);
    mv.setViewName("/index");
    
    return mv;
  }
  
  @GetMapping("/login")
  public String login() {
    log.info("테스트 1234");
      return "login";
  }
}
