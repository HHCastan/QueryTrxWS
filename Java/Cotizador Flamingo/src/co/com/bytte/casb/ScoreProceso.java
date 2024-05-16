/*
 * XML Type:  ScoreProceso
 * Namespace: http://bytte.com.co/casb/
 * Java type: co.com.bytte.casb.ScoreProceso
 *
 * Automatically generated - do not modify.
 */
package co.com.bytte.casb;


/**
 * An XML ScoreProceso(@http://bytte.com.co/casb/).
 *
 * This is a complex type.
 */
public interface ScoreProceso extends co.com.bytte.casb.Response
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(ScoreProceso.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sAA0189AD18D8D31B2D5B57AEA69C0E82").resolveHandle("scoreprocesodc20type");
    
    /**
     * Gets the "ScoreAutenticacionV2" attribute
     */
    int getScoreAutenticacionV2();
    
    /**
     * Gets (as xml) the "ScoreAutenticacionV2" attribute
     */
    org.apache.xmlbeans.XmlInt xgetScoreAutenticacionV2();
    
    /**
     * Sets the "ScoreAutenticacionV2" attribute
     */
    void setScoreAutenticacionV2(int scoreAutenticacionV2);
    
    /**
     * Sets (as xml) the "ScoreAutenticacionV2" attribute
     */
    void xsetScoreAutenticacionV2(org.apache.xmlbeans.XmlInt scoreAutenticacionV2);
    
    /**
     * Gets the "ScoreAutenticacionV3" attribute
     */
    int getScoreAutenticacionV3();
    
    /**
     * Gets (as xml) the "ScoreAutenticacionV3" attribute
     */
    org.apache.xmlbeans.XmlInt xgetScoreAutenticacionV3();
    
    /**
     * Sets the "ScoreAutenticacionV3" attribute
     */
    void setScoreAutenticacionV3(int scoreAutenticacionV3);
    
    /**
     * Sets (as xml) the "ScoreAutenticacionV3" attribute
     */
    void xsetScoreAutenticacionV3(org.apache.xmlbeans.XmlInt scoreAutenticacionV3);
    
    /**
     * Gets the "ScoreEnrolamiento" attribute
     */
    int getScoreEnrolamiento();
    
    /**
     * Gets (as xml) the "ScoreEnrolamiento" attribute
     */
    org.apache.xmlbeans.XmlInt xgetScoreEnrolamiento();
    
    /**
     * Sets the "ScoreEnrolamiento" attribute
     */
    void setScoreEnrolamiento(int scoreEnrolamiento);
    
    /**
     * Sets (as xml) the "ScoreEnrolamiento" attribute
     */
    void xsetScoreEnrolamiento(org.apache.xmlbeans.XmlInt scoreEnrolamiento);
    
    /**
     * Gets the "ScoreImagenHuella" attribute
     */
    int getScoreImagenHuella();
    
    /**
     * Gets (as xml) the "ScoreImagenHuella" attribute
     */
    org.apache.xmlbeans.XmlInt xgetScoreImagenHuella();
    
    /**
     * Sets the "ScoreImagenHuella" attribute
     */
    void setScoreImagenHuella(int scoreImagenHuella);
    
    /**
     * Sets (as xml) the "ScoreImagenHuella" attribute
     */
    void xsetScoreImagenHuella(org.apache.xmlbeans.XmlInt scoreImagenHuella);
    
    /**
     * Gets the "Finger2Enroll" attribute
     */
    int getFinger2Enroll();
    
    /**
     * Gets (as xml) the "Finger2Enroll" attribute
     */
    org.apache.xmlbeans.XmlInt xgetFinger2Enroll();
    
    /**
     * Sets the "Finger2Enroll" attribute
     */
    void setFinger2Enroll(int finger2Enroll);
    
    /**
     * Sets (as xml) the "Finger2Enroll" attribute
     */
    void xsetFinger2Enroll(org.apache.xmlbeans.XmlInt finger2Enroll);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static co.com.bytte.casb.ScoreProceso newInstance() {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static co.com.bytte.casb.ScoreProceso newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static co.com.bytte.casb.ScoreProceso parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static co.com.bytte.casb.ScoreProceso parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static co.com.bytte.casb.ScoreProceso parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static co.com.bytte.casb.ScoreProceso parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static co.com.bytte.casb.ScoreProceso parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static co.com.bytte.casb.ScoreProceso parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static co.com.bytte.casb.ScoreProceso parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static co.com.bytte.casb.ScoreProceso parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static co.com.bytte.casb.ScoreProceso parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static co.com.bytte.casb.ScoreProceso parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static co.com.bytte.casb.ScoreProceso parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static co.com.bytte.casb.ScoreProceso parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static co.com.bytte.casb.ScoreProceso parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static co.com.bytte.casb.ScoreProceso parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static co.com.bytte.casb.ScoreProceso parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static co.com.bytte.casb.ScoreProceso parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (co.com.bytte.casb.ScoreProceso) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
