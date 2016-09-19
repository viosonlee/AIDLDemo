package lee.vioson.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Author:李烽
 * Date:2016-04-14
 * FIXME
 * Todo
 */
public class LocalService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new LocalBinder();
    }

    /**
     * 可以访问
     */
    public void helloWorld() {
        Toast.makeText(this, "hello world", Toast.LENGTH_SHORT).show();
    }

    public class LocalBinder extends Binder {
        LocalService getService() {
            return LocalService.this;
        }
    }
}
