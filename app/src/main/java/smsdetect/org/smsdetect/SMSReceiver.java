package smsdetect.org.smsdetect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;


public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String smsBody = "";
        String address = "";
        Bundle intentExtras = intent.getExtras();
        if (intentExtras != null) {
            Object[] sms = (Object[]) intentExtras.get("pdus");
            for (int i = 0; i < sms.length; ++i) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                smsBody = smsMessage.getMessageBody().toString();
                address = smsMessage.getOriginatingAddress();

            }
            Toast.makeText(context, address + "\n" + smsBody, Toast.LENGTH_SHORT).show();

            if (smsBody.equals("detect")) {

                Toast.makeText(context, "detected", Toast.LENGTH_SHORT).show();

                AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

                audioManager.adjustStreamVolume(  AudioManager.STREAM_MUSIC,          audioManager.getStreamMaxVolume(  AudioManager.STREAM_MUSIC         ),    AudioManager.FLAG_SHOW_UI   );
                audioManager.adjustStreamVolume(  AudioManager.STREAM_RING,           audioManager.getStreamMaxVolume(  AudioManager.STREAM_RING          ),    AudioManager.FLAG_SHOW_UI   );
                audioManager.adjustStreamVolume(  AudioManager.STREAM_NOTIFICATION,   audioManager.getStreamMaxVolume(  AudioManager.STREAM_NOTIFICATION  ),    AudioManager.FLAG_SHOW_UI   );
                audioManager.adjustStreamVolume(  AudioManager.STREAM_ALARM,          audioManager.getStreamMaxVolume(  AudioManager.STREAM_ALARM         ),    AudioManager.FLAG_SHOW_UI   );
                audioManager.adjustStreamVolume(  AudioManager.STREAM_SYSTEM,         audioManager.getStreamMaxVolume(  AudioManager.STREAM_SYSTEM        ),    AudioManager.FLAG_SHOW_UI   );
                audioManager.adjustStreamVolume(  AudioManager.STREAM_VOICE_CALL,     audioManager.getStreamMaxVolume(  AudioManager.STREAM_VOICE_CALL    ),    AudioManager.FLAG_SHOW_UI   );
                audioManager.adjustStreamVolume(  AudioManager.STREAM_DTMF,           audioManager.getStreamMaxVolume(  AudioManager.STREAM_DTMF          ),    AudioManager.FLAG_SHOW_UI   );

            }
        }
    }
}
