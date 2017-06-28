package com.choa.ex6;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.table.TableADTO;
import com.choa.table.TableService;

public class TableTest extends MyAbstractTest{
	@Autowired
	private TableService tableService;
	
	@Test
	public void test() throws Exception{
		TableADTO tableADTO = new TableADTO();
		tableADTO.setNum(6);
		tableADTO.setWriter("t6");
		tableADTO.setTitle("t6");
		int result = tableService.insertTable(tableADTO, 5);
		assertNotEquals(0, result);
	}

}
