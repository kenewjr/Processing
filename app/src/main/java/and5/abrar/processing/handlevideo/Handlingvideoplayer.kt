package and5.abrar.processing.handlevideo

import and5.abrar.processing.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import kotlinx.android.synthetic.main.activity_handlingvideoplayer.*

class Handlingvideoplayer : AppCompatActivity() {
    private var mPlayer :ExoPlayer?=null
    private val videoUrl  = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handlingvideoplayer)
        view()
    }
    fun view(){
        mPlayer = ExoPlayer.Builder(this).build()
        video.player = mPlayer
        mPlayer!!.setMediaSource(buildMediaSource())
        mPlayer!!.prepare()
    }
    private fun buildMediaSource(): MediaSource {
        // Create a data source factory.
        val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()

        // Create a progressive media source pointing to a stream uri.
        val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(videoUrl))

        return mediaSource
    }
   fun releasePlayer(){
       if(mPlayer==null){
           return
       }
       mPlayer!!.release()
       mPlayer=null
   }

    override fun onPause() {
        super.onPause()
        releasePlayer()
    }

    override fun onStop() {
        super.onStop()
        releasePlayer()
    }
}