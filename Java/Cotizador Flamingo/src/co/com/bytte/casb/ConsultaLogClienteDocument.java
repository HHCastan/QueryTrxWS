/*
 * An XML document type.
 * Localname: ConsultaLogCliente
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.ConsultaLogClienteDocument
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb;


/**
 * A document containing one ConsultaLogCliente(@http://bytte.com.co/casb/) element.
 *
 * This is a complex type.
 */
public interface ConsultaLogClienteDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ConsultaLogClienteDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sAA0189AD18D8D31B2D5B57AEA69C0E82").resolveHandle("consultalogcliente2362doctype");
    
    /**
     * Gets the "ConsultaLogCliente" element
     */
    co.com.bytte.casb.ConsultaLogClienteDocument.ConsultaLogCliente getConsultaLogCliente();
    
    /**
     * Sets the "ConsultaLogCliente" element
     */
    void setConsultaLogCliente(co.com.bytte.casb.ConsultaLogClienteDocument.ConsultaLogCliente consultaLogCliente);
    
    /**
     * Appends and returns a new empty "ConsultaLogCliente" element
     */
    co.com.bytte.casb.ConsultaLogClienteDocument.ConsultaLogCliente addNewConsultaLogCliente();
    
    /**
     * An XML ConsultaLogCliente(@http://bytte.com.co/casb/).
     *
     * This is a complex type.
     */
    public interface ConsultaLogCliente extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ConsultaLogCliente.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sAA0189AD18D8D31B2D5B57AEA69C0E82").resolveHandle("consultalogcliente37dbelemtype");
        
        /**
         * Gets the "request" element
         */
        co.com.bytte.casb.ConsultaLogClienteRequest getRequest();
        
        /**
         * True if has "request" element
         */
        boolean isSetRequest();
        
        /**
         * Sets the "request" element
         */
        void setRequest(co.com.bytte.casb.ConsultaLogClienteRequest request);
        
        /**
         * Appends and returns a new empty "request" element
         */
        co.com.bytte.casb.ConsultaLogClienteRequest addNewRequest();
        
        /**
         * Unsets the "request" element
         */
        void unsetRequest();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static co.com.bytte.casb.ConsultaLogClienteDocument.ConsultaLogCliente newInstance() {
              return (co.com.bytte.casb.ConsultaLogClienteDocument.ConsultaLogCliente) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static co.com.bytte.casb.ConsultaLogClienteDocument.ConsultaLogCliente newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (co.com.bytte.casb.ConsultaLogClienteDocument.ConsultaLogCliente) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static co.com.bytte.casb.ConsultaLogClienteDocument newInstance() {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static co.com.bytte.casb.ConsultaLogClienteDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static co.com.bytte.casb.ConsultaLogClienteDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (co.com.bytte.casb.ConsultaLogClienteDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
