package lee.vioson.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import lee.vioson.aidlclien.R;

public class AIDLActivity extends AppCompatActivity {
    private TextView textView;
    IMyAidlInterface iMyAidlInterface;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iMyAidlInterface = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);

        Intent intent = new Intent();
        intent.setComponent(new ComponentName("lee.vioson.aidldemo", "lee.vioson.aidldemo.IRemoteService"));
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    public void add(View view) {
        Model model = new Model("test", 0);
        try {
            List<Model> add = iMyAidlInterface.add(model);
            Log.d("TAG", add.toString());
            textView.setText(add.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
