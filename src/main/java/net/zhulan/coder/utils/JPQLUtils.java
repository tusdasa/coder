package net.zhulan.coder.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class JPQLUtils {
	private Map<String, String> map = new HashMap<String, String>();
	private String configPath = "JPQL.xml";

	public JPQLUtils() {
		
		configPath = JPQLUtils.class.getResource("/").getPath()+configPath;
		SAXReader reader = new SAXReader();
		Document document;
		try {
			document = reader.read(new File(configPath));
			Element rootElement = document.getRootElement();
			Iterator<?> iterator = rootElement.elementIterator();
			while (iterator.hasNext()) {
				String key = "", value = "";
				Element stu = (Element) iterator.next();
				List<Attribute> attributes = stu.attributes();
				for (Attribute attribute : attributes) {

					key = attribute.getValue();
				}
				Iterator<?> iterator1 = stu.elementIterator();
				while (iterator1.hasNext()) {
					Element stuChild = (Element) iterator1.next();
					if (stuChild.getName().equals("sql")) {
						value = stuChild.getStringValue();
					}
				}
				map.put(key, value);
			}
/*
			for (Map.Entry<String, String> entry : map.entrySet()) {
				String key = entry.getKey().toString();
				String value = entry.getValue().toString();
				System.out.println("key=" + key + " value=" + value);
			}
*/
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

	public String getConfigPath() {
		return configPath;
	}

	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

}
