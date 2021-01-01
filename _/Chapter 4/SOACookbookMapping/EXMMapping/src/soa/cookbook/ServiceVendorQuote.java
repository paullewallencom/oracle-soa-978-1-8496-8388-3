package soa.cookbook;

import java.math.BigDecimal;

public class ServiceVendorQuote extends VendorQuote {
  public ServiceVendorQuote() {
    super();
  }
  
  private ServiceItem[] items;

  public ServiceVendorQuote(String vendor, ServiceItem[] items) {
    super(vendor);
    this.items = items;
  }

  public BigDecimal getPrice() {
    BigDecimal price = new BigDecimal(0);
    for (ServiceItem item : items) {
      price = price.add(item.getPrice());
    }
    return price;
    }

  public void setItems(ServiceItem[] items) {
    this.items = items;
  }

  public ServiceItem[] getItems() {
    return items;
  }

  @Override
  public String toString() {
    String itemsString = "{";
    for (ServiceItem item : items) {
    itemsString += item.toString()+",";
    }
    itemsString += "}";
    return "ServiceVendorQuote"+
           "{"+super.toString()+","+
           ":items="+itemsString+"}";
  }
}
