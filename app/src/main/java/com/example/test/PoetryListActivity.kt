package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_poetry_list.*

class PoetryListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poetry_list)
        val intent = intent.getStringExtra("itemStr")
        action_bar_poetry_list.setStyle { back, txt, share, collection ->
            back.setOnClickListener {
                finish()
            }
            txt.text = intent
            share.visibility = View.GONE
            collection.visibility = View.GONE
        }
    }
}