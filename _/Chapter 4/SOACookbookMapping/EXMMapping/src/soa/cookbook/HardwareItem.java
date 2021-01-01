package soa.cookbook;

import java.io.Serializable;

import java.math.BigDecimal;

public class HardwareItem implements Serializable {
  public HardwareItem() {
    super();
  }
  private String item;
  private boolean airTransportable;
  private int quantity;
  private BigDecimal price;

  public HardwareItem(String item, boolean airTransportable, int quantity,
                      BigDecimal price) {
    super();
    this.item = item;
    this.airTransportable = airTransportable;
    this.quantity = quantity;
    this.price = price;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getItem() {
    return item;
  }

  public void setAirTransportable(boolean airTransportable) {
    this.airTransportable = airTransportable;
  }

  public boolean isAirTransportable() {
    return airTransportable;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getQuantity() {
    return quantity;
  }
  
  @Override
  public String toString() {
    return "HardwareItem"+
           "{item="+item+
           ":airTransportable="+airTransportable+
           ":price="+price+
           ":quantity="+quantity+"}";
  }
}
