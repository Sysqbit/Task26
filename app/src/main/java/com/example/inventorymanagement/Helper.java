package com.example.inventorymanagement;

import android.media.MediaPlayer;
import android.os.Vibrator;

public class Helper extends InventoryManagement {
    public static void playSuccess() {
        try {
            MediaPlayer player = MediaPlayer.create(getInstance(), R.raw.success);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playError() {
        try {
            MediaPlayer player = MediaPlayer.create(getInstance(), R.raw.error);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playWarning() {
        try {
            MediaPlayer player = MediaPlayer.create(getInstance(), R.raw.warning);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playBeep()
    {
        try {
            MediaPlayer mediaPlayer = MediaPlayer.create(getInstance(),R.raw.beep);
            mediaPlayer.start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void playVibrateLong() {
        try {
            Vibrator vibrator = (Vibrator) getInstance().getSystemService(VIBRATOR_SERVICE);
            vibrator.vibrate(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void playVibrate() {
        try {
            Vibrator vibrator = (Vibrator) getInstance().getSystemService(VIBRATOR_SERVICE);
            vibrator.vibrate(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
