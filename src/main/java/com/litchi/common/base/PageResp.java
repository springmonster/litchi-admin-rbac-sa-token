package com.litchi.common.base;


import java.util.Collections;
import java.util.List;

/**
 * Description:
 * <p> 分页返回结果封装
 * Create by noah
 * Date 2023/9/20 17:33
 */
public class PageResp<T> {

    private Long pageNo = 1L;

    private Long pageSize = 10L;

    private Long total = 0L;

    private List<T> result = Collections.emptyList();

    public PageResp(Long total, Long pageSize, Long pageNo, List<T> records) {
        this.setPageNo(pageNo);
        this.setPageSize(pageSize);
        this.setTotal(total);
        this.setResult(records);
    }

    public Long getPageNo() {
        return pageNo;
    }

    public void setPageNo(Long pageNo) {
        this.pageNo = pageNo;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
