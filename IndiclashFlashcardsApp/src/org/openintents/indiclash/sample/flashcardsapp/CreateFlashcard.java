package org.openintents.indiclash.sample.flashcardsapp;

import org.openintents.indiclash.sample.flashcardsapp.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Activity to create a flashcard.
 * This activity is called via an Intent, for instance by a dictionary app.
 */
public class CreateFlashcard extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Get the fields sent with the intent.
        final Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String sourceLanguage = (String)extras.get("SOURCE_LANGUAGE");
        String targetLanguage = (String)extras.get("TARGET_LANGUAGE");
        String sourceText = (String)extras.get("SOURCE_TEXT");
        String targetText = (String)extras.get("TARGET_TEXT");

        // Just display the fields.
        // A real flashcard app would create a new flashcard from those fields,
        // or display a flashcard creation screen with pre-filled fields. 
        WebView webView = (WebView) findViewById(R.id.create_flashcard);
        String html = "<html><body>"
        	+ "<p>Source language: " + sourceLanguage + "</p>"
        	+ "<p>Target language: " + targetLanguage + "</p>"
        	+ "<p>Source text: " + sourceText + "</p>"
        	+ "<p>Target text: " + targetText + "</p>"
        	+ "</body></html>";
        webView.loadDataWithBaseURL("", html, "text/html", "utf-8", null);
    }
}