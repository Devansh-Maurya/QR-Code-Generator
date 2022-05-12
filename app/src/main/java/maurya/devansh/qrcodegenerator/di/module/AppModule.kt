package maurya.devansh.qrcodegenerator.di.module

import maurya.devansh.qrcodegenerator.BuildConfig
import maurya.devansh.qrcodegenerator.data.remote.NetworkService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by devansh on 12/05/22.
 */

object AppModule {

    private val retrofit by lazy { provideRetrofit() }
    val networkService by lazy { provideNetworkService() }

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.APPWRITE_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
    }

    private fun provideNetworkService(): NetworkService {
        return retrofit.create(NetworkService::class.java)
    }
}