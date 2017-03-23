package com.ffghub.dagger2.networks;

import com.ffghub.dagger2.models.GithubRepo;
import com.ffghub.dagger2.models.GithubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by vinaylogics on 21-03-2017.
 */

public interface GitHubService {
    @GET("users/{username}/repos")
    Call<List<GithubRepo>> getReposForUser(@Path("username") String username );

    @GET("repositories")
    Call<List<GithubRepo>> getAllRepos();

    @GET("users/{username}")
    Call<GithubUser> getUser(@Path("username")String username);
}
