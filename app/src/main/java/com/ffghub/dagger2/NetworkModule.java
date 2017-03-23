package com.ffghub.dagger2;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by vinaylogics on 23-03-2017.
 */
@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    @GitHubApplicationScope
    public HttpLoggingInterceptor loggingInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
               @Override
               public void log(String message) {
                   Timber.i(message);
               }
           });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Provides
    @GitHubApplicationScope
    public File cacheFile(@ApplicationContext Context context){
        return new File(context.getCacheDir(),"okhttp_cache");

    }

    @Provides
    @GitHubApplicationScope
    public Cache cache(File cacheFile){
        return new Cache(cacheFile, 10 * 1000 * 1000); //10MB Cache
    }

    @Provides
    @GitHubApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache){
       return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }
}
