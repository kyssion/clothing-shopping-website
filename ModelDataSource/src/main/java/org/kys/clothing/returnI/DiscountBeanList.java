package org.kys.clothing.returnI;

import org.kys.clothing.discounts.DiscountsBean;

import java.util.List;

public class DiscountBeanList {
    int page;
    int allpage;
    List<DiscountsBean> list;

    public DiscountBeanList(){
        super();
    }
    public DiscountBeanList(int i, int i1, List<DiscountsBean> list) {
        this.page=i;
        this.allpage=i1;
        this.list=list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getAllpage() {
        return allpage;
    }

    public void setAllpage(int allpage) {
        this.allpage = allpage;
    }

    public List<DiscountsBean> getList() {
        return list;
    }

    public void setList(List<DiscountsBean> list) {
        this.list = list;
    }
}
