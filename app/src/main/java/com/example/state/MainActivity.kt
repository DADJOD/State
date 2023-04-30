package com.example.state

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var count = 0
    lateinit var buttonFirst: Button
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonFirst = findViewById(R.id.button1)
        textView = findViewById(R.id.textView)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT)
        }

        textView.text = "$count"
        buttonFirst.setOnClickListener(this)
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, count)
    }

    override fun onClick(v: View?) {
        count++
        textView.text = "$count"
    }

    companion object {
        const val KEY_COUNT = "COUNT"
    }

//    override fun onClick(view: View?) {
//        count++
//        textView.text = "" + count
//    }
}