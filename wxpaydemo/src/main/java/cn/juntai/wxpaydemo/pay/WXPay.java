package cn.juntai.wxpaydemo.pay;

import cn.juntai.wxpaydemo.sdk.WXPayUtil;
import cn.juntai.wxpaydemo.util.DateUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class WXPay {

    private static Log log = LogFactory.getLog(WXPay.class);

    private static final String PAY_SUCCESS = "SUCCESS";
    private static final String PAY_USERPAYING = "USERPAYING";

    //二维码支付方法
    public void TwoCodePay(int price) throws Exception {

        unifiedOrder(price);
            //测试获取当前路径
    }

    //一维码支付方法
    public void OneCodePay(String auth_code,int price) throws Exception {
        scanCodeToPay(auth_code,price);
    }

    public static void main(String[] args) throws Exception {

        // 生成二维码，完成支付
        // unifiedOrder();
        // 商家扫用户手机的条形码
        //scanCodeToPay("133819286798799636",1);  一维码支付
         unifiedOrder(1);

    }

    /**
     * 扫码支付
     *
     * @throws Exception
     */
    public static String scanCodeToPay(String auth_code,int price) throws Exception {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String spbill_create_ip = addr.getHostAddress();

        MyConfig config = new MyConfig();
        cn.juntai.wxpaydemo.sdk.WXPay wxpay = new cn.juntai.wxpaydemo.sdk.WXPay(config);
        String out_trade_no = DateUtil.getCurrentTime();
        Map<String, String> map = new HashMap<>(16);
        map.put("attach", "订单额外描述");
        map.put("auth_code", auth_code);
        map.put("body", "购物");
        map.put("device_info", "天天华莱士");
        map.put("nonce_str", WXPayUtil.generateNonceStr());
        map.put("out_trade_no", out_trade_no);
        map.put("spbill_create_ip", spbill_create_ip);
        map.put("total_fee", String.valueOf(price));   //可通过依赖包的数据传入并生成
        //生成签名
        String sign = WXPayUtil.generateSignature(map, config.getKey());
        map.put("sign", sign);
        String mapToXml = null;
        try {
            //调用微信的扫码支付接口
            Map<String, String> resp = wxpay.microPay(map);
            System.out.println("扫码支付结果：" + resp);
            mapToXml = WXPayUtil.mapToXml(resp);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("微信支付失败" + e);
        }
        //判断支付是否成功
        /*String return_code = null;
        String result_code = null;
        String err_code_des = null;
        String err_code = null;
        //获取Document对象（主要是获取支付接口的返回信息）
        Document doc = DocumentHelper.parseText(mapToXml);
        //获取对象的根节点<xml>
        Element rootElement = doc.getRootElement();
        //获取对象的子节点
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            if (element.getName().equals("return_code")) {
                return_code = element.getTextTrim();
            } else if (element.getName().equals("result_code")) {
                result_code = element.getTextTrim();
            } else if (element.getName().equals("err_code_des")) {
                err_code_des = element.getTextTrim();
            } else if (element.getName().equals("err_code")) {
                err_code = element.getTextTrim();
            }
        }*/
        /*if (PAY_SUCCESS.equals(return_code) && PAY_SUCCESS.equals(result_code)) {
            log.info("微信免密支付成功！");
            return PAY_SUCCESS;
        } else if (PAY_USERPAYING.equals(err_code)) {
            for (int i = 0; i < 4; i++) {
                Thread.sleep(3000);
                Map<String, String> data = new HashMap<>(16);
                data.put("out_trade_no", out_trade_no);
                //调用微信的查询接口
                Map<String, String> orderQuery = wxpay.orderQuery(data);
                String orderResp = WXPayUtil.mapToXml(orderQuery);
                String trade_state = null;
                //获取Document对象
                Document orderDoc = DocumentHelper.parseText(orderResp);
                //获取对象的根节点<xml>
                Element rootElement1 = orderDoc.getRootElement();
                //获取对象的子节点
                List<Element> elements1 = rootElement1.elements();
                for (Element element : elements1) {
                    if (element.getName().equals("trade_state")) {
                        trade_state = element.getTextTrim();
                    }
                }
                if (PAY_SUCCESS.equals(trade_state)) {
                    log.info("微信加密支付成功！");
                    return PAY_SUCCESS;
                }
                log.info("正在支付" + orderResp);
            }
        }
        log.error("微信支付失败！");*/
        return "";
    }

    /*
    下单：生成二维码
     */
    public static void unifiedOrder(int price) {
        Map<String, String> resultMap = new HashMap();
        String openid = "ouR0E1oP5UGTEBce8jZ_sChfH26g";
        MyConfig config = null;
        cn.juntai.wxpaydemo.sdk.WXPay wxpay = null;
        try {
            config = new MyConfig();
            wxpay = new cn.juntai.wxpaydemo.sdk.WXPay(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //生成的随机字符串
        String nonce_str = WXPayUtil.generateNonceStr();
        //获取客户端的ip地址
        //获取本机的ip地址
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String spbill_create_ip = addr.getHostAddress();
        //支付金额，需要转成字符串类型，否则后面的签名会失败
        int total_fee = price;//100分：1块钱
        //商品描述
        String body = "天天华莱士";
        //商户订单号
        String out_trade_no = WXPayUtil.generateNonceStr();
        //统一下单接口参数
        SortedMap<String, String> data = new TreeMap<String, String>();
        data.put("appid", "wxd9a46e74fc279fcc");
        data.put("body", body);
        data.put("mch_id", "1623889015");
        // 回调接口，必须是一个域名，不能使用IP
        // 腾讯会自动调用你（程序自己提供的接口）的接口，给你发送支付结果的数据，数据格式：xml格式
        data.put("notify_url", "http://4i802776s9.zicp.vip/result");
        data.put("out_trade_no", out_trade_no);//交易号
        data.put("spbill_create_ip", spbill_create_ip);//下单的电脑IP地址
        data.put("trade_type", "NATIVE");//支付类型
        data.put("total_fee", String.valueOf(total_fee));
        //data.put("openid", openid);
        data.put("attach","id,11111;price,18.00;amount,1;");//可以不用管的，后面wxappdemo利用数据库处理

        try {
            Map<String, String> rMap = wxpay.unifiedOrder(data);
            System.out.println("统一下单接口返回: " + rMap);
            createQRCode(rMap);//生成二维码
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createQRCode(Map<String, String> map) throws Exception {

        File directory = new File("");//设定为当前文件夹
        System.out.println(directory.getAbsolutePath());//获取绝对路径;
        File outputFile = new File(directory.getAbsolutePath()+ File.separator + "pay.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        String url = map.get("code_url");
        System.out.println("生成二维码url:" + url);
        try {
            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 300, 300, hints);

            MatrixToImageWriter.writeToStream(bitMatrix, "jpg", fileOutputStream);
        } catch (Exception e) {
            throw new Exception("生成二维码失败！");
        } finally {
            fileOutputStream.close();
        }
    }
}