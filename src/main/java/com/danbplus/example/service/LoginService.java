package com.danbplus.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import com.danbplus.example.domain.MEMBER;
import com.danbplus.example.domain.LOGIN;
import com.danbplus.example.repository.MemberRepository;
import com.danbplus.example.repository.LoginRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoginService {
  @Autowired
  PlatformTransactionManager manager;
  
  private final LoginRepository loginRepository;
  
  public LoginService(LoginRepository loginRepository) {
    this.loginRepository = loginRepository;
  }
  
  /*
  public List<MEMBER> getName(int userNo){
      return memberRepository.getName(userNo);
  }
  */
  
  public int getDuplicateCheck(String id) {
    return loginRepository.getDuplicateCheck(id);
  }
  
  public String join(LOGIN login) {
    loginRepository.join(login);    //로그인 정보 등록
    return login.getId();
  }
  
  
}
