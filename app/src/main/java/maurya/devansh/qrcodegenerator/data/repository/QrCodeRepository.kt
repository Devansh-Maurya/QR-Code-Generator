package maurya.devansh.qrcodegenerator.data.repository

import maurya.devansh.qrcodegenerator.data.model.QrCodeImageUrl
import maurya.devansh.qrcodegenerator.data.remote.NetworkService

/**
 * Created by devansh on 12/05/22.
 */

class QrCodeRepository(
    private val networkService: NetworkService
) {
    suspend fun getQrCode(text: String): QrCodeImageUrl {
        return networkService.getQrCode(text)
    }
}