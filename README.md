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

#### Constructor

> GitRepoSearcher(Context context)

- When your application start, you should initialize the library using the constructor as the followng sameple:

```Java
        GitRepoSearcher searcher =  new GitRepoSearcher(this);
```

#### Callback setup method

> void setFetchCallback(RequestFetchListener callback)

- In order to listen the search result and access the detail data in the logic, you need to setup the callback, sample as the following:
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

#### Extended constructor

> GitRepoSearcher(Context context, RequestFetchListener callback)

- You also can setup the callback with the interface `RequestFetchListener` when initial the library with the extended constructor as the following.

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

#### Search method

> void searchWith(String platform, String organization)

- For execute search, you can use the method after initial the library.
  - This method still can run without setup callback, the `Info` debug nessage will print out the `description` in each fetched list data if exist.
