package com.dagger.app;

import android.app.Application;

import com.dagger.app.dagger.ApiComponent;
import com.dagger.app.dagger.ApiModule;
import com.dagger.app.dagger.AppModule;
import com.dagger.app.dagger.DaggerApiComponent;

/**
 * Created by OM on 22-11-2018.
 */

public class MainApplication extends Application {

    private ApiComponent apiComponent;
    @Override
    public void onCreate(){
        super.onCreate();
        initDagger();
    }

    private void initDagger(){
        //dagger component initilized
        apiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule(""))
                .build();
    }

    public ApiComponent getNetComponent() {
        return apiComponent;
    }
}
