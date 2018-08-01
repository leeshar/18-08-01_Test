package com.icia.aboard2.entity;

import java.util.*;

import org.springframework.format.annotation.*;

import lombok.*;

// JPA @Entity - 테이블과 1:1로 대응하는 클래스
// Data Transfer Object(DTO) - 사용자와 입출력하는 클래스
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	private String id;
	private String pwd;
	private String irum;
	private String tel;
	private String email;
	private Integer enabled;
	private Date birthDate;
	private int loginCnt;
	private int writeCnt;
}
