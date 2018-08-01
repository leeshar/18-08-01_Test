package com.icia.aboard2.util.pagination;

import lombok.*;

@Data
@AllArgsConstructor
public class Pageable {
	private Integer page;		// 페이지 번호
	private Integer size;		// 페이지 당 글의 개수
	private Integer block;		// 페이지네이션 블록 개수
	public Pageable() {
		page = 1;
		size = 10;
		block = 5;
	}
}
