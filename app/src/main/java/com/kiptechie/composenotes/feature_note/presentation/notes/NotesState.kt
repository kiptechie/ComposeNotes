package com.kiptechie.composenotes.feature_note.presentation.notes

import com.kiptechie.composenotes.feature_note.data.domain.model.Note
import com.kiptechie.composenotes.feature_note.data.domain.util.NoteOrder
import com.kiptechie.composenotes.feature_note.data.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
