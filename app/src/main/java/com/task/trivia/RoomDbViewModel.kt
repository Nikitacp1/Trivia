package com.task.trivia

import android.app.Application
import androidx.lifecycle.*
import com.task.trivia.model.DetailsModel
import kotlinx.coroutines.launch
import com.task.trivia.roomDatabase.DatabaseHelper

internal class RoomDBViewModel(private val dbHelper: DatabaseHelper, application: Application) : AndroidViewModel(application) {

    private val gameList = MutableLiveData<List<DetailsModel>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            try {
                val detailsFromDb = dbHelper.fetchAll()

                gameList.postValue(detailsFromDb)

                // here you have your usersFromDb

            } catch (e: Exception) {
                // handler error
            }
        }
    }

   /* fun getList(): LiveData<DetailsModel> {
        return gameList
    }*/

}