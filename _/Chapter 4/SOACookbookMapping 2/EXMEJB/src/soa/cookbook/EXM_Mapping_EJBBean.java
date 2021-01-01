package soa.cookbook;

import javax.ejb.Stateless;

@Stateless(name = "EXM_Mapping_EJB", mappedName = "EXM_Mapping_EJB")
public class EXM_Mapping_EJBBean extends QuoteImpl implements EXM_Mapping_EJB,
                                            EXM_Mapping_EJBLocal  {
  public EXM_Mapping_EJBBean() {
  }
}
