package org.kys.clothing.Good;


public class GoodsBean {

  private long id;
  private String goodsName;
  private String sku;
  private String categroyId;
  private String categroyName;
  private long money;
  private String img;
  private long color;
  private String size;
  private String sizeId;
  private String style;
  private String information;
  private boolean isDiscount;
  private long discountMoney;

  public long getDiscountMoney() {
    return discountMoney;
  }

  public void setDiscountMoney(long discountMoney) {
    this.discountMoney = discountMoney;
  }

  public boolean isDiscount() {

    return isDiscount;
  }

  public void setDiscount(boolean discount) {
    isDiscount = discount;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getCategroyId() {
    return categroyId;
  }

  public void setCategroyId(String categroyId) {
    this.categroyId = categroyId;
  }

  public String getCategroyName() {
    return categroyName;
  }

  public void setCategroyName(String categroyName) {
    this.categroyName = categroyName;
  }

  public long getMoney() {
    return money;
  }

  public void setMoney(long money) {
    this.money = money;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public long getColor() {
    return color;
  }

  public void setColor(long color) {
    this.color = color;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getSizeId() {
    return sizeId;
  }

  public void setSizeId(String sizeId) {
    this.sizeId = sizeId;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getInformation() {
    return information;
  }

  public void setInformation(String information) {
    this.information = information;
  }
}
