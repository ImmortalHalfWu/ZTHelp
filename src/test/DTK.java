package test;

import immortal.half.wu.DTKManager;
import immortal.half.wu.JsonUtil;
import immortal.half.wu.beans.params.builds.ParamsProductInfoBeanBuilder;
import immortal.half.wu.beans.results.JsonProductInfoBean;
import immortal.half.wu.http.SimpleCallBack;
import okhttp3.Call;

import java.io.IOException;

public class DTK {

    public static void test() {
        DTKManager.init(Util.Key, Util.Value);

//        DTKManager.getProductList(new SimpleCallBack<JsonProductListBean>() {
//            @Override
//            public void onFail(okhttp3.Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(okhttp3.Call call, JsonProductListBean resultBean, String resultString) throws IOException {
//                System.out.println(resultString);
//                System.out.println(JsonUtil.toJson(resultBean));
//
//            }
//        }, new ParamsProductListBeanBuilder().createParamsProductListBean("1"));
//
//
        DTKManager.getProductInfo(new SimpleCallBack<JsonProductInfoBean>() {
            @Override
            public void onResponse(Call call, JsonProductInfoBean resultBean, String resultString) throws IOException {
                System.out.println(resultString);
                System.out.println(JsonUtil.toJson(resultBean));
            }

            @Override
            public void onFail(Call call, IOException e) {

            }
        }, new ParamsProductInfoBeanBuilder().setId("23621527").createParamsProductInfoBean());


//        DTKManager.getProductCategorys(new SimpleCallBack<JsonProductCategoryBean>() {
//            @Override
//            public void onResponse(Call call, JsonProductCategoryBean resultBean, String resultString) throws IOException {
//                System.out.println(resultString);
//                System.out.println(JsonUtil.toJson(resultBean));
//            }
//
//            @Override
//            public void onFail(Call call, IOException e) {
//
//            }
//        }, new ParamsProductCategoryBeanBuilder().createParamsProductCategoryBean());


//        DTKManager.getProductForSave(new SimpleCallBack<JsonProductSaveBean>() {
//            @Override
//            public void onResponse(Call call, JsonProductSaveBean resultBean, String resultString) throws IOException {
//                System.out.println(resultString);
//                System.out.println(JsonUtil.toJson(resultBean));
//            }
//
//            @Override
//            public void onFail(Call call, IOException e) {
//
//            }
//        }, new ParamsProductSaveBeanBuilder().createParamsProductSaveBean("1"));
//
//
//        DTKManager.test(new SimpleCallBack<Object>() {
//            @Override
//            public void onResponse(Call call, Object resultBean, String resultString) throws IOException {
//                System.out.println(resultString);
//            }
//
//            @Override
//            public void onFail(Call call, IOException e) {
//
//            }
//        }, new ParamsProductRefreshBeanBuilder().createParamsProductRefreshBean(10, 1));
//
//
//        DTKManager.getProductRefresh(new SimpleCallBack<JsonProductRefreshBean>() {
//            @Override
//            public void onResponse(Call call, JsonProductRefreshBean resultBean, String resultString) throws IOException {
//                System.out.println(resultString);
//                System.out.println(JsonUtil.toJson(resultBean));
//            }
//
//            @Override
//            public void onFail(Call call, IOException e) {
//
//            }
//        }, new ParamsProductRefreshBeanBuilder().createParamsProductRefreshBean(10, 1));


//        DTKManager.getProductFor9(new SimpleCallBack<JsonProduct9Bean>() {
//            @Override
//            public void onResponse(Call call, JsonProduct9Bean resultBean, String resultString) throws IOException {
//                System.out.println(resultString);
//                System.out.println(JsonUtil.toJson(resultBean));
//            }
//
//            @Override
//            public void onFail(Call call, IOException e) {
//
//            }
//        }, new ParamsProduct9BeanBuilder().createParamsProduct9Bean("100", "2", "2"));


//        DTKManager.getProductForSearch(new SimpleCallBack<JsonProductSearchBean>() {
//            @Override
//            public void onResponse(Call call, JsonProductSearchBean resultBean, String resultString) throws IOException {
//                System.out.println(resultString);
//                System.out.println(JsonUtil.toJson(resultBean));
//            }
//
//            @Override
//            public void onFail(Call call, IOException e) {
//
//            }
//        }, new ParamsProductSearchBeanBuilder().createParamsProductSearchBean(0, 1, 20, "袜子"));


//        DTKManager.getUrlConvert(new SimpleCallBack<JsonUrlConvertBean>() {
//            @Override
//            public void onResponse(Call call, JsonUrlConvertBean resultBean, String resultString) throws IOException {
//                System.out.println(resultString);
//                System.out.println(JsonUtil.toJson(resultBean));
//            }
//
//            @Override
//            public void onFail(Call call, IOException e) {
//
//            }
//        }, new ParamsUrlConveterBeanBuilder().createParamsUrlConveterBean("577326998857"));


//        DTKManager.getProductForUserKey(new SimpleCallBack<JsonProductUserSaveBean>() {
//            @Override
//            public void onResponse(Call call, JsonProductUserSaveBean resultBean, String resultString) throws IOException {
//                System.out.println(resultString);
//                System.out.println(JsonUtil.toJson(resultBean));
//            }
//
//            @Override
//            public void onFail(Call call, IOException e) {
//
//            }
//        }, Util.UserKey, "1");
    }

}
