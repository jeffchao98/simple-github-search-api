package com.scchao.githubsearcher.models;

import com.google.gson.annotations.SerializedName;

public class RepoItem {
    @SerializedName("name")
    public String name = "";

    @SerializedName("full_name")
    public String fullName = "";

    @SerializedName("description")
    public String description = "";

    @SerializedName("language")
    public String language = "";

    @SerializedName("private")
    public Boolean privateStatus;
}
