package com.danbplus.example.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.danbplus.example.domain.LOGIN;
import com.danbplus.example.domain.MEMBER;

@Repository
public interface MemberRepository {
	List<MEMBER> getName(int userNo); // 회원 휴가목록 조회
	MEMBER newMember(MEMBER member);  // 회원 정보 등록
}
