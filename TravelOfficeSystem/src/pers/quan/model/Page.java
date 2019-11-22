package pers.quan.model;

import java.util.List;

/**
 * @Description 分页bean
 * @author 何永泉
 * @param <T>
 * @date 2019年8月23日 上午10:55:17
 *
 */
public class Page<T> {

	// 开始页
	private int startIndex;
	// 每页数据数
	private int pageSize;
	// 总数据量
	private int rows;
	// 当前页
	private int currentPage;
	// 总页面数
	private int pages;
	// 需要分页的数据集合
	private List<T> list;
	
	public Page() {
	}
	
	// 自动获取分页所需开始索引值
	public int getStartIndex() {
		startIndex = (currentPage - 1) * pageSize;
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	// 自动获取页面总数
	public int getPages() {
		if (pageSize > 0) {
			if (rows % pageSize == 0) {
				pages = rows / pageSize;

			} else {
				pages = rows / pageSize + 1;
			}
		}
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

}
