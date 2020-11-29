package com.scchao.githubsearcher;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.scchao.githubsearcher.interfaces.RequestFetchListener;

public class GitRepoSearcher {
    private static final String LOG_TAG = "GitRepoSearcher";

    private Context context;
    private RequestQueue requestQueue;
    private RequestFetchListener callback;

    public GitRepoSearcher(Context context) {
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }

    public GitRepoSearcher(Context context, RequestFetchListener callback) {
        this(context);
        setFetchCallback(callback);
    }

    public void setFetchCallback(RequestFetchListener callback) {
        this.callback = callback;
    }

}
