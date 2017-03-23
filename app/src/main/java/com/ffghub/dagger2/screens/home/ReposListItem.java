package com.ffghub.dagger2.screens.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ffghub.dagger2.R;
import com.ffghub.dagger2.models.GithubRepo;
import com.squareup.picasso.Picasso;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vinaylogics on 21-03-2017.
 */
@SuppressLint("ViewConstructor")
public class ReposListItem  extends FrameLayout {

    private final Picasso picasso;

    @BindView(R.id.user_avatar)
    ImageView avatarImage;

    @BindView(R.id.repo_name)
    TextView name;

    @BindView(R.id.repo_description)
    TextView description;

    @BindView(R.id.repo_stars)
    TextView stars;

    @BindView(R.id.repo_issues)
    TextView issues;

    @BindView(R.id.repo_forks)
    TextView forks;

    @BindView(R.id.repo_updated_at)
    TextView updatedAt;
    private static final DateTimeFormatter  DATE_TIME_FORMATTER = DateTimeFormat.fullDate();
    public ReposListItem(@NonNull Context context,Picasso picasso) {
        super(context);
        this.picasso = picasso;
        inflate(getContext(),R.layout.list_item_repo,this);
        ButterKnife.bind(this);

    }


   public void setRepo(GithubRepo githubRepo){
       Locale locale = getResources().getConfiguration().locale;
       name.setText(githubRepo.name);
       description.setVisibility(TextUtils.isEmpty(githubRepo.description)?GONE:VISIBLE);
       description.setText(String.valueOf(githubRepo.description));

       updatedAt.setText(getResources().getString(R.string.last_pushed,DATE_TIME_FORMATTER.print(githubRepo.updatedAt)));
       stars.setText(String.format(locale,"%d",githubRepo.stargazersCount));
       issues.setText(String.format(locale,"%d",githubRepo.openIssuesCount));
       forks.setText(String.format(locale,"%d",githubRepo.forksCount));

      picasso.load(githubRepo.owner.avatarUrl)
               .placeholder(R.drawable.ic_person_black_24dp)
               .into(avatarImage);
   }
}
