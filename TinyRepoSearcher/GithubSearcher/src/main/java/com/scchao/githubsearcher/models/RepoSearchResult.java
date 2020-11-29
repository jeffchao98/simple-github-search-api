package com.scchao.githubsearcher.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RepoSearchResult {
    @SerializedName("items")
    public List<RepoItem> items = new ArrayList<>();
}
