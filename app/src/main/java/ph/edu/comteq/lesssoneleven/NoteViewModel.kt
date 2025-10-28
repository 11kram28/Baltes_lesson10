package ph.edu.comteq.lesssoneleven

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val noteDao: NoteDao = AppDatabase.getDatabase(application).noteDao()

    // Track what user is search for
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    // show all notes OR notes that match the query
//    val allNotes: Flow<List<Note>> = noteDao.getAllNotes()

    val allNotes: Flow<List<Note>> = searchQuery.flatMapLatest { query ->
        if (query.isEmpty()) { // or isBlack
            noteDao.getAllNotes()    // show all notes
        } else {
            noteDao.searchNotes(query)  // show only notes that match the query
        }
    }

    // call this when user types in the search query
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }


    // call this to clear search query
    fun clearSearch() {
        _searchQuery.value = ""
    }




    fun insert(note: Note) = viewModelScope.launch {
        noteDao.insertNote(note)
    }

    fun update(note: Note) = viewModelScope.launch {
        noteDao.updateNote(note)
    }

    fun delete(note: Note) = viewModelScope.launch {
        noteDao.deleteNote(note)
    }


}