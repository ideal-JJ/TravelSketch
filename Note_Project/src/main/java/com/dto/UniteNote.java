package com.dto;

import java.util.HashMap;
import java.util.List;

public class UniteNote {
	
	private List<Note> note;
	
	private List<HashMap<Integer, Integer>> replyList;
	private List<HashMap<Integer, Integer>> likeList;
	
	public UniteNote() { }

	public UniteNote(List<Note> note, List<HashMap<Integer, Integer>> replyList,
			List<HashMap<Integer, Integer>> likeList) {
		super();
		this.note = note;
		this.replyList = replyList;
		this.likeList = likeList;
	}

	public List<Note> getNote() {
		return note;
	}

	public void setNote(List<Note> note) {
		this.note = note;
	}

	public List<HashMap<Integer, Integer>> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<HashMap<Integer, Integer>> replyList) {
		this.replyList = replyList;
	}

	public List<HashMap<Integer, Integer>> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<HashMap<Integer, Integer>> likeList) {
		this.likeList = likeList;
	}
	
	
	
	
}
