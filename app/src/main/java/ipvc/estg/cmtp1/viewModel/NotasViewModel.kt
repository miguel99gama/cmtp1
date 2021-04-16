package ipvc.estg.cmtp1.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import ipvc.estg.cmtp1.db.NotasRepository
import ipvc.estg.cmtp1.entities.Notas
import ipvc.estg.cmtp1.db.NotasDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotasViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: NotasRepository

    val allNotas: LiveData<List<Notas>>

    init{
        val notes = NotasDB.getDatabase(application, viewModelScope).notasDao()
        repository = NotasRepository(notes)
        allNotas = repository.allNotas
    }

    fun insert(nota: Notas) = viewModelScope.launch {
        repository.insert(nota)
    }
    fun delete(nota: Notas) = viewModelScope.launch {
        repository.delete(nota)
    }
    fun update(nota: Notas) = viewModelScope.launch {
        repository.update(nota)
    }

}