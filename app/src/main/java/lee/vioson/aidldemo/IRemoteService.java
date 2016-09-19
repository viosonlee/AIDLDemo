package lee.vioson.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:李烽
 * Date:2016-04-14
 * FIXME
 * Todo
 */
public class IRemoteService extends Service {
    private List<Model> models = new ArrayList<>();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    private IBinder iBinder = new IMyAidlInterface.Stub() {
        @Override
        public List<Model> add(Model model) throws RemoteException {
            models.add(model);
            return models;
        }
    };
}
