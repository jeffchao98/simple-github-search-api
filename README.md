# Simple helper for search Github repo

- This project provide the simple helper that returns a list of GitHub repository information with the given `organization` and `platform`.

## Setup

- [MUST] You should add the tag `<uses-library android:name="org.apache.http.legacy" android:required="false" />` in `AndroidManifest.xml` , as the following example

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.yourapp">
    <application
    ...
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher">
        ...
        <uses-library android:name="org.apache.http.legacy" android:required="false" />
    </application>
</manifest>

```

### Manually

### Auto ( via Maven ) 
- Coming soon...

## Usage

- When your application start, you should initialize the library using the snippet below:

```Java
        GitRepoSearcher searcher =  new GitRepoSearcher(this);
```

- In order to listen the search result and access the detail data, you need to setup the callback with the method `void setFetchCallback(RequestFetchListener callback)` , sample as the following:
  - The boolean value `success` indicate if the search via github api is success or not
  - The `RepoItem` list indicate the fetched items

```Java
        searcher.setFetchCallback(new RequestFetchListener() {
            @Override
            public void onFetch(boolean success, List<RepoItem> items) {
                Log.i("MainActivity", "success");
                // Your process logic here
            }
        })
```

- You also can setup the callback with the interface `RequestFetchListener` for receive the fetch result when initial the library as the following.

```Java
        GitRepoSearcher searcher =  new GitRepoSearcher(this, new RequestFetchListener() {
            @Override
            public void onFetch(boolean success, List<RepoItem> items) {
                Log.i("MainActivity", "success");
            }
        });
```

- The class `RepoItem` including the following attributes:

| Name | Type | description |
| --- | --- | --- |
| name | String | name of the fetched repo info |
| fullName | String | full name of the fetched repo info |
| description | String | description of the fetched repo info |
| language | String | using language of the fetched repo info |
| privateStatus | String | private status of the fetched repo info |

- For execute search, you can use the method `void searchWith(String platform, String organization)` after initial the library and setup the callback.
  - This method still can run without setup callback, the `Info` debug nessage will print out the `description` in each fetched list data if exist.
