package soa.cookbook;

import java.io.Serializable;

import java.math.BigDecimal;

public abstract class VendorQuote implements Serializable {
  public VendorQuote() {
    super();
  }
  
  private String vendor;

  public VendorQuote(String vendor) {
    super();
    this.vendor = vendor;
  }

  public void setVendor(String vendor) {
    this.vendor = vendor;
  }

  public String getVendor() {
    return vendor;
  }

  public abstract BigDecimal getPrice();
  
  @Override
  public String toString() {
    return "VendorQuote" +
           "{vendor=" + vendor +
           ":price="+getPrice()+"}";
  }
}
