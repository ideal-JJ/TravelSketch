package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.NoteDAO;
import com.dto.Note;

@Service
public class NoteService {
	
	@Autowired
	public NoteDAO dao;
	
	public List<Integer> selectNotePageRange(HashMap<String, Integer> map) {
		return dao.selectNotePageRange(map);
	}
	
	public List<Note> selectNoteAll(ArrayList<Integer> list) {
		return dao.selectNoteAll(list);
	}
}
