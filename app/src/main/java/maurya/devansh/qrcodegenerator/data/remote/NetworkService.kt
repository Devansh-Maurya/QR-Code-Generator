package maurya.devansh.qrcodegenerator.data.remote

import maurya.devansh.qrcodegenerator.data.model.QrCodeImageUrl
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by devansh on 12/05/22.
 */

interface NetworkService {

    @GET("/v1/avatars/qr")
    suspend fun getQrCode(@Query("text") text: String): QrCodeImageUrl
}