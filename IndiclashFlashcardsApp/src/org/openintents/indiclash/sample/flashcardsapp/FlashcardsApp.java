package org.openintents.indiclash.sample.flashcardsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * A sample flashcard app. Does nothing.
 */
public class FlashcardsApp extends Activity {
	private static final int REQUEST_CODE_TRANSLATE = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button button = (Button) findViewById(R.id.lookupBeer);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				FlashcardsApp.lookupWord("beer", FlashcardsApp.this);
			}
		});

		Button wineButton = (Button) findViewById(R.id.lookupWine);
		wineButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				FlashcardsApp.lookupWord("wine", FlashcardsApp.this);
			}
		});

	}

	public static void lookupWord(String word, Activity activity) {
		Toast.makeText(activity, "looking up word in dictionary...", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent();
		intent.setAction("org.openintents.dictionary.LOOKUP");
		// See http://en.wikipedia.org/wiki/List_of_ISO_639-1_codes
		intent.putExtra("SOURCE_LANGUAGE", "en");
		intent.putExtra("TARGET_LANGUAGE", "fr");
		intent.putExtra("SOURCE_TEXT", word);
		activity.startActivityForResult(intent, REQUEST_CODE_TRANSLATE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE_TRANSLATE) {
			if (data.hasExtra("TARGET_TEXT")) {
				String translation = data.getStringExtra("TARGET_TEXT");
				Toast.makeText(this, "Translation found: " + translation, Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "Sorry, no translation found...", Toast.LENGTH_SHORT).show();
			}
		}
	}
}