package and5.abrar.processing.handlepdf

import and5.abrar.processing.R
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pdf_storage.*

class PdfStorage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_storage)
        selectpdfStorage()
    }
    fun showPdfFromStorage(uri:Uri){
        pdfstorage.fromUri(uri)
            .defaultPage(0)
            .spacing(10)
            .load()
    }
    fun selectpdfStorage(){
        val browserfile = Intent(Intent(Intent.ACTION_GET_CONTENT))
        browserfile.type ="application/pdf"
        browserfile.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(Intent.createChooser(browserfile,"select pdf"),99)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==99 && resultCode==Activity.RESULT_OK && data !=null){
            val selectpdf = data.data
            showPdfFromStorage(selectpdf!!)
        }
    }
}