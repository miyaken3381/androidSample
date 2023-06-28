package jp.co.miyaken3381.guideSample;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.GuidedStepSupportFragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements GuideTvFragmentListener {
    private MainActivity mFragmentActivity;
    // エラー表示ガイド
    private GuidedStepSupportFragment mGuidFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentActivity = this;

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGuidFragment = new GuideTvFragment("タイトルサンプル", "ほげほげ\nふがふが");
                GuidedStepSupportFragment.addAsRoot(mFragmentActivity, mGuidFragment, android.R.id.content);
            }
        });
    }

    public void onClickButton(long action) {
        Toast.makeText(getApplicationContext(), "表示しました。ボタンID[" + action + "]", Toast.LENGTH_SHORT).show();
    }
}