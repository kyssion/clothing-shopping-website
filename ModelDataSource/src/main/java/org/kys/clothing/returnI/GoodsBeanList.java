package org.kys.clothing.returnI;

import org.kys.clothing.Good.GoodsBean;

import java.util.List;

public class GoodsBeanList{
    public GoodsBeanList(){

    }
    public GoodsBeanList(int page,int allpage,List<GoodsBean> list){
        this.page=page;
        this.allpage=allpage;
        this.list=list;
    }

    int page;
    int allpage;
    List<GoodsBean> list;

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

    public List<GoodsBean> getList() {
        return list;
    }

    public void setList(List<GoodsBean> list) {
        this.list = list;
    }
}