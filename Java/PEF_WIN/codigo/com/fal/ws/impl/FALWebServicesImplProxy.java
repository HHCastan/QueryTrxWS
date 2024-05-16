package com.fal.ws.impl;

public class FALWebServicesImplProxy implements com.fal.ws.impl.FALWebServicesImpl {
  private String _endpoint = null;
  private com.fal.ws.impl.FALWebServicesImpl fALWebServicesImpl = null;
  
  public FALWebServicesImplProxy() {
    _initFALWebServicesImplProxy();
  }
  
  public FALWebServicesImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initFALWebServicesImplProxy();
  }
  
  private void _initFALWebServicesImplProxy() {
    try {
      fALWebServicesImpl = (new com.fal.ws.impl.FALWebServicesImplServiceLocator()).getFALWebServicesImplPort();
      if (fALWebServicesImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)fALWebServicesImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)fALWebServicesImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (fALWebServicesImpl != null)
      ((javax.xml.rpc.Stub)fALWebServicesImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.fal.ws.impl.FALWebServicesImpl getFALWebServicesImpl() {
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl;
  }
  
  public com.fal.ws.impl.RewardsResponse requestRewards(com.fal.ws.impl.BasketRequest rewardsRequest) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.requestRewards(rewardsRequest);
  }
  
  public com.fal.ws.impl.SvBaseLoyaltyResponse SVMessagesRequest(com.fal.ws.impl.SvBaseLoyaltyRequest SVRequest) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.SVMessagesRequest(SVRequest);
  }
  
  public com.fal.ws.impl.BaseLoyaltyResponse validateCoupon(com.fal.ws.impl.BasketRequest basket) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.validateCoupon(basket);
  }
  
  public com.fal.ws.impl.FalBaseResponse deleteCurrencyRate(java.lang.String currencyCodeFrom, java.lang.String currencyCodeTo, java.util.Calendar currencyRateDate) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.deleteCurrencyRate(currencyCodeFrom, currencyCodeTo, currencyRateDate);
  }
  
  public com.fal.ws.impl.FalBaseResponse deleteFamilyByLevel(java.lang.String familyCode, java.lang.Short familyLevel) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.deleteFamilyByLevel(familyCode, familyLevel);
  }
  
  public com.fal.ws.impl.FalBaseResponse deleteFamilyByParent(java.lang.String familyCode, java.lang.String parentFamilyCode) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.deleteFamilyByParent(familyCode, parentFamilyCode);
  }
  
  public com.fal.ws.impl.FalBaseResponse deleteProduct(java.lang.String productCode) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.deleteProduct(productCode);
  }
  
  public com.fal.ws.impl.FalBaseResponse deleteTender(java.lang.String tenderCode) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.deleteTender(tenderCode);
  }
  
  public com.fal.ws.impl.FalBaseResponse saveCurrencyRate(com.fal.ws.impl.CurrencyRate currencyRate) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.saveCurrencyRate(currencyRate);
  }
  
  public com.fal.ws.impl.FalBaseResponse saveFamily(com.fal.ws.impl.FamilyDTO family) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.saveFamily(family);
  }
  
  public com.fal.ws.impl.FalBaseResponse saveTender(com.fal.ws.impl.Tender tender) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.saveTender(tender);
  }
  
  public com.fal.ws.impl.FalBaseResponse saveProduct(com.fal.ws.impl.ProductDTO product) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.saveProduct(product);
  }
  
  public com.fal.ws.impl.FalBaseResponse saveProductPrice(com.fal.ws.impl.ProductPriceDTO productPrice) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.saveProductPrice(productPrice);
  }
  
  public com.fal.ws.impl.FalBaseResponse saveBrand(com.fal.ws.impl.BrandDTO brand) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.saveBrand(brand);
  }
  
  public com.fal.ws.impl.FalBaseResponse deleteBrand(java.lang.String brandCode) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.deleteBrand(brandCode);
  }
  
  public com.fal.ws.impl.CardLookupResponse lookupCards(com.fal.ws.impl.CardLookupRequest lookupRequest) throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.lookupCards(lookupRequest);
  }
  
  public com.fal.ws.impl.FalInfoResponse getVersionInfo() throws java.rmi.RemoteException{
    if (fALWebServicesImpl == null)
      _initFALWebServicesImplProxy();
    return fALWebServicesImpl.getVersionInfo();
  }
  
  
}