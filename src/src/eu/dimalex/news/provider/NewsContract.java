package eu.dimalex.news.provider;

import android.net.Uri;
import android.provider.BaseColumns;

public class NewsContract {
	
	private static final String PATH_EVENTS = "events";
	private static final String PATH_PLACES = "places";
	private static final String PATH_FAVOURITES = "favourites";
	
	static final String CONTENT_AUTHORITY = "eu.dimalex.news.provider";
	
	private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
	
	public static class Events implements BaseColumns, IEventsColumns {
		
		public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_EVENTS).build();
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.news.event";
		public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.news.event";
	}
	
	public static class Places implements BaseColumns, IPlacesColumns {
		
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_PLACES).build();
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.news.place";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.news.place";
	}
	
	public static class Favourites implements BaseColumns, IFavouritesColumns {
        
		public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_FAVOURITES).build();
		public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.news.favourite";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.news.favourite";
	}
}
