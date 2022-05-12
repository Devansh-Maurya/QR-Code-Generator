package maurya.devansh.qrcodegenerator.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import maurya.devansh.qrcodegenerator.BuildConfig
import maurya.devansh.qrcodegenerator.data.model.QrCodeImageUrl

/**
 * Created by devansh on 12/05/22.
 */

class MainViewModel : ViewModel() {

    private val _qrCodeLiveData = MutableLiveData<QrCodeImageUrl>()
    val qrCodeLiveData: LiveData<QrCodeImageUrl>
        get() = _qrCodeLiveData

    fun getQrCodeUrl(text: String) {
        _qrCodeLiveData.value = "${BuildConfig.APPWRITE_BASE_URL}v1/avatars/qr?text=${text}"
    }
}