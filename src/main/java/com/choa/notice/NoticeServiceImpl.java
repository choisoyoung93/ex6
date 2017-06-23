package com.choa.notice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.RowMaker;

@Service
//NoticeService noticeService = new NoticeService();
public class NoticeServiceImpl implements BoardService{
	@Autowired
	private NoticeDAOImpl noticeDAO;	
	
	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {
		List<BoardDTO> noticeArr = noticeDAO.boardList(rowMaker);
		return noticeArr;
	}
	
	@Override
	public BoardDTO boardView(int num) throws Exception {
		noticeDAO.boardHit(num);
		BoardDTO noticeDTO = noticeDAO.boardView(num);		
		return noticeDTO;
	}
	
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardWrite(boardDTO);
	}
	
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardUpdate(boardDTO);
	}
	
	@Override
	public int boardDelete(int num) throws Exception {
		return noticeDAO.boardDelete(num);
	}
	
	@Override
	public int boardCount(RowMaker rowMaker) throws Exception {
		return noticeDAO.boardCount(rowMaker);
	}
}
