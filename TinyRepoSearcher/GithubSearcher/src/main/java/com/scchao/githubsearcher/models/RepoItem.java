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

    @Override
    public String toString() {
        return String.format(
                "\nname: %s \nfull_name: %s \ndescription: %s \nlanguage: %s \nprivate: %s",
                name == null ? "" : name,
                fullName == null ? "" : fullName,
                description == null ? "" : description,
                language == null ? "" : language,
                privateStatus == null ? "Null" : String.valueOf(privateStatus));
    }
}
