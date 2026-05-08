package com.masnoi.journalapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.masnoi.journalapp.data.JournalDatabase
import com.masnoi.journalapp.data.JournalEntry
import com.masnoi.journalapp.data.JournalRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class JournalViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: JournalRepository
    val allEntries: StateFlow<List<JournalEntry>>

    init {
        val journalDao = JournalDatabase.getDatabase(application).journalDao()
        repository = JournalRepository(journalDao)
        allEntries = repository.getAllEntries().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    }

    fun insert(entry: JournalEntry) = viewModelScope.launch {
        repository.insertEntry(entry)
    }

    fun update(entry: JournalEntry) = viewModelScope.launch {
        repository.updateEntry(entry)
    }

    fun delete(entry: JournalEntry) = viewModelScope.launch {
        repository.deleteEntry(entry)
    }

    suspend fun getEntryById(id: Int): JournalEntry? {
        return repository.getEntryById(id)
    }
}
