package com.danbplus.example.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.danbplus.example.domain.LOGIN;

@Repository
public interface LoginRepository {
  int getDuplicateCheck(String id); // id 중복체크
  LOGIN join(LOGIN login);  // 로그인 정보 등록
}
