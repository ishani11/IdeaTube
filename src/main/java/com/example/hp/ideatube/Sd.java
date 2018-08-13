package com.example.hp.ideatube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Sd extends YouTubeBaseActivity
{
    YouTubePlayerView bYouTubePlayerView;
    YouTubePlayer.OnInitializedListener bOnInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sd2);
        bYouTubePlayerView=findViewById(R.id.ytSd);

        bOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadPlaylist("PL4BrNFx1j7E6a6IKg8N0IgnkoamHlCHWa");

            }


            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        bYouTubePlayerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bYouTubePlayerView.initialize(YouTubeConfig.getApiKey(), bOnInitializedListener);


            }
        });
    }
}



