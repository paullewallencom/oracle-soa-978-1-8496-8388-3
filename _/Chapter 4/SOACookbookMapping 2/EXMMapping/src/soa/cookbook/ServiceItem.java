package soa.cookbook;

import java.io.Serializable;

import java.math.BigDecimal;

public class ServiceItem implements Serializable {
  public ServiceItem() {
    super();
  }
  private String service;
  private String details;
  private BigDecimal price;

  public ServiceItem(String service, String details, BigDecimal price) {
    super();
    this.service = service;
    this.details = details;
    this.price = price;
  }

  public void setService(String service) {
    this.service = service;
  }

  public String getService() {
    return service;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public String getDetails() {
    return details;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getPrice() {
    return price;
  }
  
  @Override
  public String toString() {
    return "ServiceItem"+
           "{service="+service+
           ":details="+details+
           ":price="+price+"}";
  }
}
