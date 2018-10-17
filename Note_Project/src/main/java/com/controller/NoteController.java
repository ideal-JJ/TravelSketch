package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.dto.Chapter;
import com.dto.FineLike;
import com.dto.Member;
import com.dto.Note;
import com.dto.Reply;
import com.dto.Upload;
import com.service.LikeService;
//import com.dto.Note;
import com.service.NoteService;
import com.service.ReplyService;

@Controller
public class NoteController {
	
//	private static final int RESULT_EXCEED_SIZE = -2;
//    private static final int RESULT_UNACCEPTED_EXTENSION = -1;
//    private static final int RESULT_SUCCESS = 1;
//    private static final long LIMIT_SIZE = 10 * 1024 * 1024;
	
	@Autowired
	NoteService nService;
	
	@Autowired
	ReplyService rService;
	
	@Autowired
	LikeService lkService;

	@RequestMapping("/test")
	public String home(RedirectAttributes flash) {
		
		HashMap<String, Integer> map = new HashMap<>();
		List<HashMap<Integer, Integer>> replyList = new ArrayList();
		List<HashMap<Integer, Integer>> likeList = new ArrayList();
		
		map.put("f_range", 1);
		map.put("l_range", 5);
		
		List<Integer> rangeList = nService.selectNotePageRange(map);
		System.out.println("rangeList : " + rangeList);

//		replyList = rService.selectNotePageRangePerReply((ArrayList<Integer>) rangeList);
//		System.out.println("replyList == " + replyList);
//		
//		likeList = lkService.selectNotePageRangePerLike((ArrayList<Integer>) rangeList);
//		System.out.println("likeList === " + likeList);
		
		List<Note> noteList = nService.selectNoteAll((ArrayList<Integer>) rangeList);
		
		/*for (int range : rangeList) {
			System.out.println("range : " + range);
			
			for (Note note : noteList) {
				
				if (range == note.getNtIdx()) {
					
					UniteNote uNote = new UniteNote(
						note.getNtIdx(), 
						note.getUuId(), 
						note.getUserName(),
						note.getuPhoto(),
						note.getNtTitle(),
						note.getNtDate(),
						note.getChIdx(),
						note.getChTitle(),
						note.getChTravelDate(),
						note.getPctImgs()
					);
				}
			}
		}*/
		
		
		/*int beforeIdx = 0;
		
		for (Note note : noteList) {
			if (beforeIdx != note.getNtIdx()) {
				beforeIdx = note.getNtIdx();
				
				UniteNote uNote = new UniteNote();
				uNote.setNtIdx(note.getNtIdx()); 
				uNote.setUuId(note.getUuId());
				uNote.setUserName(note.getUserName());
				uNote.setuPhoto(note.getuPhoto());
				uNote.setNtTitle(note.getNtTitle());
				uNote.setNtDate(note.getNtDate());
				uNote.setChIdx(note.getChIdx());
				uNote.setChTitle(note.getChTitle());
				uNote.setChTravelDate(note.getChTravelDate());
				uNote.setPctImgs(note.getPctImgs());
				
			} else {
				
			}
		}*/
		
		flash.addFlashAttribute("noteList", noteList);
		
		return "redirect:/";
		
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
	
	@RequestMapping("chapterList/noteIdx/{noteIdx}")
	public String chapterList(@PathVariable int noteIdx, HttpSession session, RedirectAttributes flash) {
		Member m = (Member) session.getAttribute("login");
		int uuid = m.getUuid();
		
		List<Chapter> chapterList = nService.chapterList(noteIdx);
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
		
		System.out.println(">>> " + noteIdx + ", " + uuid);
		
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
	
	@RequestMapping("/upload")
	public String home() {
		return "upload";
	}
	
	@RequestMapping("/noteUpload")
	// Upload 클래스를 만들어서 저장을 한다 - Upload 값을 info.jsp에서 확인을 할 수 잇따
	public String upload(Upload x) {
		String theText = x.getTheText();
		CommonsMultipartFile theFile = x.getTheFile();
		
		long size = theFile.getSize();
		String name = theFile.getName();
		String OriFileName = theFile.getOriginalFilename();
		String contentType = theFile.getContentType();
		
		System.out.println("size : " + size);
		System.out.println("name : " + name);
		System.out.println("OriFileName : " + OriFileName);
		System.out.println("contentType : " + contentType);
		
		// 파일 저장
		File f = new File("c:\\upload", OriFileName);
		
		try {
			// 실제로 저장
			theFile.transferTo(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "info";
	}
	
	@RequestMapping(value = "requestupload2")
    public String requestupload2(MultipartHttpServletRequest mtfRequest, HttpSession session) {
        List<MultipartFile> fileList = mtfRequest.getFiles("file");
        String src = mtfRequest.getParameter("src");
        System.out.println("src value : " + src);

        String path = "C:\\upload\\";
        
        List<List<String>> groupPicList = new ArrayList<List<String>>();
        List<String> picList = new ArrayList<String>();

        for (MultipartFile mf : fileList) {
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            long fileSize = mf.getSize(); // 파일 사이즈

            System.out.println("originFileName : " + originFileName);
            System.out.println("fileSize : " + fileSize);

            String safeFile = path + System.currentTimeMillis() + originFileName;
            System.out.println("safeFile : " + safeFile);
            try {
                mf.transferTo(new File(safeFile));
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "info";
    }


}
