package fr.uge.taupereflex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView


fun randomTaupe(taupe: ImageView){
    val horizontal = listOf(Gravity.LEFT, Gravity.CENTER_HORIZONTAL, Gravity.RIGHT)
    val vertical = listOf(Gravity.TOP, Gravity.CENTER_VERTICAL, Gravity.BOTTOM)
    val randPoseH=(0..2).random()
    val randPoseV=(0..2).random()

    val layoutParams = taupe.layoutParams as FrameLayout.LayoutParams
    layoutParams.gravity = horizontal[randPoseH] or vertical[randPoseV]
    taupe.layoutParams = layoutParams
    taupe.visibility = ImageView.VISIBLE}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val taupe = findViewById<ImageView>(R.id.taupe)
        val start = findViewById<Button>(R.id.start)
        val bientot = findViewById<TextView>(R.id.bientotText)
        val temps=0
        var debut = 0


        taupe.setOnClickListener(){
            var fin = System.currentTimeMillis().toInt()
            taupe.visibility = ImageView.GONE
            var temps = fin - debut
            bientot.setText("Temps : " + temps + " ms")
            bientot.visibility = TextView.VISIBLE

        }

        start.setOnClickListener(){
            var randTime= (1000..10000).random()
            bientot.setText("La taupe va sortir")
            bientot.visibility = TextView.VISIBLE

            taupe.postDelayed({
                randomTaupe(taupe)
                debut= System.currentTimeMillis().toInt()
                bientot.visibility = TextView.GONE
            }, randTime.toLong())


        }


    }
}