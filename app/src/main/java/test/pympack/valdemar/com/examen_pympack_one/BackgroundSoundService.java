package test.pympack.valdemar.com.examen_pympack_one;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import android.util.Log;

public class BackgroundSoundService extends Service {
    private MediaPlayer mp;

    public BackgroundSoundService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp = MediaPlayer.create(this,R.raw.sound);

        Log.v("TAG_SOUND","PLAY SONIDO");
        mp.setLooping(true);
        mp.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("TAG_SOUND","STOP SONIDO");
        mp.stop();

    }
}
