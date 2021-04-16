package ipvc.estg.cmtp1.db

import androidx.lifecycle.LiveData
import ipvc.estg.cmtp1.dao.NotasDao

import ipvc.estg.cmtp1.entities.Notas

class NotasRepository(private val notasDao: NotasDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allNotas: LiveData<List<Notas>> = notasDao.getNotas()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.


    suspend fun insert(notas: Notas) {
        notasDao.insert(notas)
    }
    suspend fun delete(notas: Notas) {
        notasDao.delete(notas)
    }
    suspend fun update(notas: Notas) {
        notasDao.update(notas)
    }

}