package lee.vioson.aidldemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import lee.vioson.aidlclien.R;

/**
 * Author:李烽
 * Date:2016-04-14
 * FIXME
 * Todo
 */
public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void aidl(View view) {
        startActivity(new Intent(this, AIDLActivity.class));
    }

    public void ibinder(View view) {
        startActivity(new Intent(this, IBinderActivity.class));
    }

    public void messenger(View view) {
        startActivity(new Intent(this, MessengerActivity.class));
    }
}
