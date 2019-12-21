package com.example.instantcash;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;




import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;


public class HomeActivity extends AppCompatActivity {
private TextView mywallet;
private Button earnadds,earnvideos,earngames,payout;

private RewardedAd    rewardedAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mywallet = findViewById(R.id.my_wallet);
        earnadds = findViewById(R.id.earn_adds);
earngames = findViewById(R.id.earn_games);
payout = findViewById(R.id.payout);
earnvideos= findViewById(R.id.earn_videos);
        rewardedAd = new RewardedAd(this,
                "ca-app-pub-3940256099942544/5224354917");

        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
            }

            @Override
            public void onRewardedAdFailedToLoad(int errorCode) {
                // Ad failed to load.
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);



    }
}
