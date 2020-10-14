package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PoetryDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poetry_details)
        val poetryId = intent.getIntExtra("poetryId", 1)
    }
}