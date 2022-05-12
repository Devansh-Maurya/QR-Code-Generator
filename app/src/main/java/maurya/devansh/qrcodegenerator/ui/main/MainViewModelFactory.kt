package maurya.devansh.qrcodegenerator.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import maurya.devansh.qrcodegenerator.data.repository.QrCodeRepository
import maurya.devansh.qrcodegenerator.di.module.AppModule

/**
 * Created by devansh on 12/05/22.
 */

class MainViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(QrCodeRepository(AppModule.networkService)) as T
    }
}