package com.danbplus.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import com.danbplus.example.domain.BOARD;
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
  
  public List<BOARD> boardList() {
    return boardRepository.getBoardList();
  }
  
  public List<BOARD> getDetailInfo(int num) {
    return boardRepository.getDetailInfo(num);
  }
  
  public List<BOARD> write(BOARD board) {
    return boardRepository.write(board);
  }
  
  public List<BOARD> modify(BOARD board) {
    return boardRepository.modify(board);
  }
  
}
