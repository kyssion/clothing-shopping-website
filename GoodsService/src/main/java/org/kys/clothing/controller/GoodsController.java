package org.kys.clothing.controller;

import org.kys.clothing.Good.GoodsBean;
import org.kys.clothing.discounts.DiscountsBean;
import org.kys.clothing.fegin.DiscountsFegin;
import org.kys.clothing.fegin.InventoryFegin;
import org.kys.clothing.inventroy.InventoryBean;
import org.kys.clothing.returnI.GoodsBeanList;
import org.kys.clothing.service.GoodsService;
import org.kys.util.PageUtil;
import org.kys.util.datePackaging.ReturnListDataPackaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GoodsController {

    @Autowired
    public GoodsService goodsService;

    @Autowired
    DiscountsFegin discountsFegin;

    @Autowired
    InventoryFegin inventoryFegin;

    /**
     * 查询所有的服装信息
     *
     * @param page     表示当前要查询的页码
     * @param pageSize 分页每页的大小 -1 表示大侠为空
     * @return 返回所有需要的服装信息标签 按照上架时间进行排序
     */
    @RequestMapping("get_all_goods")
    public ReturnListDataPackaging getAllGoodsInfo(@RequestParam(value = "page", defaultValue = "1") int page,
                                                   @RequestParam(value = "pageSize", defaultValue = "-1") int pageSize) {
        pageSize = pageSize == -1 ? PageUtil.EACH_PAGE_SIZE : pageSize;
        List<GoodsBean> list = goodsService.getAllGoodsInfo(page - 1, pageSize);
        return PageUtil.getReturnListPackaging(list);
    }

    /**
     * 获得指定分类的所有服装
     *
     * @param page     表示当前要查询的页码
     * @param pageSize 分页每页的大小 -1 表示大侠为空
     * @return 返回所有需要的服装信息标签 按照上架时间进行排序
     */
    @RequestMapping("get_all_goods_by_categration")
    public ReturnListDataPackaging getAllGoodsInfoBycategration(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                @RequestParam(value = "pageSize", defaultValue = "-1") int pageSize, @RequestParam("categration") int categration, @RequestParam("fcategration") int c) {
        pageSize = pageSize == -1 ? PageUtil.EACH_PAGE_SIZE : pageSize;
        Integer all = goodsService.getAllGoodsInfoNumber(categration, c);
        all = all == null ? 0 : all;
        int number = all / pageSize;
        if (all % pageSize > 0) {
            number++;
        }
        List<GoodsBean> list = goodsService.getAllGoodsInfobycategration(page - 1, pageSize, categration, c);
        return PageUtil.getReturnListPackaging(list, number);
    }

    /**
     * 获得指定分类的所有服装
     *
     * @param page     表示当前要查询的页码
     * @param pageSize 分页每页的大小 -1 表示大侠为空
     * @return 返回所有需要的服装信息标签 按照上架时间进行排序
     */
    @RequestMapping("get_all_fgoods_by_categration")
    public ReturnListDataPackaging getAllFGoodsInfoBycategration(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                 @RequestParam(value = "pageSize", defaultValue = "-1") int pageSize, @RequestParam("fcategration") int categration) {
        pageSize = pageSize == -1 ? PageUtil.EACH_PAGE_SIZE : pageSize;
        List<GoodsBean> list = goodsService.getAllFGoodsInfobycategration(page - 1, pageSize, categration);
        return PageUtil.getReturnListPackaging(list);
    }

    /**
     * 查询服装的优惠信息
     *
     * @param page     同上
     * @param pageSize 同上
     * @return
     */
    @RequestMapping("get_discounts_goods")
    public ReturnListDataPackaging getDiscountsGoods(@RequestParam(value = "page", defaultValue = "1") int page,
                                                     @RequestParam(value = "pageSize", defaultValue = "-1") int pageSize) {
        pageSize = pageSize == -1 ? PageUtil.EACH_PAGE_SIZE : pageSize;
        List<GoodsBean> list = discountsFegin.getDiscountsGoods(page, pageSize);
        return PageUtil.getReturnListPackaging(list);
    }


    /**
     * 获得商品的详情
     *
     * @param sku
     * @return
     */
    @RequestMapping("get_goods_information")
    public GoodsBean getGoodsInformation(@RequestParam("sku") String sku) {
        DiscountsBean discountsBean = discountsFegin.getDiscountsInformationBySku(sku);
        InventoryBean inventoryBean = inventoryFegin.getInventoryBean(sku);
        return goodsService.getGoodsInformation(discountsBean,inventoryBean, sku);
    }


    @RequestMapping("get_all_goods_by_page")
    public List<GoodsBean> getAllGoodsBean(@RequestParam("number")int number) {
        return goodsService.getAllgoods(number);
    }

    @RequestMapping("delete_goods")
    public boolean deleteGoodsBean(@RequestParam("sku") String sku) {
        return goodsService.deleteGoods(sku);
    }

    @RequestMapping("insert_goods")
    public boolean insertGoodsBean(@RequestBody GoodsBean goodsBean) {
        return goodsService.insert(goodsBean);
    }


    @RequestMapping("get_all_a_goods")
    public GoodsBeanList getAdminGoodsList(@RequestParam("page")int number, @RequestParam("sku")@Nullable String sku,
                                           @RequestParam("c")@Nullable String categration,
                                           @RequestParam("fc")@Nullable String fcategration){
        return goodsService.getAdminGoodsList(number,sku,categration,fcategration);
    }

}