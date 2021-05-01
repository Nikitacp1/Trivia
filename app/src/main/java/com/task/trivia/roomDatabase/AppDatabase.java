package com.task.trivia.roomDatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.task.trivia.model.DetailsModel;

@Database(entities = {DetailsModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DatabaseHelper detailsDao();
}