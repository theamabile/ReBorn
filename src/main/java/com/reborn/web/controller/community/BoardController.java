package com.reborn.web.controller.community;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.reborn.web.entity.community.Board;
import com.reborn.web.entity.community.BoardView;
import com.reborn.web.entity.community.Comment;
import com.reborn.web.entity.community.CommentView;
import com.reborn.web.entity.community.Like;
import com.reborn.web.service.community.BoardService;

@Controller
@RequestMapping("/community")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	//글 리스트
	@RequestMapping("list")
	public String list(
		@RequestParam(name="p", defaultValue ="1") int page,
		@RequestParam(name="v", defaultValue = "10") int view,		
		@RequestParam(name="f", defaultValue ="title") String field,
		@RequestParam(name="q", defaultValue = "") String query, 
		@RequestParam(name="c", defaultValue = "", required = false) String option,
		Model model) {
		
		List<BoardView> list = service.getViewList(page, view, field, query, option);
		System.out.println(page + ","+ view +","+field+","+query+","+option);
		int count = service.getCount(field, query);
		
		//int size = view;
		int pageCount = (int)Math.ceil(count/(float)view);
		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		
		return "home.community.list";
	}
	//글 상세 Get 방식
	@GetMapping("{id}")
	public String detail(Model model, @PathVariable("id") int id,
			HttpServletRequest httpRequest
			) {
//		int memberId = ((Member) httpRequest.getSession().getAttribute("login")).
				
		BoardView board = service.get(id);		
		model.addAttribute("b", board);
		
		System.out.println(board.getId());
		
		List<CommentView> comment = service.getCommentViewList(id);
		model.addAttribute("comment", comment);
		
		int commentCount = service.getCommentCount(id);
		model.addAttribute("commentCount", commentCount);
		
//		Like like = new Like();
//		like.setBoardId(id);
//		like.setMemberId(memberId);		
		
		int likeCount = service.getLikeCount(id);
		model.addAttribute("likeCount", likeCount);
		
		return "home.community.detail";		
	}
	
	@PostMapping("{id}/like" )
	@ResponseBody
	public Map<String, Object> like(Model model, @PathVariable("id") int id,						
			HttpServletRequest httpRequest) {
		
		
		String likes;		
		
		Like like = new Like();
		like.setBoardId(id);
		like.setMemberId(1);
		
		int result = service.getCount(id, 1);
		
		if(result == 0) { 		
		  service.insert(like);
			likes = "insert";
		} else {
			service.delete(id, 1);
			likes = "delete";
		}		
		int likeCount = service.getLikeCount(id);		
		Map<String, Object> dto = new HashMap<>();
		dto.put("likes", likes);
		dto.put("likeCount", likeCount);
		
		return dto;		
	}
	
	
	
	//글 수정 요청
	@GetMapping("{id}/edit")
	public String edit(Model model, @PathVariable("id") int id) {
		
		BoardView board = service.get(id);
		model.addAttribute("b", board);
		
		return "home.community.edit";
	}
	
	//글 수정 Post
	@PostMapping("{id}/edit")
	public String edit(Board board, @RequestParam(name="category", defaultValue ="1") int category,
			@RequestParam(name="file", defaultValue = "", required = false) Part filePart,
			HttpServletRequest request) throws IOException {
		int id = board.getId();
		String title = board.getTitle();
		String content = board.getContent();
		String fileName = ""; 
		
		if(filePart != null) {
			fileName = filePart.getSubmittedFileName();
			board.setFiles(fileName);
			
			String pathTemp = request.getServletContext().getRealPath("/uploadFiles/board/2021/"+id+"/");
			System.out.println(pathTemp);
			
			File path = new File(pathTemp);
			if(!path.exists())	
				path.mkdirs();
			
			String filePath = pathTemp + File.separator + fileName;
			
			InputStream fis = filePart.getInputStream();
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1)
					fos.write(buf, 0, size);
			
			fos.close();
			fis.close();
		}//end if
		
		
		
		
		
		
		
		Board origin = service.get(board.getId());
		origin.setTitle(title);
		origin.setContent(content);
		origin.setBoardCategoryId(category);
		System.out.println(content + "/" + category);
		System.out.println(board.getId());
		
		service.update(origin);
		
		return "redirect:../"+board.getId();
	} 
	
	
	
	//글 삭제
	@RequestMapping("{id}/del")
	public String delete(@PathVariable("id") int id) {
		System.out.println("========="+id);
		service.delete(id);
		
		return "redirect:../list";
		
	}
	
	//글 요청
	@GetMapping("reg")
	public String reg() {
		return "home.community.reg";
	}
	
	//글 등록
	@PostMapping("reg")
	public String reg(@RequestParam(name="title") String title,
			@RequestParam(name="content") String content,
			@RequestParam(name="category") int category,
			@RequestParam(name="memberId", defaultValue = "1" ) int member,
			@RequestParam(name="file", defaultValue = "", required = false) Part filePart,
			Principal principal, HttpServletRequest request) throws IOException, ServletException {
//		String uid = principal.getName();
//		int id = Integer.parseInt(uid);
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setBoardCategoryId(category);
		Board lastId = service.getLastId();
		int newBoardId = lastId.getId()+1;
		board.setId(newBoardId);
		//멤버ID는 멤버가 주는 값으로 수정해야 함.		
		board.setMemberId(1);
		
//		if(filePart != null) {
//			String fileName = filePart.getSubmittedFileName();
//			board.setFiles(fileName);
//			
//			String pathTemp = request.getServletContext().getRealPath("/uploadFiles/board/2021/"+newBoardId+"/");
//			System.out.println(pathTemp);
//			
//			File path = new File(pathTemp);
//			if(!path.exists())	
//				path.mkdirs();
//			
//			String filePath = pathTemp + File.separator + fileName;
//			
//			InputStream fis = filePart.getInputStream();
//			FileOutputStream fos = new FileOutputStream(filePath);
//			
//			byte[] buf = new byte[1024];
//			int size = 0;
//			while((size = fis.read(buf)) != -1)
//					fos.write(buf, 0, size);
//			
//			fos.close();
//			fis.close();
//		}//end if
		Collection<Part> fileParts = request.getParts();
		String fileName = "";
		String fileNames = "";
		for(Part p : fileParts) {
			if(p.getName().equals("file") && p.getSize()>0 ) {
				filePart = p;
				fileName = filePart.getSubmittedFileName();
				fileNames += fileName;
				fileNames += ",";
				
				String url = "/upload/community/2021/"+newBoardId;
				String pathTemp = request.getServletContext().getRealPath(url);
				System.out.println("pathTemp"+pathTemp);
				
				File path = new File(pathTemp);
				if(!path.exists())
						path.mkdirs();
				
				String filePath = pathTemp + File.separator + fileName;
				System.out.println(filePath);
				
				InputStream fis = filePart.getInputStream();
				FileOutputStream fos = new FileOutputStream(filePath);
				
				byte[] buf = new byte[1024];
				int size = 0;
				while((size = fis.read(buf)) != -1)
						fos.write(buf, 0, size);
				
				fos.close();
				fis.close();
	}
}
	
		board.setFiles(fileNames);
		System.out.println(fileNames);		
		
		service.insert(board);
		
		return "redirect:list";
	}
	
	//댓글 삭제
	@RequestMapping("{id}/comment/{commentId}/del")
	public String commentDelete(@PathVariable("id") int id,
			@PathVariable("commentId") int commentId
			) {
		
		System.out.println(id);
		service.commentDelete(commentId);
		
		return "redirect:../../../"+id;
	}
	
	//댓글 수정 요청
	@GetMapping("{id}/comment/{commentId}/edit")
	public String commentEdit(@PathVariable("id")  int id,
			@PathVariable("commentId") int commentId,
			Model model
			) {
		
			
		
		return "../../../"+id;
	}
	
	
	//댓글 작성
	@PostMapping("{id}/comment/write")
	public String commentWrite(
			@PathVariable("id") int id,
			@RequestParam(name="comment") String commentContent,			
			Principal principal
			) {
		Comment comment = new Comment();
		comment.setContent(commentContent);
		comment.setMemberId(1);
		comment.setBoardId(id);
		
		service.commentInsert(comment);
		return "redirect:../../"+id;
	
	}
	
	
	
	
	
}
