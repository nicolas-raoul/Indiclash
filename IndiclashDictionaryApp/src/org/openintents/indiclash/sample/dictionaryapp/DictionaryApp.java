package org.openintents.indiclash.sample.dictionaryapp;

import org.openintents.indiclash.sample.dictionaryapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * A sample dictionary app.
 */
public class DictionaryApp extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Button to launch a card creation Intent.
        Button button = (Button) findViewById(R.id.addWordToFlashcardApp);
        button.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Toast.makeText(DictionaryApp.this, "Adding word to flashcard app", Toast.LENGTH_SHORT).show();
        		Intent intent = new Intent();
        		intent.setAction("org.openintents.indiclash.CREATE_FLASHCARD");
        		// See http://en.wikipedia.org/wiki/List_of_ISO_639-1_codes
        		intent.putExtra("SOURCE_LANGUAGE", "ja");
        		intent.putExtra("TARGET_LANGUAGE", "fr");
        		intent.putExtra("SOURCE_TEXT", "日の出");
        		intent.putExtra("TARGET_TEXT", "Lever du soleil");
        		startActivity(intent);
        	}
        });
    }
}