package com.dto;

import org.apache.ibatis.type.Alias;

@Alias("ChapterIdx")
public class ChapterIdx {
	private int chIdx;

	public ChapterIdx() { }

	public int getChIdx() {
		return chIdx;
	}

	public void setChIdx(int chIdx) {
		this.chIdx = chIdx;
	}
	
	
}
