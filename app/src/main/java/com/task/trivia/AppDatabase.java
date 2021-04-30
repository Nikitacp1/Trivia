package com.task.trivia;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DetailsModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DatabaseHelper detailsDao();
}