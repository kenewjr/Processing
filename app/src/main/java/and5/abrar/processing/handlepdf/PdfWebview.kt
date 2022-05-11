package and5.abrar.processing.handlepdf

import and5.abrar.processing.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_pdf_webview.*

class PdfWebview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_webview)
        loadpdfwebview()
    }
    fun loadpdfwebview(){
        viewwebview.webViewClient = WebViewClient()
        viewwebview.settings.setSupportZoom(true)
        viewwebview.settings.javaScriptEnabled = true
        viewwebview.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + "https://kotlinlang.org/assets/kotlin-media-kit.pdf\n")
    }
}