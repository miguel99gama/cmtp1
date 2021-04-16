package ipvc.estg.cmtp1.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ipvc.estg.cmtp1.entities.Notas

@Dao
interface NotasDao {

    @Query("SELECT * FROM notas_table ORDER BY Id ASC")
    fun getNotas(): LiveData<List<Notas>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(notas: Notas)

    @Query("DELETE FROM notas_table")
    suspend fun deleteAll()

    @Delete()
    suspend fun delete(notas: Notas)

    @Update()
    suspend fun update(notas: Notas)
}