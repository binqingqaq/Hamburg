package cn.edu.guet.weappdemo.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

public class Xml2Json {

    public static List<Element> list;
    public static Map map;

    //普通xml转json
    public String xml2JSON(String xml) {
        return new XMLSerializer().read(xml).toString();
    }

    //普通json转xml
    public String json2XML(String json) {
        JSONObject jobj = JSONObject.fromObject(json);
        String xml = new XMLSerializer().write(jobj);
        return xml;
    }

    //cdata xml转json
    public static List<Element> jdomParseXml(String xml) {
        try {
            StringReader read = new StringReader(xml);
            // 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
            InputSource source = new InputSource(read);
            // 创建一个新的SAXBuilder
            SAXBuilder sb = new SAXBuilder();
            // 通过输入源构造一个Document
            Document doc;
            doc = (Document) sb.build(source);

            Element root = doc.getRootElement();// 指向根节点
            list = root.getChildren();
            /*
             * if(list!=null&&list.size()>0){ for (org.jdom.Element element :
             * list) {
             *
             *
             * //
             * System.out.println("key是："+element.getName()+"，值是："+element.getText
             * ()); jdomxml= "key是："+element.getName()+"，值是："+element.getText();
             * } }
             */

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    //测试
    public static void main(String[] args) {
        map = new HashMap<String, String>();

        String xmlString = "<xml><return_code><![CDATA[SUCCESS]]></return_code>"
                + "<return_msg><![CDATA[OK]]></return_msg>"
                + "<appid><![CDATA[wx49151a8d01a6bf48]]></appid>"
                + "<mch_id><![CDATA[1363729502]]></mch_id>"
                + "<nonce_str><![CDATA[S1NLDjWlAFUrS6ZA]]></nonce_str>"
                + "<sign><![CDATA[8D94E45B7B47C89A6FB7FA4119469EC2]]></sign>"
                + "<result_code><![CDATA[FAIL]]></result_code>"
                + "</xml>";

        List<Element> jdomParseXml = Xml2Json.jdomParseXml(xmlString);
        for (Element element : list) {
            //  System.out.println("key是：" + element.getName() + "，值是："
            //      + element.getText());


            map.put(element.getName(), element.getText());
        }
        JSONObject jsonObject = JSONObject.fromObject(map);
        System.out.println(jsonObject);

    }
}