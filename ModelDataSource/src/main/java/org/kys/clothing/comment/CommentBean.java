package org.kys.clothing.comment;


public class CommentBean {

  private long id;
  private String userCode;
  private String commentInfo;
  private String sku;
  private String addTime;
  private long status;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUserCode() {
    return userCode;
  }

  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }


  public String getCommentInfo() {
    return commentInfo;
  }

  public void setCommentInfo(String commentInfo) {
    this.commentInfo = commentInfo;
  }


  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }


  public String getAddTime() {
    return addTime;
  }

  public void setAddTime(String addTime) {
    this.addTime = addTime;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

}
