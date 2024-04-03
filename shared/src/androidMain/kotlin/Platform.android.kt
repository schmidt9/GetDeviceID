import android.content.Context
import android.provider.Settings.Secure

actual fun getDeviceId(context: Any?): String {
    val appContext = context as Context
    return Secure.getString(appContext.getContentResolver(), Secure.ANDROID_ID);
}