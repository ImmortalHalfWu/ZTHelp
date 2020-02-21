package immortal.half.wu.ui.events;

import immortal.half.wu.ui.weights.beans.ProductItemViewBean;

public class ProductItemEditClickEvent {

    private final ProductItemViewBean productItemViewBean;

    public ProductItemEditClickEvent(ProductItemViewBean productItemViewBean) {
        this.productItemViewBean = productItemViewBean;
    }

    public ProductItemViewBean getProductItemViewBean() {
        return productItemViewBean;
    }
}
