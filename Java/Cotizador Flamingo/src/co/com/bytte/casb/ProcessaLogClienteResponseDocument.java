/*
 * An XML document type.
 * Localname: ProcessaLogClienteResponse
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.ProcessaLogClienteResponseDocument
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb;


/**
 * A document containing one ProcessaLogClienteResponse(@http://bytte.com.co/casb/) element.
 *
 * This is a complex type.
 */
public interface ProcessaLogClienteResponseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProcessaLogClienteResponseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sAA0189AD18D8D31B2D5B57AEA69C0E82").resolveHandle("processalogclienteresponse06e0doctype");
    
    /**
     * Gets the "ProcessaLogClienteResponse" element
     */
    co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse getProcessaLogClienteResponse();
    
    /**
     * Sets the "ProcessaLogClienteResponse" element
     */
    void setProcessaLogClienteResponse(co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse processaLogClienteResponse);
    
    /**
     * Appends and returns a new empty "ProcessaLogClienteResponse" element
     */
    co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse addNewProcessaLogClienteResponse();
    
    /**
     * An XML ProcessaLogClienteResponse(@http://bytte.com.co/casb/).
     *
     * This is a complex type.
     */
    public interface ProcessaLogClienteResponse extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ProcessaLogClienteResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sAA0189AD18D8D31B2D5B57AEA69C0E82").resolveHandle("processalogclienteresponseb69belemtype");
        
        /**
         * Gets the "ProcessaLogClienteResult" element
         */
        co.com.bytte.casb.LogResponse getProcessaLogClienteResult();
        
        /**
         * True if has "ProcessaLogClienteResult" element
         */
        boolean isSetProcessaLogClienteResult();
        
        /**
         * Sets the "ProcessaLogClienteResult" element
         */
        void setProcessaLogClienteResult(co.com.bytte.casb.LogResponse processaLogClienteResult);
        
        /**
         * Appends and returns a new empty "ProcessaLogClienteResult" element
         */
        co.com.bytte.casb.LogResponse addNewProcessaLogClienteResult();
        
        /**
         * Unsets the "ProcessaLogClienteResult" element
         */
        void unsetProcessaLogClienteResult();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse newInstance() {
              return (co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (co.com.bytte.casb.ProcessaLogClienteResponseDocument.ProcessaLogClienteResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument newInstance() {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static co.com.bytte.casb.ProcessaLogClienteResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (co.com.bytte.casb.ProcessaLogClienteResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
