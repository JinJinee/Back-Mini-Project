package com.campus.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.campus.myapp.dao.ReserveDAO;
import com.campus.myapp.vo.ReserveVO;

@Service
public class ReserveServiceImpl implements ReserveService{
	@Inject
	ReserveDAO dao;
	
	@Override
	public int custInsert(ReserveVO vo) {
		return dao.custInsert(vo);
	}

}
