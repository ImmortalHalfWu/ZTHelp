package immortal.half.wu.beans.params.builds;

import immortal.half.wu.beans.params.ParamsProductSearchBean;
import org.jetbrains.annotations.NotNull;

public class ParamsProductSearchBeanBuilder {
    private String tmall;
    private String haitao;
    private String sort;

    @NotNull
    public ParamsProductSearchBeanBuilder setTmall(String tmall) {
        this.tmall = tmall;
        return this;
    }

    @NotNull
    public ParamsProductSearchBeanBuilder setHaitao(String haitao) {
        this.haitao = haitao;
        return this;
    }

    @NotNull
    public ParamsProductSearchBeanBuilder setSort(String sort) {
        this.sort = sort;
        return this;
    }

    @NotNull
    public ParamsProductSearchBean createParamsProductSearchBean(int type, int pageId, int pageSize, String keyWords) {
        return new ParamsProductSearchBean(type + "", pageId + "", pageSize + "", keyWords, tmall, haitao, sort);
    }

}