package soa.cookbook;

import java.io.Serializable;

import java.util.Calendar;

public class QuoteRequest implements Serializable {
  public QuoteRequest() {
    super();
  }

  private String[] products;
  private Calendar requiredDate;

  public QuoteRequest(String[] products, Calendar requiredDate) {
    super();
    this.products = products;
    this.requiredDate = requiredDate;
  }

  public void setProducts(String[] products) {
    this.products = products;
  }

  public String[] getProducts() {
    return products;
  }

  public String getProduct(int i) {
    String product = null;
    if (products!=null && products.length > i)
      product = products[0];
    return product;
  }
  
  public String getProduct() {
    return getProduct(0);
  }

  public void setProduct(String product) {
    products = new String[1];
    products[0] = product;
    return;
  }

  public void setRequiredDate(Calendar requiredDate) {
    this.requiredDate = requiredDate;
  }

  public Calendar getRequiredDate() {
    return requiredDate;
  }

  @Override
  public String toString() {
    String productsString = "{";
    for (String product : products) {
      productsString += product + ",";
    }
    productsString += "}";
    return "QuoteRequest" +
           "{products=" + productsString +
           ":requiredDate="+requiredDate+"}";
  }
}
