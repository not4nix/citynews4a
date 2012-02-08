package eu.dimalex.afisha.provider;

import android.net.Uri;
import android.provider.BaseColumns;

public class NewsContract {
	
	private static final String PATH_EVENTS = "events";
	private static final String PATH_PLACES = "places";
	private static final String PATH_FAVOURITES = "favourites";
	
	public static final String CONTENT_AUTHORITY = "eu.dimalex.cars.provider";
	
	 private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
	
	public interface EventsColumns {
		String EVENT_ID = "eventId";
		String PLACE_ADDRESS = "eventPlace";
		String EVENT_DATE = "eventDate";
		String EVENT_DESCRIPTION = "eventDescription";
		String EVENT_PLACE = "eventPlace";
	}
	
	public interface PlacesColumns {
		String PLACE_ID = "placeId";
		String PLACE_ADDRESS = "placeAddress";
	}
	
	public interface FavouritesColumns {
		String FAVOURITE_ID = "fid";
		String EVENT_NAME = "eventName";
		String PLACE_NAME = "placeName";
		String EVENT_DATE = "eventDate";
		String EVENT_DESCRIPTION = "eventDescription";
		String PLACE_ADDRESS = "placeAddress";
	}
	
	public static class Events implements BaseColumns, EventsColumns {
		public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_EVENTS).build();
		
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.afisha.event";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.afisha.event";
	}
	
	public static class Places implements BaseColumns, PlacesColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_PLACES).build();
		
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.afisha.place";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.afisha.place";
	}
	
	public static class Favourites implements BaseColumns, FavouritesColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_FAVOURITES).build();
		
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.afisha.favourite";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.afisha.favourite";
	}
}
