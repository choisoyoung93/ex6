package com.choa.ex6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.board.BoardDTO;
import com.choa.memo.MemoDAO;
import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.notice.NoticeDAOImpl;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;


public class DTOTest extends MyAbstractTest{

	@Autowired
	private MemoService memoService;
	
	@Test
	public void test() throws Exception{
		/*PageMaker pageMaker = new PageMaker(1);
		RowMaker rowMaker = pageMaker.getRowMaker("", "");
		List<MemoDTO> ar = memoService.boardList(rowMaker);
		System.out.println(ar.size());
		System.out.println(ar.get(0).getWriter());
		assertNotEquals(0, ar.size());
		*/
		/*
		List<MemoDTO> ar = memoDAO.memoList(rowMaker);
		System.out.println(ar.size());
		assertNotEquals(0, ar.size());*/
		
		/*MemoDTO memoDTO = new MemoDTO();
		//memoDTO.setNum(1);
		memoDTO.setWriter("soyoung");
		memoDTO.setContents("댓글달기");
		int result = memoService.boardWrite(memoDTO);
		assertEquals(1, result);
		*/
		/*int result = memoDAO.memoUpdate(memoDTO);
		assertEquals(1, result);*/
		
		/*int result = memoService.boardDelete(1);
		assertEquals(1, result);*/
		
		MemoDTO memoDTO = memoService.boardView(1);
		System.out.println(memoDTO.getContents());
		assertNotNull(memoDTO);
	}

}
