package com.icia.aboard2.service;

import java.io.*;
import java.util.List;
import java.util.stream.*;

import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.*;
import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.util.*;
import org.springframework.web.multipart.*;
import com.google.gson.*;
import com.icia.aboard2.controller.*;
import com.icia.aboard2.dao.*;
import com.icia.aboard2.dto.*;
import com.icia.aboard2.dto.BoardDto.*;
import com.icia.aboard2.entity.*;
import com.icia.aboard2.exception.*;
import com.icia.aboard2.util.*;
import com.icia.aboard2.util.pagination.*;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardDao;
	@Autowired
	private AttachRepository attachDao;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private Gson gson;
	
	@Transactional
	public boolean write(CreateBoard create, MultipartFile[] files)  {
		Board board = modelMapper.map(create, Board.class);
		boardDao.write(board);
		// files는 파일 업로드를 안해도 length가 1, 파일 하나 업로드해도 length가 1이다
		// files에 대한 null 체크 불필요
		for(MultipartFile file:files) {
			// 원본 파일 이름 가져오기
			String originalFileName = file.getOriginalFilename();
			// 현재 시간을 앞에 붙여서 저장할 파일 이름으로 변경하기
			String savedFileName = System.currentTimeMillis() + "-" + originalFileName;
			// 파일을 업로드하면 서버의 메모리로 업로드되므로 하드디스크에 저장해야 한다
			// 저장하기 위해 비어있는 파일을 생성한 다음 메모리의 원본을 복사
			File dest = new File(ABoard2Contstants.UPLOAD_PATH, savedFileName);
			try {
				FileCopyUtils.copy(file.getBytes(), dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// attach 테이블에 첨부파일 정보를 저장
			// attach(ano, originalFileName, savedFileName, 글번호)
			Attachment attachment = new Attachment(0, originalFileName, savedFileName, board.getBno());
			attachDao.insert(attachment);
		}
		return true;
	}

	@Transactional
	public String read(Integer bno) {
		int result = boardDao.increaseReadCnt(bno);
		if(result==0)
			throw new BoardNotFoundException();
		// 글을 읽어온 다음
		Board board = boardDao.read(bno);
		// BoardDto.Response로 변환
		BoardDto.Response response = modelMapper.map(board, BoardDto.Response.class);
		// BoardDto.Response에 첨부파일을 추가
		response.setAttachments(attachDao.list(bno));
		// json으로 변환한다
		return gson.toJson(response);
	}

	public String list(Pageable pageable) {
		Integer count = boardDao.count();
		Pagination pagination = PagingUtil.getPagination(pageable, count);
		List list = boardDao.list(pagination.getStartRow(), pagination.getEndRow());
		Page page = Page.builder().list(list).pagination(pagination).build();
		return gson.toJson(page);
	}
}



