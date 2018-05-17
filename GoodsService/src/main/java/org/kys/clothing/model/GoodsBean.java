package org.kys.clothing.model;


public class GoodsBean {

  private long id;
  private String goodsName;
  private String sku;
  private String categroyId;
  private String categroyName;
  private long money;
  private String img;


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

}
