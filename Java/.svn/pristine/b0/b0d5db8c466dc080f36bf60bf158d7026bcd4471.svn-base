/**
 * SwLiteClientesLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package co.com.flamingo.www._2018._06;

public class SwLiteClientesLocator extends org.apache.axis.client.Service implements co.com.flamingo.www._2018._06.SwLiteClientes {

    public SwLiteClientesLocator() {
    }


    public SwLiteClientesLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SwLiteClientesLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EndPoint1
    private java.lang.String EndPoint1_address = "http://172.16.8.59/SwLiteClientes/SwLiteClientes.svc";

    public java.lang.String getEndPoint1Address() {
        return EndPoint1_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EndPoint1WSDDServiceName = "EndPoint1";

    public java.lang.String getEndPoint1WSDDServiceName() {
        return EndPoint1WSDDServiceName;
    }

    public void setEndPoint1WSDDServiceName(java.lang.String name) {
        EndPoint1WSDDServiceName = name;
    }

    public co.com.flamingo.www.ISWLiteClientes getEndPoint1() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EndPoint1_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEndPoint1(endpoint);
    }

    public co.com.flamingo.www.ISWLiteClientes getEndPoint1(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.EndPoint1Stub _stub = new org.tempuri.EndPoint1Stub(portAddress, this);
            _stub.setPortName(getEndPoint1WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEndPoint1EndpointAddress(java.lang.String address) {
        EndPoint1_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (co.com.flamingo.www.ISWLiteClientes.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.EndPoint1Stub _stub = new org.tempuri.EndPoint1Stub(new java.net.URL(EndPoint1_address), this);
                _stub.setPortName(getEndPoint1WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EndPoint1".equals(inputPortName)) {
            return getEndPoint1();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.flamingo.com.co/2018/06", "SwLiteClientes");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.flamingo.com.co/2018/06", "EndPoint1"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EndPoint1".equals(portName)) {
            setEndPoint1EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
