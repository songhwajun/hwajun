package com.danbplus.example.domain;

import org.apache.ibatis.type.Alias;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

//JPA사용시 어노테이션 작성
//기존TABLE명이용시 table 어노테이션 작성
@Entity
@Table(name="MEMBER")
//Mybatis 별칭 기능 사용시 선언
@Alias("MEMBER")
//@Data
/**
* JPA사용시에는 getter,setter가 사용되지 않는다.
* JPA는 Entity라 표현하고 , Mybatis는 DTO(VO)라고 표현한다.
* JPA는 ORM(Object Relational Mapping)방식이며 Mabatis는 Query기반방식이기때문이다.
* ORM이란 객체와 데이터베이스의 테이블이 매핑을 이루는 것을 의미한다. -> 즉 객체가 테이블이 되도록 매핑 시켜주는 것
* 우리나라기준으로 현재 Mybatis를 많이 사용하며 , 현재 서비스업쪽에서 JPA를 많이 도입하고 있다.
*/
public class MEMBER {
	
    @Id
	private int userNo;			// 회원번호
	private String id;      	// 아이디
	private String name; 	// 이름
	private String phone;    // 핸드폰
	private String registDt;    // 가입일
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegistDt() {
		return registDt;
	}
	public void setRegistDt(String registDt) {
		this.registDt = registDt;
	}
	
	@Override
	public String toString() {
		return "MEMBER [userNo=" + userNo + ", id=" + id + ", name=" + name + ", phone="
				+ phone + ", registDt=" + registDt + "]";
	}
}