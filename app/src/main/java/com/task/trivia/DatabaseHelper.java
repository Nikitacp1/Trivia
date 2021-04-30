package com.task.trivia;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
interface DatabaseHelper {

    @Query("SELECT * FROM detailsmodel")
    List<DetailsModel> fetchAll();

    @Insert
    void insert(DetailsModel task);

    @Delete
    void delete(DetailsModel task);

    @Update
    void update(DetailsModel task);

}
