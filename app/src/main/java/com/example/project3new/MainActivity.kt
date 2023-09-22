package com.example.project3new

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    /**
     * Practice Arithmetic app main activity.
     * Test a user's ability to perform mathematical calculations of
     * various difficulty levels and of different operations.
     *
     * @author Kenna Edwards
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * onCreate of the MainActivity.kt. This is the NavHost.
         *
         * @property savedInstanceState - saved state of the variables
         */
        super.onCreate(savedInstanceState)
        Log.d("MainActivty.kt", "Program started")
        setContentView(R.layout.activity_main)
    }
}