package com.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Chart;
import com.dto.Login;
import com.dto.Member;

@Repository
public class MemberDAO {

	@Autowired
	SqlSessionTemplate template;
	
	public Member login(Login x) {
		System.out.println("user id : " + x.getUserid()); 
		Member m = template.selectOne("MemberMapper.login", x);
		return m;
	}
	
	public Chart chartSelect() {
		Chart chart = template.selectOne("chartSelect");
		return chart;
	}
}
