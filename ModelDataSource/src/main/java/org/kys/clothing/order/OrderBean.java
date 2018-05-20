package org.kys.clothing.order;


public class OrderBean {

  private long id;
  private String orderId;
  private String goodsInfo;
  private long addTime;
  private long changeTime;
  private long status;
  private String userCode;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }


  public String getGoodsInfo() {
    return goodsInfo;
  }

  public void setGoodsInfo(String goodsInfo) {
    this.goodsInfo = goodsInfo;
  }


  public long getAddTime() {
    return addTime;
  }

  public void setAddTime(long addTime) {
    this.addTime = addTime;
  }


  public long getChangeTime() {
    return changeTime;
  }

  public void setChangeTime(long changeTime) {
    this.changeTime = changeTime;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

}
