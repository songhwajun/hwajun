package com.danbplus.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

  @GetMapping("/")
  public String index() {
    log.info("테스트 123");
    
      
      return "index";
  }
  
  @GetMapping("/login")
  public String login() {
    log.info("테스트 1234");
      return "login";
  }
}
