package com.fazahidah.dodolan.database

import android.content.Context
import androidx.room.*

@Dao
interface DodolanDao

@Database(
    entities = [User::class, Penghutang::class, Product::class],
    version = 1,
    exportSchema = false
)
abstract class DodolanDatabase : RoomDatabase() {

    abstract val dodolanDao: DodolanDao

    companion object {
        private lateinit var instance: DodolanDatabase

        fun getDatabase(context: Context): DodolanDatabase {
            synchronized(DodolanDatabase::class.java) {
                if (!::instance.isInitialized) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DodolanDatabase::class.java,
                        "dodolan_database"
                    ).fallbackToDestructiveMigration().build()
                }

                return instance
            }
        }
    }
}