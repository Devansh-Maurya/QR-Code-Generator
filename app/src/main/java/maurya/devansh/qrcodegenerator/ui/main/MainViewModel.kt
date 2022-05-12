package maurya.devansh.qrcodegenerator.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import maurya.devansh.qrcodegenerator.BuildConfig
import maurya.devansh.qrcodegenerator.data.model.QrCodeImageUrl
import maurya.devansh.qrcodegenerator.data.repository.QrCodeRepository

/**
 * Created by devansh on 12/05/22.
 */

class MainViewModel(
    private val qrCodeRepository: QrCodeRepository
) : ViewModel() {

    private val _qrCodeLiveData = MutableLiveData<QrCodeImageUrl>()
    val qrCodeLiveData: LiveData<QrCodeImageUrl>
        get() = _qrCodeLiveData

//    fun generateQrCode(text: String) {
//        viewModelScope.launch {
//            qrCodeRepository.getQrCode(text)
//                .catch { e ->
//                    Log.e("ApiError", e.localizedMessage.orEmpty())
//                }
//                .collect {
//                    _qrCodeLiveData.value = it.bytes()
//                }
//        }
//    }

    fun getQrCodeUrl(text: String) {
        _qrCodeLiveData.value = "${BuildConfig.APPWRITE_BASE_URL}v1/avatars/qr?text=${text}"
    }
}