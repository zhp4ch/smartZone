package com.mass.biz.smart.property.suggestion.utils; 

import java.util.List;

/**
 *
 * 项目名称：smartZone-ht
 * 类名称：Page
 * 类描述：
 * 创建人：yihai Zhao
 * 创建时间：2018年7月18日 下午3:07:43
 * 修改人：yihai Zhao
 * 修改时间：2018年7月18日 下午3:07:43
 * 
 * @version
 *
 */
public class Page<T> {

	    public final static int DEFAULT_PAGE_SIZE = 10;

	    public final static int DEFAULT_PAGE_INDEX = 1;

	    /**
	     * 总记录数.
	     */
	    private long total = 0L;

	    /**
	     * 查询结果集合
	     */
	    private List<T> rows = null;

	    /**
	     * 当前页（页码）
	     */
	    private int pageIndex = DEFAULT_PAGE_INDEX;

	    /**
	     * 每页显示记录数
	     */
	    private int pageSize = DEFAULT_PAGE_SIZE;

	    /**
	     * 构造函数.
	     *
	     * @param total             总记录数
	     * @param rows              查询结果集合
	     * @param pageIndex         当前页
	     * @param pageSize          每页显示记录数
	     */
	    public Page(long total, List<T> rows, int pageIndex, int pageSize) {
	        super();
	        this.total = total;
	        this.rows = rows;
	        this.pageIndex = pageIndex;
	        this.pageSize = pageSize;
	    }

	    /**
	     * 获得记录数目. <br/>
	     *
	     * @return 记录数目
	     */
	    public long getTotal() {
	        return total;
	    }

	    /**
	     * 设置记录数目. <br/>
	     *
	     * @param total 记录数目
	     */
	    public void setTotal(long total) {
	        this.total = total;
	    }

	    /**
	     * 获得记录集合. <br/>
	     *
	     * @return 记录集合
	     */
	    public List<T> getRows() {
	        return rows;
	    }

	    /**
	     * 获得记录集合. <br/>
	     *
	     * @param rows 记录集合
	     */
	    public void setRows(List<T> rows) {
	        this.rows = rows;
	    }

	    public int getPageIndex() {
	        return pageIndex;
	    }

	    public void setPageIndex(int pageIndex) {
	        this.pageIndex = pageIndex;
	    }

	    public int getPageSize() {
	        return pageSize;
	    }

	    public void setPageSize(int pageSize) {
	        this.pageSize = pageSize;
	    }

	    /**
	     * 总页数
	     * @return  总页数
	     */
	    public int getPageCount() {
	        return (int) ((total + pageSize - 1) / pageSize);
	    }

	    public boolean getHasPreviousPage() {
	        return getPageIndex() > 1;
	    }

	    public boolean getHasNextPage() {
	        return getPageIndex() < getPageCount();
	    }

	    public boolean getIsFirstPage() {
	        return getPageIndex() == 1;
	    }

	    public boolean getIsLastPage() {
	        return getPageIndex() == getPageCount();
	    }
}
