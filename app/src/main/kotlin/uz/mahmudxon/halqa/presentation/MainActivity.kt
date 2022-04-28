package uz.mahmudxon.halqa.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.primarySurface
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import uz.mahmudxon.halqa.presentation.theme.BlueTheme
import uz.mahmudxon.halqa.presentation.ui.chapter_list.AllChapters
import uz.mahmudxon.halqa.presentation.ui.chapter_list.ChapterListViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val listViewModel: ChapterListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listViewModel.getChaptersList()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            BlueTheme {
                Scaffold(
                    backgroundColor = MaterialTheme.colors.primarySurface,
                    // bottomBar = { OwlBottomBar(navController = navController, tabs) }
                ) {
                    AllChapters(listViewModel.chapters.value)
                    {

                    }
                }
            }
        }
    }
}