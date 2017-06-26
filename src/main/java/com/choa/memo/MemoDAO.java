package com.choa.memo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.util.RowMaker;

@Repository
public class MemoDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "memoMapper.";
	
	//list
	public List<MemoDTO> boardList(RowMaker rowMaker) throws Exception{
		return sqlSession.selectList(NAMESPACE + "list", rowMaker);
	}
	
	//View
	public MemoDTO boardView(int num) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "view", num);
	}
	
	//Write
	public int boardWrite(MemoDTO memoDTO) throws Exception{
		return sqlSession.insert(NAMESPACE + "write", memoDTO);
	}
	
	//Update
	public int boardUpdate(MemoDTO memoDTO) throws Exception{
		return sqlSession.update(NAMESPACE + "update", memoDTO);
	}
	
	//Delete
	public int boardDelete(int num) throws Exception{
		return sqlSession.delete(NAMESPACE + "delete", num);
	}
	
	//Count
	public int boardCount(RowMaker rowMaker) throws Exception{
		return sqlSession.selectOne(NAMESPACE + "count", rowMaker);
	}
}
