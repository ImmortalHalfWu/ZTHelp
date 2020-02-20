package immortal.half.wu.beans.params.builds;

import immortal.half.wu.beans.params.ParamsProductListBean;
import org.jetbrains.annotations.NotNull;

public class ParamsProductListBeanBuilder {
    private String pageSize = "";
    private String sort = "";
    private String cids = "";
    private String subcid = "";
    private String juHuaSuan = "";
    private String taoQiangGou = "";
    private String tmall = "";
    private String tchaoshi = "";
    private String goldSeller = "";
    private String haitao = "";
    private String pre = "";
    private String brand = "";
    private String brandIds = "";
    private String priceLowerLimit = "";
    private String priceUpperLimit = "";
    private String couponPriceLowerLimit = "";
    private String commissionRateLowerLimit = "";
    private String monthSalesLowerLimit = "";

    @NotNull
    ParamsProductListBeanBuilder setPageSize(String pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setSort(String sort) {
        this.sort = sort;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setCids(String cids) {
        this.cids = cids;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setSubcid(String subcid) {
        this.subcid = subcid;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setJuHuaSuan(String juHuaSuan) {
        this.juHuaSuan = juHuaSuan;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setTaoQiangGou(String taoQiangGou) {
        this.taoQiangGou = taoQiangGou;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setTmall(String tmall) {
        this.tmall = tmall;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setTchaoshi(String tchaoshi) {
        this.tchaoshi = tchaoshi;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setGoldSeller(String goldSeller) {
        this.goldSeller = goldSeller;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setHaitao(String haitao) {
        this.haitao = haitao;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setPre(String pre) {
        this.pre = pre;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setBrandIds(String brandIds) {
        this.brandIds = brandIds;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setPriceLowerLimit(String priceLowerLimit) {
        this.priceLowerLimit = priceLowerLimit;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setPriceUpperLimit(String priceUpperLimit) {
        this.priceUpperLimit = priceUpperLimit;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setCouponPriceLowerLimit(String couponPriceLowerLimit) {
        this.couponPriceLowerLimit = couponPriceLowerLimit;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setCommissionRateLowerLimit(String commissionRateLowerLimit) {
        this.commissionRateLowerLimit = commissionRateLowerLimit;
        return this;
    }

    @NotNull
    public ParamsProductListBeanBuilder setMonthSalesLowerLimit(String monthSalesLowerLimit) {
        this.monthSalesLowerLimit = monthSalesLowerLimit;
        return this;
    }

    @NotNull
    public ParamsProductListBean createParamsProductListBean(String pageId) {
        return new ParamsProductListBean(pageSize, pageId, sort, cids, subcid, juHuaSuan, taoQiangGou, tmall, tchaoshi, goldSeller, haitao, pre, brand, brandIds, priceLowerLimit, priceUpperLimit, couponPriceLowerLimit, commissionRateLowerLimit, monthSalesLowerLimit);
    }
}