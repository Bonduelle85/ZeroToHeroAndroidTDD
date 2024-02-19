package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.LinearLayout.*
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val linearLayout = LinearLayout(this)
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        linearLayout.layoutParams = params
        linearLayout.orientation = HORIZONTAL
        linearLayout.gravity = Gravity.CENTER

        val tv = TextView(this)
        tv.gravity = Gravity.CENTER
        tv.id = R.id.titleTextView
        tv.text = getString(R.string.i_am_an_android_developer)

        linearLayout.addView(tv)

        setContentView(linearLayout)
//        setContentView(R.layout.activity_main)
    }
}