/**
 * FALWebServicesImplPortBindingStub.java
 *
 * This file was auto-generated from WSDL by the Apache Axis 1.4 Apr 22, 2006
 * (06:55:48 PDT) WSDL2Java emitter.
 */

package com.fal.ws.impl;

import org.apache.log4j.Logger;

public class FALWebServicesImplPortBindingStub extends org.apache.axis.client.Stub implements
  com.fal.ws.impl.FALWebServicesImpl
{
  private java.util.Vector cachedSerClasses = new java.util.Vector();
  private java.util.Vector cachedSerQNames = new java.util.Vector();
  private java.util.Vector cachedSerFactories = new java.util.Vector();
  private java.util.Vector cachedDeserFactories = new java.util.Vector();
  private static Logger log = Logger.getLogger(FALWebServicesImplPortBindingStub.class);

  static org.apache.axis.description.OperationDesc[] _operations;

  static
  {
    _operations = new org.apache.axis.description.OperationDesc[17];
    _initOperationDesc1();
    _initOperationDesc2();
  }

  private static void _initOperationDesc1()
  {
    org.apache.axis.description.OperationDesc oper;
    org.apache.axis.description.ParameterDesc param;
    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("requestRewards");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "RewardsRequest"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.ws.fal.com/",
        "basketRequest"), com.fal.ws.impl.BasketRequest.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewardsResponse"));
    oper.setReturnClass(com.fal.ws.impl.RewardsResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "RewardsResponse"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[0] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("SVMessagesRequest");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "SVRequest"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.ws.fal.com/",
        "svBaseLoyaltyRequest"), com.fal.ws.impl.SvBaseLoyaltyRequest.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "svBaseLoyaltyResponse"));
    oper.setReturnClass(com.fal.ws.impl.SvBaseLoyaltyResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "SVResponse"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[1] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("validateCoupon");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Basket"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.ws.fal.com/",
        "basketRequest"), com.fal.ws.impl.BasketRequest.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "baseLoyaltyResponse"));
    oper.setReturnClass(com.fal.ws.impl.BaseLoyaltyResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseMessage"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[2] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("deleteCurrencyRate");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CurrencyCodeFrom"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",
        "string"), java.lang.String.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CurrencyCodeTo"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",
        "string"), java.lang.String.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CurrencyRateDate"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",
        "dateTime"), java.util.Calendar.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falBaseResponse"));
    oper.setReturnClass(com.fal.ws.impl.FalBaseResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseMessage"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[3] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("deleteFamilyByLevel");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "FamilyCode"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",
        "string"), java.lang.String.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "FamilyLevel"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",
        "short"), java.lang.Short.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falBaseResponse"));
    oper.setReturnClass(com.fal.ws.impl.FalBaseResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseMessage"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[4] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("deleteFamilyByParent");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "FamilyCode"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",
        "string"), java.lang.String.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ParentFamilyCode"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",
        "string"), java.lang.String.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falBaseResponse"));
    oper.setReturnClass(com.fal.ws.impl.FalBaseResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseMessage"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[5] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("deleteProduct");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ProductCode"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",
        "string"), java.lang.String.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falBaseResponse"));
    oper.setReturnClass(com.fal.ws.impl.FalBaseResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseMessage"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[6] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("deleteTender");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "TenderCode"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",
        "string"), java.lang.String.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falBaseResponse"));
    oper.setReturnClass(com.fal.ws.impl.FalBaseResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseMessage"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[7] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("saveCurrencyRate");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CurrencyRate"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.ws.fal.com/",
        "currencyRate"), com.fal.ws.impl.CurrencyRate.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falBaseResponse"));
    oper.setReturnClass(com.fal.ws.impl.FalBaseResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseMessage"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[8] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("saveFamily");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Family"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.ws.fal.com/",
        "familyDTO"), com.fal.ws.impl.FamilyDTO.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falBaseResponse"));
    oper.setReturnClass(com.fal.ws.impl.FalBaseResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseMessage"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[9] = oper;

  }

  private static void _initOperationDesc2()
  {
    org.apache.axis.description.OperationDesc oper;
    org.apache.axis.description.ParameterDesc param;
    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("saveTender");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Tender"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.ws.fal.com/", "tender"),
      com.fal.ws.impl.Tender.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falBaseResponse"));
    oper.setReturnClass(com.fal.ws.impl.FalBaseResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseMessage"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[10] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("saveProduct");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Product"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.ws.fal.com/",
        "productDTO"), com.fal.ws.impl.ProductDTO.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falBaseResponse"));
    oper.setReturnClass(com.fal.ws.impl.FalBaseResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseMessage"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[11] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("saveProductPrice");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ProductPrice"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.ws.fal.com/",
        "productPriceDTO"), com.fal.ws.impl.ProductPriceDTO.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falBaseResponse"));
    oper.setReturnClass(com.fal.ws.impl.FalBaseResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseMessage"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[12] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("saveBrand");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Brand"),
      org.apache.axis.description.ParameterDesc.IN,
      new javax.xml.namespace.QName("http://impl.ws.fal.com/", "brandDTO"), com.fal.ws.impl.BrandDTO.class, false,
      false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falBaseResponse"));
    oper.setReturnClass(com.fal.ws.impl.FalBaseResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseMessage"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[13] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("deleteBrand");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "BrandCode"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema",
        "string"), java.lang.String.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falBaseResponse"));
    oper.setReturnClass(com.fal.ws.impl.FalBaseResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseMessage"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[14] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("lookupCards");
    param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "LookupRequest"),
      org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://impl.ws.fal.com/",
        "cardLookupRequest"), com.fal.ws.impl.CardLookupRequest.class, false, false);
    param.setOmittable(true);
    oper.addParameter(param);
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "cardLookupResponse"));
    oper.setReturnClass(com.fal.ws.impl.CardLookupResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "CardLookupResponse"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[15] = oper;

    oper = new org.apache.axis.description.OperationDesc();
    oper.setName("getVersionInfo");
    oper.setReturnType(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falInfoResponse"));
    oper.setReturnClass(com.fal.ws.impl.FalInfoResponse.class);
    oper.setReturnQName(new javax.xml.namespace.QName("", "FalInfoResponse"));
    oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
    oper.setUse(org.apache.axis.constants.Use.LITERAL);
    _operations[16] = oper;

  }

  public FALWebServicesImplPortBindingStub() throws org.apache.axis.AxisFault
  {
    this(null);
  }

  public FALWebServicesImplPortBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service)
    throws org.apache.axis.AxisFault
  {
    this(service);
    super.cachedEndpoint = endpointURL;
  }

  public FALWebServicesImplPortBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault
  {
    if (service == null)
    {
      super.service = new org.apache.axis.client.Service();
    }
    else
    {
      super.service = service;
    }
    ((org.apache.axis.client.Service) super.service).setTypeMappingVersion("1.2");
    java.lang.Class cls;
    javax.xml.namespace.QName qName;
    javax.xml.namespace.QName qName2;
    java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
    java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
    java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
    java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
    java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
    java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
    java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
    java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
    java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
    java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", ">falBaseResponse>messages");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.ResponseMessage[].class;
    cachedSerClasses.add(cls);
    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "responseMessage");
    qName2 = new javax.xml.namespace.QName("", "message");
    cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
    cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", ">rewardsResponse>nearMissMessages");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.NearMissMessage[].class;
    cachedSerClasses.add(cls);
    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "nearMissMessage");
    qName2 = new javax.xml.namespace.QName("", "nearMissMessage");
    cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
    cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "balance");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.Balance.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "balances");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.Balances.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "baseLoyaltyRequest");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.BaseLoyaltyRequest.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "baseLoyaltyResponse");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.BaseLoyaltyResponse.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "basketRequest");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.BasketRequest.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "brandDTO");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.BrandDTO.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "cardData");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.CardData.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "cardLookupRequest");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.CardLookupRequest.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "cardLookupResponse");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.CardLookupResponse.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "coupon");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.Coupon.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "couponMessages");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.CouponMessages.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "coupons");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.Coupons.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "currencyRate");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.CurrencyRate.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "customerDetails");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.CustomerDetails.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "customerName");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.CustomerName.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falBaseDTO");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.FalBaseDTO.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falBaseResponse");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.FalBaseResponse.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "falInfoResponse");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.FalInfoResponse.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "familyDTO");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.FamilyDTO.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "giftReward");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.GiftReward.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "giftRewards");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.GiftRewards.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "keyValue");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.KeyValue.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "lineItem");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.LineItem.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "lineItems");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.LineItems.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "messageLevel");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.MessageLevel.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(enumsf);
    cachedDeserFactories.add(enumdf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "nearMissMessage");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.NearMissMessage.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "paymentMethod");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.PaymentMethod.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "paymentMethods");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.PaymentMethods.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "productDTO");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.ProductDTO.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "productPriceDTO");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.ProductPriceDTO.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "productTrigger");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.ProductTrigger.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "productTriggers");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.ProductTriggers.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "responseMessage");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.ResponseMessage.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "reward");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.Reward.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewardLimitation");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.RewardLimitation.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewardLimitations");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.RewardLimitations.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewardMessage");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.RewardMessage.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewards");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.Rewards.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewardsField");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.RewardsField.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "rewardsResponse");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.RewardsResponse.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "supInfos");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.SupInfos.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "svBaseLoyaltyRequest");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.SvBaseLoyaltyRequest.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "svBaseLoyaltyResponse");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.SvBaseLoyaltyResponse.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "tender");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.Tender.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "ticket");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.Ticket.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "ticketMessage");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.TicketMessage.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "ticketMessages");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.TicketMessages.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "transactionLimitation");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.TransactionLimitation.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "transactionLimitations");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.TransactionLimitations.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "trxError");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.TrxError.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "trxErrors");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.TrxErrors.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "voidedReward");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.VoidedReward.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "voidedRewards");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.VoidedRewards.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "voucherDto");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.VoucherDto.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);

    qName = new javax.xml.namespace.QName("http://impl.ws.fal.com/", "vouchersDto");
    cachedSerQNames.add(qName);
    cls = com.fal.ws.impl.VouchersDto.class;
    cachedSerClasses.add(cls);
    cachedSerFactories.add(beansf);
    cachedDeserFactories.add(beandf);
    // Iniciando Logger
    

  }

  protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException
  {
    try
    {
      org.apache.axis.client.Call _call = super._createCall();
      if (super.maintainSessionSet)
      {
        _call.setMaintainSession(super.maintainSession);
      }
      if (super.cachedUsername != null)
      {
        _call.setUsername(super.cachedUsername);
      }
      if (super.cachedPassword != null)
      {
        _call.setPassword(super.cachedPassword);
      }
      if (super.cachedEndpoint != null)
      {
        _call.setTargetEndpointAddress(super.cachedEndpoint);
      }
      if (super.cachedTimeout != null)
      {
        _call.setTimeout(super.cachedTimeout);
      }
      if (super.cachedPortName != null)
      {
        _call.setPortName(super.cachedPortName);
      }
      java.util.Enumeration keys = super.cachedProperties.keys();
      while (keys.hasMoreElements())
      {
        java.lang.String key = (java.lang.String) keys.nextElement();
        _call.setProperty(key, super.cachedProperties.get(key));
      }
      // All the type mapping information is registered
      // when the first call is made.
      // The type mapping information is actually registered in
      // the TypeMappingRegistry of the service, which
      // is the reason why registration is only needed for the first call.
      synchronized (this)
      {
        if (firstCall())
        {
          // must set encoding style before registering serializers
          _call.setEncodingStyle(null);
          for (int i = 0; i < cachedSerFactories.size(); ++i)
          {
            java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
            javax.xml.namespace.QName qName = (javax.xml.namespace.QName) cachedSerQNames.get(i);
            java.lang.Object x = cachedSerFactories.get(i);
            if (x instanceof Class)
            {
              java.lang.Class sf = (java.lang.Class) cachedSerFactories.get(i);
              java.lang.Class df = (java.lang.Class) cachedDeserFactories.get(i);
              _call.registerTypeMapping(cls, qName, sf, df, false);
            }
            else if (x instanceof javax.xml.rpc.encoding.SerializerFactory)
            {
              org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory) cachedSerFactories
                .get(i);
              org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory) cachedDeserFactories
                .get(i);
              _call.registerTypeMapping(cls, qName, sf, df, false);
            }
          }
        }
      }
      return _call;
    }
    catch (java.lang.Throwable _t)
    {
      throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
    }
  }

  public com.fal.ws.impl.RewardsResponse requestRewards(com.fal.ws.impl.BasketRequest rewardsRequest)
    throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[0]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "requestRewards"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { rewardsRequest });
      if (log.isInfoEnabled())
      {
        log.info("[FALWS] envio: " + _call.getMessageContext().getRequestMessage().getSOAPPartAsString());
        log.info("[FALWS] respuesta: " + _call.getResponseMessage().getSOAPPartAsString());
      // Log.logInfo("[FALWS] envio: " +
      // _call.getMessageContext().getRequestMessage().getSOAPPartAsString());

//      Log.logInfo("[FALWS] respuesta: " + _call.getResponseMessage().getSOAPPartAsString());
      }
      System.out.println("[FALWS] respuesta: " + _call.getResponseMessage().getSOAPPartAsString());

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.RewardsResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.RewardsResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.RewardsResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.SvBaseLoyaltyResponse SVMessagesRequest(com.fal.ws.impl.SvBaseLoyaltyRequest SVRequest)
    throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[1]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "SVMessagesRequest"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { SVRequest });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.SvBaseLoyaltyResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.SvBaseLoyaltyResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.SvBaseLoyaltyResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.BaseLoyaltyResponse validateCoupon(com.fal.ws.impl.BasketRequest basket)
    throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[2]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "validateCoupon"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { basket });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.BaseLoyaltyResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.BaseLoyaltyResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.BaseLoyaltyResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.FalBaseResponse deleteCurrencyRate(java.lang.String currencyCodeFrom,
    java.lang.String currencyCodeTo, java.util.Calendar currencyRateDate) throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[3]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "deleteCurrencyRate"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call
        .invoke(new java.lang.Object[] { currencyCodeFrom, currencyCodeTo, currencyRateDate });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.FalBaseResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.FalBaseResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.FalBaseResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.FalBaseResponse deleteFamilyByLevel(java.lang.String familyCode, java.lang.Short familyLevel)
    throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[4]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "deleteFamilyByLevel"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { familyCode, familyLevel });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.FalBaseResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.FalBaseResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.FalBaseResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.FalBaseResponse deleteFamilyByParent(java.lang.String familyCode,
    java.lang.String parentFamilyCode) throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[5]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "deleteFamilyByParent"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { familyCode, parentFamilyCode });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.FalBaseResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.FalBaseResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.FalBaseResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.FalBaseResponse deleteProduct(java.lang.String productCode) throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[6]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "deleteProduct"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { productCode });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.FalBaseResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.FalBaseResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.FalBaseResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.FalBaseResponse deleteTender(java.lang.String tenderCode) throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[7]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "deleteTender"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { tenderCode });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.FalBaseResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.FalBaseResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.FalBaseResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.FalBaseResponse saveCurrencyRate(com.fal.ws.impl.CurrencyRate currencyRate)
    throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[8]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "saveCurrencyRate"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { currencyRate });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.FalBaseResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.FalBaseResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.FalBaseResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.FalBaseResponse saveFamily(com.fal.ws.impl.FamilyDTO family) throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[9]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "saveFamily"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { family });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.FalBaseResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.FalBaseResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.FalBaseResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.FalBaseResponse saveTender(com.fal.ws.impl.Tender tender) throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[10]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "saveTender"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { tender });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.FalBaseResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.FalBaseResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.FalBaseResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.FalBaseResponse saveProduct(com.fal.ws.impl.ProductDTO product)
    throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[11]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "saveProduct"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { product });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.FalBaseResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.FalBaseResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.FalBaseResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.FalBaseResponse saveProductPrice(com.fal.ws.impl.ProductPriceDTO productPrice)
    throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[12]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "saveProductPrice"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { productPrice });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.FalBaseResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.FalBaseResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.FalBaseResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.FalBaseResponse saveBrand(com.fal.ws.impl.BrandDTO brand) throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[13]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "saveBrand"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { brand });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.FalBaseResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.FalBaseResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.FalBaseResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.FalBaseResponse deleteBrand(java.lang.String brandCode) throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[14]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "deleteBrand"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { brandCode });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.FalBaseResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.FalBaseResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.FalBaseResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.CardLookupResponse lookupCards(com.fal.ws.impl.CardLookupRequest lookupRequest)
    throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[15]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "lookupCards"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] { lookupRequest });

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.CardLookupResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.CardLookupResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.CardLookupResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

  public com.fal.ws.impl.FalInfoResponse getVersionInfo() throws java.rmi.RemoteException
  {
    if (super.cachedEndpoint == null)
    {
      throw new org.apache.axis.NoEndPointException();
    }
    org.apache.axis.client.Call _call = createCall();
    _call.setOperation(_operations[16]);
    _call.setUseSOAPAction(true);
    _call.setSOAPActionURI("");
    _call.setEncodingStyle(null);
    _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
    _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
    _call.setOperationName(new javax.xml.namespace.QName("http://impl.ws.fal.com/", "getVersionInfo"));

    setRequestHeaders(_call);
    setAttachments(_call);
    try
    {
      java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

      if (_resp instanceof java.rmi.RemoteException)
      {
        throw (java.rmi.RemoteException) _resp;
      }
      else
      {
        extractAttachments(_call);
        try
        {
          return (com.fal.ws.impl.FalInfoResponse) _resp;
        }
        catch (java.lang.Exception _exception)
        {
          return (com.fal.ws.impl.FalInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp,
            com.fal.ws.impl.FalInfoResponse.class);
        }
      }
    }
    catch (org.apache.axis.AxisFault axisFaultException)
    {
      throw axisFaultException;
    }
  }

}
