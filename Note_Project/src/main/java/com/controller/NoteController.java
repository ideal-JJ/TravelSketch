package com.controller;

import java.util.ArrayList;
//import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.Note;
import com.service.LikeService;
//import com.dto.Note;
import com.service.NoteService;
import com.service.ReplyService;

@Controller
public class NoteController {
	
	@Autowired
	NoteService nService;
	
	@Autowired
	ReplyService rService;
	
	@Autowired
	LikeService lkService;

	@RequestMapping("/test")
	public String home() {
		
		HashMap<String, Integer> map = new HashMap<>();
		List<HashMap<Integer, Integer>> replyList = new ArrayList();
		List<HashMap<Integer, Integer>> likeList = new ArrayList();
		
		map.put("f_range", 6);
		map.put("l_range", 10);
		
		List<Integer> rangeList = nService.selectNotePageRange(map);
		System.out.println("rangeList : " + rangeList);

		replyList = rService.selectNotePageRangePerReply((ArrayList<Integer>) rangeList);
		System.out.println("replyList == " + replyList);
		
		likeList = lkService.selectNotePageRangePerLike((ArrayList<Integer>) rangeList);
		System.out.println("likeList === " + likeList);
		
		List<Note> noteList = nService.selectNoteAll((ArrayList<Integer>) rangeList);
		System.out.println("noteList === " + noteList);
		
		return "/home";
//		Date date = new Date();
		
//		Chapter ch = new Chapter(1, 1, "이거슨", date);
//		Picture pct = new Picture("a.jpg");
//		Reply rp = new Reply(3);
//		FineLike flk = new FineLike(32);
		
//		Note nt = new Note(1, 1042, "재밌네요", date, ch); //, pct, rp, flk);
//		
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/note.xml");
//		NoteService service = ctx.getBean("service", NoteService.class);
//		
//		List<Note> list = service.selectList();
//		
//		for (Note dto : list) {
//			System.out.println(dto.getNtTitle());
//		}
//		
//		return "nt";
//		
	}

}
