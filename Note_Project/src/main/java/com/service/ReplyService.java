package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ReplyDAO;

@Service
public class ReplyService {

	@Autowired
	public ReplyDAO dao;
	
	public List<HashMap<Integer, Integer>> selectNotePageRangePerReply(ArrayList<Integer> list) {
		return dao.selectNotePageRangePerReply(list);
	}
}
