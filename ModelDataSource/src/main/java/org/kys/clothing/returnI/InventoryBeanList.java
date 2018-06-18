package org.kys.clothing.returnI;


import org.kys.clothing.inventroy.InventoryBean;

import java.util.List;

public class InventoryBeanList {
    int page;
    int allpage;
    List<InventoryBean> list;
    public InventoryBeanList(){
        super();
    }

    public InventoryBeanList(int i, int i1, List<InventoryBean> list) {
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

    public List<InventoryBean> getList() {
        return list;
    }

    public void setList(List<InventoryBean> list) {
        this.list = list;
    }
}
