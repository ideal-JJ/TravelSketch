package com.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dto.Chapter;
import com.dto.ChapterIdx;
import com.dto.FineLike;
import com.dto.InsertChapter;
import com.dto.InsertNote;
import com.dto.InsertPicture;
import com.dto.Member;
import com.dto.Note;
import com.dto.Reply;
import com.service.LikeService;
//import com.dto.Note;
import com.service.NoteService;
import com.service.ReplyService;

@Controller
public class NoteController {
	
	private final String URL_PATH = "http://wo01-ws6491.ktics.co.kr/";
	
	@Autowired
	NoteService nService;
	
	@Autowired
	ReplyService rService;
	
	@Autowired
	LikeService lkService;
	
	ArrayList<Chapter> addChapterList = new ArrayList<>();
	ArrayList<InsertPicture> addPictureList = new ArrayList<>();

	@RequestMapping("/")
	public String home(RedirectAttributes flash) {
		
		System.out.println("home !!!");
		if (addChapterList.size() != 0)
			addChapterList.removeAll(addChapterList);
		
		if (addPictureList.size() != 0)
			addPictureList.removeAll(addPictureList);
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("f_range", 1);
		map.put("l_range", 5);
		
		List<Integer> rangeList = nService.selectNotePageRange(map);

		List<Note> noteList = nService.selectNoteAll((ArrayList<Integer>) rangeList);

		
		flash.addFlashAttribute("noteList", noteList);
		
		return "redirect:/note";
	}
	
	@RequestMapping("/note")
	public String note(RedirectAttributes flash) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		if (addChapterList.size() != 0)
			addChapterList.removeAll(addChapterList);
		
		if (addPictureList.size() != 0)
			addPictureList.removeAll(addPictureList);
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("f_range", 1);
		map.put("l_range", 5);
		
		List<Integer> rangeList = nService.selectNotePageRange(map);
		List<Note> noteList = nService.selectNoteAll((ArrayList<Integer>) rangeList);
		
		flash.addFlashAttribute("noteList", noteList);
		
		return "redirect:/";
	}
	
	@RequestMapping("chapterList/noteIdx/{noteIdx}")
	public String chapterList(@PathVariable int noteIdx, HttpSession session, RedirectAttributes flash) {
		Member m = (Member) session.getAttribute("login");
		int uuid = m.getUuid();
		
		List<Chapter> chapterList = nService.chapterList(noteIdx);
		
		for (Chapter chapter : chapterList) {
			System.out.println("imgs : " + chapter.getChImgs());
		}
		
		List<FineLike> likeList = nService.likeOfNote(noteIdx);
		List<Reply> replyList = nService.replyOfNote(noteIdx);
		
		flash.addFlashAttribute("uuid", uuid);
		flash.addFlashAttribute("noteIdx", noteIdx);
		flash.addFlashAttribute("chapterList", chapterList);
		flash.addFlashAttribute("likeList", likeList);
		flash.addFlashAttribute("replyList", replyList);
		
		return "redirect:/chapter";
	}
	
	@RequestMapping("chapterAddLike")
	public @ResponseBody String chapterAddLike(@RequestParam int noteIdx, HttpSession session, RedirectAttributes flash) {
		Member m = (Member) session.getAttribute("login");
		System.out.println(m.getUserid() + ", " + m.getUuid());
		int uuid = m.getUuid();
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("uuid", uuid);
		map.put("noteIdx", noteIdx);
		
		int likeCount = nService.selectUserLikeCount(map);
		
		String cnt = "hasCount";
		
		if (likeCount == 0) {
			// 카운터가 없으면 insert를 한 후
			int temp = nService.insertLike(map);
			// 현재 유저의 사진을 ajax 값으로 보낸다
			cnt = m.getPhoto();
		} else {
			// 카운트가 있으면 delete 한다
			int temp = nService.deleteLike(map);
		}
		
		return cnt;
	}
	
	@RequestMapping("/noteUpload")
	public String noteUpload(Model m) {
		if (addChapterList.size() != 0)
			addChapterList.removeAll(addChapterList);
		
		if (addPictureList.size() != 0)
			addPictureList.removeAll(addPictureList);
		
		m.addAttribute("uploadPage", "note");
		return "upload";
	}
	
	
	@RequestMapping("/nextChapter")
	// 노트 제목을 폼에서 받는다
	public String nextChapter(@RequestParam String noteTitle, HttpSession session, Model m) {
		
		Member mb = (Member) session.getAttribute("login");
		int uuid = mb.getUuid();
		session.setAttribute("noteTitle", noteTitle);
		
		// chapter 페이지로 넘어가야 하기에 페이지 구분 값을 chapterForm 로 한다
		m.addAttribute("uploadPage", "chapter");
		m.addAttribute("noteTitle", noteTitle);
		m.addAttribute("uuid", uuid);
		
		return "upload";
	}
	
	
	
	@RequestMapping(value = "/addChapter" , method=RequestMethod.POST)
    public @ResponseBody Chapter addChapter(MultipartHttpServletRequest multi) {
         
		String filePath ="C:\\upload\\";
        String newFileName = ""; // 업로드 되는 파일명
         
        File dir = new File(filePath);
        if(!dir.isDirectory()){
            dir.mkdir();
        }
        
        String pics = "";
//        String tempPics = "";
        String slush = "";
        Boolean isSlush = true;
        
        Iterator<String> files = multi.getFileNames();
        while(files.hasNext()){
            String uploadFile = files.next();
                         
            MultipartFile mFile = multi.getFile(uploadFile);
            String fileName = mFile.getOriginalFilename();
            
            System.out.println("fileName :: " + fileName);
            
            if (fileName != "") {
//	            newFileName = System.currentTimeMillis() + fileName;
            	newFileName = fileName;
	            if (isSlush) {
	            	isSlush = false;
	            } else {
	            	slush = "|";
	            }
	            
	            
	            
	            try {
	                mFile.transferTo(new File(filePath + newFileName));
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            
//	            pics += slush + URL_PATH + newFileName;
	            pics += slush + newFileName;
//	            tempPics += slush + newFileName;
            }
        }
        
        System.out.println("pics :: " + pics);
//        System.out.println("tempPics :: " + tempPics);
        
        Date newDate = null;
        try {
        	newDate = new SimpleDateFormat("yyyy-MM-dd").parse(multi.getParameter("travelDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        int increase = Integer.parseInt(multi.getParameter("increase"));
        
    	Chapter ch = new Chapter();
//        ch.setChIdx(0);
        ch.setChIncrease(increase);
        ch.setChTitle(multi.getParameter("chtitle"));
        ch.setChContent(multi.getParameter("content"));
        ch.setChImgs(pics);
        ch.setChMapInfo(multi.getParameter("mapInfo"));
        ch.setChTravelDate(newDate);
        
        addChapterList.add(ch);
        
        
        InsertPicture pic = new InsertPicture();
        pic.setImg(pics);		// img가 없으면 없는대로 넣는다
        
        addPictureList.add(pic);
        
        
        return ch;
    }
	
	@RequestMapping(value = "/saveNote" , method=RequestMethod.POST)
	public String saveNnote(HttpSession session) {
		
		Member mb = (Member) session.getAttribute("login");
		int uuid = mb.getUuid();
		
		String noteTitle = (String) session.getAttribute("noteTitle");
		
		InsertNote addNote = new InsertNote(uuid, noteTitle);

		// note insert
		nService.insertAddNote(addNote);
		
		// 현재 note max 값 가져오기
		int noteIdx = nService.maxNoteIdx();
		
		for (Chapter chapter : addChapterList) {
			chapter.setChNtIdx(noteIdx);
		}
		
		int temp = nService.insertAddChapter(addChapterList);
		
		// 현재 추가한 chapter idx list 값 가져오기
		List<ChapterIdx> chIdxList = nService.ChapterCurrentAddIdxList(noteIdx);
		
		// picture에 데이터 저장
		for (int i = 0; i < addPictureList.size(); i++) {
			addPictureList.get(i).setNtIdx(noteIdx);
			addPictureList.get(i).setChIdx(chIdxList.get(i).getChIdx());
		}
		
		for (InsertPicture picc : addPictureList) {
			System.out.println("> " + picc.getImg());
		}
		
		// picture insert
		int temp2 = nService.insertAddPicture(addPictureList);
		
		
		return "redirect:/note";
	}
	
	
}
