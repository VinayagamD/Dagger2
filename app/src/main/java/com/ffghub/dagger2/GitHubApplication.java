package com.ffghub.dagger2;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.ffghub.dagger2.converters.DateTimeConverter;
import com.ffghub.dagger2.networks.GitHubService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import org.joda.time.DateTime;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by vinaylogics on 21-03-2017.
 */

public class GitHubApplication extends MultiDexApplication {

    private GitHubApplicationComponent component;

    public static GitHubApplication get(Activity activity){
        return (GitHubApplication) activity.getApplication();
    }



//        Activity

//    GithubService  picasso

// Retrofit         OkHttp3Downloader

//     gson       Okhttp

//           Logger     Cache

//          Timber          file

    @Override
    public void onCreate() {
        try {
            super.onCreate();

            Timber.plant(new Timber.DebugTree());
            component = DaggerGitHubApplicationComponent.builder()
                    .contextModule(new ContextModule(this))
                    .build();


        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public GitHubApplicationComponent component() {
        return component;
    }

}
