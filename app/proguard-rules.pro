##--------------- Support AppCompat  -----------------
-keep public class android.support.v7.widget.** { *; }
-keep public class android.support.v7.internal.widget.** { *; }
-keep public class android.support.v7.internal.view.menu.** { *; }

-keep public class * extends android.support.v4.view.ActionProvider {
    public <init>(android.content.Context);
}
##--------------- Support AppCompat  -----------------

##--------------- Support Design  -----------------
-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }
##--------------- Support Design  -----------------


##--------------- Retrofit 2 / OkHTTP 3  -----------------
-dontwarn com.squareup.okhttp.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn javax.annotation.Nullable
-dontwarn javax.annotation.ParametersAreNonnullByDefault
-dontwarn retrofit2.**
-dontnote retrofit2.Platform
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
-dontwarn retrofit2.Platform$Java8
-keepattributes Signature
-keepattributes Exceptions
##--------------- Retrofit 2 / OkHTTP 3  -----------------

##--------------- Glide  -----------------
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.AppGlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
##--------------- Glide  -----------------


##--------------- Gson  -----------------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class me.aungkyawpaing.data.network.retrofit.responses.** { *; }
#-keep class com.google.gson.examples.android.model.** { *; }

# Prevent proguard from stripping interface information from TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
##---------------Gson -----------------

##---------------Dagger 2 -----------------
-dontwarn com.google.errorprone.annotations.*
##---------------Dagger 2 -----------------

##---------------Kotlin-----------------
-dontwarn kotlin.**
##---------------Kotlin-----------------

##---------------Account Kit-----------------
-keep class com.facebook.FacebookSdk {
   boolean isInitialized();
}
-keep class com.facebook.appevents.AppEventsLogger {
   com.facebook.appevents.AppEventsLogger newLogger(android.content.Context);
   void logSdkEvent(java.lang.String, java.lang.Double, android.os.Bundle);
}
##---------------Account Kit-----------------

##---------------ViewPager Indicator-----------------
-dontwarn com.viewpagerindicator.**
##---------------ViewPager Indicator-----------------