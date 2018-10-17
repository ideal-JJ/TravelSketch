package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.Chapter;
import com.dto.FineLike;
import com.dto.Note;
import com.dto.Reply;

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
	
	public List<Chapter> chapterList(int noteIdx) {
		return template.selectList("chapterList", noteIdx);
	}
	
	public List<FineLike> likeOfNote(int noteIdx) {
		return template.selectList("likeOfNote", noteIdx);
	}
	
	public List<Reply> replyOfNote(int noteIdx) {
		return template.selectList("replyOfNote", noteIdx);
	}
	
	public int selectUserLikeCount(HashMap<String, Integer> map) {
		return template.selectOne("selectUserLikeCount", map);
	}
	
	public int insertLike(HashMap<String, Integer> map) {
		return template.insert("insertLike", map);
	}
	
	public int deleteLike(HashMap<String, Integer> map) {
		return template.delete("deleteLike", map);
	}
}
