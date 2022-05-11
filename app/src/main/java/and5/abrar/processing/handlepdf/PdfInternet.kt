package and5.abrar.processing.handlepdf

import and5.abrar.processing.R
import android.content.Context
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import kotlinx.android.synthetic.main.activity_pdf_assets.*
import kotlinx.android.synthetic.main.activity_pdf_internet.*
import java.io.File

class PdfInternet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_internet)
        checkPdf()
    }
    fun showpdfinternet(file: File){
        viewpdfinternet.fromFile(file)
            .defaultPage(0)
            .spacing(10)
            .load()
    }
    fun getpdfurl():String{
        return "https://kotlinlang.org/assets/kotlin-media-kit.pdf"
    }
    private fun downloadPdfFromInternet(url: String, dirPath: String, fileName: String) {
        PRDownloader.download(
            url,
            dirPath,
            fileName
        ).build()
            .start(object : OnDownloadListener {
                override fun onDownloadComplete() {
                    Toast.makeText(this@PdfInternet, "downloadComplete", Toast.LENGTH_LONG)
                        .show()
                    val downloadedFile = File(dirPath, fileName)
                    showpdfinternet(downloadedFile)
                }

                override fun onError(error: com.downloader.Error?) {
                    Toast.makeText(
                        this@PdfInternet,
                        "Error in downloading file : $error",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            })
    }

    fun getRootDirPath(context: Context): String {
        return if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
            val file: File = ContextCompat.getExternalFilesDirs(
                context.applicationContext,
                null
            )[0]
            file.absolutePath
        } else {
            context.applicationContext.filesDir.absolutePath
        }
    }

    fun checkPdf(){
        val  fileName = "file.pdf"
        downloadPdfFromInternet(getpdfurl(),getRootDirPath(this),fileName)
    }
}