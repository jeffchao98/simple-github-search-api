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

### Manually import the SDK

- After compile the whole project completed, you can find the `.aar` file in the path `${repo root path}/TinyRepoSearcher/GithubSearcher/build/outputs/aar`
- Copy-paste the aar file to the path `${project root path}/app/libs` your project ( you can create `libs` folder if not created yet )
- In the gradle script of your project ( app level ) add the `repositories` for include the `libs` folder before the `dependencies` section, as the followng example:

```gradle
repositories {
    flatDir {
        dirs 'libs'
    }
}
dependencies {
...
```

- In the `dependencies` section of the app-level gradle script, add the followinf three implementation statements import this SDK and the related resources

```gradle
dependencies {
    ...
    implementation 'com.mcxiaoke.volley:library:1.0.19'
    implementation 'com.google.code.gson:gson:2.8.6'
    implementation(name: 'GithubSearcher-debug', ext: 'aar')
    ...
}
```

## Usage

### Constructor

> GitRepoSearcher(Context context)

- When your application start, you should initialize the library using the constructor as the followng sameple:

```Java
        GitRepoSearcher searcher =  new GitRepoSearcher(this);
```

### Search method

> void searchWith(String platform, String organization, RequestFetchListener callback)

- For execute search, you can use the method after initial the library.
  - This method still can run without setup callback, the `Info` debug nessage will print out the `description` in each fetched list data if exist.

- In order to listen the search result and access the detail data in the logic, you need `RequestFetchListener` interface for build the callback, which will return two attribtues:
  - The boolean value `success` indicate if the search via github api is success or not
  - The `RepoItem` list indicate the fetched items, attributes as the following

| Name | Type | description |
| --- | --- | --- |
| name | String | name of the fetched repo info |
| fullName | String | full name of the fetched repo info |
| description | String | description of the fetched repo info |
| language | String | using language of the fetched repo info |
| privateStatus | String | private status of the fetched repo info |

- For using the method, sameple as the follwoing

```Java
        RequestFetchListener listener = new RequestFetchListener() {
            @Override
            public void onFetch(boolean success, List<RepoItem> items) {
                Log.i("MainActivity", "success");
            }
        };
        searcher.searchWith("android", "google", listener);
```

