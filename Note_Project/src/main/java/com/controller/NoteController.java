package com.controller;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.Note;
import com.service.NoteService;

@Controller
public class NoteController {

	@RequestMapping("/home")
	@ModelAttribute("nt")
	public String home() {
		
		Date date = new Date();
		
//		Chapter ch = new Chapter(1, 1, "이거슨", date);
//		Picture pct = new Picture("a.jpg");
//		Reply rp = new Reply(3);
//		FineLike flk = new FineLike(32);
		
//		Note nt = new Note(1, 1042, "재밌네요", date, ch); //, pct, rp, flk);
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:com/config/note.xml");
		NoteService service = ctx.getBean("service", NoteService.class);
		
		List<Note> list = service.selectList();
		
		for (Note dto : list) {
			System.out.println(dto.getNtTitle());
		}
		
		return "nt";
	}

}