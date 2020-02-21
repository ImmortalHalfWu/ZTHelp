package immortal.half.wu.ui.events;

import immortal.half.wu.ui.weights.beans.DeviceItemViewBean;
import immortal.half.wu.ui.weights.beans.ProductItemViewBean;

public class ProductItemClickEvent {

    private final ProductItemViewBean productItemViewBean;

    public ProductItemClickEvent(ProductItemViewBean productItemViewBean) {
        this.productItemViewBean = productItemViewBean;
    }

    public ProductItemViewBean getProductItemViewBean() {
        return productItemViewBean;
    }
}
