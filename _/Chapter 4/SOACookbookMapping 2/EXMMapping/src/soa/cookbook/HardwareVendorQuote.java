package soa.cookbook;

import java.math.BigDecimal;

public class HardwareVendorQuote extends VendorQuote {
  public HardwareVendorQuote() {
    super();
  }
  private HardwareItem[] items;

  public HardwareVendorQuote(String vendor, HardwareItem[] items) {
    super(vendor);
    this.items = items;
  }

  public BigDecimal getPrice() {
    BigDecimal price = new BigDecimal(0);
    for (HardwareItem item : items) {
      price = price.add(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
    }
    return price;
  }

  public void setItems(HardwareItem[] items) {
    this.items = items;
  }

  public HardwareItem[] getItems() {
    return items;
  }

  @Override
  public String toString() {
    String itemsString = "{";
    for (HardwareItem item : items) {
    itemsString += item.toString()+",";
    }
    itemsString += "}";
    return "HardwareVendorQuote"+
           "{"+super.toString()+","+
           ":items="+itemsString+"}";
  }
}
