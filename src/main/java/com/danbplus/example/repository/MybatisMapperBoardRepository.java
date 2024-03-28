package com.danbplus.example.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;
import com.danbplus.example.domain.LOGIN;
import com.danbplus.example.repository.mapper.BoardMapper;
import com.danbplus.example.repository.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MybatisMapperBoardRepository implements BoardRepository{

  private final BoardMapper boardMapper;
  
  public MybatisMapperBoardRepository(BoardMapper boardMapper) {
      this.boardMapper = boardMapper;
  }
  
}
