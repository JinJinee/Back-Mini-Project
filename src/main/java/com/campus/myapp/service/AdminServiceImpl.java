package com.campus.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.campus.myapp.dao.AdminDAO;
import com.campus.myapp.vo.AdminVO;
import com.campus.myapp.vo.PagingVO;
import com.campus.myapp.vo.ReserveVO;

@Service
public class AdminServiceImpl implements AdminService {
	@Inject
	AdminDAO dao;

	@Override
	public int empInsert(AdminVO vo) {
		return dao.empInsert(vo);
	}

	@Override
	public int idCheck(String empid) {
		return dao.idCheck(empid);
	}

	@Override
	public AdminVO loginCheck(AdminVO vo) {
		return dao.loginCheck(vo);
	}

	@Override
	public List<ReserveVO> custList(PagingVO pVO) {
		return dao.custList(pVO);
	}

	@Override
	public int totalRecord(PagingVO pVO) {
		return dao.totalRecord(pVO);
	}

	@Override
	public int custInsert(ReserveVO vo) {
		return dao.custInsert(vo);
	}

	@Override
	public ReserveVO custSelect(int custno) {
		return dao.custSelect(custno);
	}

	@Override
	public int custUpdate(ReserveVO vo) {
		return dao.custUpdate(vo);
	}

	@Override
	public int custListMultiDelete(ReserveVO vo) {
		return dao.custListMultiDelete(vo);
	}

	@Override

	public List<ReserveVO> calSelect() {
		return dao.calSelect();
	}
}
