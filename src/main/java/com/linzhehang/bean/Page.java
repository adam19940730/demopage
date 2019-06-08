package com.linzhehang.bean;

import java.util.List;

public class Page<T> {
	private int pg;// 当前页面
	private int size;// 每页行数
	private int countRow;// 总行数
	private int maxPage;// 总页数
	private int pre;// 上一页
	private int next;// 下一页
	private int startLine;// 起始行
	private int startPage;// 起始页
	private int endPage;// 结束页
	private List<T> list;// 分页数据

	public Page(int p, int sz, int cr) {
		// 当前页面
		this.pg = p;
		// 每页行数
		this.size = sz;
		// 总行数
		this.countRow = cr;
		// 总页数
		this.maxPage = (int) Math.ceil(this.countRow * 1.0 / this.size);
		// 利用总页数，将当前页数控制在有效范围内
		if (this.pg < 1)
			this.pg = 1;
		if (this.pg > this.maxPage)
			this.pg = this.maxPage;
		// 上一页
		this.pre = this.pg - 1;
		// 下一页
		this.next = this.pg + 1;
		// 起始行
		this.startLine = (this.pg - 1) * this.size;
		// 根据页面的展示不同，当最大行数小于10时，需要对其进行处理
		if (this.maxPage <= 10) {
			this.startPage = 1;
			this.endPage = this.maxPage;
		} else {
			this.startPage = this.pg - 5;
			this.endPage = this.pg + 4;
			//当起始页减5后，可能出现小于1，此时让起始页为1
			if (this.startPage < 1) {
				this.startPage = 1;
				this.endPage = 10;
			}
			//当结束页加4后，可能出现大于总页数，此时让结束页等于总页数
			if (this.endPage >= this.maxPage) {
				this.startPage = this.maxPage - 9;
				this.endPage = this.maxPage;
			}

		}

	}

	public int getPg() {
		return pg;
	}

	public void setPg(int pg) {
		this.pg = pg;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCountRow() {
		return countRow;
	}

	public void setCountRow(int countRow) {
		this.countRow = countRow;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getPre() {
		return pre;
	}

	public void setPre(int pre) {
		this.pre = pre;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getStartLine() {
		return startLine;
	}

	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Page [pg=" + pg + ", size=" + size + ", countRow=" + countRow + ", maxPage=" + maxPage + ", pre=" + pre
				+ ", next=" + next + ", startLine=" + startLine + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", list=" + list + "]";
	}

}
