package immortal.half.wu.beans.params.builds;

import immortal.half.wu.beans.params.ParamsProductInfoBean;
import org.jetbrains.annotations.NotNull;

public class ParamsProductInfoBeanBuilder {
    private String id;
    private String goodsId;

    @NotNull
    public ParamsProductInfoBeanBuilder setId(String id) {
        this.id = id;
        return this;
    }

    @NotNull
    public ParamsProductInfoBeanBuilder setGoodsId(String goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    @NotNull
    public ParamsProductInfoBean createParamsProductInfoBean() {
        return new ParamsProductInfoBean(id, goodsId);
    }
}