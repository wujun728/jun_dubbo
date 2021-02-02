package com.yuxuntoo.www.common.vo.resp;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
 * 对Page<E>结果进行包装
 * <p/>
 * 新增分页的多项属性，
 *
 * @author Camel
 * 
 */
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     *  当前页
     */
    private int pageNum;
    /**
     *  每页的数量
     */
    private int pageSize;
    /**
     *  总记录数
     */
    private long total;
    /**
     *  总页数
     */
    private int pages;
    /**
     *  结果集
     */
    private List<T> lists;
    /**
     *  是否为第一页
     */
    private boolean isFirstPage = false;
    /**
     *  是否为最后一页
     */
    private boolean isLastPage = false;


    public PageInfo() {
    }

    /**
     * 分页
     * @param list        列表数据
     * @param totalCount  总记录数
     * @param pageSize    每页记录数
     * @param currPage    当前页数
     */
    public PageInfo(List<T> list, int totalCount, int pageSize, int currPage) {
        this.lists = list;
        this.total = totalCount;
        this.pageSize = pageSize;
        this.pageNum = currPage;
        this.pages = (int)Math.ceil((double)totalCount/pageSize);
    }

    /**
     * 包装Page对象
     *
     * @param lists
     */
    public PageInfo(List<T> lists) {
        if (lists instanceof Page) {
            Page page = (Page) lists;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();

            this.pages = page.getPages();
            this.lists = page;
            this.total = page.getTotal();
        } else if (lists instanceof Collection) {
            this.pageNum = 1;
            this.pageSize = lists.size();

            this.pages = 1;
            this.lists = lists;
            this.total = lists.size();
        }
        if (lists instanceof Collection) {
            //判断页面边界
            judgePageBoudary();
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }


    public List<T> getLists() {
		return lists;
	}

	public void setLists(List<T> lists) {
		this.lists = lists;
	}

	public boolean isIsFirstPage() {
        return isFirstPage;
    }

    public void setIsFirstPage(boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
    }

    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", lists=").append(lists);
        sb.append(", isFirstPage=").append(isFirstPage);
        sb.append(", isLastPage=").append(isLastPage);
        sb.append(", navigatepageNums=");
        sb.append('}');
        return sb.toString();
    }
}