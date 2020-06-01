package com.sun_asterisk.clean_architecture_sample2.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun_asterisk.clean_architecture_sample2.presentation.movies.MoviesFragment
import com.sun_asterisk.clean_architecture_sample2.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.mainFrameLayout, MoviesFragment.newInstance())
            .commit()
    }
}
