package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Note;

@Repository
public class NoteDAO {

	@Autowired
	SqlSessionTemplate template;
	
	public List<Integer> selectNotePageRange(HashMap<String, Integer> map) {
		return template.selectList("selectNotePageRange", map);
	}
	
	public List<Note> selectNoteAll(ArrayList<Integer> list) {
		return template.selectList("selectNoteAll", list);
	}
}
