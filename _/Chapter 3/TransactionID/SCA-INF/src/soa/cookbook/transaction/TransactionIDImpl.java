package soa.cookbook.transaction;

import java.util.Arrays;

import weblogic.transaction.Transaction;
import weblogic.transaction.TransactionHelper;


public class TransactionIDImpl implements TransactionID {
  public TransactionIDImpl() {
    super();
  }

  public XID getTransactionID() {
    TransactionHelper txHelper = TransactionHelper.getTransactionHelper();
    Transaction tx = (Transaction)txHelper.getTransaction();
    return new XID(tx.getXid());
  }

  public String getGlobalTransactionID() {
    XID xid = getTransactionID();
    return Arrays.toString(xid.getGlobalTransactionId());
  }

  public String getBranchQualifier() {
    XID xid = getTransactionID();
    return Arrays.toString(xid.getBranchQualifier());
  }

}
