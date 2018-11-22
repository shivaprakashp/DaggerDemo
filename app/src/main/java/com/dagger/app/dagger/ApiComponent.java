package com.dagger.app.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by OM on 22-11-2018.
 */

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
}
