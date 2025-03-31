package com.vaibhavjoshi.demoapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.vaibhavjoshi.demoapplication.databinding.ActivityMainBinding

/*class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}*/

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isShowing = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set initial progress properties
        binding.progressCircular.apply {
            max = 100
            setProgressCompat(30, true) // Initial progress at 75%
        }

        // Toggle button click listener
        binding.toggleButton.setOnClickListener {
            if (isShowing) {
                hideProgress()
            } else {
                showProgress()
            }
            isShowing = !isShowing
        }
    }

    private fun showProgress() {
        binding.progressCircular.visibility = CircularProgressIndicator.VISIBLE

        // Optional: Simulate progress update
//        val handler = Handler(Looper.getMainLooper())
//        Thread {
//            for (i in 0..100 step 10) {
//                handler.post {
//                    binding.progressCircular.setProgressCompat(i, true)
//                }
//                Thread.sleep(500)
//            }
//        }.start()

        binding.progressCircular.setProgressCompat(50, true)

    }

    private fun hideProgress() {
        binding.progressCircular.visibility = CircularProgressIndicator.GONE
    }
}

