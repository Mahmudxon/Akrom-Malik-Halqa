package uz.mahmudxon.halqa.presentation.ui.chapter_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.mahmudxon.halqa.business.domain.model.Chapter
import uz.mahmudxon.halqa.business.interactors.story.GetChapterList
import javax.inject.Inject

@HiltViewModel
class ChapterListViewModel
@Inject constructor(
    private val getChapterList: GetChapterList
) {
    val chapters: MutableState<List<Chapter>> = mutableStateOf(ArrayList())
    val loading = mutableStateOf(false)
    var recipeListScrollPosition = 0


}