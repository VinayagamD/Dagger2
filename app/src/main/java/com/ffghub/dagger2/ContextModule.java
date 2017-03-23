package com.ffghub.dagger2;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vinaylogics on 23-03-2017.
 */
@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @GitHubApplicationScope
    @ApplicationContext
    public Context context(){
        return context;
    }
}
