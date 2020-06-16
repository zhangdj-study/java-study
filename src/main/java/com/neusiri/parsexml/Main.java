package com.neusiri.parsexml;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.Iterator;

/**
 * 解析xml文件测试类 dom解析 和 dom4j包的sax解析
 *
 * @author zhangdj
 * @date 2020-01-17 14:05
 */
public class Main {

    /**
     * dom方式解析xml文件
     * 根据xml的层级结构在内存中分配一个树形结构，把xml的标签，属性和文本都分装成对象。
     * 缺点：如果文件过大，造成内存溢出
     * 优点：很方便实现增删改操作
     * @throws Exception
     */
    @Test
    public void parseXMLByDom() throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("parsexml/test.xml");
        //将xml文档加载到内存，以树状形式存储
        Document document = documentBuilder.parse(resourceAsStream);
        //获取节点名称为configuration的节点列表
        NodeList nodeList = document.getElementsByTagName("configuration");
        System.out.println("nodeList-----" + nodeList.getLength());
        //遍历节点
        for (int i = 0; i < nodeList.getLength(); i++) {
            //获取当前索引的节点
            Node configurationNode = nodeList.item(i);
            //获取该configuration节点的全部子节点,即dataSource节点列表
            NodeList childNodes = configurationNode.getChildNodes();
            System.out.println("childNodes-----" + childNodes.getLength());
            //遍历子节点
            for (int j = 0; j < childNodes.getLength(); j++) {
                //获取当前索引的dataSource节点
                Node dataSourceNode = childNodes.item(j);
                String nodeName1 = dataSourceNode.getNodeName();
                if ("dataSource".equals(nodeName1)) {
                    //获取所有property节点
                    NodeList dataSourceNodeChildNodes = dataSourceNode.getChildNodes();
                    System.out.println("childChildNodes-----" + dataSourceNodeChildNodes.getLength());
                    for (int k = 0; k < dataSourceNodeChildNodes.getLength(); k++) {
                        Node propertiesNode = dataSourceNodeChildNodes.item(k);
                        String nodeName = propertiesNode.getNodeName();
                        if ("property".equals(nodeName)) {
                            NamedNodeMap attributes = propertiesNode.getAttributes();
                            Node name = attributes.getNamedItem("name");
                            Node value = attributes.getNamedItem("value");
                            String nodeName2 = name.getNodeValue();
                            String nodeValue = value.getNodeValue();
                            System.out.println(nodeName2 + "-----" + nodeValue);
                        }
                    }
                }
            }
        }
    }

    /**
     * sax解析xml文件
     *
     * 从上到下，一行一行的解析，解析到某一个对象，把对象名称返回
     * 优点：使用sax方式不会造成内存溢出，实现查询
     * 缺点：使用sax方式，不能实现增删改操作
     * @throws Exception
     */
    @Test
    public void parseXMLBySax() throws Exception {
        SAXReader reader = new SAXReader();
        org.dom4j.Document document = reader.read("src/main/resources/parsexml/test.xml");
        //获取根节点
        Element rootElement = document.getRootElement();
        System.out.println("根节点的名字是:" + rootElement.getName());
        //获取子节点列表
        Iterator second = rootElement.elementIterator();
        while (second.hasNext()) {
            Element second_FirstChild = (Element) second.next();
            System.out.println("第二级节点名称是：" + second_FirstChild.getName());
            Iterator thirdIterator = second_FirstChild.elementIterator();
            while (thirdIterator.hasNext()){
                Element third_FirstChild = (Element)thirdIterator.next();
                System.out.println("第三级" + "节点名称是：" + third_FirstChild.getName());
                String name = third_FirstChild.attribute("name").getValue();
                String value = third_FirstChild.attribute("value").getValue();
                System.out.println(name + "-----" + value);
            }
        }
    }
}
