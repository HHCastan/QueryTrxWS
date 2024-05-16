/*
 * XML Type:  ArrayOfLogResponseImage
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.ArrayOfLogResponseImage
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb;


/**
 * An XML ArrayOfLogResponseImage(@http://bytte.com.co/casb/).
 *
 * This is a complex type.
 */
public interface ArrayOfLogResponseImage extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ArrayOfLogResponseImage.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sAA0189AD18D8D31B2D5B57AEA69C0E82").resolveHandle("arrayoflogresponseimage361btype");
    
    /**
     * Gets array of all "LogResponseImage" elements
     */
    co.com.bytte.casb.LogResponseImage[] getLogResponseImageArray();
    
    /**
     * Gets ith "LogResponseImage" element
     */
    co.com.bytte.casb.LogResponseImage getLogResponseImageArray(int i);
    
    /**
     * Tests for nil ith "LogResponseImage" element
     */
    boolean isNilLogResponseImageArray(int i);
    
    /**
     * Returns number of "LogResponseImage" element
     */
    int sizeOfLogResponseImageArray();
    
    /**
     * Sets array of all "LogResponseImage" element
     */
    void setLogResponseImageArray(co.com.bytte.casb.LogResponseImage[] logResponseImageArray);
    
    /**
     * Sets ith "LogResponseImage" element
     */
    void setLogResponseImageArray(int i, co.com.bytte.casb.LogResponseImage logResponseImage);
    
    /**
     * Nils the ith "LogResponseImage" element
     */
    void setNilLogResponseImageArray(int i);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "LogResponseImage" element
     */
    co.com.bytte.casb.LogResponseImage insertNewLogResponseImage(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "LogResponseImage" element
     */
    co.com.bytte.casb.LogResponseImage addNewLogResponseImage();
    
    /**
     * Removes the ith "LogResponseImage" element
     */
    void removeLogResponseImage(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static co.com.bytte.casb.ArrayOfLogResponseImage newInstance() {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static co.com.bytte.casb.ArrayOfLogResponseImage newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static co.com.bytte.casb.ArrayOfLogResponseImage parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (co.com.bytte.casb.ArrayOfLogResponseImage) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
