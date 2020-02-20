package immortal.half.wu.ui.models.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class IdleFishUserConfigBean {

    private final List<IdleFishUserInfoBean> idleFishUserInfoBeans;

    public IdleFishUserConfigBean(List<IdleFishUserInfoBean> idleFishUserInfoBeans) {
        this.idleFishUserInfoBeans = idleFishUserInfoBeans;
    }

    public List<IdleFishUserInfoBean> getIdleFishUserInfoBeans() {
        return idleFishUserInfoBeans;
    }




    public static class IdleFishUserInfoBean {

        private final String userName;
        private final List<IdleFishProductBean> idleFishProductModelBeans;

        public IdleFishUserInfoBean(String userName, List<IdleFishProductBean> idleFishProductModelBeans) {
            this.userName = userName;
            this.idleFishProductModelBeans = idleFishProductModelBeans;
        }

        public String getUserName() {
            return userName;
        }

        public List<IdleFishProductBean> getIdleFishProductModelBeans() {
            return idleFishProductModelBeans;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof IdleFishUserInfoBean)) return false;
            IdleFishUserInfoBean that = (IdleFishUserInfoBean) o;
            return userName.equals(that.userName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userName);
        }
    }






    public static class IdleFishProductBean {

        private final String productUrl;
        private final String imageUrl;
        private final String productName;
        private final String time;
        private final String stateString;
        private final String oldPrice;
        private final String nowPrice;
        private final String profitPrice;

        public IdleFishProductBean(String productUrl, String imageUrl, String productName, String time, String stateString, String oldPrice, String nowPrice, String profitPrice) {
            this.productUrl = productUrl;
            this.imageUrl = imageUrl;
            this.productName = productName;
            this.time = time;
            this.stateString = stateString;
            this.oldPrice = oldPrice;
            this.nowPrice = nowPrice;
            this.profitPrice = profitPrice;
        }

        public String getProductUrl() {
            return productUrl;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public String getProductName() {
            return productName;
        }

        public String getTime() {
            return time;
        }

        public String getStateString() {
            return stateString;
        }

        public String getOldPrice() {
            return oldPrice;
        }

        public String getNowPrice() {
            return nowPrice;
        }

        public String getProfitPrice() {
            return profitPrice;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof IdleFishProductBean)) return false;
            IdleFishProductBean that = (IdleFishProductBean) o;
            return productUrl.equals(that.productUrl) &&
                    oldPrice.equals(that.oldPrice) &&
                    nowPrice.equals(that.nowPrice) &&
                    profitPrice.equals(that.profitPrice);
        }

        @Override
        public int hashCode() {
            return Objects.hash(productUrl, oldPrice, nowPrice, profitPrice);
        }
    }

}
