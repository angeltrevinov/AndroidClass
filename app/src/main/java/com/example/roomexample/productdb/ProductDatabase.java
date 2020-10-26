package com.example.roomexample.productdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Product.class}, version = 1)
@TypeConverters({DataRoomConverter.class})
public abstract class ProductDatabase extends RoomDatabase {

    public abstract ProductDao getProductDao();

    private static ProductDatabase INSTANCE;

    public static synchronized ProductDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabaseInstanceContext(context);
        }

        return INSTANCE;
    }

    public static ProductDatabase buildDatabaseInstanceContext(Context context) {
        return Room.databaseBuilder(
                context,
                ProductDatabase.class,
                Constants.DB_NAME
        ).allowMainThreadQueries().build();
    }
}
