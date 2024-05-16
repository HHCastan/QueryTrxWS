/**
 * RemisionesPosServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class RemisionesPosServiceLocator extends org.apache.axis.client.Service implements org.tempuri.RemisionesPosService {

    public RemisionesPosServiceLocator() {
    }


    public RemisionesPosServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RemisionesPosServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_IRemisionesPosService
    private java.lang.String BasicHttpBinding_IRemisionesPosService_address = "http://172.16.8.206/WcfRemisionesRegistroPosMpAuto/RemisionesPosService.svc";

    public java.lang.String getBasicHttpBinding_IRemisionesPosServiceAddress() {
        return BasicHttpBinding_IRemisionesPosService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_IRemisionesPosServiceWSDDServiceName = "BasicHttpBinding_IRemisionesPosService";

    public java.lang.String getBasicHttpBinding_IRemisionesPosServiceWSDDServiceName() {
        return BasicHttpBinding_IRemisionesPosServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_IRemisionesPosServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_IRemisionesPosServiceWSDDServiceName = name;
    }

    public org.tempuri.IRemisionesPosService getBasicHttpBinding_IRemisionesPosService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_IRemisionesPosService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_IRemisionesPosService(endpoint);
    }

    public org.tempuri.IRemisionesPosService getBasicHttpBinding_IRemisionesPosService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.BasicHttpBinding_IRemisionesPosServiceStub _stub = new org.tempuri.BasicHttpBinding_IRemisionesPosServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_IRemisionesPosServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_IRemisionesPosServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_IRemisionesPosService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.IRemisionesPosService.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.BasicHttpBinding_IRemisionesPosServiceStub _stub = new org.tempuri.BasicHttpBinding_IRemisionesPosServiceStub(new java.net.URL(BasicHttpBinding_IRemisionesPosService_address), this);
                _stub.setPortName(getBasicHttpBinding_IRemisionesPosServiceWSDDServiceName());
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
        if ("BasicHttpBinding_IRemisionesPosService".equals(inputPortName)) {
            return getBasicHttpBinding_IRemisionesPosService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "RemisionesPosService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_IRemisionesPosService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_IRemisionesPosService".equals(portName)) {
            setBasicHttpBinding_IRemisionesPosServiceEndpointAddress(address);
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
