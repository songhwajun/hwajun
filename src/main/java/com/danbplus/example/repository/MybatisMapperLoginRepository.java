package com.danbplus.example.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;
import com.danbplus.example.domain.LOGIN;
import com.danbplus.example.repository.mapper.LoginMapper;
import com.danbplus.example.repository.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MybatisMapperLoginRepository implements LoginRepository{

  private final LoginMapper loginMapper;
  
  public MybatisMapperLoginRepository(LoginMapper loginMapper) {
      this.loginMapper = loginMapper;
  }
  
  /**
   * id 중복체크
   */
  @Override
  public int getDuplicateCheck(String id) {
    int cnt = 0;
    HashMap<String, String> map = new HashMap();
    map.put("id", id);
    cnt = loginMapper.getDuplicateCheck(map);
    return cnt;
  }
  
  /**
   * 회원가입   
   */
  @Override
  public LOGIN join(LOGIN login) {
    HashMap<String, String> map = new HashMap();
    map.put("id", login.getId());
    map.put("password", login.getPassword());
    loginMapper.join(map);
    
    return login;
  }
  
}
