package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LikeDAO;

@Service
public class LikeService {

	@Autowired
	public LikeDAO dao;
	
	public List<HashMap<Integer, Integer>> selectNotePageRangePerLike(ArrayList<Integer> list) {
		return dao.selectNotePageRangePerLike(list);
	}
}
