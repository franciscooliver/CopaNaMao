package com.app.fran.copanamao.utils;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.os.ResultReceiver;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class TimeService extends IntentService {

    public static final String RESULT_RECEIVER_EXTRA = "result_receiver_extra";
    public static final String RESULT_DATA_KEY = "result_data_key";
    public static final int SUCCESS_RESULT = 0;
    public static final int FAILURE_RESULT = 1;
    public static final String FAILURE_MESSAGE_KEY = "failure_message_key";

    private final String TIME_SERVER = "time.nist.gov";
    private ResultReceiver resultReceiver;

    public TimeService() {
        super("TimeService");
    }

    //Método para facilitar o uso do Service
    public static void requestTime(@NonNull Context context,
                                   @NonNull ResultReceiver resultReceiver) {

        Intent intent = new Intent(context, TimeService.class);
        intent.putExtra(RESULT_RECEIVER_EXTRA, resultReceiver);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@NonNull Intent intent) {

        resultReceiver = intent.getParcelableExtra(RESULT_RECEIVER_EXTRA);
        if(resultReceiver == null){
            throw new IllegalArgumentException("No ResultReceiver");
        }
        deliverResultToReceiver(getTime());
    }

    private TimeResult getTime(){

        NTPUDPClient timeClient = new NTPUDPClient();
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(TIME_SERVER);
        } catch (UnknownHostException e) {
            return new TimeResult(FAILURE_RESULT, -1, e.getMessage());
        }
        TimeInfo timeInfo = null;
        try {
            timeInfo = timeClient.getTime(inetAddress);
        } catch (IOException e) {
            return new TimeResult(FAILURE_RESULT, -1, e.getMessage());
        }
        long time = timeInfo.getMessage().getTransmitTimeStamp().getTime();
        return new TimeResult(SUCCESS_RESULT, time, "");
    }

    //Usa o ResultReceiver para enviar o resultado
    @SuppressLint("RestrictedApi")
    private void deliverResultToReceiver(TimeResult result){
        Bundle bundle = new Bundle();
        bundle.putString(FAILURE_MESSAGE_KEY, result.failureMessage);
        bundle.putLong(RESULT_DATA_KEY, result.time);
        resultReceiver.send(result.resultCode, bundle);
    }

    private class TimeResult{

        int resultCode;
        String failureMessage;
        long time;

        protected TimeResult(int resultCode, long time, String failureMessage){

            this.resultCode = resultCode;
            this.time = time;
            this.failureMessage = failureMessage;
        }
    }
}
