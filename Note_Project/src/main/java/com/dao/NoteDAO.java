package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.dto.Note;


public class NoteDAO {

	@Autowired
	SqlSessionTemplate template;
	
	public List<Note> selectList() {
		return template.selectList("selectAll");
	}
}
