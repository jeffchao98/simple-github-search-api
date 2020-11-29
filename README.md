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
- Initialization
- Run search
