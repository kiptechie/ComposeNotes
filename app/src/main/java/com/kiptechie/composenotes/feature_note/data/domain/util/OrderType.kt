package com.kiptechie.composenotes.feature_note.data.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
