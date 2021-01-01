<?xml version="1.0" encoding="UTF-8" ?>
<?oracle-xsl-mapper
  <!-- SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY. -->
  <mapSources>
    <source type="WSDL">
      <schema location="../MappingBPELProcess.wsdl"/>
      <rootElement name="process" namespace="http://xmlns.oracle.com/SOACookbookMapping/MiscMappings/MappingBPELProcess"/>
    </source>
  </mapSources>
  <mapTargets>
    <target type="WSDL">
      <schema location="../MappingBPELProcess.wsdl"/>
      <rootElement name="processResponse" namespace="http://xmlns.oracle.com/SOACookbookMapping/MiscMappings/MappingBPELProcess"/>
    </target>
  </mapTargets>
  <!-- GENERATED BY ORACLE XSL MAPPER 11.1.1.5.0(build 110418.1550.0174) AT [SAT SEP 24 13:12:13 MDT 2011]. -->
?>
<xsl:stylesheet version="1.0"
                xmlns:blog="http://www.oracle.com/XSL/Transform/java/antony.blog.XPathImpl"
                xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/"
                xmlns:bpel="http://docs.oasis-open.org/wsbpel/2.0/process/executable"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:med="http://schemas.oracle.com/mediator/xpath"
                xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath"
                xmlns:bpm="http://xmlns.oracle.com/bpmn20/extensions"
                xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:plnk="http://schemas.xmlsoap.org/ws/2003/05/partner-link/"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
                xmlns:bpmn="http://schemas.oracle.com/bpm/xpath"
                xmlns:ora="http://schemas.oracle.com/xpath/extension"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:client="http://xmlns.oracle.com/SOACookbookMapping/MiscMappings/MappingBPELProcess"
                xmlns:stat="http://www.oracle.com/XSL/Transform/java/soa.cookbook.xpath.StdDev"
                xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap"
                exclude-result-prefixes="xsi xsl plnk xsd wsdl client blog xp20 bpws bpel mhdr oraext dvm hwf med ids bpm xdk xref bpmn ora socket stat ldap">
  <xsl:template match="/">
    <client:processResponse>
      <client:val1>
        <xsl:value-of select="/client:process/client:val1"/>
      </client:val1>
      <client:val2>
        <xsl:value-of select="/client:process/client:val2"/>
      </client:val2>
    </client:processResponse>
  </xsl:template>
</xsl:stylesheet>
