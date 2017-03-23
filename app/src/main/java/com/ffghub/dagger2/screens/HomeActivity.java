package com.ffghub.dagger2.screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.ffghub.dagger2.GitHubApplication;
import com.ffghub.dagger2.R;
import com.ffghub.dagger2.models.GithubRepo;
import com.ffghub.dagger2.networks.GitHubService;
import com.ffghub.dagger2.screens.home.AdapterRepos;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.repo_home_list)
    ListView listView;
    Call<List<GithubRepo>> reposCall;

    @Inject
    GitHubService gitHubService;

    @Inject
    AdapterRepos adapterRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            ButterKnife.bind(this);

            HomeActivityComponent component = DaggerHomeActivityComponent.builder()
                    .homeActivityModule(new HomeActivityModule(this))
                    .gitHubApplicationComponent(GitHubApplication.get(this).component())
                    .build();

            component.injectHomeActivity(this);

            listView.setAdapter(adapterRepos);



            reposCall = gitHubService.getAllRepos();
            reposCall.enqueue(new Callback<List<GithubRepo>>() {
                @Override
                public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                    adapterRepos.swapData(response.body());
                }

                @Override
                public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                    t.printStackTrace();
                    Toast.makeText(HomeActivity.this,"Error getting Repos "+t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        try {
            super.onDestroy();
            if(reposCall!=null)
                reposCall.cancel();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
