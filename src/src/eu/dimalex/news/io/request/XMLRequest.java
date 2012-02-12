package eu.dimalex.news.io.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLRequest {
	
	public XMLRequest(){
		
	}
	
	public static String getXML(){
		String line = null;
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet("http://gorod.dp.ua/afisha/export.php");
			HttpResponse response = client.execute(get);
			HttpEntity httpEntity = response.getEntity();
			line = EntityUtils.toString(httpEntity);
		}
		catch(UnsupportedEncodingException ex){
			line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
		} 
		catch (ClientProtocolException e) {
			line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
		} 
		catch (IOException e) {
			line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
		}
		return line;
	}
	
	public static Document XMLFromString(String xml){
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			doc = db.parse(is);
		}
		catch(ParserConfigurationException ex){
			ex.printStackTrace();
		} 
		catch (SAXException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	public static String getValue(Element item, String s){
		NodeList node = item.getElementsByTagName(s);
		return XMLRequest.getElementValue(node.item(0));
	}
	
	public static String getElementValue(Node n){
		Node children;
		if(n != null){
			if(n.hasChildNodes()){
				for( children = n.getFirstChild(); n != null; children = children.getNextSibling()){
					if( children.getNodeType() == Node.TEXT_NODE){
						return children.getNodeValue();
					}
				}
			}
		}
		return "";
	}
	
	public static int numResults(Document doc){		
		Node results = doc.getDocumentElement();
		int res = -1;
		try{
			res = Integer.valueOf(results.getAttributes().getNamedItem("count").getNodeValue());
		}
		catch(Exception e ){
			res = -1;
		}
		return res;
	}
}
