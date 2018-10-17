package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.NoteDAO;
import com.dto.Chapter;
import com.dto.FineLike;
import com.dto.Note;
import com.dto.Reply;

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
	
	public List<Chapter> chapterList(int noteIdx) {
		return dao.chapterList(noteIdx);
	}
	
	public List<FineLike> likeOfNote(int noteIdx) {
		return dao.likeOfNote(noteIdx);
	}
	
	public List<Reply> replyOfNote(int noteIdx) {
		return dao.replyOfNote(noteIdx);
	}
	
	public int selectUserLikeCount(HashMap<String, Integer> map) {
		return dao.selectUserLikeCount(map);
	}
	
	public int insertLike(HashMap<String, Integer> map) {
		return dao.insertLike(map);
	}
	
	public int deleteLike(HashMap<String, Integer> map) {
		return dao.deleteLike(map);
	}
}
