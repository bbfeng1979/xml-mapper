package bbfeng.xmlmapper.xmlmapper;

import org.dom4j.Element;
import org.dom4j.Node;

public class BaseWriter {

	private String name;
	private String src;
	private BaseWriter parent;
	private StringBuilder sb;
	
	public StringBuilder getSb() {
		return sb;
	}

	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public BaseWriter getParent() {
		return parent;
	}

	public void setParent(BaseWriter parent) {
		this.parent = parent;
	}
	
	public void append(Element el) {
		Node n = el.selectSingleNode(src);
		sb.append("<").append(name).append(">")
			.append(n == null ? "": n.getText().trim())
			.append("</").append(name).append(">");
	}

	

}
