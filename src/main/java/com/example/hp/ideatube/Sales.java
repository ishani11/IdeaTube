package com.example.hp.ideatube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONException;
import org.json.JSONObject;



import java.io.IOException;
import java.net.URL;

public class Sales extends YouTubeBaseActivity {

    YouTubePlayerView mYouTubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
        mYouTubePlayerView=(YouTubePlayerView)findViewById(R.id.ytSales);


        mOnInitializedListener = new YouTubePlayer.OnInitializedListener()
        {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //String[] videolist= new String[]{"YykjpeuMNEk", "WTJSt4wP2ME","VPRjCeoBqrI","1G4isv_Fylg","QtXby3twMmI"};
                //Random random= new Random();
                //youTubePlayer.loadVideo(videolist[random.nextInt(5)]);
                youTubePlayer.loadPlaylist("PLdLc0x0ZutQm_atW1BSYp9c5vAiM3mD2t");


            }


            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        mYouTubePlayerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(), mOnInitializedListener);


            }
        });
    }

}

