package org.example.utils;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtils {
	// xml文件的路径
	public static String PATH = "src/main/resources/META-INF/person.xml";
	
	// 得到Document对象
	public static Document getDocument(String path) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(path);
		return document;
	}
	// 回写xml文件
	public static void xmlWriters(String path, Document document) throws Exception {
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(
				new FileOutputStream(PATH), 
				format);
		writer.write(document);
		writer.close();
	}
}
