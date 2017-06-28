package com.choa.table;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TableDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "tableMapper.";
	
	public int insertTableA(TableADTO tableADTO) throws Exception{
		return sqlSession.insert(NAMESPACE + "insertTableA", tableADTO);
	}
	
	public int insertTableB(TableBDTO tableBDTO) throws Exception{
		return sqlSession.insert(NAMESPACE + "insertTableB", tableBDTO);
	}
}
