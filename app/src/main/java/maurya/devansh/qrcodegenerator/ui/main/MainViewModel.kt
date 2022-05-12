package maurya.devansh.qrcodegenerator.ui.main

import androidx.lifecycle.ViewModel
import maurya.devansh.qrcodegenerator.data.repository.QrCodeRepository

/**
 * Created by devansh on 12/05/22.
 */

class MainViewModel(
    private val qrCodeRepository: QrCodeRepository
) : ViewModel() {
}