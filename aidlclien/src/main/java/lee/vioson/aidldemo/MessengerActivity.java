package lee.vioson.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import lee.vioson.aidlclien.R;

/**
 * Author:李烽
 * Date:2016-04-14
 * FIXME
 * Todo
 */
public class MessengerActivity extends AppCompatActivity {
    public static final int MSG = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messenger);
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Messenger messenger = new Messenger(service);
            Message message = new Message();
            message.what = 0;
            message.replyTo = m;
            try {
                messenger.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("lee.vioson.aidldemo","lee.vioson.aidldemo.RemoteService"));
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG:
                    Toast.makeText(MessengerActivity.this.getApplicationContext(), "Hello World Remote Client!",
                            Toast.LENGTH_SHORT).show();
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    Messenger m = new Messenger(new IncomingHandler());
}
