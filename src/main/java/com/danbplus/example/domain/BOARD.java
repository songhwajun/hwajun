package com.danbplus.example.domain;

import org.apache.ibatis.type.Alias;

import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;


//JPA사용시 어노테이션 작성
//기존TABLE명이용시 table 어노테이션 작성
@Entity
@Table(name="BOARD")
//Mybatis 별칭 기능 사용시 선언
@Alias("BOARD")
//@Data
/**
* JPA사용시에는 getter,setter가 사용되지 않는다.
* JPA는 Entity라 표현하고 , Mybatis는 DTO(VO)라고 표현한다.
* JPA는 ORM(Object Relational Mapping)방식이며 Mabatis는 Query기반방식이기때문이다.
* ORM이란 객체와 데이터베이스의 테이블이 매핑을 이루는 것을 의미한다. -> 즉 객체가 테이블이 되도록 매핑 시켜주는 것
* 우리나라기준으로 현재 Mybatis를 많이 사용하며 , 현재 서비스업쪽에서 JPA를 많이 도입하고 있다.
*/
public class BOARD {
  
  @Id
  private int boardNum;  // 글번호
  private int userNo;    // 회원번호
  private String title;     // 제목
  private String content;   // 내용
  private String registDate;  // 작성일
  private String updateDate;  // 수정일
  private String userName; //회원이름
  
  public int getBoardNum() {
    return boardNum;
  }
  public void setBoardNum(int boardNum) {
      this.boardNum = boardNum;
  }
  public int getUserNo() {
    return userNo;
  }
  public void setUserNo(int userNo) {
      this.userNo = userNo;
  }
  public String getTitle() {
      return title;
  }
  public void setTitle(String title) {
      this.title = title;
  }
  public String getContent() {
      return content;
  }
  public void setContent(String content) {
      this.content = content;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  public String getRegistDate() {
      return registDate;
  }
  public void setRegistDate(String registDate) {
      this.registDate = registDate;
  }
  public String getUpdateDate() {
    return updateDate;
  }
  public void setUpdateDate(String updateDate) {
      this.updateDate = updateDate;
  }

  @Override
  public String toString() {
      return "BOARD [boardNum=" + boardNum + ", userNo=" + userNo + ", title="
              + title + ", content=" + content + ", registDate=" + registDate + 
              ", updateDate=" + updateDate + ", userName=" + userName + "]";
  }
  
}
