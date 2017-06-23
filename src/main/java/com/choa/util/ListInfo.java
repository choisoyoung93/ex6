package com.choa.util;

public class ListInfo {
	private Integer curPage;
	private Integer perPage;
	private String kind;
	private String search;
	public Integer getCurPage() {
		if(curPage==null){
			curPage=1;
		}
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public Integer getPerPage() {
		if(perPage == null) perPage = 10;
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	
}
