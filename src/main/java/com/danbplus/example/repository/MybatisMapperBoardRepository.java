package com.danbplus.example.repository;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.danbplus.example.domain.BOARD;
import com.danbplus.example.repository.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MybatisMapperBoardRepository implements BoardRepository{

  private final BoardMapper boardMapper;
  
  public MybatisMapperBoardRepository(BoardMapper boardMapper) {
      this.boardMapper = boardMapper;
  }
  
  /**
   * 게시판 글 조회  
   */
  @Override
  public List<BOARD> getBoardList() {
    HashMap<String, String> map = new HashMap();
    List<BOARD> list = boardMapper.getBoardList(map);
    
    return list;
  }
  
  /**
   * 게시판 글 상세 조회  
   */
  @Override
  public List<BOARD> getDetailInfo(int num) {
    List<BOARD> list = boardMapper.getDetailInfo(num);
    return list;
  }
  
}
