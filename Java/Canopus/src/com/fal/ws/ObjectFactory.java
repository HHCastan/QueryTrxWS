
package com.fal.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.fal.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteBrandResponse_QNAME = new QName("http://impl.ws.fal.com/", "deleteBrandResponse");
    private final static QName _DeleteFamilyByParent_QNAME = new QName("http://impl.ws.fal.com/", "deleteFamilyByParent");
    private final static QName _DeleteFamilyByParentResponse_QNAME = new QName("http://impl.ws.fal.com/", "deleteFamilyByParentResponse");
    private final static QName _LookupCards_QNAME = new QName("http://impl.ws.fal.com/", "lookupCards");
    private final static QName _DeleteFamilyByLevel_QNAME = new QName("http://impl.ws.fal.com/", "deleteFamilyByLevel");
    private final static QName _DeleteCurrencyRate_QNAME = new QName("http://impl.ws.fal.com/", "deleteCurrencyRate");
    private final static QName _DeleteProduct_QNAME = new QName("http://impl.ws.fal.com/", "deleteProduct");
    private final static QName _DeleteCurrencyRateResponse_QNAME = new QName("http://impl.ws.fal.com/", "deleteCurrencyRateResponse");
    private final static QName _ValidateCoupon_QNAME = new QName("http://impl.ws.fal.com/", "validateCoupon");
    private final static QName _SVMessagesRequest_QNAME = new QName("http://impl.ws.fal.com/", "SVMessagesRequest");
    private final static QName _DeleteTenderResponse_QNAME = new QName("http://impl.ws.fal.com/", "deleteTenderResponse");
    private final static QName _SaveTender_QNAME = new QName("http://impl.ws.fal.com/", "saveTender");
    private final static QName _GetVersionInfo_QNAME = new QName("http://impl.ws.fal.com/", "getVersionInfo");
    private final static QName _DeleteBrand_QNAME = new QName("http://impl.ws.fal.com/", "deleteBrand");
    private final static QName _SuggestProductPromotions_QNAME = new QName("http://impl.ws.fal.com/", "suggestProductPromotions");
    private final static QName _SaveTenderResponse_QNAME = new QName("http://impl.ws.fal.com/", "saveTenderResponse");
    private final static QName _SaveFamily_QNAME = new QName("http://impl.ws.fal.com/", "saveFamily");
    private final static QName _SaveProduct_QNAME = new QName("http://impl.ws.fal.com/", "saveProduct");
    private final static QName _DeleteTender_QNAME = new QName("http://impl.ws.fal.com/", "deleteTender");
    private final static QName _ValidateCouponResponse_QNAME = new QName("http://impl.ws.fal.com/", "validateCouponResponse");
    private final static QName _SVMessagesRequestResponse_QNAME = new QName("http://impl.ws.fal.com/", "SVMessagesRequestResponse");
    private final static QName _GetCardInfo_QNAME = new QName("http://impl.ws.fal.com/", "getCardInfo");
    private final static QName _GetVersionInfoResponse_QNAME = new QName("http://impl.ws.fal.com/", "getVersionInfoResponse");
    private final static QName _SaveProductPriceResponse_QNAME = new QName("http://impl.ws.fal.com/", "saveProductPriceResponse");
    private final static QName _GetPersonalRewardsResponse_QNAME = new QName("http://impl.ws.fal.com/", "getPersonalRewardsResponse");
    private final static QName _GetPersonalRewards_QNAME = new QName("http://impl.ws.fal.com/", "getPersonalRewards");
    private final static QName _SaveProductPrice_QNAME = new QName("http://impl.ws.fal.com/", "saveProductPrice");
    private final static QName _SaveCurrencyRateResponse_QNAME = new QName("http://impl.ws.fal.com/", "saveCurrencyRateResponse");
    private final static QName _GetCardInfoResponse_QNAME = new QName("http://impl.ws.fal.com/", "getCardInfoResponse");
    private final static QName _SaveFamilyResponse_QNAME = new QName("http://impl.ws.fal.com/", "saveFamilyResponse");
    private final static QName _DeleteProductResponse_QNAME = new QName("http://impl.ws.fal.com/", "deleteProductResponse");
    private final static QName _RequestRewardsResponse_QNAME = new QName("http://impl.ws.fal.com/", "requestRewardsResponse");
    private final static QName _SaveBrandResponse_QNAME = new QName("http://impl.ws.fal.com/", "saveBrandResponse");
    private final static QName _LookupCardsResponse_QNAME = new QName("http://impl.ws.fal.com/", "lookupCardsResponse");
    private final static QName _SaveBrand_QNAME = new QName("http://impl.ws.fal.com/", "saveBrand");
    private final static QName _RequestRewards_QNAME = new QName("http://impl.ws.fal.com/", "requestRewards");
    private final static QName _SaveProductResponse_QNAME = new QName("http://impl.ws.fal.com/", "saveProductResponse");
    private final static QName _SaveCurrencyRate_QNAME = new QName("http://impl.ws.fal.com/", "saveCurrencyRate");
    private final static QName _DeleteFamilyByLevelResponse_QNAME = new QName("http://impl.ws.fal.com/", "deleteFamilyByLevelResponse");
    private final static QName _SuggestProductPromotionsResponse_QNAME = new QName("http://impl.ws.fal.com/", "suggestProductPromotionsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.fal.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FalBaseResponse }
     * 
     */
    public FalBaseResponse createFalBaseResponse() {
        return new FalBaseResponse();
    }

    /**
     * Create an instance of {@link RewardsResponse }
     * 
     */
    public RewardsResponse createRewardsResponse() {
        return new RewardsResponse();
    }

    /**
     * Create an instance of {@link GetCardInfo }
     * 
     */
    public GetCardInfo createGetCardInfo() {
        return new GetCardInfo();
    }

    /**
     * Create an instance of {@link GetVersionInfoResponse }
     * 
     */
    public GetVersionInfoResponse createGetVersionInfoResponse() {
        return new GetVersionInfoResponse();
    }

    /**
     * Create an instance of {@link SaveTenderResponse }
     * 
     */
    public SaveTenderResponse createSaveTenderResponse() {
        return new SaveTenderResponse();
    }

    /**
     * Create an instance of {@link SaveFamily }
     * 
     */
    public SaveFamily createSaveFamily() {
        return new SaveFamily();
    }

    /**
     * Create an instance of {@link SaveProduct }
     * 
     */
    public SaveProduct createSaveProduct() {
        return new SaveProduct();
    }

    /**
     * Create an instance of {@link SVMessagesRequestResponse }
     * 
     */
    public SVMessagesRequestResponse createSVMessagesRequestResponse() {
        return new SVMessagesRequestResponse();
    }

    /**
     * Create an instance of {@link DeleteTender }
     * 
     */
    public DeleteTender createDeleteTender() {
        return new DeleteTender();
    }

    /**
     * Create an instance of {@link ValidateCouponResponse }
     * 
     */
    public ValidateCouponResponse createValidateCouponResponse() {
        return new ValidateCouponResponse();
    }

    /**
     * Create an instance of {@link DeleteTenderResponse }
     * 
     */
    public DeleteTenderResponse createDeleteTenderResponse() {
        return new DeleteTenderResponse();
    }

    /**
     * Create an instance of {@link SaveTender }
     * 
     */
    public SaveTender createSaveTender() {
        return new SaveTender();
    }

    /**
     * Create an instance of {@link GetVersionInfo }
     * 
     */
    public GetVersionInfo createGetVersionInfo() {
        return new GetVersionInfo();
    }

    /**
     * Create an instance of {@link DeleteBrand }
     * 
     */
    public DeleteBrand createDeleteBrand() {
        return new DeleteBrand();
    }

    /**
     * Create an instance of {@link SuggestProductPromotions }
     * 
     */
    public SuggestProductPromotions createSuggestProductPromotions() {
        return new SuggestProductPromotions();
    }

    /**
     * Create an instance of {@link DeleteBrandResponse }
     * 
     */
    public DeleteBrandResponse createDeleteBrandResponse() {
        return new DeleteBrandResponse();
    }

    /**
     * Create an instance of {@link DeleteFamilyByParent }
     * 
     */
    public DeleteFamilyByParent createDeleteFamilyByParent() {
        return new DeleteFamilyByParent();
    }

    /**
     * Create an instance of {@link DeleteFamilyByParentResponse }
     * 
     */
    public DeleteFamilyByParentResponse createDeleteFamilyByParentResponse() {
        return new DeleteFamilyByParentResponse();
    }

    /**
     * Create an instance of {@link LookupCards }
     * 
     */
    public LookupCards createLookupCards() {
        return new LookupCards();
    }

    /**
     * Create an instance of {@link DeleteCurrencyRateResponse }
     * 
     */
    public DeleteCurrencyRateResponse createDeleteCurrencyRateResponse() {
        return new DeleteCurrencyRateResponse();
    }

    /**
     * Create an instance of {@link DeleteFamilyByLevel }
     * 
     */
    public DeleteFamilyByLevel createDeleteFamilyByLevel() {
        return new DeleteFamilyByLevel();
    }

    /**
     * Create an instance of {@link DeleteCurrencyRate }
     * 
     */
    public DeleteCurrencyRate createDeleteCurrencyRate() {
        return new DeleteCurrencyRate();
    }

    /**
     * Create an instance of {@link DeleteProduct }
     * 
     */
    public DeleteProduct createDeleteProduct() {
        return new DeleteProduct();
    }

    /**
     * Create an instance of {@link SVMessagesRequest }
     * 
     */
    public SVMessagesRequest createSVMessagesRequest() {
        return new SVMessagesRequest();
    }

    /**
     * Create an instance of {@link ValidateCoupon }
     * 
     */
    public ValidateCoupon createValidateCoupon() {
        return new ValidateCoupon();
    }

    /**
     * Create an instance of {@link SaveProductResponse }
     * 
     */
    public SaveProductResponse createSaveProductResponse() {
        return new SaveProductResponse();
    }

    /**
     * Create an instance of {@link SaveCurrencyRate }
     * 
     */
    public SaveCurrencyRate createSaveCurrencyRate() {
        return new SaveCurrencyRate();
    }

    /**
     * Create an instance of {@link DeleteFamilyByLevelResponse }
     * 
     */
    public DeleteFamilyByLevelResponse createDeleteFamilyByLevelResponse() {
        return new DeleteFamilyByLevelResponse();
    }

    /**
     * Create an instance of {@link SuggestProductPromotionsResponse }
     * 
     */
    public SuggestProductPromotionsResponse createSuggestProductPromotionsResponse() {
        return new SuggestProductPromotionsResponse();
    }

    /**
     * Create an instance of {@link LookupCardsResponse }
     * 
     */
    public LookupCardsResponse createLookupCardsResponse() {
        return new LookupCardsResponse();
    }

    /**
     * Create an instance of {@link SaveBrand }
     * 
     */
    public SaveBrand createSaveBrand() {
        return new SaveBrand();
    }

    /**
     * Create an instance of {@link RequestRewards }
     * 
     */
    public RequestRewards createRequestRewards() {
        return new RequestRewards();
    }

    /**
     * Create an instance of {@link GetPersonalRewards }
     * 
     */
    public GetPersonalRewards createGetPersonalRewards() {
        return new GetPersonalRewards();
    }

    /**
     * Create an instance of {@link SaveProductPrice }
     * 
     */
    public SaveProductPrice createSaveProductPrice() {
        return new SaveProductPrice();
    }

    /**
     * Create an instance of {@link SaveCurrencyRateResponse }
     * 
     */
    public SaveCurrencyRateResponse createSaveCurrencyRateResponse() {
        return new SaveCurrencyRateResponse();
    }

    /**
     * Create an instance of {@link GetCardInfoResponse }
     * 
     */
    public GetCardInfoResponse createGetCardInfoResponse() {
        return new GetCardInfoResponse();
    }

    /**
     * Create an instance of {@link SaveFamilyResponse }
     * 
     */
    public SaveFamilyResponse createSaveFamilyResponse() {
        return new SaveFamilyResponse();
    }

    /**
     * Create an instance of {@link DeleteProductResponse }
     * 
     */
    public DeleteProductResponse createDeleteProductResponse() {
        return new DeleteProductResponse();
    }

    /**
     * Create an instance of {@link SaveBrandResponse }
     * 
     */
    public SaveBrandResponse createSaveBrandResponse() {
        return new SaveBrandResponse();
    }

    /**
     * Create an instance of {@link RequestRewardsResponse }
     * 
     */
    public RequestRewardsResponse createRequestRewardsResponse() {
        return new RequestRewardsResponse();
    }

    /**
     * Create an instance of {@link SaveProductPriceResponse }
     * 
     */
    public SaveProductPriceResponse createSaveProductPriceResponse() {
        return new SaveProductPriceResponse();
    }

    /**
     * Create an instance of {@link GetPersonalRewardsResponse }
     * 
     */
    public GetPersonalRewardsResponse createGetPersonalRewardsResponse() {
        return new GetPersonalRewardsResponse();
    }

    /**
     * Create an instance of {@link BaseLoyaltyResponse }
     * 
     */
    public BaseLoyaltyResponse createBaseLoyaltyResponse() {
        return new BaseLoyaltyResponse();
    }

    /**
     * Create an instance of {@link KeyValue }
     * 
     */
    public KeyValue createKeyValue() {
        return new KeyValue();
    }

    /**
     * Create an instance of {@link RewardLimitations }
     * 
     */
    public RewardLimitations createRewardLimitations() {
        return new RewardLimitations();
    }

    /**
     * Create an instance of {@link ProductDTO }
     * 
     */
    public ProductDTO createProductDTO() {
        return new ProductDTO();
    }

    /**
     * Create an instance of {@link ProductTrigger }
     * 
     */
    public ProductTrigger createProductTrigger() {
        return new ProductTrigger();
    }

    /**
     * Create an instance of {@link Balance }
     * 
     */
    public Balance createBalance() {
        return new Balance();
    }

    /**
     * Create an instance of {@link Coupons }
     * 
     */
    public Coupons createCoupons() {
        return new Coupons();
    }

    /**
     * Create an instance of {@link BaseLoyaltyRequest }
     * 
     */
    public BaseLoyaltyRequest createBaseLoyaltyRequest() {
        return new BaseLoyaltyRequest();
    }

    /**
     * Create an instance of {@link GiftReward }
     * 
     */
    public GiftReward createGiftReward() {
        return new GiftReward();
    }

    /**
     * Create an instance of {@link VoidedReward }
     * 
     */
    public VoidedReward createVoidedReward() {
        return new VoidedReward();
    }

    /**
     * Create an instance of {@link TillInteractionAnswers }
     * 
     */
    public TillInteractionAnswers createTillInteractionAnswers() {
        return new TillInteractionAnswers();
    }

    /**
     * Create an instance of {@link TillInteractionDto }
     * 
     */
    public TillInteractionDto createTillInteractionDto() {
        return new TillInteractionDto();
    }

    /**
     * Create an instance of {@link ProductPromotionResponse }
     * 
     */
    public ProductPromotionResponse createProductPromotionResponse() {
        return new ProductPromotionResponse();
    }

    /**
     * Create an instance of {@link CustomerName }
     * 
     */
    public CustomerName createCustomerName() {
        return new CustomerName();
    }

    /**
     * Create an instance of {@link ProductInfo }
     * 
     */
    public ProductInfo createProductInfo() {
        return new ProductInfo();
    }

    /**
     * Create an instance of {@link FamilyDTO }
     * 
     */
    public FamilyDTO createFamilyDTO() {
        return new FamilyDTO();
    }

    /**
     * Create an instance of {@link TrxError }
     * 
     */
    public TrxError createTrxError() {
        return new TrxError();
    }

    /**
     * Create an instance of {@link CustomerMessageDTO }
     * 
     */
    public CustomerMessageDTO createCustomerMessageDTO() {
        return new CustomerMessageDTO();
    }

    /**
     * Create an instance of {@link CustomerTotalDTO }
     * 
     */
    public CustomerTotalDTO createCustomerTotalDTO() {
        return new CustomerTotalDTO();
    }

    /**
     * Create an instance of {@link Balances }
     * 
     */
    public Balances createBalances() {
        return new Balances();
    }

    /**
     * Create an instance of {@link PaymentMethods }
     * 
     */
    public PaymentMethods createPaymentMethods() {
        return new PaymentMethods();
    }

    /**
     * Create an instance of {@link NearMissMessage }
     * 
     */
    public NearMissMessage createNearMissMessage() {
        return new NearMissMessage();
    }

    /**
     * Create an instance of {@link Tender }
     * 
     */
    public Tender createTender() {
        return new Tender();
    }

    /**
     * Create an instance of {@link SupInfos }
     * 
     */
    public SupInfos createSupInfos() {
        return new SupInfos();
    }

    /**
     * Create an instance of {@link Reward }
     * 
     */
    public Reward createReward() {
        return new Reward();
    }

    /**
     * Create an instance of {@link TillInteractionAnswer }
     * 
     */
    public TillInteractionAnswer createTillInteractionAnswer() {
        return new TillInteractionAnswer();
    }

    /**
     * Create an instance of {@link Coupon }
     * 
     */
    public Coupon createCoupon() {
        return new Coupon();
    }

    /**
     * Create an instance of {@link FalBaseDTO }
     * 
     */
    public FalBaseDTO createFalBaseDTO() {
        return new FalBaseDTO();
    }

    /**
     * Create an instance of {@link PersonalReward }
     * 
     */
    public PersonalReward createPersonalReward() {
        return new PersonalReward();
    }

    /**
     * Create an instance of {@link CurrencyRate }
     * 
     */
    public CurrencyRate createCurrencyRate() {
        return new CurrencyRate();
    }

    /**
     * Create an instance of {@link ProductPriceDTO }
     * 
     */
    public ProductPriceDTO createProductPriceDTO() {
        return new ProductPriceDTO();
    }

    /**
     * Create an instance of {@link IdentifierDTO }
     * 
     */
    public IdentifierDTO createIdentifierDTO() {
        return new IdentifierDTO();
    }

    /**
     * Create an instance of {@link LineItems }
     * 
     */
    public LineItems createLineItems() {
        return new LineItems();
    }

    /**
     * Create an instance of {@link CustomerTotalsDTO }
     * 
     */
    public CustomerTotalsDTO createCustomerTotalsDTO() {
        return new CustomerTotalsDTO();
    }

    /**
     * Create an instance of {@link GiftRewards }
     * 
     */
    public GiftRewards createGiftRewards() {
        return new GiftRewards();
    }

    /**
     * Create an instance of {@link ProductTriggers }
     * 
     */
    public ProductTriggers createProductTriggers() {
        return new ProductTriggers();
    }

    /**
     * Create an instance of {@link BasketRequest }
     * 
     */
    public BasketRequest createBasketRequest() {
        return new BasketRequest();
    }

    /**
     * Create an instance of {@link CardData }
     * 
     */
    public CardData createCardData() {
        return new CardData();
    }

    /**
     * Create an instance of {@link BrandDTO }
     * 
     */
    public BrandDTO createBrandDTO() {
        return new BrandDTO();
    }

    /**
     * Create an instance of {@link SvBaseLoyaltyResponse }
     * 
     */
    public SvBaseLoyaltyResponse createSvBaseLoyaltyResponse() {
        return new SvBaseLoyaltyResponse();
    }

    /**
     * Create an instance of {@link TicketMessages }
     * 
     */
    public TicketMessages createTicketMessages() {
        return new TicketMessages();
    }

    /**
     * Create an instance of {@link TrxErrors }
     * 
     */
    public TrxErrors createTrxErrors() {
        return new TrxErrors();
    }

    /**
     * Create an instance of {@link PersonalRewardsResponse }
     * 
     */
    public PersonalRewardsResponse createPersonalRewardsResponse() {
        return new PersonalRewardsResponse();
    }

    /**
     * Create an instance of {@link PaymentMethod }
     * 
     */
    public PaymentMethod createPaymentMethod() {
        return new PaymentMethod();
    }

    /**
     * Create an instance of {@link ResponseMessage }
     * 
     */
    public ResponseMessage createResponseMessage() {
        return new ResponseMessage();
    }

    /**
     * Create an instance of {@link Rewards }
     * 
     */
    public Rewards createRewards() {
        return new Rewards();
    }

    /**
     * Create an instance of {@link VoidedRewards }
     * 
     */
    public VoidedRewards createVoidedRewards() {
        return new VoidedRewards();
    }

    /**
     * Create an instance of {@link CardInfoDTO }
     * 
     */
    public CardInfoDTO createCardInfoDTO() {
        return new CardInfoDTO();
    }

    /**
     * Create an instance of {@link CardLookupResponse }
     * 
     */
    public CardLookupResponse createCardLookupResponse() {
        return new CardLookupResponse();
    }

    /**
     * Create an instance of {@link RewardLimitation }
     * 
     */
    public RewardLimitation createRewardLimitation() {
        return new RewardLimitation();
    }

    /**
     * Create an instance of {@link TicketMessage }
     * 
     */
    public TicketMessage createTicketMessage() {
        return new TicketMessage();
    }

    /**
     * Create an instance of {@link RewardsField }
     * 
     */
    public RewardsField createRewardsField() {
        return new RewardsField();
    }

    /**
     * Create an instance of {@link CardDetails }
     * 
     */
    public CardDetails createCardDetails() {
        return new CardDetails();
    }

    /**
     * Create an instance of {@link SvBaseLoyaltyRequest }
     * 
     */
    public SvBaseLoyaltyRequest createSvBaseLoyaltyRequest() {
        return new SvBaseLoyaltyRequest();
    }

    /**
     * Create an instance of {@link TransactionLimitation }
     * 
     */
    public TransactionLimitation createTransactionLimitation() {
        return new TransactionLimitation();
    }

    /**
     * Create an instance of {@link CustomerDetails }
     * 
     */
    public CustomerDetails createCustomerDetails() {
        return new CustomerDetails();
    }

    /**
     * Create an instance of {@link TransactionLimitations }
     * 
     */
    public TransactionLimitations createTransactionLimitations() {
        return new TransactionLimitations();
    }

    /**
     * Create an instance of {@link TillInteractions }
     * 
     */
    public TillInteractions createTillInteractions() {
        return new TillInteractions();
    }

    /**
     * Create an instance of {@link VouchersDto }
     * 
     */
    public VouchersDto createVouchersDto() {
        return new VouchersDto();
    }

    /**
     * Create an instance of {@link ProductPromotion }
     * 
     */
    public ProductPromotion createProductPromotion() {
        return new ProductPromotion();
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

    /**
     * Create an instance of {@link VoucherDto }
     * 
     */
    public VoucherDto createVoucherDto() {
        return new VoucherDto();
    }

    /**
     * Create an instance of {@link FalInfoResponse }
     * 
     */
    public FalInfoResponse createFalInfoResponse() {
        return new FalInfoResponse();
    }

    /**
     * Create an instance of {@link CardLookupRequest }
     * 
     */
    public CardLookupRequest createCardLookupRequest() {
        return new CardLookupRequest();
    }

    /**
     * Create an instance of {@link CouponMessages }
     * 
     */
    public CouponMessages createCouponMessages() {
        return new CouponMessages();
    }

    /**
     * Create an instance of {@link LineItem }
     * 
     */
    public LineItem createLineItem() {
        return new LineItem();
    }

    /**
     * Create an instance of {@link CustomerMessagesDTO }
     * 
     */
    public CustomerMessagesDTO createCustomerMessagesDTO() {
        return new CustomerMessagesDTO();
    }

    /**
     * Create an instance of {@link RewardMessage }
     * 
     */
    public RewardMessage createRewardMessage() {
        return new RewardMessage();
    }

    /**
     * Create an instance of {@link FalBaseResponse.Messages }
     * 
     */
    public FalBaseResponse.Messages createFalBaseResponseMessages() {
        return new FalBaseResponse.Messages();
    }

    /**
     * Create an instance of {@link RewardsResponse.NearMissMessages }
     * 
     */
    public RewardsResponse.NearMissMessages createRewardsResponseNearMissMessages() {
        return new RewardsResponse.NearMissMessages();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBrandResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "deleteBrandResponse")
    public JAXBElement<DeleteBrandResponse> createDeleteBrandResponse(DeleteBrandResponse value) {
        return new JAXBElement<DeleteBrandResponse>(_DeleteBrandResponse_QNAME, DeleteBrandResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFamilyByParent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "deleteFamilyByParent")
    public JAXBElement<DeleteFamilyByParent> createDeleteFamilyByParent(DeleteFamilyByParent value) {
        return new JAXBElement<DeleteFamilyByParent>(_DeleteFamilyByParent_QNAME, DeleteFamilyByParent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFamilyByParentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "deleteFamilyByParentResponse")
    public JAXBElement<DeleteFamilyByParentResponse> createDeleteFamilyByParentResponse(DeleteFamilyByParentResponse value) {
        return new JAXBElement<DeleteFamilyByParentResponse>(_DeleteFamilyByParentResponse_QNAME, DeleteFamilyByParentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LookupCards }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "lookupCards")
    public JAXBElement<LookupCards> createLookupCards(LookupCards value) {
        return new JAXBElement<LookupCards>(_LookupCards_QNAME, LookupCards.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFamilyByLevel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "deleteFamilyByLevel")
    public JAXBElement<DeleteFamilyByLevel> createDeleteFamilyByLevel(DeleteFamilyByLevel value) {
        return new JAXBElement<DeleteFamilyByLevel>(_DeleteFamilyByLevel_QNAME, DeleteFamilyByLevel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCurrencyRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "deleteCurrencyRate")
    public JAXBElement<DeleteCurrencyRate> createDeleteCurrencyRate(DeleteCurrencyRate value) {
        return new JAXBElement<DeleteCurrencyRate>(_DeleteCurrencyRate_QNAME, DeleteCurrencyRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "deleteProduct")
    public JAXBElement<DeleteProduct> createDeleteProduct(DeleteProduct value) {
        return new JAXBElement<DeleteProduct>(_DeleteProduct_QNAME, DeleteProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCurrencyRateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "deleteCurrencyRateResponse")
    public JAXBElement<DeleteCurrencyRateResponse> createDeleteCurrencyRateResponse(DeleteCurrencyRateResponse value) {
        return new JAXBElement<DeleteCurrencyRateResponse>(_DeleteCurrencyRateResponse_QNAME, DeleteCurrencyRateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCoupon }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "validateCoupon")
    public JAXBElement<ValidateCoupon> createValidateCoupon(ValidateCoupon value) {
        return new JAXBElement<ValidateCoupon>(_ValidateCoupon_QNAME, ValidateCoupon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SVMessagesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "SVMessagesRequest")
    public JAXBElement<SVMessagesRequest> createSVMessagesRequest(SVMessagesRequest value) {
        return new JAXBElement<SVMessagesRequest>(_SVMessagesRequest_QNAME, SVMessagesRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTenderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "deleteTenderResponse")
    public JAXBElement<DeleteTenderResponse> createDeleteTenderResponse(DeleteTenderResponse value) {
        return new JAXBElement<DeleteTenderResponse>(_DeleteTenderResponse_QNAME, DeleteTenderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveTender }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "saveTender")
    public JAXBElement<SaveTender> createSaveTender(SaveTender value) {
        return new JAXBElement<SaveTender>(_SaveTender_QNAME, SaveTender.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVersionInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "getVersionInfo")
    public JAXBElement<GetVersionInfo> createGetVersionInfo(GetVersionInfo value) {
        return new JAXBElement<GetVersionInfo>(_GetVersionInfo_QNAME, GetVersionInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteBrand }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "deleteBrand")
    public JAXBElement<DeleteBrand> createDeleteBrand(DeleteBrand value) {
        return new JAXBElement<DeleteBrand>(_DeleteBrand_QNAME, DeleteBrand.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SuggestProductPromotions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "suggestProductPromotions")
    public JAXBElement<SuggestProductPromotions> createSuggestProductPromotions(SuggestProductPromotions value) {
        return new JAXBElement<SuggestProductPromotions>(_SuggestProductPromotions_QNAME, SuggestProductPromotions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveTenderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "saveTenderResponse")
    public JAXBElement<SaveTenderResponse> createSaveTenderResponse(SaveTenderResponse value) {
        return new JAXBElement<SaveTenderResponse>(_SaveTenderResponse_QNAME, SaveTenderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveFamily }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "saveFamily")
    public JAXBElement<SaveFamily> createSaveFamily(SaveFamily value) {
        return new JAXBElement<SaveFamily>(_SaveFamily_QNAME, SaveFamily.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "saveProduct")
    public JAXBElement<SaveProduct> createSaveProduct(SaveProduct value) {
        return new JAXBElement<SaveProduct>(_SaveProduct_QNAME, SaveProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTender }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "deleteTender")
    public JAXBElement<DeleteTender> createDeleteTender(DeleteTender value) {
        return new JAXBElement<DeleteTender>(_DeleteTender_QNAME, DeleteTender.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateCouponResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "validateCouponResponse")
    public JAXBElement<ValidateCouponResponse> createValidateCouponResponse(ValidateCouponResponse value) {
        return new JAXBElement<ValidateCouponResponse>(_ValidateCouponResponse_QNAME, ValidateCouponResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SVMessagesRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "SVMessagesRequestResponse")
    public JAXBElement<SVMessagesRequestResponse> createSVMessagesRequestResponse(SVMessagesRequestResponse value) {
        return new JAXBElement<SVMessagesRequestResponse>(_SVMessagesRequestResponse_QNAME, SVMessagesRequestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "getCardInfo")
    public JAXBElement<GetCardInfo> createGetCardInfo(GetCardInfo value) {
        return new JAXBElement<GetCardInfo>(_GetCardInfo_QNAME, GetCardInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVersionInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "getVersionInfoResponse")
    public JAXBElement<GetVersionInfoResponse> createGetVersionInfoResponse(GetVersionInfoResponse value) {
        return new JAXBElement<GetVersionInfoResponse>(_GetVersionInfoResponse_QNAME, GetVersionInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveProductPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "saveProductPriceResponse")
    public JAXBElement<SaveProductPriceResponse> createSaveProductPriceResponse(SaveProductPriceResponse value) {
        return new JAXBElement<SaveProductPriceResponse>(_SaveProductPriceResponse_QNAME, SaveProductPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonalRewardsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "getPersonalRewardsResponse")
    public JAXBElement<GetPersonalRewardsResponse> createGetPersonalRewardsResponse(GetPersonalRewardsResponse value) {
        return new JAXBElement<GetPersonalRewardsResponse>(_GetPersonalRewardsResponse_QNAME, GetPersonalRewardsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonalRewards }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "getPersonalRewards")
    public JAXBElement<GetPersonalRewards> createGetPersonalRewards(GetPersonalRewards value) {
        return new JAXBElement<GetPersonalRewards>(_GetPersonalRewards_QNAME, GetPersonalRewards.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveProductPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "saveProductPrice")
    public JAXBElement<SaveProductPrice> createSaveProductPrice(SaveProductPrice value) {
        return new JAXBElement<SaveProductPrice>(_SaveProductPrice_QNAME, SaveProductPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCurrencyRateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "saveCurrencyRateResponse")
    public JAXBElement<SaveCurrencyRateResponse> createSaveCurrencyRateResponse(SaveCurrencyRateResponse value) {
        return new JAXBElement<SaveCurrencyRateResponse>(_SaveCurrencyRateResponse_QNAME, SaveCurrencyRateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "getCardInfoResponse")
    public JAXBElement<GetCardInfoResponse> createGetCardInfoResponse(GetCardInfoResponse value) {
        return new JAXBElement<GetCardInfoResponse>(_GetCardInfoResponse_QNAME, GetCardInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveFamilyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "saveFamilyResponse")
    public JAXBElement<SaveFamilyResponse> createSaveFamilyResponse(SaveFamilyResponse value) {
        return new JAXBElement<SaveFamilyResponse>(_SaveFamilyResponse_QNAME, SaveFamilyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "deleteProductResponse")
    public JAXBElement<DeleteProductResponse> createDeleteProductResponse(DeleteProductResponse value) {
        return new JAXBElement<DeleteProductResponse>(_DeleteProductResponse_QNAME, DeleteProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestRewardsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "requestRewardsResponse")
    public JAXBElement<RequestRewardsResponse> createRequestRewardsResponse(RequestRewardsResponse value) {
        return new JAXBElement<RequestRewardsResponse>(_RequestRewardsResponse_QNAME, RequestRewardsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveBrandResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "saveBrandResponse")
    public JAXBElement<SaveBrandResponse> createSaveBrandResponse(SaveBrandResponse value) {
        return new JAXBElement<SaveBrandResponse>(_SaveBrandResponse_QNAME, SaveBrandResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LookupCardsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "lookupCardsResponse")
    public JAXBElement<LookupCardsResponse> createLookupCardsResponse(LookupCardsResponse value) {
        return new JAXBElement<LookupCardsResponse>(_LookupCardsResponse_QNAME, LookupCardsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveBrand }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "saveBrand")
    public JAXBElement<SaveBrand> createSaveBrand(SaveBrand value) {
        return new JAXBElement<SaveBrand>(_SaveBrand_QNAME, SaveBrand.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestRewards }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "requestRewards")
    public JAXBElement<RequestRewards> createRequestRewards(RequestRewards value) {
        return new JAXBElement<RequestRewards>(_RequestRewards_QNAME, RequestRewards.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "saveProductResponse")
    public JAXBElement<SaveProductResponse> createSaveProductResponse(SaveProductResponse value) {
        return new JAXBElement<SaveProductResponse>(_SaveProductResponse_QNAME, SaveProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveCurrencyRate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "saveCurrencyRate")
    public JAXBElement<SaveCurrencyRate> createSaveCurrencyRate(SaveCurrencyRate value) {
        return new JAXBElement<SaveCurrencyRate>(_SaveCurrencyRate_QNAME, SaveCurrencyRate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFamilyByLevelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "deleteFamilyByLevelResponse")
    public JAXBElement<DeleteFamilyByLevelResponse> createDeleteFamilyByLevelResponse(DeleteFamilyByLevelResponse value) {
        return new JAXBElement<DeleteFamilyByLevelResponse>(_DeleteFamilyByLevelResponse_QNAME, DeleteFamilyByLevelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SuggestProductPromotionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.ws.fal.com/", name = "suggestProductPromotionsResponse")
    public JAXBElement<SuggestProductPromotionsResponse> createSuggestProductPromotionsResponse(SuggestProductPromotionsResponse value) {
        return new JAXBElement<SuggestProductPromotionsResponse>(_SuggestProductPromotionsResponse_QNAME, SuggestProductPromotionsResponse.class, null, value);
    }

}
