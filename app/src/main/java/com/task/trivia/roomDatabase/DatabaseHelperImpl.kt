package com.task.trivia.roomDatabase

import com.task.trivia.model.DetailsModel

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override fun fetchAll(): MutableList<DetailsModel> {
        return appDatabase.detailsDao().fetchAll() as MutableList<DetailsModel>
    }

    override fun insert(task: DetailsModel?) {
        appDatabase.detailsDao().insert(task)
    }

    override fun delete(task: DetailsModel?) {
        appDatabase.detailsDao().delete(task)
    }

    override fun update(task: DetailsModel?) {
        appDatabase.detailsDao().update(task)
    }



}