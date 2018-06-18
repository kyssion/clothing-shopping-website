package org.kys.clothing.inventroy;


public class InventoryBean {

  private long id;
  private String sku;
  private long inventoryNumber;
  private long status;
  private String goodsName;
  private String img;

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }


  public long getInventoryNumber() {
    return inventoryNumber;
  }

  public void setInventoryNumber(long inventoryNumber) {
    this.inventoryNumber = inventoryNumber;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

}
