package org.kys.clothing.user;


import java.io.Serializable;

public class UserBean implements Serializable {

  private long id;
  private String userCode;
  private String userPassword;
  private String userTel;
  private String userEmail;
  private String userAddr;


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


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public String getUserTel() {
    return userTel;
  }

  public void setUserTel(String userTel) {
    this.userTel = userTel;
  }


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }


  public String getUserAddr() {
    return userAddr;
  }

  public void setUserAddr(String userAddr) {
    this.userAddr = userAddr;
  }

}
