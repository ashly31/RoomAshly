package BD

import Dao.DaoPrimera
import Entidad.EntidadPrimera
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [EntidadPrimera::class], version = 3)
abstract class DatabasePrimer: RoomDatabase() {


abstract fun DaoPrimera(): DaoPrimera?

companion object {
    private var INSTANCE: DatabasePrimer?= null

    val migration_1_2: Migration = object: Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE tblPrimera ADD COLUMN phone TEXT DEFAULT ''")
        }
    }
    fun getAppDatabase(context: Context): DatabasePrimer? {

        if(INSTANCE == null ) {

            INSTANCE = Room.databaseBuilder<DatabasePrimer>(
                context.applicationContext, DatabasePrimer::class.java, "AppDBB"
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