package com.danbplus.example.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.danbplus.example.domain.LOGIN;
import com.danbplus.example.domain.MEMBER;
import com.danbplus.example.repository.mapper.MemberMapper;


//@RequiredArgsConstructor
@Repository
public class MybatisMapperMemberRepository implements MemberRepository{

	private final MemberMapper memberMapper;
	
	public MybatisMapperMemberRepository(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	/**
	 * mybatis 연동테스트
	 */
	@Override
	public List<MEMBER> getName(int userNo) {
		HashMap<String, String> map = new HashMap();
		String toStringUserNo = userNo+"";
		map.put("userNo", toStringUserNo);
		List<MEMBER> list = memberMapper.getName(map);
		return list;
	}
	
	  /**
	   * 회원정보   
	   */
	  @Override
	  public MEMBER newMember(MEMBER member) {
	    HashMap<String, String> map = new HashMap();
	    map.put("id", member.getId());
	    map.put("name", member.getName());
	    map.put("phone", member.getPhone());
	    
	    // 현재 날짜 구하기   
	    LocalDate now = LocalDate.now();         
	    // 포맷 정의       
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");         
	    // 포맷 적용        
	    String formatedNow = now.format(formatter);         
	    // 결과 출력        
	    map.put("registDt", formatedNow);
	    memberMapper.newMember(map);
	    
	    return member;
	  }
}
