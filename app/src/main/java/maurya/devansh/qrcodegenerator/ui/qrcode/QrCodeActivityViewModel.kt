package maurya.devansh.qrcodegenerator.ui.qrcode

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.appwrite.services.Avatars
import kotlinx.coroutines.launch
import maurya.devansh.qrcodegenerator.QrCodeGeneratorApp

/**
 * Created by devansh on 12/05/22.
 */

class QrCodeActivityViewModel : ViewModel() {

    private val _qrCodeLiveData = MutableLiveData<ByteArray>()
    val qrCodeLiveData: LiveData<ByteArray>
        get() = _qrCodeLiveData

    fun getQrCode(text: String) {
        val avatars = Avatars(QrCodeGeneratorApp.INSTANCE.appwriteClient)

        viewModelScope.launch {
            avatars.getQR(text).runCatching {
                _qrCodeLiveData.value = this
            }.onFailure {
                Log.e("QRFail", it.localizedMessage.orEmpty())
            }
        }
    }
}