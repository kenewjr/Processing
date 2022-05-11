package and5.abrar.processing.handlepdf

import and5.abrar.processing.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pdf_assets.*

class PdfAssets : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_assets)
        showPdfFromAssets(getPdfName())
    }
    fun showPdfFromAssets(pdfname:String){
     viewpdfassets.fromAsset(pdfname)
         .password(null)
         .defaultPage(0)
         .onPageError { page,_ ->
             Toast.makeText(this,"halo",Toast.LENGTH_LONG).show()
         }
         .load()
    }
    fun getPdfName():String{
        return "SALINAN INMENDAGRI NO 06 TAHUN 2022 TENTANG PPKM JAWA BALI.pdf"
    }
}