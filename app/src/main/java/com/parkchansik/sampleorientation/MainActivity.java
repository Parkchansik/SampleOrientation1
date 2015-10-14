package com.parkchansik.sampleorientation;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] ROTATION = {"PORT", "LAND" , "REV_PORT" , "REV_LAND"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate...", Toast.LENGTH_SHORT).show();
        int orientation = getResources().getConfiguration().orientation;//화면이 포트레잇인지 랜드스케이프인지 정보를 받아옴 (단 새로시작할때만)

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "Portrait", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Landscape", Toast.LENGTH_SHORT).show();
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int rotation = getWindowManager().getDefaultDisplay().getRotation();// 화면이 네가지로 구분되서 받아오는듯
        Toast.makeText(this, "ROTATION : " + ROTATION[rotation], Toast.LENGTH_SHORT).show();

    }

        //이거 꼭 메니페스토에 해줘야햄<activity android:name=".MainActivity" android:configChanges="orientation|screenSize">
        public void onConfigurationChanged(Configuration newConfig) {//이걸 해줘야 이제 새롭게 생성되는게 아니라 화면만 전환되는거야
            super.onConfigurationChanged(newConfig);
            int orientation = newConfig.orientation;
            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                Toast.makeText(this, "Changed Portrait", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Changed Landscape", Toast.LENGTH_SHORT).show();
            }

    }
}
