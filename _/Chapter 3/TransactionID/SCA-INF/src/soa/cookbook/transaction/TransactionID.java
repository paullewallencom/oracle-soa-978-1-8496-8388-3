package soa.cookbook.transaction;

public interface TransactionID {
  public XID getTransactionID();

  public String getGlobalTransactionID();

  public String getBranchQualifier();
}
