package com.danbplus.example.repository.mapper;

import java.util.HashMap;
import org.apache.ibatis.annotations.Mapper;
import com.danbplus.example.domain.LOGIN;

@Mapper
public interface LoginMapper {
  
  int getDuplicateCheck(HashMap map); //id 중복체크
  void join(HashMap map); //로그인 정보 등록
}
