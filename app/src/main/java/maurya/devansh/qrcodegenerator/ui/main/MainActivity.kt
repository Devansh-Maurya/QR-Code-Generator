package maurya.devansh.qrcodegenerator.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import maurya.devansh.qrcodegenerator.databinding.ActivityMainBinding
import maurya.devansh.qrcodegenerator.ui.qrcode.QrCodeActivity

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel> { MainViewModelFactory() }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.qrCodeLiveData.observe(this) {
            startActivity(QrCodeActivity.getStartIntent(this, it))
        }

        binding.btGenerateQr.setOnClickListener {
            viewModel.getQrCodeUrl(binding.editText.text?.toString().orEmpty())
        }
    }
}