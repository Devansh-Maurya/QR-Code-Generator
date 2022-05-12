package maurya.devansh.qrcodegenerator.ui.main

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

class MainViewModel : ViewModel() {

    private val _qrCodeLiveData = MutableLiveData<ByteArray>()
    val qrCodeLiveData: LiveData<ByteArray>
        get() = _qrCodeLiveData

    fun getQrCodeUrl(text: String) {
        val avatars = Avatars(QrCodeGeneratorApp.INSTANCE.appwriteClient)

        viewModelScope.launch {
            avatars.getQR(text).runCatching {
                _qrCodeLiveData.value = this
            }
        }
    }
}