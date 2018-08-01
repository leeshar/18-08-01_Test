package com.icia.aboard2.dao;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.icia.aboard2.dto.*;
import com.icia.aboard2.entity.*;

public interface AttachRepository {
	// 아래 메소드 버림
	// String getSavedFileName(@Param("originalFileName") String fileName, @Param("ano") Integer ano);

	void insert(Attachment attachment);

	List<Attachment> list(Integer bno);

	void deleteAll(int bno);

	Attachment getAttachment(@Param("bno") int bno, @Param("ano") int ano);

}
