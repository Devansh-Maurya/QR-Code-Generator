package maurya.devansh.qrcodegenerator

import android.app.Application
import io.appwrite.Client

/**
 * Created by devansh on 12/05/22.
 */

class QrCodeGeneratorApp : Application() {

    companion object {
        lateinit var INSTANCE: QrCodeGeneratorApp
    }

    val client by lazy {
        Client(this)
            .setEndpoint("${BuildConfig.APPWRITE_BASE_URL}/v1")
            .setProject(BuildConfig.APPWRITE_PROJECT_ID)
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}