package eu.dimalex.news;

import android.app.ListActivity;
import android.os.Bundle;

public class EventsActivity extends ListActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_events);
	}
}

