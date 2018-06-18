package org.kys.clothing.returnI;

import org.kys.clothing.order.OrderBean;

import java.util.List;

public class OrderBeanList {
    int page;
    int allpage;
    List<OrderBean> list;

    public OrderBeanList() {
        super();
    }

    public OrderBeanList(int page, int allpage, List<OrderBean> list) {
        this.page = page;
        this.allpage = allpage;
        this.list = list;
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

    public List<OrderBean> getList() {
        return list;
    }

    public void setList(List<OrderBean> list) {
        this.list = list;
    }
}
