package maurya.devansh.qrcodegenerator.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import maurya.devansh.qrcodegenerator.databinding.ActivityMainBinding
import maurya.devansh.qrcodegenerator.ui.qrcode.QrCodeActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btGenerateQr.setOnClickListener {
            val qrText = binding.editText.text?.toString()

            if (!qrText.isNullOrEmpty()) {
                startActivity(QrCodeActivity.getStartIntent(this, qrText))
            } else {
                Toast.makeText(this, "Enter some text", Toast.LENGTH_SHORT).show()
            }
        }
    }
}