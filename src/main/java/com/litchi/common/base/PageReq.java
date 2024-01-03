package com.litchi.common.base;


/**
 * Description:
 * <p> 分页请求
 * Create by noah
 * Date 2023/9/20 17:32
 */
public class PageReq {

    private Long pageNo = 1L;

    private Long pageSize = 10L;

    public Long getPageNo(){
        if(pageNo == null || pageNo < 1){
            return 1L;
        }
        return pageNo;
    }

    public Long getPageSize(){
        if(pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE){
            return 10L;
        }
        return pageSize;
    }
    public void setPageNo(Long pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
