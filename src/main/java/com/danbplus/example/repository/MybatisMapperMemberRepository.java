package com.danbplus.example.repository;

import java.util.HashMap;



import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
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
	
}
