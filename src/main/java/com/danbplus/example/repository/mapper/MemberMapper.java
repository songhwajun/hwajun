package com.danbplus.example.repository.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.danbplus.example.domain.MEMBER;
@Mapper
public interface MemberMapper {

	List<MEMBER> getName(HashMap map);	// 회원 휴가내역 전체조회
}
