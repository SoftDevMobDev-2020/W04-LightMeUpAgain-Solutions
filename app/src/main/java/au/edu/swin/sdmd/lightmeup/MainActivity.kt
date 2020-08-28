package au.edu.swin.sdmd.lightmeup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel

class MainActivity : AppCompatActivity() {

    val imageViewModel: ImageViewModel by viewModels()

    companion object {
        private const val KEY_IMAGE = "IMAGE"
    }
    


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageDrawable(getDrawable(imageViewModel.state))

        /*savedInstanceState?.let {
            state = it.getInt(KEY_IMAGE)
            imageView.setImageDrawable(getDrawable(state))
        }*/


        imageView.setOnLongClickListener {
            // update the image state
            imageViewModel.nextImage()
            // then show it on screen
            imageView.setImageDrawable(getDrawable(imageViewModel.state))
            true
        }
    }

    /*override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_IMAGE, state)
    }*/
}

class ImageViewModel: ViewModel() {
    // this keeps track of the current image
    var state = R.drawable.ic_assignment_turned_in_24px

    fun nextImage() {
        state = when (state) {
            R.drawable.ic_assignment_turned_in_24px -> R.drawable.ic_assignment_late_24px
            R.drawable.ic_assignment_late_24px -> R.drawable.ic_assignment_turned_in_24px
            else -> R.drawable.ic_assignment_turned_in_24px
        }
    }

}