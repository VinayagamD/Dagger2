package com.ffghub.dagger2.screens;

import android.content.Context;

import com.ffghub.dagger2.screens.home.AdapterRepos;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vinaylogics on 23-03-2017.
 */
@Module
public class HomeActivityModule {
    private final HomeActivity homeActivity;

    public HomeActivityModule(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    @Provides
    @HomeActivityScope
    public HomeActivity homeActivity(){
        return homeActivity;
    }
}
