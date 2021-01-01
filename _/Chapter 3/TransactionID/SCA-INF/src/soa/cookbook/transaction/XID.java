package soa.cookbook.transaction;

import javax.transaction.xa.Xid;

public class XID implements Xid {
  private int formatId;
  private byte[] globalTransactionId;
  private byte[] branchQualifier;
  
  public XID(Xid xid) {
    formatId = xid.getFormatId();
    globalTransactionId = xid.getGlobalTransactionId();
    branchQualifier = xid.getBranchQualifier();
  }
  
  public XID() {
  }

  public int getFormatId() {
    return formatId;
  }

  public byte[] getGlobalTransactionId() {
    return globalTransactionId;
  }

  public byte[] getBranchQualifier() {
    return branchQualifier;
  }

  public void setFormatId(int formatId) {
    this.formatId = formatId;
  }

  public void setGlobalTransactionId(byte[] globalTransactionId) {
    this.globalTransactionId = globalTransactionId;
  }

  public void setBranchQualifier(byte[] branchQualifier) {
    this.branchQualifier = branchQualifier;
  }

  public void setGlobalTransactionIdString(String globalTransactionIdString) {
  }

  public String getGlobalTransactionIdString() {
    return getByteString(globalTransactionId);
  }

  public void setBranchQualifierString(String branchQualifierString) {
  }

  public String getBranchQualifierString() {
    return getByteString(branchQualifier);
  }
  
  private String getByteString(byte[] bytes) {
    if (bytes == null || bytes.length == 0) return "00";
    StringBuffer buff = new StringBuffer(2*bytes.length);
    Object[] data = new Object[1];
    for (int i = 0; i < bytes.length; i++) {
      data[0] = new Byte(bytes[i]);
      buff.append(String.format("%2X",data));
    }
    return buff.toString();
  }
}
