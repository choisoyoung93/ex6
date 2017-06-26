package com.choa.ex6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;
import com.choa.util.MakePage;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

@Controller
@RequestMapping(value = "/memo/**")
public class MemoController {
	@Autowired
	private MemoService memoService;
	
	@RequestMapping(value = "memoList", method = RequestMethod.GET)
	public void memoList() throws Exception{
	}
	
	@RequestMapping(value = "getMemoList/{curPage}/{kind}/{search}", method = RequestMethod.GET)
	@ResponseBody //return하는 데이터를 view가 아닌 돌아가는 데이터로 보냄
	public List<MemoDTO> memoList(@PathVariable("curPage") Integer curPage, @PathVariable("kind") String kind, @PathVariable("search") String search, Model model) throws Exception{
		PageMaker pageMaker = new PageMaker(curPage);
		RowMaker rowMaker = pageMaker.getRowMaker("%", "%");
		int totalCount = memoService.boardCount(rowMaker);
		MakePage makePage = pageMaker.getMakePage(totalCount);
		List<MemoDTO> ar = memoService.boardList(rowMaker);
		
		return ar;
	}
	
	@RequestMapping(value = "memoView/{num}")
	@ResponseBody
	public MemoDTO memoView(@PathVariable("num") Integer num) throws Exception{
						
		MemoDTO memoDTO = memoService.boardView(num);
		return memoDTO;
	}
	
	@RequestMapping(value = "memoWrite", method = RequestMethod.POST)
	public String memoWrite(MemoDTO memoDTO, Model model) throws Exception{
		int result = memoService.boardWrite(memoDTO);
		String message = "WRITE FAIL";
		if(result > 0){
			message = "WRITE SUCCESS";
		}
		model.addAttribute("message", message);
		return "commons/ajaxResult";
	}
}
