package eu.dimalex.afisha.provider;

import android.app.Activity;
import android.database.Cursor;
import eu.dimalex.afisha.provider.NewsContract.Events;

public class NewsDAO {
	
	public void findEventByDate(String eventDate, Activity activity){
		String select = Events.EVENT_DATE + "=" + eventDate;
		Cursor c = activity.managedQuery(Events.CONTENT_URI, null, select, null, null);
		c.moveToFirst();
	}
	
	public void findEventByPlace(String eventPlace, Activity activity){
		String s = Events.EVENT_PLACE + "=" + eventPlace;
		Cursor cursor = activity.managedQuery(Events.CONTENT_URI, null, s, null, null);
		cursor.moveToFirst();
	}
}