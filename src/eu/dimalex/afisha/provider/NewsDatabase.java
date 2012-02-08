package eu.dimalex.afisha.provider;

import eu.dimalex.afisha.provider.NewsContract.Events;
import eu.dimalex.afisha.provider.NewsContract.Favourites;
import eu.dimalex.afisha.provider.NewsContract.Places;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class NewsDatabase extends SQLiteOpenHelper{

	private static final String DATABASE_NAME = "news.db";
	private static final int DATABASE_VERSION = 1;
	
	public NewsDatabase(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	} 
	
	public NewsDatabase(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public interface ITables {
		String EVENTS = "events";
		String PLACES = "places";
		String FAVOURITES = "favourites";
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
//		db.execSQL("create table " + INewsDatabaseTables.EVENTS + "(_id integer primary key autoincrement," +
//				"eventName text not null, date text not null, unique("+Events.ID+") ON CONFLICT REPLACE");
//		db.execSQL("create table " + INewsDatabaseTables.PLACES + "(_id integer primary key autoincrement," +
//				"name text not null,eventName text not null, unique("+Places.ID+") ON CONFLICT REPLACE");
		db.execSQL(CREATE_TABLE_EVENTS);
		db.execSQL(CREATE_TABLE_PLACES);
		db.execSQL(CREATE_TABLE_FAVOURITES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + ITables.EVENTS);
		db.execSQL("DROP TABLE IF EXISTS " + ITables.PLACES);
		db.execSQL("DROP TABLE IF EXISTS " + ITables.FAVOURITES);
		onCreate(db);
	}
	
	private static final String CREATE_TABLE_EVENTS = "CREATE TABLE "
            + ITables.EVENTS + " ("
            + Events._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Events.EVENT_ID + " INTEGER, "
            + Events.EVENT_DESCRIPTION + " TEXT, "
            + Events.EVENT_DATE + " TEXT, "
            + Events.EVENT_PLACE + " TEXT, "
            + "UNIQUE (" + Events.EVENT_ID + ") ON CONFLICT REPLACE)";
	
	private static final String CREATE_TABLE_PLACES = "CREATE TABLE "
            + ITables.PLACES + " ("
            + Places._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Places.PLACE_ID + " INTEGER, "
            + Places.PLACE_ADDRESS + " TEXT, "
            + "UNIQUE (" + Places.PLACE_ID + ") ON CONFLICT REPLACE)";
	
	private static final String CREATE_TABLE_FAVOURITES = "CREATE TABLE "
            + ITables.FAVOURITES + " ("
            + Favourites._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Favourites.FAVOURITE_ID + "INTEGER,"
            + Favourites.EVENT_NAME + " TEXT, "
            + Favourites.PLACE_NAME + " TEXT, "
            + Favourites.PLACE_ADDRESS + " TEXT, "
            + Favourites.EVENT_DESCRIPTION + " TEXT, "
            + "UNIQUE (" + Favourites.FAVOURITE_ID + ") ON CONFLICT REPLACE)";
}
