package com.icia.aboard2.rest_service;

import java.io.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.*;

import com.icia.aboard2.dao.*;
import com.icia.aboard2.entity.*;
import com.icia.aboard2.exception.*;

@Service
public class BoardRestService {
	@Autowired
	private BoardRepository boardDao;
	@Autowired
	private AttachRepository attachDao;
	
	public int recommend(String id, int bno, boolean alreadyRecommend) {
		int result = boardDao.recommend(bno);
		if(result==0)
			throw new BoardNotFoundException();
		return boardDao.getRecommendCnt(bno);
	}
	
	public int report(String id, int bno, boolean alreadyReport) {
		int result = boardDao.report(bno);
		if(result==0)
			throw new BoardNotFoundException();
		return boardDao.getReportCnt(bno);
	}

	public Attachment getAttachment(int bno, int ano) throws FileNotFoundException {
		Attachment attachment = attachDao.getAttachment(bno, ano);
		if(attachment==null)
			throw new FileNotFoundException("원본 파일을 찾을 수 없습니다 ");
		return attachment;
	}

	
}
