package com.danbplus.example.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.danbplus.example.domain.BOARD;

@Repository
public interface BoardRepository {
  List<BOARD> getBoardList();  // 게시글 전체
  List<BOARD> getDetailInfo(int num); // 특정 글 상세정보
}
