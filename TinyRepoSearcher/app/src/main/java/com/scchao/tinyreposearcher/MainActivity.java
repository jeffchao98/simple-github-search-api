package com.scchao.tinyreposearcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.scchao.githubsearcher.GitRepoSearcher;
import com.scchao.githubsearcher.interfaces.RequestFetchListener;
import com.scchao.githubsearcher.models.RepoItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GitRepoSearcher searcher =  new GitRepoSearcher(this);
        RequestFetchListener listener = new RequestFetchListener() {
            @Override
            public void onFetch(boolean success, List<RepoItem> items) {
                Log.i("MainActivity", "success");
            }
        };
        searcher.searchWith("android", "rakutentech", listener);
        searcher.searchWith("android", "google", listener);
        searcher.searchWith("adakjdjln", "klklejlkr", listener);
    }
}