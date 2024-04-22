package com.danbplus.example.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
  
  /**
   * 게시판 글 상세 조회  
   */
  @Override
  public List<BOARD> write(BOARD board) {
    HashMap<String, Object> map = new HashMap();
    
    map.put("userNo" , board.getUserNo());
    map.put("title" , board.getTitle());
    map.put("content" , board.getContent());
    map.put("userName" , board.getUserName());
    
 // 현재 날짜 구하기   
    LocalDate now = LocalDate.now();         
    // 포맷 정의       
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");         
    // 포맷 적용        
    String formatedNow = now.format(formatter);         
    // 결과 출력        
    map.put("registDate", formatedNow);
    map.put("updateDate", "");
    List<BOARD> list = boardMapper.write(map);
    
    
    return list;
  }
  
  /**
   * 게시판 글 수정 
   */
  @Override
  public List<BOARD> modify(BOARD board) {
    HashMap<String, Object> map = new HashMap();
    map.put("boardNum", board.getBoardNum());
    map.put("userNo" , board.getUserNo());
    map.put("title" , board.getTitle());
    map.put("content" , board.getContent());
    map.put("userName" , board.getUserName());
    
 // 현재 날짜 구하기   
    LocalDate now = LocalDate.now();         
    // 포맷 정의       
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");         
    // 포맷 적용        
    String formatedNow = now.format(formatter);         
    // 결과 출력        
    map.put("updateDate", formatedNow);
    log.info("테스트진행중 " + map);
    List<BOARD> list = boardMapper.modify(map);
    
    return list;
  }
  
  public String delete(String boardNum) {
    HashMap<String, Object> map = new HashMap();
    map.put("boardNum", boardNum);
    
    boardMapper.delete(map);
    
    return "";
  }
}
