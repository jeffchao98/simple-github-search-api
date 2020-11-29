package com.scchao.githubsearcher;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class GitRepoSearcher {
    private static final String LOG_TAG = "GitRepoSearcher";

    private Context context;
    private RequestQueue requestQueue;

    public GitRepoSearcher(Context context) {
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }

}
