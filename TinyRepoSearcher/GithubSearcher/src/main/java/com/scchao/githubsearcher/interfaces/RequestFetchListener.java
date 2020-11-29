package com.scchao.githubsearcher.interfaces;

import com.scchao.githubsearcher.models.RepoItem;

import java.util.List;

public interface RequestFetchListener {
    void onFetch(boolean success, List<RepoItem> items);
}
