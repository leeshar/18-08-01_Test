package com.icia.aboard2.util.pagination;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagination {
	// 페이징 처리, 페이지네이션 처리에 필요한 필드 7개
	private Integer startRow;
	private Integer endRow;
	private Integer startPage;
	private Integer endPage;
	private Integer prev;
	private Integer next;
	private Integer page;
}
