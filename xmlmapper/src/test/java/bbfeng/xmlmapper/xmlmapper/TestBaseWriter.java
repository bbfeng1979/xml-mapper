package bbfeng.xmlmapper.xmlmapper;

import static org.junit.Assert.*;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestBaseWriter {

	private String filePath = this.getClass().getClassLoader().getResource("simple-1.xml").getPath();

	@Test
	public void test() throws DocumentException {
		SAXReader reader = new SAXReader();
        File file = new File(filePath);
        Document document = reader.read(file);
        Element root = document.getRootElement();
        
        BaseWriter bw = new BaseWriter();
        bw.setName("Emp");
        bw.setSrc("/Employees/Employee/Name");
        bw.setSb(new StringBuilder());
        bw.append(root);
        System.out.println(bw.getSb().toString());
	}

}
