package soa.cookbook;


import java.math.BigDecimal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;

public class QuoteImpl implements QuoteInterface {
  public QuoteImpl() {
    super();
  }

  public static void main(String[] args) {
    String[] products = { "Product 1", "Product 2", "Service 3" };
    QuoteRequest req = new QuoteRequest(products, Calendar.getInstance());

    QuoteImpl impl = new QuoteImpl();

    QuoteResponse resp = impl.getQuotes(req);
    System.out.println(req.toString());
    System.out.println(resp.toString());
  }

  public QuoteResponse getQuotes(QuoteRequest request) {
    System.out.println(request);
    String[] products = request.getProducts();

    AbstractList<Quote> quotes = new ArrayList<Quote>();
    for (String product : products) {
      AbstractList<VendorQuote> vendors = new ArrayList<VendorQuote>(3);
      for (int i = 0; i < 3; i++) {
        VendorQuote vQuote;
        if (product.startsWith("Service")) {
          ServiceItem[] items =
          { new ServiceItem("Service 1", "Details 1", new BigDecimal("17.1")),
            new ServiceItem("Service 2", "Details 2", new BigDecimal("19.2")),
            new ServiceItem("Service 3", "Details 3", new BigDecimal("21.3")) };
          vQuote = new ServiceVendorQuote("Vendor "+i, items);
        } else {
          HardwareItem[] items =
          { new HardwareItem("Item 1", true, 4, new BigDecimal("17.1")),
            new HardwareItem("Iteme 2", false, 5, new BigDecimal("19.2")),
            new HardwareItem("Item 3", true, 7, new BigDecimal("21.3")) };
          vQuote = new HardwareVendorQuote("Vendor "+i, items);
        }
        vendors.add(vQuote);
      }
      Quote quote = new Quote(product, vendors);
      quotes.add(quote);
    }
    QuoteResponse resp = new QuoteResponse(quotes);
    System.out.println(resp);
    return resp;
  }
}
