package maurya.devansh.qrcodegenerator

import android.app.Application
import io.appwrite.Client

/**
 * Created by devansh on 12/05/22.
 */

class QRCodeGeneratorApp : Application() {

    companion object {
        val INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()
        val client = Client(this)
            .setEndpoint("${BuildConfig.APPWRITE_BASE_URL}/v1")
            .setProject(BuildConfig.APPWRITE_PROJECT_ID)
            .setSelfSigned(true)
    }
}