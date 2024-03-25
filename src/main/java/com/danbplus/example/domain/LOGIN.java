package com.danbplus.example.domain;

import org.apache.ibatis.type.Alias;

import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;


//JPA사용시 어노테이션 작성
//기존TABLE명이용시 table 어노테이션 작성
@Entity
@Table(name="LOGIN")
//Mybatis 별칭 기능 사용시 선언
@Alias("LOGIN")
//@Data
/**
* JPA사용시에는 getter,setter가 사용되지 않는다.
* JPA는 Entity라 표현하고 , Mybatis는 DTO(VO)라고 표현한다.
* JPA는 ORM(Object Relational Mapping)방식이며 Mabatis는 Query기반방식이기때문이다.
* ORM이란 객체와 데이터베이스의 테이블이 매핑을 이루는 것을 의미한다. -> 즉 객체가 테이블이 되도록 매핑 시켜주는 것
* 우리나라기준으로 현재 Mybatis를 많이 사용하며 , 현재 서비스업쪽에서 JPA를 많이 도입하고 있다.
*/
public class LOGIN {
  
  @Id
  private String id;          // 아이디
  private String password;    // 비밀번호
  private String passwordErr; // 비밀번호오류횟수
  
  public String getId() {
      return id;
  }
  public void setId(String id) {
      this.id = id;
  }
  public String getPassword() {
      return password;
  }
  public void setPassword(String password) {
      this.password = password;
  }
  public String getPasswordErr() {
      return passwordErr;
  }
  public void setPasswordErr(String passwordErr) {
      this.passwordErr = passwordErr;
  }
  
  @Override
  public String toString() {
      return "LOGIN [id=" + id + ", password=" + password + ", passwordErr="
              + passwordErr + "]";
  }
  
}
