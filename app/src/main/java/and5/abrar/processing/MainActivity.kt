package and5.abrar.processing

import and5.abrar.processing.handleimage.HandleImage
import and5.abrar.processing.handlepdf.HandlePdf
import and5.abrar.processing.handlevideo.Handlingvideoplayer
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_handlepdf.setOnClickListener {
            startActivity(Intent(this, HandlePdf::class.java))
        }
        btn_handlevideo.setOnClickListener {
            startActivity(Intent(this, Handlingvideoplayer::class.java))
        }
        btn_handleimage.setOnClickListener {
            startActivity(Intent(this, HandleImage::class.java))
        }

    }
}