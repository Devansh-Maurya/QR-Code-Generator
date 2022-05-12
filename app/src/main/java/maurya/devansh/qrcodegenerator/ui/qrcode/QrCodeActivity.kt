package maurya.devansh.qrcodegenerator.ui.qrcode

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import maurya.devansh.qrcodegenerator.R
import maurya.devansh.qrcodegenerator.databinding.ActivityQrCodeBinding

class QrCodeActivity : AppCompatActivity() {

    companion object {
        private const val INTENT_EXTRA_QR_TEXT = "qr_text"

        fun getStartIntent(context: Context, qrText: String): Intent =
            Intent(context, QrCodeActivity::class.java).apply {
                putExtra(INTENT_EXTRA_QR_TEXT, qrText)
            }
    }

    private val binding by lazy { ActivityQrCodeBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<QrCodeActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        title = "Your QR Code"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Glide.with(this)
            .load(R.drawable.placeholder)
            .into(binding.ivQrCode)

        val qrText = intent?.getStringExtra(INTENT_EXTRA_QR_TEXT)
        viewModel.getQrCode(qrText.orEmpty())

        viewModel.qrCodeLiveData.observe(this) {
            Glide.with(this)
                .load(it)
                .thumbnail(Glide.with(this).load(R.drawable.placeholder))
                .into(binding.ivQrCode)
        }
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