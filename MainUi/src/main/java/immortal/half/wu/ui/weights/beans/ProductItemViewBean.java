package immortal.half.wu.ui.weights.beans;

import immortal.half.wu.ui.models.beans.IdleFishUserConfigBean;

public class ProductItemViewBean extends BaseViewBean {

    public static ProductItemViewBean create(
            String productUrl, String imageUrl, String productName, String time, String stateString, String stateColor, String oldPrice, String nowPrice, String profitPrice
    ) {
        return new ProductItemViewBean(
            "", productUrl, imageUrl, productName, time, stateString, stateColor, oldPrice, nowPrice, profitPrice
        );
    }


    public static ProductItemViewBean createSendSuc(
            String productUrl,
            String imageUrl,
            String productName,
            String time,
            String oldPrice,
            String nowPrice,
            String profitPrice
    ) {
        return new ProductItemViewBean(
                "", productUrl, imageUrl, productName, time, STATE_SUC, STATE_COLOR_SUC, oldPrice, nowPrice, profitPrice
        );
    }

    public static ProductItemViewBean createSendFail(
            String productUrl,
            String imageUrl,
            String productName,
            String time,
            String oldPrice,
            String nowPrice,
            String profitPrice
    ) {
        return new ProductItemViewBean(
                "", productUrl, imageUrl, productName, time, STATE_COLOR_FAIL, STATE_FAIL, oldPrice, nowPrice, profitPrice
        );
    }

    public static ProductItemViewBean create(
            Object tag, IdleFishUserConfigBean.IdleFishProductBean bean
    ) {
        return new ProductItemViewBean(
                tag, bean
        );
    }

    public static ProductItemViewBean createSendSuc(
            Object tag, IdleFishUserConfigBean.IdleFishProductBean bean
    ) {
        return new ProductItemViewBean(
                tag, STATE_COLOR_SUC, bean
        );
    }

    public static ProductItemViewBean createSendFail(
            Object tag, IdleFishUserConfigBean.IdleFishProductBean bean
    ) {
        return new ProductItemViewBean(
                tag, STATE_COLOR_FAIL, bean
        );
    }

    private static final String STATE_COLOR_SUC = "#26A426";
    private static final String STATE_COLOR_FAIL = "FC4426";

    private final static String STATE_SUC = "发布成功";
    private final static String STATE_FAIL = "发布失败";

    private final IdleFishUserConfigBean.IdleFishProductBean idleFishModelBean;
    private final String stateColor;


    private ProductItemViewBean(Object tag, String productUrl, String imageUrl, String productName, String time, String stateString, String stateColor, String oldPrice, String nowPrice, String profitPrice) {
        this(tag, stateColor, new IdleFishUserConfigBean.IdleFishProductBean(
                productUrl, imageUrl, productName,
                time, stateString,
                oldPrice, nowPrice, profitPrice
        ));
    }

    private ProductItemViewBean(
            Object tag,
            String stateColor,
            IdleFishUserConfigBean.IdleFishProductBean bean) {
        super(tag);
        idleFishModelBean = bean;
        this.stateColor = stateColor;
    }

    private ProductItemViewBean(
            Object tag,
            IdleFishUserConfigBean.IdleFishProductBean bean) {
        super(tag);
        idleFishModelBean = bean;
        this.stateColor = bean.getStateString().equals(STATE_SUC) ? STATE_COLOR_SUC : STATE_COLOR_FAIL;
    }

    public String getImageUrl() {
        return idleFishModelBean.getImageUrl();
    }

    public String getStateString() {
        return idleFishModelBean.getStateString();
    }

    public String getStateColor() {
        return stateColor;
    }

    public String getOldPrice() {
        return idleFishModelBean.getOldPrice();
    }

    public String getNowPrice() {
        return idleFishModelBean.getNowPrice();
    }

    public String getProfitPrice() {
        return idleFishModelBean.getProfitPrice();
    }

    public String getProductName() {
        return idleFishModelBean.getProductName();
    }

    public String getTime() {
        return idleFishModelBean.getTime();
    }

    public String getProductUrl() {
        return idleFishModelBean.getProductUrl();
    }
}
