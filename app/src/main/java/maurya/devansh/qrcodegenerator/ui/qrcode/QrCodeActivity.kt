package maurya.devansh.qrcodegenerator.ui.qrcode

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import maurya.devansh.qrcodegenerator.R
import maurya.devansh.qrcodegenerator.databinding.ActivityQrCodeBinding

class QrCodeActivity : AppCompatActivity() {

    companion object {
        private const val INTENT_EXTRA_QR_CODE_URL = "qr_code_url"

        fun getStartIntent(context: Context, qrCodeUrl: ByteArray): Intent =
            Intent(context, QrCodeActivity::class.java).apply {
                putExtra(INTENT_EXTRA_QR_CODE_URL, qrCodeUrl)
            }
    }

    private val binding by lazy { ActivityQrCodeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        title = "Your QR Code"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val qrCodeUrl = intent?.getByteArrayExtra(INTENT_EXTRA_QR_CODE_URL)
        Glide.with(this)
            .load(qrCodeUrl)
            .thumbnail(Glide.with(this).load(R.drawable.placeholder))
            .into(binding.ivQrCode)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}