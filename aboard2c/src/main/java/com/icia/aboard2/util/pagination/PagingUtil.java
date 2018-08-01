package com.icia.aboard2.util.pagination;


public class PagingUtil {
	public static Pagination getPagination(Pageable pageable, Integer count) {
		Integer page = pageable.getPage();		// 페이지 번호
		Integer size = pageable.getSize();		// 페이지 당 글의 개수(10)
		Integer block = pageable.getBlock();	// 페이지 번호의 개수
		// 1페이지 - sR : 1	, eR : 10
		// 2페이지 - sR : 11, eR : 20
		Integer startRow = (page-1) * size + 1;
		Integer endRow = startRow + size - 1;
		endRow = (endRow>count) ? count : endRow;
		// block이 5일때
		// 1~5페이지		블록번호 0
		// 6~10페이지		블록번호 1
		// 11~15페이지		블록번호 2
		Integer blockNumber = (page-1)/block;
		Integer startPage = blockNumber * block + 1;
		Integer endPage = startPage + block - 1;
		int countOfPage = count/size + 1;
		endPage = (endPage>countOfPage) ? countOfPage : endPage;
		
		Integer prev = startPage - 1;
		Integer next = endPage + 1;
		if(endPage == countOfPage)
			next = 0; 
		
		return Pagination.builder().startPage(startPage).endPage(endPage)
			.startRow(startRow).endRow(endRow).prev(prev).next(next)
			.page(page).build();
	}
}
