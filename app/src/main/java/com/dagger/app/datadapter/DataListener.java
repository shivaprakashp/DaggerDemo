package com.dagger.app.datadapter;

/**
 * Created by OM on 22-11-2018.
 */

import android.app.ProgressDialog;
import android.content.Context;

import com.dagger.app.EmaarProgressDialog;
import com.dagger.app.RequestProperties;
import com.dagger.app.TaskComplete;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 1000779 on 1/24/2018.
 */

public class DataListener {

    private EmaarProgressDialog dialog;
    private Context context;
    protected TaskComplete taskComplete;
    private RequestProperties properties;

    public DataListener(Context context, TaskComplete taskComplete, RequestProperties properties) {
        this.context = context;
        this.taskComplete = taskComplete;
        dialog = new EmaarProgressDialog(context, null);
        this.properties = properties;
    }

    public void dataLoad(Call call) {
        try {
            // dialog.setMessage(context.getResources().getString(R.string.loading));

            dialog.showDialog();
            dialog.setCancelListener(new EmaarProgressDialog.onDialogCancelListener() {
                @Override
                public void onCancel() {
                    taskComplete = null;
                }
            });

            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    dialog.dismiss();
                    taskComplete.onTaskFinished(response,properties.getRequestKey());
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    dialog.dismiss();
                    taskComplete.onTaskError(call, t,properties.getRequestKey());
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}