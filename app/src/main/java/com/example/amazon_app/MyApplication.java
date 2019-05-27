package com.example.amazon_app;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myrealm.realm")
                .deleteRealmIfMigrationNeeded()//스키마 변경 때문에 exception 발생하는 것 무시
                .build();
        Realm.setDefaultConfiguration(config);
    }
}