package com.danbplus.example.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.danbplus.example.mybatis.MemberMapper;

@Service //스프링이 관리해주는 객체 == 스프링 빈
@Transactional
public class MemberService {
  @Autowired
  MemberMapper mapper;
  
  @Autowired
  PlatformTransactionManager manager;
  
  public String getName(String test) {
    TransactionStatus status = manager.getTransaction(new DefaultTransactionDefinition());
    String name = "";
    try {
        name = mapper.getName("");
        //manager.commit(status);
        //manager.rollback(status);
    }catch(Exception ex) {
        ex.printStackTrace();
    }
    return name;
  }
}
