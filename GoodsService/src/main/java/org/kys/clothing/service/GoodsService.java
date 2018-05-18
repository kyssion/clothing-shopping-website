package org.kys.clothing.service;

import org.kys.clothing.GoodsBean;
import org.kys.clothing.dataQuery.GoodsDataQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsDataQuery goodsDataQuery;

    public List<GoodsBean> getAllGoodsInfo(int page, int pageSize) {
        List<GoodsBean> goodsList= goodsDataQuery.SelectAllGoods(page,pageSize);
        return goodsList;
    }
}
