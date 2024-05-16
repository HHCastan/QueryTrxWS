/*
 * An XML document type.
 * Localname: InitWsResponse
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.InitWsResponseDocument
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb;


/**
 * A document containing one InitWsResponse(@http://bytte.com.co/casb/) element.
 *
 * This is a complex type.
 */
public interface InitWsResponseDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(InitWsResponseDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sAA0189AD18D8D31B2D5B57AEA69C0E82").resolveHandle("initwsresponse7be4doctype");
    
    /**
     * Gets the "InitWsResponse" element
     */
    co.com.bytte.casb.InitWsResponseDocument.InitWsResponse getInitWsResponse();
    
    /**
     * Sets the "InitWsResponse" element
     */
    void setInitWsResponse(co.com.bytte.casb.InitWsResponseDocument.InitWsResponse initWsResponse);
    
    /**
     * Appends and returns a new empty "InitWsResponse" element
     */
    co.com.bytte.casb.InitWsResponseDocument.InitWsResponse addNewInitWsResponse();
    
    /**
     * An XML InitWsResponse(@http://bytte.com.co/casb/).
     *
     * This is a complex type.
     */
    public interface InitWsResponse extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(InitWsResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sAA0189AD18D8D31B2D5B57AEA69C0E82").resolveHandle("initwsresponse791belemtype");
        
        /**
         * Gets the "InitWsResult" element
         */
        co.com.bytte.casb.ScoreProceso getInitWsResult();
        
        /**
         * True if has "InitWsResult" element
         */
        boolean isSetInitWsResult();
        
        /**
         * Sets the "InitWsResult" element
         */
        void setInitWsResult(co.com.bytte.casb.ScoreProceso initWsResult);
        
        /**
         * Appends and returns a new empty "InitWsResult" element
         */
        co.com.bytte.casb.ScoreProceso addNewInitWsResult();
        
        /**
         * Unsets the "InitWsResult" element
         */
        void unsetInitWsResult();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static co.com.bytte.casb.InitWsResponseDocument.InitWsResponse newInstance() {
              return (co.com.bytte.casb.InitWsResponseDocument.InitWsResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static co.com.bytte.casb.InitWsResponseDocument.InitWsResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (co.com.bytte.casb.InitWsResponseDocument.InitWsResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static co.com.bytte.casb.InitWsResponseDocument newInstance() {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static co.com.bytte.casb.InitWsResponseDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static co.com.bytte.casb.InitWsResponseDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static co.com.bytte.casb.InitWsResponseDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static co.com.bytte.casb.InitWsResponseDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static co.com.bytte.casb.InitWsResponseDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static co.com.bytte.casb.InitWsResponseDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static co.com.bytte.casb.InitWsResponseDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static co.com.bytte.casb.InitWsResponseDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static co.com.bytte.casb.InitWsResponseDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static co.com.bytte.casb.InitWsResponseDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static co.com.bytte.casb.InitWsResponseDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static co.com.bytte.casb.InitWsResponseDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static co.com.bytte.casb.InitWsResponseDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static co.com.bytte.casb.InitWsResponseDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static co.com.bytte.casb.InitWsResponseDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static co.com.bytte.casb.InitWsResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static co.com.bytte.casb.InitWsResponseDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (co.com.bytte.casb.InitWsResponseDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
