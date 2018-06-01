package org.kys.util.datePackaging;

import java.util.List;

public class ReturnListDataPackaging<T> {
    public List infomation;

    public int pageAll;

    public ReturnListDataPackaging(List list){
        this.infomation=list;
    }

    public int getPageAll() {
        return pageAll;
    }

    public void setPageAll(int pageAll) {
        this.pageAll = pageAll;
    }

    public ReturnListDataPackaging(List list, int pageAll){
        this.infomation=list;
        this.pageAll=pageAll;
    }

    public List getInfomation() {
        return infomation;
    }
    public void setInfomation(List infomation) {
        this.infomation = infomation;
    }
}
