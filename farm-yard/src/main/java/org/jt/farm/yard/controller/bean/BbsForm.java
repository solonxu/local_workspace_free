package org.jt.farm.yard.controller.bean;

import java.util.List;

public class BbsForm {
	private String  newTitle;
	private String  newContent;
	
	private List<Memo> memoList;

	public String getNewTitle() {
		return newTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newTitle = newTitle;
	}

	public String getNewContent() {
		return newContent;
	}

	public void setNewContent(String newContent) {
		this.newContent = newContent;
	}

	public List<Memo> getMemoList() {
		return memoList;
	}

	public void setMemoList(List<Memo> memoList) {
		this.memoList = memoList;
	}

	
	

	
	
	
}
