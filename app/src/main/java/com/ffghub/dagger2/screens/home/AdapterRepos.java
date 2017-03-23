package com.ffghub.dagger2.screens.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ffghub.dagger2.models.GithubRepo;
import com.ffghub.dagger2.screens.HomeActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by vinaylogics on 21-03-2017.
 */

public class AdapterRepos  extends BaseAdapter{
    private final List<GithubRepo> repoList = new ArrayList<>(0);
    private final Context context;
    private final Picasso picasso;

    @Inject
    public AdapterRepos(HomeActivity context, Picasso picasso) {
        this.context = context;
        this.picasso = picasso;
    }



    @Override
    public int getCount() {
        return repoList.size();
    }

    @Override
    public GithubRepo getItem(int position) {
        return repoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return repoList.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ReposListItem reposListItem;
        if (convertView == null){
            reposListItem = new ReposListItem(context,picasso);
        }else {
            reposListItem = ReposListItem.class.cast(convertView);
        }
        reposListItem.setRepo(repoList.get(position));
        return reposListItem;
    }

    public void swapData(Collection<GithubRepo> githubRepos){
        repoList.clear();
        if (githubRepos!=null){
            repoList.addAll(githubRepos);
        }
        notifyDataSetChanged();
    }
}
