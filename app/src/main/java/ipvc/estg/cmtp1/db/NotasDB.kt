package ipvc.estg.cmtp1.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import ipvc.estg.cmtp1.dao.NotasDao
import ipvc.estg.cmtp1.entities.Notas
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Notas::class), version = 1, exportSchema = false)
public abstract class NotasDB : RoomDatabase() {

    abstract fun notasDao(): NotasDao

    private class WordDatabaseCallback(
            private val scope: CoroutineScope
    ): RoomDatabase.Callback() {

       override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var notasDao = database.notasDao()

                    notasDao.deleteAll()
/*
                    var notas = Notas(1, "gosto", "podia ser melhor")
                    var notas2 = Notas(2, "gosasasto", "podia seasasr melhor")
                    notasDao.insert(notas)
                    notasDao.insert(notas2)
*/
                }
            }
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: NotasDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): NotasDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        NotasDB::class.java,
                        "notas_database"
                ).build()


                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}

