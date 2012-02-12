package eu.dimalex.news;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import eu.dimalex.news.io.request.XMLRequest;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

/******TEMPORARY HARDCODED**********/
public class EventsActivity extends ListActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.events_layout);
		ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		String xml = XMLRequest.getXML();
		Document doc = XMLRequest.XMLFromString(xml);
		int numResults = XMLRequest.numResults(doc);
		if((numResults <= 0)){
        	Toast.makeText(EventsActivity.this, "Not found", Toast.LENGTH_LONG).show();  
        	finish();
        }
		NodeList nodes = doc.getElementsByTagName("result");
		for (int i = 0; i < nodes.getLength(); i++) {							
			HashMap<String, String> map = new HashMap<String, String>();	
			
			Element e = (Element)nodes.item(i);
			map.put("", XMLRequest.getValue(e, ""));
        	map.put("", "" + XMLRequest.getValue(e, ""));
        	map.put("", "" + XMLRequest.getValue(e, ""));
        	list.add(map);			
		}
		ListAdapter adapter = new SimpleAdapter(this, list , R.layout.main, 
                new String[] { "", "S" }, 
                new int[] { R.id.item_title, R.id.item_subtitle });
		setListAdapter(adapter);
		final ListView lv = getListView();
        lv.setTextFilterEnabled(true);	
        lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {        		
        		@SuppressWarnings("unchecked")
				HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	        		
        		Toast.makeText(EventsActivity.this, "ID '" + o.get("id") + "' was clicked.", Toast.LENGTH_LONG).show();
			}
        });  	
	}
}
