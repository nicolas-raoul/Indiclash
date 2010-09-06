package org.openintents.indiclash.sample.dictionaryapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Activity to translate an entry. This activity is called via an Intent, for
 * instance by a flashcard app.
 */
public class DictionaryLookup extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Get the fields sent with the intent.
		final Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		String sourceLanguage = (String) extras.get("SOURCE_LANGUAGE");
		String targetLanguage = (String) extras.get("TARGET_LANGUAGE");
		String sourceText = (String) extras.get("SOURCE_TEXT");

		Intent returnData = new Intent();
		// our dictionary only knows one word...
		if (sourceLanguage.equals("en") && targetLanguage.equals("fr") && sourceText.equals("beer")) {
			// word found => return as intent extra TARGET_TEXT of type string
			returnData.putExtra("TARGET_TEXT", "bire");
		} else {
			// word unknown
			// => leave intent extra TARGET_TEXT unset to signal "unknown word"
		}
		setResult(RESULT_OK, returnData);
		finish();
	}
}