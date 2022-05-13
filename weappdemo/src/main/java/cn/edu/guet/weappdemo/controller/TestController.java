package cn.edu.guet.weappdemo.controller;

import cn.edu.guet.weappdemo.service.impl.OrderServiceImpl;
import cn.edu.guet.weappdemo.dao.ShopCarDao;
import cn.edu.guet.weappdemo.service.OrderService;
import cn.edu.guet.weappdemo.bean.Order;
import cn.edu.guet.weappdemo.dao.impl.ShopCarDaoImpl;
import cn.edu.guet.weappdemo.util.ConnectionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author liwei
 * @Date 2021-08-04 11:28
 * @Version 1.0
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/auth")
    public String auth(@RequestParam("code") String code) {
        log.info("获取code");
        log.info("code : " + code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxd9a46e74fc279fcc&secret=7deb521448e11ddbc163fca849648198&code=" + code + "&grant_type=authorization_code";
        String response = restTemplate.getForObject(url, String.class);
        log.info("response = {}", response);
        return response;
    }

    @PostMapping("/result")
    public String result(HttpServletRequest request, HttpServletResponse res) {

        String ip = request.getRemoteAddr();
        System.out.println("IP地址:" + ip);
        BufferedReader reader = null;
        try {
            reader = request.getReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = "";
        StringBuffer inputString = new StringBuffer();

        try {
            while ((line = reader.readLine()) != null) {
                inputString.append(line);
            }
            request.getReader().close();
            String response = inputString.toString();//接收的回调结果（支付成功后，腾讯调用我们的接口，并发数据给我们）
            String pattern =
                    ".+<attach><!\\[CDATA\\[(.+);.+" +
                            "<mch_id><!\\[CDATA\\[(\\d{10}).+" +
                            "<out_trade_no><!\\[CDATA\\[(.{32}).+" +
                            "<time_end><!\\[CDATA\\[(\\d{14}).+" +
                            "<transaction_id><!\\[CDATA\\[(\\d{28})";
            Pattern r = Pattern.compile(pattern);
            // 现在创建 matcher 对象
            Matcher m = r.matcher(response);
            if (m.find()) {

                String itemInfo = m.group(1);
                String item[] = itemInfo.split(";");

                String item_id = item[0].split(",")[1];
                String item_price = item[1].split(",")[1];
                String item_amount = item[2].split(",")[1];
                String mch_id = m.group(2);
                String orderNo = m.group(3);
                String orderTime = m.group(4);
                String transactionId = m.group(5);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                Timestamp timestamp = new Timestamp(sdf.parse(orderTime).getTime());
                //支付那边只负责生成，本次交易的码单，不写涉及到具体商品，因此正则表达式可能需要修改一些
                //这里的控制器在打包后给主工程调用，生成二维码并扫码后，二维码触发本次回调,这里

                //查询购物车，并返回购物车结果集
                ShopCarDao shopCarDao = new ShopCarDaoImpl();
                ResultSet RS=shopCarDao.SelectAll();

                //这里是每次支付生成一次，一次生成的代号对应多个商品（一对多的关系）

                Order order = new Order();
                String id = UUID.randomUUID().toString().replace("-", "");
                System.out.println(id);
                order.setId(id);//会自动生成32个字符
                order.setMch_id(Integer.parseInt(mch_id));
                order.setOut_trade_no(orderNo);
                order.setOrder_time(timestamp);
                order.setTransaction_id(transactionId);

                while(RS.next()){
                    //根据将查询到的数据商品名再去查找Item表目前的库存，并将库存信息插入到与ID信息插入stock表
                    //这里是查询数据库获得的数据--前面回调得到数据再加上这层数据
                    order.setUserId(RS.getInt(5));
                    order.setItem_id(RS.getInt(2));
                    order.setItem_price(RS.getFloat(3));
                    order.setAmount(RS.getInt(4));
                    order.setOrder_price(RS.getFloat(3)*RS.getInt(4));
                    OrderService orderService = new OrderServiceImpl();
                    //不想大幅度改参数，在这里传入就行了
                    orderService.newOrder(order, String.valueOf(order.getItem_id()), String.valueOf(order.getAmount()));
                    //将被改动的库存表数据利用update更新到item表;--->先留空等待管理员同意再接入管理
                }
                //当执行完购物车结算并完成支付时，将购物车清空
                System.out.println("=========清空购物车=========");
                shopCarDao.DelAll();

                /*
                发信息给微信，告知微信官方，已收到通知
                 */
                String result = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>" +
                        "<return_msg><![CDATA[OK]]></return_msg>" +
                        "</xml>";
                BufferedOutputStream out = new BufferedOutputStream(
                        res.getOutputStream());
                out.write(result.getBytes());
                RS.close();
                out.flush();
                out.close();
                ConnectionHandler.closeConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
