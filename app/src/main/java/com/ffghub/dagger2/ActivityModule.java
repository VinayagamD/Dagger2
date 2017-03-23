package com.ffghub.dagger2;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vinaylogics on 23-03-2017.
 */
@Module
public class ActivityModule {

    private final Activity context;

    public ActivityModule(Activity context) {
        this.context = context;
    }

    @Provides
    @GitHubApplicationScope
    public Context context(){
        return context;
    }
}
