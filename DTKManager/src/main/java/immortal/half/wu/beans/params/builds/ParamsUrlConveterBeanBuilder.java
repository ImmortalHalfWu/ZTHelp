package immortal.half.wu.beans.params.builds;

import immortal.half.wu.beans.params.ParamsUrlConveterBean;
import org.jetbrains.annotations.NotNull;

public class ParamsUrlConveterBeanBuilder {
    private String couponId;
    private String pid;
    private String channelId;

    @NotNull
    public ParamsUrlConveterBeanBuilder setCouponId(String couponId) {
        this.couponId = couponId;
        return this;
    }

    @NotNull
    public ParamsUrlConveterBeanBuilder setPid(String pid) {
        this.pid = pid;
        return this;
    }

    @NotNull
    public ParamsUrlConveterBeanBuilder setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    @NotNull
    public ParamsUrlConveterBean createParamsUrlConveterBean(String goodsId) {
        return new ParamsUrlConveterBean(goodsId, couponId, pid, channelId);
    }
}