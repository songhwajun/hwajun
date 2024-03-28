package com.danbplus.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import com.danbplus.example.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService {
  @Autowired
  PlatformTransactionManager manager;
  
  private final BoardRepository boardRepository;
  
  public BoardService(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }
  
  
  
}
