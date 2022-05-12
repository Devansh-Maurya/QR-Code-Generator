package maurya.devansh.qrcodegenerator.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import maurya.devansh.qrcodegenerator.databinding.ActivityMainBinding
import maurya.devansh.qrcodegenerator.ui.qrcode.QrCodeActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btGenerateQr.setOnClickListener {
            startActivity(
                QrCodeActivity.getStartIntent(
                    this,
                    binding.editText.text?.toString().orEmpty()
                )
            )
        }
    }
}