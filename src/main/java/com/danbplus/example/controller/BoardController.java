package com.danbplus.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.danbplus.example.domain.BOARD;
import com.danbplus.example.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {

  private final BoardService boardService;
  
  @Autowired
  public BoardController(BoardService boardService) {
    this.boardService = boardService;
  }
  
  //회원가입 페이지 출력 요청
  @RequestMapping("/boardDetail")
  public ModelAndView boardDetail(@RequestParam("num") String num) {
    ModelAndView mv = new ModelAndView();
    
    log.info("num : " + num);
    int intNum = Integer.parseInt(num);
    
    if(num != null && !num.isEmpty()) {
      List<BOARD> boardDetailInfo = boardService.getDetailInfo(intNum);
      log.info("" + boardDetailInfo);
      mv.addObject("boardList", boardDetailInfo);
    }
    
    mv.setViewName("/board");
    
    return mv;
  }
  
  
}
