package immortal.half.wu.beans.params.builds;

import immortal.half.wu.beans.params.ParamsProductRefreshBean;
import org.jetbrains.annotations.NotNull;

public class ParamsProductRefreshBeanBuilder {
    private String startTime;
    private String endTime;
    private String cids;
    private String subcid;
    private String juHuaSuan;
    private String taoQiangGou;
    private String tmall;
    private String tchaoshi;
    private String goldSeller;
    private String haitao;
    private String brand;
    private String brandIds;
    private String priceLowerLimit;
    private String priceUpperLimit;
    private String couponPriceLowerLimit;
    private String commissionRateLowerLimit;
    private String monthSalesLowerLimit;
    private String sort;

    @NotNull
    public ParamsProductRefreshBeanBuilder setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setCids(String cids) {
        this.cids = cids;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setSubcid(String subcid) {
        this.subcid = subcid;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setJuHuaSuan(String juHuaSuan) {
        this.juHuaSuan = juHuaSuan;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setTaoQiangGou(String taoQiangGou) {
        this.taoQiangGou = taoQiangGou;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setTmall(String tmall) {
        this.tmall = tmall;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setTchaoshi(String tchaoshi) {
        this.tchaoshi = tchaoshi;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setGoldSeller(String goldSeller) {
        this.goldSeller = goldSeller;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setHaitao(String haitao) {
        this.haitao = haitao;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setBrandIds(String brandIds) {
        this.brandIds = brandIds;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setPriceLowerLimit(String priceLowerLimit) {
        this.priceLowerLimit = priceLowerLimit;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setPriceUpperLimit(String priceUpperLimit) {
        this.priceUpperLimit = priceUpperLimit;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setCouponPriceLowerLimit(String couponPriceLowerLimit) {
        this.couponPriceLowerLimit = couponPriceLowerLimit;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setCommissionRateLowerLimit(String commissionRateLowerLimit) {
        this.commissionRateLowerLimit = commissionRateLowerLimit;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setMonthSalesLowerLimit(String monthSalesLowerLimit) {
        this.monthSalesLowerLimit = monthSalesLowerLimit;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBeanBuilder setSort(String sort) {
        this.sort = sort;
        return this;
    }

    @NotNull
    public ParamsProductRefreshBean createParamsProductRefreshBean(int pageSize, int pageId) {
        return new ParamsProductRefreshBean(pageSize + "", pageId + "", startTime, endTime, cids, subcid, juHuaSuan, taoQiangGou, tmall, tchaoshi, goldSeller, haitao, brand, brandIds, priceLowerLimit, priceUpperLimit, couponPriceLowerLimit, commissionRateLowerLimit, monthSalesLowerLimit, sort);
    }
}