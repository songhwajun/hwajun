package com.danbplus.example.repository;

import java.util.List;


import com.danbplus.example.domain.MEMBER;

public interface MemberRepository {
	List<MEMBER> getName(int userNo); // 회원 휴가목록 조회
}
