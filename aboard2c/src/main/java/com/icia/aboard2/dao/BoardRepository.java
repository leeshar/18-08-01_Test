package com.icia.aboard2.dao;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.icia.aboard2.entity.*;

public interface BoardRepository {
	public int count();

	public List<Board> list(@Param("startRow")int startRow, @Param("endRow") int endRow);

	public int increaseReadCnt(Integer bno);

	public Board read(Integer bno);
	
	public int recommend(int bno);
	
	public int getRecommendCnt(int bno);

	public int report(int bno);

	public int getReportCnt(int bno);

	public void write(Board board);

	public int update(Board board);

	public void delete(int bno);
}
