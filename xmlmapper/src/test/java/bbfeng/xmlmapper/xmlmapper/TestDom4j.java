package bbfeng.xmlmapper.xmlmapper;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;


public class TestDom4j {

	private String filePath = this.getClass().getClassLoader().getResource("simple-1.xml").getPath();
	
	private void printNode(Element node, String indent) {
		System.out.print(indent);
		System.out.print("<" + node.getName());
        List<Attribute> attributeList = node.attributes();
        for (Attribute attr : attributeList) {
            System.out.println(attr.getName() + "=\"" + attr.getValue() + "\"");
        }
        
        
		List<Element> childElements = node.elements();
		if(childElements.isEmpty()) {
			System.out.print(">");
			System.out.print(node.getText());
			System.out.println("</" + node.getName() + ">");
		} else {
			System.out.println(">");
	        for (Element child : childElements) {
	        	printNode(child, indent + "    ");
	        }
			System.out.print(indent);
	        System.out.println("</" + node.getName() + ">");
		}
		

        return;
	}
	@Test
	public void testErgodic() throws DocumentException {
		
		SAXReader reader = new SAXReader();
        File file = new File(filePath);
        Document document = reader.read(file);
        Element root = document.getRootElement();
        printNode(root, "");
	}

	@Test
	public void testXPath() throws DocumentException {
		SAXReader reader = new SAXReader();
        File file = new File(filePath);
        Document document = reader.read(file);
        Element root = document.getRootElement();
        Node emp = root.selectSingleNode("//Employee/Address");
        System.out.print(emp.asXML());
        
	}
}
