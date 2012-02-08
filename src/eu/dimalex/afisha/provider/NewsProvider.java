package eu.dimalex.afisha.provider;

import eu.dimalex.afisha.provider.NewsContract.Events;
import eu.dimalex.afisha.provider.NewsContract.Favourites;
import eu.dimalex.afisha.provider.NewsContract.Places;
import eu.dimalex.afisha.provider.NewsDatabase.ITables;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class NewsProvider extends ContentProvider{

	private static final UriMatcher sUriMatcher = buildUriMatcher();
	
	private static final int EVENTS = 50;
	private static final int PLACES = 100;
	private static final int FAVOURITES = 150;
	
	private NewsDatabase mDatabase;
	
	private static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = NewsContract.CONTENT_AUTHORITY;

        matcher.addURI(authority, "events", EVENTS);
        matcher.addURI(authority, "places", PLACES);
        matcher.addURI(authority, "favourites", FAVOURITES);
        
        return matcher;
    }
	
	protected String matchTable(Uri uri){
		final int match = sUriMatcher.match(uri);
		switch(match){
		case EVENTS:
			return ITables.EVENTS;
		case PLACES:
			return ITables.PLACES;
		case FAVOURITES:
			return ITables.FAVOURITES;
		default:
			throw new UnsupportedOperationException("Table doesn't match : " + uri);
		}
	}
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		final SQLiteDatabase db = mDatabase.getWritableDatabase();
		final String table = matchTable(uri);
		int retVal = db.delete(table, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return retVal;
	}

	@Override
	public String getType(Uri uri) {
		final int match = sUriMatcher.match(uri);
		switch(match){
		case EVENTS:
			return Events.CONTENT_TYPE;
		case PLACES:
			return Places.CONTENT_TYPE;
		case FAVOURITES:
			return Favourites.CONTENT_TYPE;
		default:
			throw new UnsupportedOperationException("Bad Uri: " + uri);
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCreate() {
		mDatabase = new NewsDatabase(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
