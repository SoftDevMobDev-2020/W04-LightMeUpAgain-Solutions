package au.edu.swin.sdmd.lightmeup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    // this keeps track of the current image
    var state = R.drawable.ic_assignment_turned_in_24px

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setOnLongClickListener {
            // update the image state
            state = when (state) {
                R.drawable.ic_assignment_turned_in_24px -> R.drawable.ic_assignment_late_24px
                R.drawable.ic_assignment_late_24px -> R.drawable.ic_assignment_turned_in_24px
                else -> R.drawable.ic_assignment_turned_in_24px
            }
            // then show it on screen
            imageView.setImageDrawable(getDrawable(state))
            true
        }
    }
}