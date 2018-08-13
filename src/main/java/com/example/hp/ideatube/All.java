package com.example.hp.ideatube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class All extends YouTubeBaseActivity {
    YouTubePlayerView nYouTubePlayerView;
    YouTubePlayer.OnInitializedListener nOnInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        nYouTubePlayerView=findViewById(R.id.ytAll);


        nOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadPlaylist("PLx0sYbCqOb8TBPRdmBHs5Iftvv9TPboYG");

            }


            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        nYouTubePlayerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nYouTubePlayerView.initialize(YouTubeConfig.getApiKey(), nOnInitializedListener);


            }
        });
    }
}
