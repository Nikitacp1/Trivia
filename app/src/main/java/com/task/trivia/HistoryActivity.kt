package com.task.trivia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HistoryActivity : AppCompatActivity() {

    private lateinit var rvCrickters : RecyclerView
    private lateinit var btGame : Button
    private lateinit var viewModel: RoomDBViewModel
    private lateinit var adapter : GameAdapter
    private var gameList : ArrayList<DetailsModel> = ArrayList<DetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_history)

        rvCrickters = findViewById(R.id.rvCrickters)
        btGame = findViewById(R.id.btGame)
        adapter = GameAdapter(gameList)

        rvCrickters.layoutManager = LinearLayoutManager(this@HistoryActivity)

        val dividerItemDecoration = DividerItemDecoration(rvCrickters.context,
                LinearLayoutManager(this@HistoryActivity).orientation)
        rvCrickters.addItemDecoration(dividerItemDecoration)

        rvCrickters.adapter = adapter

        lifecycleScope.launch(Dispatchers.Default){
            val dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(this@HistoryActivity!!))
            gameList.clear()
            gameList = dbHelper.fetchAll() as ArrayList<DetailsModel>
            adapter.setResults(gameList)

        }

        btGame.setOnClickListener {
            startActivity(Intent(this@HistoryActivity, MainActivity::class.java))
            finish()
        }


    }



}