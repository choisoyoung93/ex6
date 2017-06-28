package com.choa.aspect;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.choa.board.BoardDTO;
import com.choa.util.MakePage;

public class TestInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// Controller 빠져 나올 때 -> DispatcherServlet
		System.out.println("Controller 나온 후");
		Map<String, Object> modelMap = modelAndView.getModel();
		Object list = modelMap.get("boardList");
		Object makePage = modelMap.get("makePage");
		Object board = modelMap.get("board");
		
		//modelAndView.addObject(attributeName, attributeValue);	넣을 수도 있음
		modelAndView.setViewName("home");
		
		System.out.println("[0]Title : " + ((List<BoardDTO>)list).get(0).getTitle());
		System.out.println("CurBlock: " + ((MakePage)makePage).getCurBlock());
		System.out.println("Board: " + board);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("Controller 가기 전");
		return true;
	}
	
}
