package com.icia.aboard2.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.icia.aboard2.dto.BoardDto.CreateBoard;
import com.icia.aboard2.service.BoardService;
import com.icia.aboard2.util.ABoard2Contstants;
import com.icia.aboard2.util.ABoard2Util;
import com.icia.aboard2.util.pagination.Pageable;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
	@Autowired
	private BoardService service;
	@Autowired
	private ObjectMapper mapper;
	@GetMapping("/boards")
	public String list(Pageable pageable, Model model) throws JsonProcessingException {
		log.info("{}", pageable);
		String str = mapper.writeValueAsString(service.list(pageable));
		model.addAttribute("page", service.list(pageable));
		
		return "boards/list";
	}
	@GetMapping("/boards2")
	@ResponseBody
	public String lista(Pageable pageable, Model model) throws JsonProcessingException {
		log.info("{}", pageable);
		int first = service.list(pageable).indexOf("[");
		int second = service.list(pageable).indexOf("]")+1;
		Map<String, Object> map = new HashMap<>();
		map.put("records", service.list(pageable).substring(first,second));
		String str = mapper.writeValueAsString(map);
		model.addAttribute("page", service.list(pageable));
		
		return str;
	}
	
	@GetMapping("/boards/read")
	public String read(@NonNull Integer bno, Model model) {
		model.addAttribute("board", service.read(bno));
		return "boards/read";
	}
	
	@GetMapping("/boards/write")
	public String write() {
		return "boards/write";
	}
	
	/* ※ 파일 업로드
	 * 1. 파일의 대분류
	 * 		텍스트 파일 : 	글자를 저장하는 파일. 모든 시스템에서 읽고 쓸 수 있으므로 호환성이 매우 뛰어나다
	 * 						객체를 텍스트로 저장해 호환성을 확보하자 -> HTML, XML, JSON ...
	 * 		이진 파일 : 일반적인 파일로 당연히 텍스트 파일도 이진 파일이지만 보통 둘을 분리해서 생각한다
	 * 					즉 특별한 처리없이 사용할 수 있는 텍스트 파일과 전용 프로그램이 필요한 이진 파일로
	 * 2. content type
	 * 		request 객체에 실어보내는 데이터 형식을 서버에 알려주는 역할
	 * 		웹 프로그래밍에서 프론트와 백엔드가 정보를 주고 받기 위해서는 서로간의 데이터 처리 방식, 데이터 형식을 맞춰야 한다
	 * 		폼의 기본 인코딩 타입인 application/x-www-form-urlencoded
	 * 			key=value&key=value 형식으로 데이터를 전송
	 * 			get 방식은 key=value&key=value가 주소 표시줄을 이용해 전달됨 -> QueryString
	 * 			post 방식은 key=value&key=value가 request body를 이용해 전달됨
	 * 		바이너리 파일을 전달하려면 multipart-formdata 지정 필요
	 * 3. $.ajax
	 * 		contentType
	 * 			boolean 또는 문자열
	 * 			기본값은 'application/x-www-form-urlencoded; charset=UTF-8'
	 * 			만약 data : JSON.stringify(str)로 넘긴다면 contentType: "application/json" 필요
	 * 			false로 주면 contentType을 비운다 (http://api.jquery.com/jquery.ajax/ 참조)
	 * 		processData
	 * 			data를 application/x-www-form-urlencoded 방식으로 처리하는 것이 기본값
	 * 			false로 지정하면 처리작업을 하지 않는다
	 * 4. MultipartFile을 전달받는 방법
	 * 		<input type="file" name="sajin"> --> MultipartFile sajin
	 * 		<input type="file" name="sajin" multiple="multiple"> --> MultipartFile[] sajin
	*/
	
	@PostMapping("/boards/write")
	public String write(@Valid CreateBoard board, BindingResult results, MultipartFile[] files, RedirectAttributes ra) throws BindException, IOException {
		ABoard2Util.throwBindException(results);
		// 원래는 로그인한 아이디를 글쓴이로 저장하면 되는데...각자 알아서 아이디 넣어줄것
		board.setWriter("hasaway11");
		boolean result = service.write(board, files);
		if(result)
			ra.addFlashAttribute("msg", ABoard2Contstants.WRITE_SUCCESS);
		else
			ra.addFlashAttribute("msg", ABoard2Contstants.JOB_FAIL);
		return "redirect:/";
	}
	
	
}
