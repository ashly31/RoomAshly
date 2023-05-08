package com.example.roomashly.BD

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomashly.Dao.PrimerDao
import com.example.roomashly.Entidad.PrimeraEntidad

@Database(entities = [PrimeraEntidad::class], version = 3)
abstract class PrimeraDatabase: RoomDatabase() {


    abstract fun PrimerDao(): PrimerDao?

    companion object {
        private var INSTANCE: PrimeraDatabase?= null

        val migration_1_2: Migration = object: Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE tblPrimera ADD COLUMN phone TEXT DEFAULT ''")
            }
        }
        fun getAppDatabase(context: Context): PrimeraDatabase? {

            if(INSTANCE == null ) {

                INSTANCE = Room.databaseBuilder<PrimeraDatabase>(
                    context.applicationContext, PrimeraDatabase::class.java, "AppDBB"
                )
                    .addMigrations(migration_1_2)
                    .allowMainThreadQueries()
                    .build()

            }
            return INSTANCE

        }
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}