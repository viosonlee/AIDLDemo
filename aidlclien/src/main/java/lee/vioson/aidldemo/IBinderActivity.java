package lee.vioson.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import lee.vioson.aidlclien.R;

/**
 * Author:李烽
 * Date:2016-04-14
 * FIXME
 * Todo
 */
public class IBinderActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibinder);
        Intent intent = new Intent(this, LocalService.class);
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    private LocalService localService;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            localService = ((LocalService.LocalBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public void click(View view) {
        localService.helloWorld();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
