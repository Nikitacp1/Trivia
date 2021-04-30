package com.task.trivia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SummaryActivity : AppCompatActivity() {

    lateinit var tvName : TextView
    lateinit var tvCricketerAnswer : TextView
    lateinit var tvColorSelected : TextView
    lateinit var btFinish : Button
    lateinit var btHistory : Button

    var name = ""
    var cricketer = ""
    var colors = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_summary)

        var i = intent.extras
        name = i?.getString("name","").toString()
        cricketer = i?.getString("cricketer","").toString()
        colors = i?.getString("colors","").toString()

        tvName = findViewById(R.id.tvName)
        tvCricketerAnswer = findViewById(R.id.tvCricketerAnswer)
        tvColorSelected = findViewById(R.id.tvColorSelected)
        btFinish = findViewById(R.id.btFinish)
        btHistory = findViewById(R.id.btHistory)

        tvName.text = "Hello $name"
        tvCricketerAnswer.text = cricketer
        tvColorSelected.text = colors


        btFinish.setOnClickListener {
            startActivity(Intent(this@SummaryActivity, MainActivity::class.java))
            finish()
        }


        btHistory.setOnClickListener {
            startActivity(Intent(this@SummaryActivity, HistoryActivity::class.java))
            finish()
        }

    }
}