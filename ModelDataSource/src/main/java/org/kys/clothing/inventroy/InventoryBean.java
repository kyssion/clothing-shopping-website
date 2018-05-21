package org.kys.clothing.inventroy;


public class InventoryBean {

  private long id;
  private String sku;
  private long inventoryNumber;
  private long status;


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
