package soa.cookbook;

import java.io.Serializable;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

public class QuoteResponse implements Serializable {
  public QuoteResponse() {
    super();
  }
  
  private AbstractList<Quote> quotes;

  public QuoteResponse(AbstractList<Quote> quotes) {
    super();
    this.quotes = quotes;
  }

  public void setQuotes(AbstractList<Quote> quotes) {
    this.quotes = quotes;
  }

  public AbstractList<Quote> getQuotes() {
    return quotes;
  }
  
  @Override
  public String toString() {
    String quotesString = "{";
    for (Quote quote : quotes) {
      quotesString += quote + ",";
    }
    quotesString += "}";
    return "QuoteResponse" +
           "{quotes=" + quotesString +"}";
  }

}
