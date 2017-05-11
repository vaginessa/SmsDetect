package smsdetect.org.smsdetect;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] permissions = new String[]{
                Manifest.permission.READ_SMS,
                Manifest.permission.RECEIVE_SMS
        };

        ActivityCompat.requestPermissions(this, permissions, 1);
    }
}
