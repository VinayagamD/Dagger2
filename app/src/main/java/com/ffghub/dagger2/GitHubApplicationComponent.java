package com.ffghub.dagger2;

import com.ffghub.dagger2.networks.GitHubService;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by vinaylogics on 23-03-2017.
 */
@GitHubApplicationScope
@Component(modules = {GitHubServiceModule.class,PicassoModule.class,ActivityModule.class})
public interface GitHubApplicationComponent {
    Picasso getPicasso();
    GitHubService getGitHubService();
}
