package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MemberDAO;
import com.dto.Chart;
import com.dto.Login;
import com.dto.Member;

@Service
public class MemberService {

	@Autowired
	MemberDAO mDao;
	
	public Member login(Login x) {
		return mDao.login(x);
	}
	
	public Chart chartSelect() {
		return mDao.chartSelect();
	}
}
