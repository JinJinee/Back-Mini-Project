package com.campus.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.AdminService;
import com.campus.myapp.vo.AdminVO;
import com.campus.myapp.vo.PagingVO;
import com.campus.myapp.vo.ReserveVO;

@RestController
@RequestMapping("/admin/*")
public class AdminController {
	@Inject
	AdminService service;
	
	// 로그인폼으로 이동
	@GetMapping("loginForm")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/loginForm");
		return mav;
	}
	
	// 회원가입폼으로 이동
	@GetMapping("signupForm")
	public ModelAndView signupForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/signupForm");
		
		return mav;
	}
	
	// 직원등록
	@PostMapping("signupOk")
	public ResponseEntity<String> signupOk(AdminVO vo) {
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "text/html; charset=utf-8");
		
		try {
			service.empInsert(vo);
			// 정상등록
			String msg = "<script>alert('회원가입이 완료되었습니다. \\n로그인 페이지로 이동합니다.');location.href='loginForm';</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			// 등록안됨
			String msg = "<script>alert('회원가입을 실패하였습니다.\\n회원가입 페이지로 다시 이동합니다.');history.back();</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 아이디 중복검사
	@PostMapping("signupIdCheck")
	@ResponseBody
	public int idCheck(String empid) {
		int cnt = service.idCheck(empid);
		return cnt;
	}
	
	// 로그인
	@PostMapping("loginOk")
	public ResponseEntity<String> loginOk(AdminVO vo, HttpSession session) {
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "text/html; charset=utf-8");
		
		AdminVO vo2 = service.loginCheck(vo);
		
		if(vo2 != null) { // 로그인 성공
			session.setAttribute("logId", vo2.getEmpid());
			session.setAttribute("logName", vo2.getEmpname());
			session.setAttribute("logStatus", "Y");
			
			String msg = "<script>location.href='customerList';</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		}else { // 로그인 실패: 로그인폼으로 이동
			String msg = "<script>alert('아이디 또는 비밀번호를 잘못 입력했습니다.\\n입력하신 내용을 다시 확인해주세요.');history.back();</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 로그아웃
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		session.invalidate();
		mav.setViewName("redirect:/");
		
		return mav;
	}
	
	// 고객목록 페이지로 이동
	@GetMapping("customerList")
	public ModelAndView customerList(PagingVO pVO) {
		ModelAndView mav = new ModelAndView();
		
		pVO.setTotalRecord(service.totalRecord(pVO));
		
		// DB처리
		mav.addObject("list", service.custList(pVO));
		mav.addObject("pVO", pVO);
		
		mav.setViewName("admin/customerList");
		return mav;
	}
	
	// 고객등록 폼
	@GetMapping("customerAdd")
	public ModelAndView customerWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/customerAdd");
		return mav;
	}
	
	// 고객등록(DB)
	@PostMapping("customerAddOk")
	public ResponseEntity<String> customerAddOk(ReserveVO vo){
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "text/html; charset=utf-8");
		
		try {
			service.custInsert(vo);
			// 등록 성공
			String msg = "<script>alert('등록되었습니다.');location.href='customerList';</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			// 등록 실패
			String msg = "<script>alert('등록을 실패했습니다. \\n다시 확인해 주세요.');history.back();</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 고객정보수정 폼
	@GetMapping("customerView")
	public ModelAndView customerView(int custno) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("vo", service.custSelect(custno));
		mav.setViewName("admin/customerView");
		
		return mav;
	}
	
	// 고객수정(DB)
	@PostMapping("customerEditOk")
	public ResponseEntity<String> customerEditOk(ReserveVO vo){
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "text/html; charset=utf-8");
		
		try {
			int result = service.custUpdate(vo);
			// 수정성공
			if(result > 0) {
				String msg = "<script>alert('수정을 완료했습니다.');location.href='customerList';</script>";
				entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
			}else {
				String msg = "<script>alert('수정을 실패했습니다.\\n다시 확인해 주세요.');history.back();</script>";
				entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			e.printStackTrace();
			String msg = "<script>alert('수정을 실패했습니다.\\n다시 확인해 주세요.');history.back();</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 삭제
	@PostMapping("multiDel")
	public ModelAndView multiDel(ReserveVO vo) {
		ModelAndView mav = new ModelAndView();
		
		service.custListMultiDelete(vo);
		mav.setViewName("redirect:customerList");
		
		return mav;
	}
	
	// workCalendar
	// 일정폼으로 이동
	@GetMapping("calendar")
	public ModelAndView calendar() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("calList", service.calSelect());
		mav.setViewName("admin/calendar");
		return mav;
	}
	
	//report
	// 업무보고 목록이동
	@GetMapping("report")
	public ModelAndView report() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/report");
		return mav;
	}
	
	// 내정보 이동
	@GetMapping("mypage")
	public ModelAndView mypage() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/mypage");
		return mav;
	}
}
