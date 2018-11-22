package com.dagger.app;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by OM on 22-11-2018.
 */

public interface TaskComplete {
    void onTaskFinished(Response response, String mRequestKey);
    void onTaskError(Call call, Throwable t, String mRequestKey);
}
