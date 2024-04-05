package com.danbplus.example.repository.mapper;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.danbplus.example.domain.BOARD;
import com.danbplus.example.domain.LOGIN;

@Mapper
public interface BoardMapper {
  List<BOARD> getBoardList(HashMap map);
  List<BOARD> getDetailInfo(int num);
  List<BOARD> write(HashMap map);
}
