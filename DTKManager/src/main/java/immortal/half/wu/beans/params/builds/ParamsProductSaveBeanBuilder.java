package immortal.half.wu.beans.params.builds;

import immortal.half.wu.beans.params.ParamsProductSaveBean;
import org.jetbrains.annotations.NotNull;

public class ParamsProductSaveBeanBuilder {
    private String pageSize;
    private String cid;
    private String trailerType;
    private String sort;
    private String collectionTimeOrder;

    @NotNull
    public ParamsProductSaveBeanBuilder setPageSize(String pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @NotNull
    public ParamsProductSaveBeanBuilder setCid(String cid) {
        this.cid = cid;
        return this;
    }

    @NotNull
    public ParamsProductSaveBeanBuilder setTrailerType(String trailerType) {
        this.trailerType = trailerType;
        return this;
    }

    @NotNull
    public ParamsProductSaveBeanBuilder setSort(String sort) {
        this.sort = sort;
        return this;
    }

    @NotNull
    public ParamsProductSaveBeanBuilder setCollectionTimeOrder(String collectionTimeOrder) {
        this.collectionTimeOrder = collectionTimeOrder;
        return this;
    }

    @NotNull
    public ParamsProductSaveBean createParamsProductSaveBean(String pageId) {
        return new ParamsProductSaveBean(pageSize, pageId, cid, trailerType, sort, collectionTimeOrder);
    }
}