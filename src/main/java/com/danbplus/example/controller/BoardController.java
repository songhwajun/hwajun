package com.danbplus.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.danbplus.example.domain.BOARD;
import com.danbplus.example.domain.LOGIN;
import com.danbplus.example.domain.MEMBER;
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
  
  //글 상세
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
  
  //글 작성 화면
  @RequestMapping("/write")
  public ModelAndView writeView() {
    ModelAndView mv = new ModelAndView();
    
    //mv.addObject("name", name);
    mv.setViewName("/write");
    
    return mv;
  }
  
  //글 작성
  @ResponseBody
  @RequestMapping("/BoardController/write.act")
  public String write(BOARD board, Model model) {
    log.info("/BoardController/write.act || model :: " + model);
    
    String result = "글이 정상적으로 등록되었습니다.";
    String errMsg = "";
    
    try {
        boardService.write(board);
    } catch (Exception e) {
        errMsg = e.getMessage();
    }
    
    return result;
  }
  
//글 수정
  @ResponseBody
  @RequestMapping("/BoardController/modify.act")
  public String modify(BOARD board, Model model) {
    log.info("/BoardController/modify.act || model :: " + model);
    log.info("수정");
    String result = "글이 정상적으로 수정되었습니다.";
    String errMsg = "";
    
    try {
        boardService.modify(board);
    } catch (Exception e) {
        errMsg = e.getMessage();
    }
    
    return result;
  }
  
  
}
