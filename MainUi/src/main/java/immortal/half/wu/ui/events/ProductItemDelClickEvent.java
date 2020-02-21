package immortal.half.wu.ui.events;

import immortal.half.wu.ui.weights.beans.ProductItemViewBean;

public class ProductItemDelClickEvent {

    private final ProductItemViewBean productItemViewBean;

    public ProductItemDelClickEvent(ProductItemViewBean productItemViewBean) {
        this.productItemViewBean = productItemViewBean;
    }

    public ProductItemViewBean getProductItemViewBean() {
        return productItemViewBean;
    }
}
