# Regras ProGuard para FocusFlow

# Manter classes do Jetpack Compose
-keep class androidx.compose.** { *; }
-keep class androidx.lifecycle.** { *; }
-keep class androidx.activity.** { *; }

# Manter classes do Room
-keep class androidx.room.** { *; }
-keep @androidx.room.Entity class * { *; }
-keep @androidx.room.Dao class * { *; }

# Manter classes do Kotlin
-keep class kotlin.** { *; }
-keep class kotlinx.** { *; }

# Manter classes do Gson
-keep class com.google.gson.** { *; }
-keep class * implements com.google.gson.JsonDeserializer
-keep class * implements com.google.gson.JsonSerializer

# Manter classes do aplicativo
-keep class com.focusflow.app.** { *; }

# Manter métodos nativos
-keepclasseswithmembernames class * {
    native <methods>;
}

# Manter construtores de classes que são usadas no AndroidManifest.xml
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

# Remover logs em produção
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
}
