package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikeDAO {

	@Autowired
	SqlSessionTemplate template;
	
	public List<HashMap<Integer, Integer>> selectNotePageRangePerLike(ArrayList<Integer> list) {
		return template.selectList("selectNotePageRangePerLike", list);
	}
}
