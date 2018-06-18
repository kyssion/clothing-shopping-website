package org.kys.clothing.discounts;

public class DiscountsBean {
    private long id;
    private String discountsName;
    private String sku;
    private String goodsName;
    private long status;
    private long addTime;
    private long discountsMoney;
    private long isDiscounts;
    private String img;
    private String style;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getDiscountsName() {
        return discountsName;
    }

    public void setDiscountsName(String discountsName) {
        this.discountsName = discountsName;
    }


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }


    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }


    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }


    public long getAddTime() {
        return addTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }


    public long getDiscountsMoney() {
        return discountsMoney;
    }

    public void setDiscountsMoney(long discountsMoney) {
        this.discountsMoney = discountsMoney;
    }


    public long getIsDiscounts() {
        return isDiscounts;
    }

    public void setIsDiscounts(long isDiscounts) {
        this.isDiscounts = isDiscounts;
    }

}
