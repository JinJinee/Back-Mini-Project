package com.campus.myapp.dao;

import java.util.List;

import com.campus.myapp.vo.AdminVO;
import com.campus.myapp.vo.PagingVO;
import com.campus.myapp.vo.ReserveVO;

public interface AdminDAO {
	
	// 직원등록
	public int empInsert(AdminVO vo);
	
	// 아이디중복검사
	public int idCheck(String empid);
	
	// 로그인
	public AdminVO loginCheck(AdminVO vo);

	// 고객목록
	public List<ReserveVO> custList(PagingVO pVO);
	
	// 총레코드수
	public int totalRecord(PagingVO pVO);
	
	// 고객등록
	public int custInsert(ReserveVO vo);
	
	// 고객 1명 선택
	public ReserveVO custSelect(int custno);
	
	// 고객수정
	public int custUpdate(ReserveVO vo);
	
	// 삭제
	public int custListMultiDelete(ReserveVO vo);
	
	// 캘린더 목록 선택
	public List<ReserveVO> calSelect();
}
