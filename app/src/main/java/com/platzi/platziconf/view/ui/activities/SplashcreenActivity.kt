package com.platzi.platziconf.view.ui.activities

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.platzi.platziconf.R
import kotlinx.android.synthetic.main.activity_splashcreen.*

class SplashcreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashcreen)
        setSupportActionBar(findViewById(R.id.toolbar))

       val animacion = AnimationUtils.loadAnimation(this, R.anim.animacion)
        ivLogoPlatziConf.startAnimation(animacion)

        val intent = Intent( this, MainActivity::class.java)

        animacion.setAnimationListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
        startActivity(intent)
                finish()
            }

            override fun onAnimationStart(animation: Animation?) {

            }

        } {
            
        })
    }
}