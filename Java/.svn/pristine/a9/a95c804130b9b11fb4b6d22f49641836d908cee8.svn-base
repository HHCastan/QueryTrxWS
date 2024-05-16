/**
 * FALWebServicesImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

public class FALWebServicesImplServiceLocator extends org.apache.axis.client.Service implements com.fal.ws.impl.FALWebServicesImplService {

    public FALWebServicesImplServiceLocator() {
    }


    public FALWebServicesImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FALWebServicesImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FALWebServicesImplPort
    private java.lang.String FALWebServicesImplPort_address = "http://192.168.147.91:8080/falws/falws";

    public java.lang.String getFALWebServicesImplPortAddress() {
        return FALWebServicesImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FALWebServicesImplPortWSDDServiceName = "FALWebServicesImplPort";

    public java.lang.String getFALWebServicesImplPortWSDDServiceName() {
        return FALWebServicesImplPortWSDDServiceName;
    }

    public void setFALWebServicesImplPortWSDDServiceName(java.lang.String name) {
        FALWebServicesImplPortWSDDServiceName = name;
    }

    public com.fal.ws.impl.FALWebServicesImpl getFALWebServicesImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FALWebServicesImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFALWebServicesImplPort(endpoint);
    }

    public com.fal.ws.impl.FALWebServicesImpl getFALWebServicesImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.fal.ws.impl.FALWebServicesImplPortBindingStub _stub = new com.fal.ws.impl.FALWebServicesImplPortBindingStub(portAddress, this);
            _stub.setPortName(getFALWebServicesImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFALWebServicesImplPortEndpointAddress(java.lang.String address) {
        FALWebServicesImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.fal.ws.impl.FALWebServicesImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.fal.ws.impl.FALWebServicesImplPortBindingStub _stub = new com.fal.ws.impl.FALWebServicesImplPortBindingStub(new java.net.URL(FALWebServicesImplPort_address), this);
                _stub.setPortName(getFALWebServicesImplPortWSDDServiceName());
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
        if ("FALWebServicesImplPort".equals(inputPortName)) {
            return getFALWebServicesImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.ws.fal.com/", "FALWebServicesImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "FALWebServicesImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FALWebServicesImplPort".equals(portName)) {
            setFALWebServicesImplPortEndpointAddress(address);
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
