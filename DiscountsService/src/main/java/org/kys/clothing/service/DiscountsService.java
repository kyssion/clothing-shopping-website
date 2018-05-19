package org.kys.clothing.service;

import org.kys.clothing.GoodsBean;
import org.kys.clothing.dataQuery.DiscountsClothingQuery;
import org.kys.clothing.discounts.DiscountsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountsService {

    @Autowired
    DiscountsClothingQuery discountsClothingQuery;

    public List<GoodsBean> getAllCountsService(int page, int pageSize) {
        List<GoodsBean> list =discountsClothingQuery.selectAllDiscountsClothing(page-1,pageSize);
        return list;
    }

    public DiscountsBean getDiscountsInformationBySku(String sku) {
        return discountsClothingQuery.getDiscountsInformationByGoodsId(sku);
    }
}
