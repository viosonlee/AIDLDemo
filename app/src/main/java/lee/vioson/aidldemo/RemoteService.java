package lee.vioson.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Author:李烽
 * Date:2016-04-14
 * FIXME
 * Todo
 */
public class RemoteService extends Service {
    public  static final int MSG_SAY_HELLO = 0;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }


    Handler msgHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.replyTo != null) {
                Message message = this.obtainMessage();
                message.what = 0;
                try {
                    msg.replyTo.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            switch (msg.what) {
                case MSG_SAY_HELLO:
                    Toast.makeText(RemoteService.this.getApplicationContext(), "Hello World Remote Service!",
                            Toast.LENGTH_SHORT).show();
                    break;
            }
            super.handleMessage(msg);
        }
    };

    Messenger messenger = new Messenger(msgHander);
}
