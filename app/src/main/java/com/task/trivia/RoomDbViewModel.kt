package com.task.trivia

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

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