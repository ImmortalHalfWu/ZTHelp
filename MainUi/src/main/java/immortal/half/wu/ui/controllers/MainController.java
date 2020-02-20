package immortal.half.wu.ui.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.svg.SVGGlyph;
import com.jfoenix.svg.SVGGlyphLoader;
import immortal.half.wu.device.division.UIIdleFishProductBean;
import immortal.half.wu.device.division.interfaces.IUiAndroidDevice;
import immortal.half.wu.device.division.interfaces.IUiApp;
import immortal.half.wu.ui.models.MainModel;
import immortal.half.wu.ui.models.beans.IdleFishUserConfigBean;
import immortal.half.wu.ui.models.beans.UIDevAppProductBindBean;
import immortal.half.wu.ui.models.interfaces.MainModelListener;
import immortal.half.wu.ui.utils.BeanUtil;
import immortal.half.wu.ui.utils.ThreadUtil;
import immortal.half.wu.ui.weights.beans.ProductItemViewBean;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import immortal.half.wu.ui.adapters.BaseListViewAdapter;
import immortal.half.wu.ui.weights.DeviceListItemView;
import immortal.half.wu.ui.weights.ProductListItemView;
import immortal.half.wu.ui.weights.beans.DeviceItemViewBean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

@ViewController(value = "/fxml/MainFxml.fxml", title = "我的demo")
public final class MainController implements MainModelListener {

    private MainModel mainModel;

    @FXMLViewFlowContext
    private ViewFlowContext context;
    @FXML
    private JFXRippler optionsRippler;
    @FXML
    private StackPane optionsBurger;
    @FXML
    private ListView<DeviceListItemView> listView;
    @FXML
    private JFXButton sendProductBt;
    @FXML
    private JFXButton searchDeviceBt;
    @FXML
    private ListView<Node> productListView;
    @FXML
    private BorderPane borderPane;

    private ObservableList<DeviceListItemView> deviceViews = FXCollections.observableArrayList();
    private ObservableList<Node> productViews = FXCollections.observableArrayList();

    @PostConstruct
    public void init() throws Exception {

        setBtIco(sendProductBt, "icomoon.svg.paper-plane-o, send-o");
        setBtIco(searchDeviceBt, "icomoon.svg.search2");

        listView.getStyleClass().add("device-list");
        listView.setPrefWidth(185);
        listView.setCellFactory(new BaseListViewAdapter<>());
        listView.setItems(deviceViews);
//        deviceViews.add(new DeviceListItemView(DeviceItemViewBean.createConnectLoginBean("", "朴素不朴素", "")));
//        deviceViews.add(new DeviceListItemView(DeviceItemViewBean.createConnectUnLoginBean("", "")));
//        deviceViews.add(new DeviceListItemView(DeviceItemViewBean.createDisconnectLoginBean("", "朴素不朴素")));
//        listView.setItems(deviceViews);
//        long s = System.currentTimeMillis();
//        List<ProductItemViewBean> datas = new ArrayList<>();
//        for (int i = 0; i < 15; i++) {
//            if (datas.size() == 4 || (i == 14  && datas.size() > 0)) {
//                productViews.add(new ProductListItemView(datas));
//                datas.clear();
//            }
//            datas.add(ProductItemViewBean.create(
//                    "TestUrl",
//                "http://img14.360buyimg.com/imgzone/jfs/t1/91657/8/11629/198826/5e37e559E5ee5ce2a/cfb8d362d9d01210.jpg?imageMogr2/strip/format/jpg",
//                "商品：商品：商品：商品：商品：商品：商品：商品：商品：商品：商品：" + i,
//                "2020/02/13",
//                "发布成功",
//                "#26A426",
//                "" + i + 1000,
//                "" + i * 2  + 1000,
//                "" + i  + 1000
//            ));
//        }
//
//        ThreadUtil.runInMain(new Runnable() {
//            @Override
//            public void run() {
////                deviceViews.add(0, new DeviceListItemView(DeviceItemViewBean.createDisconnectLoginBean("", "朴素不朴素")));
//                deviceViews.replaceAll(new UnaryOperator<DeviceListItemView>() {
//                    @Override
//                    public DeviceListItemView apply(DeviceListItemView deviceListItemView) {
//                        if (BeanUtil.deviceItemIsConnectLogout(deviceListItemView)) {
//                            return new DeviceListItemView(
//                                    BeanUtil.deviceItemViewBeanConvertToConnectLogin(deviceListItemView, "new UserName")
//                            );
//                        }
//                        return deviceListItemView;
//                    }
//                });
//            }
//        }, 3000);
//
//        long e = System.currentTimeMillis();
//        System.out.println((e - s));

        productListView.setStyle("-fx-background-color: #eeeeee");
        productListView.setCellFactory(new BaseListViewAdapter<>());
        productListView.setItems(productViews);

    }

    private void setBtIco(JFXButton bt, String icoName) throws Exception {
        SVGGlyph icoMoonGlyph = SVGGlyphLoader.getIcoMoonGlyph(icoName);
        icoMoonGlyph.setFill(Color.WHITE);
        icoMoonGlyph.setSize(20, 20);
        bt.setGraphic(icoMoonGlyph);
    }

    @Override
    public void loadUserConfigOver(List<UIDevAppProductBindBean> devAppProductBindBeans) {
//        初始化设备列表， 全部未登录
        ObservableList<DeviceListItemView> deviceViewTemps = FXCollections.observableArrayList();
        ObservableList<Node> productViewsTemps  = FXCollections.observableArrayList();

        List<ProductItemViewBean> childViewBeanTemps = new ArrayList<>(4);
        List<ProductItemViewBean> sourceChildViewBeanTemps = new ArrayList<>();

        devAppProductBindBeans.forEach(bean -> {

            DeviceItemViewBean deviceItemViewBean = DeviceItemViewBean.createDisconnectLoginBean(bean, bean.getUserName().getName());
            deviceViewTemps.add(new DeviceListItemView(deviceItemViewBean));

            List<IdleFishUserConfigBean.IdleFishProductBean> productBeans = bean.getProducts();

            int size = productBeans.size();

            for (int i = 0, lineMaxCount = 0; i < size; i++, lineMaxCount++) {
                if (lineMaxCount == 4 || (i == size - 1  && lineMaxCount > 0)) {
                    productViewsTemps.add(new ProductListItemView(childViewBeanTemps));
                    childViewBeanTemps.clear();
                    lineMaxCount = 0;
                }
                IdleFishUserConfigBean.IdleFishProductBean idleFishProductBean = productBeans.get(i);
                ProductItemViewBean productItemViewBean = ProductItemViewBean.create(idleFishProductBean, idleFishProductBean);
                childViewBeanTemps.add(productItemViewBean);
                sourceChildViewBeanTemps.add(productItemViewBean);
            }

            childViewBeanTemps.clear();
            sourceChildViewBeanTemps.clear();
        });

        deviceViews.clear();
        deviceViews.addAll(deviceViewTemps);
        productViews.clear();
        productViews.addAll(productViewsTemps);
    }

    @Override
    public void deviceConnectLogout(List<UIDevAppProductBindBean> devAppProductBindBeans, UIDevAppProductBindBean bean) {
//        有设备连接， 未登录闲鱼用户
    }

    @Override
    public void deviceConnectLogin(List<UIDevAppProductBindBean> devAppProductBindBeans, UIDevAppProductBindBean bean) {
//        有设备连接， 并登录了闲鱼用户
    }

    @Override
    public void deviceDisconnectLogin(List<UIDevAppProductBindBean> devAppProductBindBeans, UIDevAppProductBindBean bean) {
//        从连接登录状态  转为  未连接状态
    }

    @Override
    public void deviceDisconnectLogout(List<UIDevAppProductBindBean> devAppProductBindBeans, UIDevAppProductBindBean bean) {
//        设备未登录状态下断开连接， 移除设备UI即可
    }

}
