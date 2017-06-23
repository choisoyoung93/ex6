package com.choa.board;

import java.util.List;

import com.choa.util.RowMaker;

public interface BoardService {
	//List
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception;
	
	//View
	public BoardDTO boardView(int num) throws Exception;
	
	//Write
	public int boardWrite(BoardDTO boardDTO) throws Exception;
	
	//Update
	public int boardUpdate(BoardDTO boardDTO) throws Exception;
	
	//Delete
	public int boardDelete(int num) throws Exception;
	
	//Count
	public int boardCount(RowMaker rowMaker) throws Exception;
}
