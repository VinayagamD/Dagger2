package com.ffghub.dagger2.screens;

import com.ffghub.dagger2.GitHubApplicationComponent;
import com.ffghub.dagger2.networks.GitHubService;
import com.ffghub.dagger2.screens.home.AdapterRepos;

import dagger.Component;

/**
 * Created by vinaylogics on 23-03-2017.
 */
@HomeActivityScope
@Component(modules = HomeActivityModule.class, dependencies = GitHubApplicationComponent.class)
public interface HomeActivityComponent {
    void injectHomeActivity(HomeActivity homeActivity);
}
