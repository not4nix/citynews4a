package eu.dimalex.news;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class CityLifeActivity extends Activity {
	private ImageView mEvents;
	private ImageView mPlaces;
	private ImageView mFavourites;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mEvents = (ImageView)findViewById(R.id.im_Events);
        mEvents.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent i = new Intent(CityLifeActivity.this, EventsActivity.class);
				startActivity(i);
			}
        });
        mPlaces = (ImageView)findViewById(R.id.im_Places);
        mPlaces.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent i = new Intent(CityLifeActivity.this, PlacesActivity.class);
				startActivity(i);
			}
        });
        mFavourites = (ImageView)findViewById(R.id.imFavourites);
        mFavourites.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CityLifeActivity.this, FavouritesActivity.class);
				startActivity(intent);
			}
        });
    }
}
