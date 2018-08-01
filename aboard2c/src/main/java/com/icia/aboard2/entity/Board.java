package com.icia.aboard2.entity;

import java.util.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int readCnt;
	private int recommendCnt;
	private int reportCnt;
}

