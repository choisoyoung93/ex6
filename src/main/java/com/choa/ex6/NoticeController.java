package com.choa.ex6;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeServiceImpl;
import com.choa.util.ListInfo;
import com.choa.util.MakePage;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	@Autowired //inject는 data type으로 찾음
	private NoticeServiceImpl noticeService;
	
	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public String noticeList(Model model, ListInfo listInfo) throws Exception{
		PageMaker pageMaker = new PageMaker(listInfo.getCurPage());
		RowMaker rowMaker = pageMaker.getRowMaker(listInfo.getKind(), listInfo.getSearch());
		int totalCount = noticeService.boardCount(rowMaker);
		MakePage makePage = pageMaker.getMakePage(totalCount);
		List<BoardDTO> boardList = noticeService.boardList(rowMaker);
		
		model.addAttribute("board", "notice").addAttribute("boardList", boardList);
		model.addAttribute("makePage", makePage).addAttribute("kind", listInfo.getKind()).addAttribute("search", listInfo.getSearch()).addAttribute("curPage", listInfo.getCurPage());
		return "board/boardList";
	}
	
	@RequestMapping(value = "noticeView", method = RequestMethod.GET)
	public String noticeView(Model model, Integer num) throws Exception{
		if(num != null){ 
			BoardDTO boardDTO = noticeService.boardView(num);
			model.addAttribute("board", "notice");
			model.addAttribute("boardDTO", boardDTO);
		}
		return "board/boardView";
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String noticeWrite(Model model){
		model.addAttribute("board", "notice");
		model.addAttribute("path", "Write");
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView noticeWrite(NoticeDTO noticeDTO, RedirectAttributes reAttributes) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.boardWrite(noticeDTO);
		String message = "FAIL";
		if(result > 0){
			message = "SUCCESS";
		}
		//reAttributes.addAttribute("message", message);//주소창에 파라미터가 남음
		reAttributes.addFlashAttribute("message", message);//주소창에 남지 않음
		//mv.addObject("message", message);
		mv.setViewName("redirect:noticeList?curPage=1");
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public String noticeUpdate(Model model, Integer num) throws Exception{
		if(num != null){ 
			System.out.println(num);
			BoardDTO boardDTO = noticeService.boardView(num);
			model.addAttribute("boardDTO", boardDTO);
			model.addAttribute("board", "notice");
			model.addAttribute("path", "Update");
		}
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO, RedirectAttributes reAttributes) throws Exception{		
		System.out.println("Notice Update Process");
		int result = noticeService.boardUpdate(noticeDTO);
		String message = "FAIL";
		if(result > 0){
			message = "SUCCESS";
		}
		reAttributes.addFlashAttribute("message", message);
		return "redirect:noticeView?num="+noticeDTO.getNum();
	}
	
	@RequestMapping(value = "noticeDelete", method = RequestMethod.GET)
	public String noticeDelete(Integer num, RedirectAttributes reAttributes) throws Exception{
		System.out.println("Notice Delete Process");
		if(num != null){
			int result = noticeService.boardDelete(num);
			String message = "FAIL";
			if(result > 0){
				message = "SUCCESS";
			}
			reAttributes.addFlashAttribute("message", message);
		}
		return "redirect:noticeList";
	}
}
