package soa.cookbook.xpath;

import java.util.List;

import oracle.fabric.common.xml.xpath.IXPathContext;
import oracle.fabric.common.xml.xpath.IXPathFunction;
import oracle.fabric.common.xml.xpath.XPathFunctionException;

import oracle.xml.parser.v2.XMLNodeList;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import org.w3c.dom.Node;


public class StdDev implements IXPathFunction {
  public static double getStdDev(XMLNodeList nodes) {
    DescriptiveStatistics stats = new DescriptiveStatistics();
    
    for (int i = 0; i < nodes.getLength(); i++) {
      try {
        Node node = nodes.item(i);
        System.out.println("Node "+i+" name = "+ node.getNodeName()+" type = "+node.getNodeType());
        if (node.getNodeType() == Node.ELEMENT_NODE) {
          double value = Double.parseDouble(node.getTextContent());
          stats.addValue(value);
        }
      } catch (Exception e) {
        ; // Ignore non-numeric values
      }
    }

    return stats.getStandardDeviation();
  }

  public Object call(IXPathContext iXPathContext,
                     List list) throws XPathFunctionException {
    /*
        for (Object o : list) {
          if (o instanceof NodeList) {
            NodeList nodes = (NodeList)o;
          }
        }
    */
    XMLNodeList nodes = (XMLNodeList)list.get(0);
    Class cls = nodes.getClass();
    cls.getSuperclass();
    return getStdDev(nodes);
  }
}
