package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.NoteDAO;
import com.dto.Note;

public class NoteService {
	
	@Autowired
	public NoteDAO dao;
	
	public List<Note> selectList() {
		return dao.selectList();
	}
}
