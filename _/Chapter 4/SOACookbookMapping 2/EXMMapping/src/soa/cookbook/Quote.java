package soa.cookbook;

import java.io.Serializable;

import java.util.AbstractList;
import java.util.List;

public class Quote implements Serializable {
  public Quote() {
    super();
  }
  
  private String product;
  private AbstractList<VendorQuote> vendors;

  public Quote(String product, AbstractList<VendorQuote> vendors) {
    super();
    this.product = product;
    this.vendors = vendors;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public String getProduct() {
    return product;
  }

  public void setVendors(AbstractList<VendorQuote> vendors) {
    this.vendors = vendors;
  }

  public AbstractList<VendorQuote> getVendors() {
    return vendors;
  }
  
  @Override
  public String toString() {
    String vendorsString = "{";
    for (VendorQuote vendor : vendors) {
    vendorsString += vendor.toString()+",";
    }
    vendorsString += "}";
    return "Quote"+
           "{product="+product+
           ":vendors="+vendorsString+"}";
  }
}
