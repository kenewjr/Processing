package and5.abrar.processing.handlepdf

import and5.abrar.processing.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_handle_pdf.*

class HandlePdf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handle_pdf)
       handlepdfwebview.setOnClickListener {
           startActivity(Intent(this,PdfWebview::class.java))
       }
        handlepdfAssets.setOnClickListener {
            startActivity(Intent(this,PdfAssets::class.java))
        }
        handlepdfstorage.setOnClickListener {
            startActivity(Intent(this,PdfStorage::class.java))
        }
        handlepdfinternet.setOnClickListener {
            startActivity(Intent(this,PdfInternet::class.java))
        }
    }
}