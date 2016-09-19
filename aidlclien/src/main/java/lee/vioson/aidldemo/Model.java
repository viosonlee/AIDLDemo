package lee.vioson.aidldemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author:李烽
 * Date:2016-04-14
 * FIXME
 * Todo
 */
public class Model implements Parcelable {
    private String param1;
    private int param2;

    public Model(String param1, int param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    protected Model(Parcel in) {
        param1 = in.readString();
        param2 = in.readInt();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(param1);
        dest.writeInt(param2);
    }

    @Override
    public String toString() {
        return "{param1:" + param1 + ",param2:" + param2 + "}";
    }
}
