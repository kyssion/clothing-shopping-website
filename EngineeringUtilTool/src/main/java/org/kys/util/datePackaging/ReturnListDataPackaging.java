package org.kys.util.datePackaging;

import java.util.List;

public class ReturnListDataPackaging<T> {
    public List infomation;

    public ReturnListDataPackaging(List list){
        this.infomation=list;
    }

    public List getInfomation() {
        return infomation;
    }
    public void setInfomation(List infomation) {
        this.infomation = infomation;
    }
}
