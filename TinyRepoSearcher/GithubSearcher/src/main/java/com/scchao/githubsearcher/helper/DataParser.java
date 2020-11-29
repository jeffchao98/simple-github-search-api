package com.scchao.githubsearcher.helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.scchao.githubsearcher.models.RepoSearchResult;

public class DataParser {
    public static RepoSearchResult parserResult(final String rawData) {
        try {
            RepoSearchResult result = new Gson().fromJson(rawData,
                    new TypeToken<RepoSearchResult>(){}.getType());
            return result;
        } catch (Exception err) {
            return new RepoSearchResult();
        }
    }
}
