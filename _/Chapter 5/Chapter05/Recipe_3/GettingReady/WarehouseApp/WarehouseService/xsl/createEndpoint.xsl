<?xml version="1.0" encoding="UTF-8" ?>
<?oracle-xsl-mapper
  <!-- SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY. -->
  <mapSources>
    <source type="WSDL">
      <schema location="../WarehouseService_1.0.wsdl"/>
      <rootElement name="submitBookOrder" namespace="http://rubiconred.com/ckbk/svc/WarehouseService"/>
    </source>
  </mapSources>
  <mapTargets>
    <target type="WSDL">
      <schema location="../WarehouseService_1.0.wsdl"/>
      <rootElement name="EndpointReference" namespace="http://schemas.xmlsoap.org/ws/2003/03/addressing"/>
    </target>
  </mapTargets>
  <!-- GENERATED BY ORACLE XSL MAPPER 11.1.1.6.0(build 111214.0600.1553) AT [TUE AUG 14 10:28:46 EST 2012]. -->
?>
<xsl:stylesheet version="1.0"
                xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/"
                xmlns:ns0="http://rubiconred.com/ckbk/xsd/book"
                xmlns:bpel="http://docs.oasis-open.org/wsbpel/2.0/process/executable"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:tns="http://rubiconred.com/ckbk/svc/WarehouseService"
                xmlns:ns2="http://rubiconred.com/ckbk/xsd/common"
                xmlns:bpm="http://xmlns.oracle.com/bpmn20/extensions"
                xmlns:cor="http://xmlns.oracle.com/WarehouseApp/WarehouseService/WarehouseService/correlationset"
                xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
                xmlns:ora="http://schemas.oracle.com/xpath/extension"
                xmlns:flt="http://rubiconred.com/ckbk/xsd/fault"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:ns1="http://schemas.xmlsoap.org/ws/2003/03/addressing"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath"
                xmlns:med="http://schemas.oracle.com/mediator/xpath"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath"
                xmlns:ns3="http://rubiconred.com/ckbk/xsd/base"
                xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap"
                exclude-result-prefixes="xsi xsl bpws ns0 tns ns2 cor soap wsdl flt ns1 ns3 xsd xp20 bpws bpel bpm ora socket mhdr oraext dvm hwf med ids xdk xref ldap">
  <xsl:template match="/">
    <ns1:EndpointReference>
      <ns1:Address>
        <xsl:value-of select="concat('http://localhost:7001/soa-infra/services/default/Publisher',/tns:submitBookOrder/tns:publisher,'/publisher',xp20:lower-case(/tns:submitBookOrder/tns:publisher),'_client_ep')"/>
      </ns1:Address>
    </ns1:EndpointReference>
  </xsl:template>
</xsl:stylesheet>