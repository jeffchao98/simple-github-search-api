package com.scchao.githubsearcher;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.scchao.githubsearcher.helper.DataParser;
import com.scchao.githubsearcher.interfaces.RequestFetchListener;
import com.scchao.githubsearcher.models.RepoItem;
import com.scchao.githubsearcher.models.RepoSearchResult;

import java.util.List;

public class GitRepoSearcher {
    private static final String LOG_TAG = "GitRepoSearcher";

    private RequestQueue requestQueue;

    public GitRepoSearcher(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public void searchWith(String platform, String organization, RequestFetchListener callback) {
        String queryUrl = String.format(
                "https://api.github.com/search/repositories?q=%s+org:%s", platform, organization);
        requestQueue.add(makeVolleyRequest(queryUrl, callback));
    }

    private StringRequest makeVolleyRequest(String url, final RequestFetchListener callback) {
        return new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                RepoSearchResult searchResult = DataParser.parserResult(response);
                if (callback != null) {
                    callback.onFetch(true, searchResult.items);
                }
                printFetchedItems(searchResult.items);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (callback != null) {
                    callback.onFetch(false, null);
                }
                error.printStackTrace();
            }
        });
    }

    private void printFetchedItems(List<RepoItem> items) {
        if (items == null) {
            return;
        }
        Log.i(LOG_TAG, String.format("Fetched items count: %d", items.size()));
        for (RepoItem item : items) {
            Log.i(LOG_TAG, item.toString());
        }
    }
}
