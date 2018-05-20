package org.kys.clothing.goodsCart;


public class GoodsCardsBean {

  private long id;
  private String cardsId;
  private String sku;
  private long skuNumber;
  private long addTime;
  private String userCode;
  private String goodsName;
  private String categroyId;
  private String categroyName;
  private long money;
  private String img;
  private long color;
  private String size;
  private String style;
  private String information;

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCardsId() {
    return cardsId;
  }

  public void setCardsId(String cardsId) {
    this.cardsId = cardsId;
  }


  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }


  public long getSkuNumber() {
    return skuNumber;
  }

  public void setSkuNumber(long skuNumber) {
    this.skuNumber = skuNumber;
  }


  public long getAddTime() {
    return addTime;
  }

  public void setAddTime(long addTime) {
    this.addTime = addTime;
  }


  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

}
