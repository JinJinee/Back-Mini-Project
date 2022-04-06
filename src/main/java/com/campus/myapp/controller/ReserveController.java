package com.campus.myapp.controller;

import javax.inject.Inject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.ReserveService;
import com.campus.myapp.vo.ReserveVO;

@Controller
public class ReserveController {
	@Inject
	ReserveService service;

	// 목록
	@GetMapping("reservation")
	public String reserveForm() {
		return "/reserve/reserveForm";
	}
	
	@GetMapping("/reserve/policy")
	public String policy() {
		return "/reserve/policy";
	}

	@PostMapping("/reserveOk")
	public ResponseEntity<String> reserveOk(ReserveVO vo) {
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "text/html; charset=utf-8");
		
		try {
			service.custInsert(vo);
			// 등록 성공
			String msg = "<script>alert('상담예약이 완료되었습니다.');location.href='/myapp/';</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			String msg = "<script>history.back();</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
