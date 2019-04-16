# UserIQ Android SDK Integration

This guide will provide you with step by step details on how to integrate the SDK in just a few minutes. The following steps outline the integration process in details.

## Steps to integrate the sdk to your Android project (for Android Studio)

- [Step 1 : Add the dependency for UserIQ SDK](#step-1--add-the-dependency-for-useriq-sdk)
- [Step 2 : Initialize the SDK](#step-2--initialize-the-sdk)
- [Step 3 : Set the user](#step-3--set-the-user)

### Step 1 : Add the dependency for UserIQ SDK

1. Open build.gradle from the app folder of your project and include the SDK

```groovy
android {
    ...
}
repositories {
    jcenter()
}
dependencies {
  compile 'com.useriq:sdk:2.0.2'
  ... // your dependencies
}
```

### Step 2 : Initialize the SDK 

1. Open up your custom subclass of android.app.Application
2. Initialize UserIQSDK by including following lines in onCreate() method Application subclass.

```java
import com.appunfold.sdk.UserIQSDK;
...
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    UserIQSDK.init(this, "API_KEY");
    
    //your code
}
```

### Step 3 : Set the user

Until user is set, SDK will work in passive mode & does not send any data!
1. Open up the home activity (the activity, which comes immediately after the login)
2. Build & set the user in onCreate() method of opened activity.

```java
import com.appunfold.sdk.UserIQSDK;
...
@Override
protected void onCreate(Bundle savedInstanceState) {
    UserIQSDK.User user = new UserIQSDK.UserBuilder()
            .setId("EMP124")
            .setAccountId("1")
            .setAccountName("Acme Corp")
            .setName("Alex")
            .setEmail("alex@useriq.com")
            .addParams("location", "Atlanta")
            .build();
    UserIQSDK.setUser(user);
          
    //your code
}
```

## Alternate Installation

1. [Download](https://github.com/useriq-com/android-sdk/tree/master/SDK) the .aar file.
2. Add the .aar file to your project's libs folder. 
    ![](images/libs_location.png)
3. Initialize the SDK. [(Step 2)](#step-2--initialize-the-sdk)
4. Set the user. [(Step 3)](#step-3--set-the-user)

Note - The **_API-KEY_** can be obtained from the integration page of your app in the UserIQ dashboard.

## Misc

### Disable Fab
Floating Action Button (FAB) can be permanently disabled by calling the `disableFAB()` from the sdk. 

```java
UserIQSDK.disableFAB();
```
This can be called anytime before or after initializing the SDK. Once invoked, it will hide the FAB & also
overrides the enableFAB sent from the dashboard. (ie) if this method is called on the SDK, this will take precendence over
configuration from dashboard!

### Show Helpcenter

Helpcenter can be programatically invoked by calling `UserIQSDK.showHelpCenter()`

```java
boolean isHelpCenterShown = UserIQSDK.showHelpCenter();
```

When Modal window or popup is active, helpcenter can't be shown. In those cases, above API will return `false`

### Show Contextual help
Contextual help can be shown by calling `UserIQSDK.showCtxHelp()`

```java
boolean isCtxHelpShown = UserIQSDK.showCtxHelp();
```

Contextual help will only be shown when the current screen is tagged. If the current screen is not tagged then the above API will return `false`

#### InApp-Notification
![](images/inapp-default.gif)

#### NPS
![](images/nps.gif)

#### StarRating
![](images/star.gif)

#### Contexual Help
![](images/ctxHelp.gif)

#### HelpCentre
![](images/helpcenter.gif)
