package com.kiptechie.composenotes.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kiptechie.composenotes.feature_note.data.domain.model.Note
import com.kiptechie.composenotes.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.kiptechie.composenotes.feature_note.presentation.notes.NotesScreen
import com.kiptechie.composenotes.feature_note.presentation.util.Screen
import com.kiptechie.composenotes.ui.theme.ComposeNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNotesTheme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.NotesScreen.route
                    ) {
                        composable(route = Screen.NotesScreen.route) {
                            NotesScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AddEditNotesScreen.route +
                                    "?${Note.NOTE_ID_EXTRA}={${Note.NOTE_ID_EXTRA}}&${Note.NOTE_COLOR_EXTRA}={${Note.NOTE_COLOR_EXTRA}}",
                            arguments = listOf(
                                navArgument(
                                    name = Note.NOTE_ID_EXTRA
                                ) {
                                    type = NavType.IntType
                                    defaultValue = Note.NO_NOTE_OR_COLOR_ID
                                },
                                navArgument(
                                    name = Note.NOTE_COLOR_EXTRA
                                ) {
                                    type = NavType.IntType
                                    defaultValue = Note.NO_NOTE_OR_COLOR_ID
                                }
                            )
                        ) {
                            val color = it.arguments?.getInt(Note.NOTE_COLOR_EXTRA)
                                ?: Note.NO_NOTE_OR_COLOR_ID
                            AddEditNoteScreen(
                                navController = navController,
                                noteColor = color
                            )
                        }
                    }
                }
            }
        }
    }
}
