/**
 * PortalWebServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mefia.omnia.portal.services;

public class PortalWebServiceLocator extends org.apache.axis.client.Service implements com.mefia.omnia.portal.services.PortalWebService {

    public PortalWebServiceLocator() {
    }


    public PortalWebServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PortalWebServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PortalWebServiceImplPort
    private java.lang.String PortalWebServiceImplPort_address = "https://plataformacomercial.flamingo.com.co:7103/omnia-services/portalWebService";

    public java.lang.String getPortalWebServiceImplPortAddress() {
        return PortalWebServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PortalWebServiceImplPortWSDDServiceName = "PortalWebServiceImplPort";

    public java.lang.String getPortalWebServiceImplPortWSDDServiceName() {
        return PortalWebServiceImplPortWSDDServiceName;
    }

    public void setPortalWebServiceImplPortWSDDServiceName(java.lang.String name) {
        PortalWebServiceImplPortWSDDServiceName = name;
    }

    public omnia.mefia.com.PortalWebService getPortalWebServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PortalWebServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPortalWebServiceImplPort(endpoint);
    }

    public omnia.mefia.com.PortalWebService getPortalWebServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.mefia.omnia.portal.services.PortalWebServiceImplPortBindingStub _stub = new com.mefia.omnia.portal.services.PortalWebServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getPortalWebServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPortalWebServiceImplPortEndpointAddress(java.lang.String address) {
        PortalWebServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (omnia.mefia.com.PortalWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.mefia.omnia.portal.services.PortalWebServiceImplPortBindingStub _stub = new com.mefia.omnia.portal.services.PortalWebServiceImplPortBindingStub(new java.net.URL(PortalWebServiceImplPort_address), this);
                _stub.setPortName(getPortalWebServiceImplPortWSDDServiceName());
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
        if ("PortalWebServiceImplPort".equals(inputPortName)) {
            return getPortalWebServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services.portal.omnia.mefia.com/", "portalWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services.portal.omnia.mefia.com/", "PortalWebServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PortalWebServiceImplPort".equals(portName)) {
            setPortalWebServiceImplPortEndpointAddress(address);
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
