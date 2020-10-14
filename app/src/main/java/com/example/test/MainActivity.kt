package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.test.fragment.MineFragment
import com.example.test.fragment.PoetryFragment
import com.example.test.fragment.ZandingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        poetry_rb_main.isChecked = true
        ChangeTab(PoetryFragment())
        poetry_rb_main.setOnClickListener(this)
        zanding_rb_main.setOnClickListener(this)
        mine_rb_main.setOnClickListener(this)
    }

    fun ChangeTab(fragment: Fragment, container: Int = R.id.container_main) {
        supportFragmentManager.beginTransaction().replace(container, fragment).addToBackStack(null)
            .commitAllowingStateLoss()
    }

    override fun onClick(v: View?) {
        when (v) {
            poetry_rb_main -> {
                ChangeTab(PoetryFragment())
            }
            zanding_rb_main -> {
                ChangeTab(ZandingFragment())
            }
            mine_rb_main -> {
                ChangeTab(MineFragment())
            }
        }
    }
}