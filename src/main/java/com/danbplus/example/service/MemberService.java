package com.danbplus.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.extern.slf4j.Slf4j;
import com.danbplus.example.domain.MEMBER;
import com.danbplus.example.repository.MemberRepository;

@Slf4j
@Service
public class MemberService {
  @Autowired
  PlatformTransactionManager manager;
  
  private final MemberRepository memberRepository;
  
  public MemberService(MemberRepository memberRepository) {
    log.info("### MemberService");
    this.memberRepository = memberRepository;
  }
  
  public List<MEMBER> getName(int userNo){
      return memberRepository.getName(userNo);
  }

  public String newMember(MEMBER member){
    memberRepository.newMember(member);
    return member.getId();
  }
}
