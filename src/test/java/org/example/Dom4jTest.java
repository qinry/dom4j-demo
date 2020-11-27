package org.example;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.example.utils.Dom4jUtils;

public class Dom4jTest {
	public static void main(String[] args) throws Exception {
//		selectName();
		selectSin();
//		selectSecond();
//		addSex();
//		addBeforeAge();
//		modifyAge();
//		delSch();
//		getValues();
	}
	
	public static void getValues() throws Exception{
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		String  attr = p1.attributeValue("id");
		System.out.println(attr);
	}
	
	public static void delSch() throws Exception {
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);		
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		Element school = p1.element("school");
		Element parent = school.getParent();
		parent.remove(school);		
		Dom4jUtils.xmlWriters(Dom4jUtils.PATH, document);
	}
	
	public static void modifyAge() throws Exception {
	
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		Element age = p1.element("age");
		age.setText("30");
		Dom4jUtils.xmlWriters(Dom4jUtils.PATH, document);
	}
	// 在特殊位置添加标签age
	public static void addBeforeAge() throws Exception {
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);		
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		List<Element> list = p1.elements();
		
		Element school = DocumentHelper.createElement("school");
		school.setText("gdut");
		list.add(1, school);
		
		// rewrite xml file!!!
		Dom4jUtils.xmlWriters(Dom4jUtils.PATH, document);
		
	}
	
	// 第一个p1后添加sex标签
	public static void addSex() throws  Exception {
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);		
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		p1.addElement("sex");
		Element sex1 = p1.element("sex");
		sex1.setText("girl");
		
		// rewrite to xml file!!!
		Dom4jUtils.xmlWriters(Dom4jUtils.PATH, document);
	}

	// 获得第二个p1标签下的name文本
	public static void selectSecond() throws Exception {
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);		
		Element root = document.getRootElement();
		List<Element> list = root.elements("p1");
		Element p2 = list.get(1);
		Element name2 = p2.element("name");
		String s2 = name2.getText();
		System.out.println(s2);
	}
	// 获得第一个p1标签下的name文本
	public static void selectSin() throws Exception {
//		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);		
//		Element root = document.getRootElement();
//		Element p1 = root.element("p1");
//		Element name1 = p1.element("name");
//		String s1 = name1.getText();
//		System.out.println(s1);
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);		
		Node node = document.selectSingleNode("//p1[@id='47']/name");
		
		String s =node.getText();
		System.out.println(s);
		
	}
	// 获得所有name的标签文本
	public static void selectName() throws Exception {
//		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);		
//		Element root = document.getRootElement();
//		List<Element> list = root.elements("p1");
//		for(Element element : list) {
//			Element name = element.element("name");
//			String s = name.getText();
//			System.out.println(s);
//		}
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		List<Node> list = document.selectNodes("//name"); // 注意XML命名空间和xpath表达式的正确
		
		for(Node node : list) {
			String s = node.getText();
			System.out.println(s);
		}
	}
}
