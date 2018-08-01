package com.icia.aboard2.dto;

import java.util.*;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.*;

import com.icia.aboard2.entity.*;

import lombok.*;

public class BoardDto {
	@Data
	public static class CreateBoard {
		private Integer bno;
		private String title;
		private String content;
		private String writer;
	}
	
	@Data
	public static class Response {
		private String writer;
		private Integer bno;
		private String title;
		private String content;
		private Date writeDate;
		private Integer readCnt;
		private Integer recommendCnt;
		private Integer reportCnt;
		private java.util.List<Attachment> attachments;
	}
	// 게시판에 글의 목록을 출력하기위한 DTO
	@Data
	public static class ListBoard {
		private Integer bno;
		private String title;
		private String writer;
		private Date writeDate;
		private Integer readCnt;
		private Boolean isAttachExist;
	}
	
}

