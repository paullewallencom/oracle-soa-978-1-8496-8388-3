<?xml version="1.0" encoding="UTF-8" ?>
<?oracle-xsl-mapper
  <!-- SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY. -->
  <mapSources>
    <source type="WSDL">
      <schema location="../EmployeeService.wsdl"/>
      <rootElement name="Employee" namespace="http://soa.cookbook/Employee"/>
    </source>
  </mapSources>
  <mapTargets>
    <target type="WSDL">
      <schema location="../EmployeeEJB.wsdl"/>
      <rootElement name="addEmployee" namespace="http://model.cookbook.soa/"/>
    </target>
  </mapTargets>
  <!-- GENERATED BY ORACLE XSL MAPPER 11.1.1.5.0(build 110418.1550.0174) AT [SAT JUL 30 10:40:21 MDT 2011]. -->
?>
<xsl:stylesheet version="1.0"
                xmlns:blog="http://www.oracle.com/XSL/Transform/java/antony.blog.XPathImpl"
                xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/"
                xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:bpel="http://docs.oasis-open.org/wsbpel/2.0/process/executable"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:inp1="http://soa.cookbook/Employee"
                xmlns:ns0="http://model.cookbook.soa/types"
                xmlns:bpm="http://xmlns.oracle.com/bpmn20/extensions"
                xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/"
                xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
                xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
                xmlns:ora="http://schemas.oracle.com/xpath/extension"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath"
                xmlns:tns="http://soa.cookbook/SOACookbookChapter8/EmployeeService"
                xmlns:med="http://schemas.oracle.com/mediator/xpath"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath"
                xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:ns1="http://model.cookbook.soa/"
                xmlns:bpmn="http://schemas.oracle.com/bpm/xpath"
                xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap"
                exclude-result-prefixes="xsi xsl inp1 wsdl tns xsd ns0 soap12 soap mime ns1 blog bpws xp20 bpel bpm ora socket mhdr oraext dvm hwf med ids xdk xref bpmn ldap">
  <xsl:template match="/">
    <ns1:addEmployee>
      <arg0>
        <xsl:value-of select="/inp1:Employee/inp1:Name"/>
      </arg0>
      <arg1>
        <addr>
          <xsl:value-of select="/inp1:Employee/inp1:Address/inp1:Addr1"/>
        </addr>
        <city>
          <xsl:value-of select="/inp1:Employee/inp1:Address/inp1:Addr2"/>
        </city>
      </arg1>
      <arg2>
        <xsl:value-of select="/inp1:Employee/inp1:Phone"/>
      </arg2>
    </ns1:addEmployee>
  </xsl:template>
</xsl:stylesheet>