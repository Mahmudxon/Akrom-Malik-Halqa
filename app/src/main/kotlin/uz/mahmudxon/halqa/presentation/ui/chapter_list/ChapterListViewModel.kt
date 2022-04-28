package uz.mahmudxon.halqa.presentation.ui.chapter_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.mahmudxon.halqa.business.domain.model.Chapter
import uz.mahmudxon.halqa.business.interactors.story.GetChapterList
import uz.mahmudxon.halqa.util.TAG
import javax.inject.Inject

@HiltViewModel
class ChapterListViewModel
@Inject constructor(
    private val getChapterList: GetChapterList
)  : ViewModel () {
    val chapters : MutableState<List<Chapter>> = mutableStateOf(ArrayList())
    val loading = mutableStateOf(false)
    var listScrollPosition = 0


    fun getChaptersList() {
        Log.d(TAG, "getChaptersList : $getChapterList")
        getChapterList.execute().onEach { dataState ->
            loading.value = dataState.loading
            dataState.data?.let {
                chapters.value = it
            }

            dataState.error?.let {
                Log.e(TAG, "getChaptersList: $it")
            }
        }
            .launchIn(viewModelScope)
    }

}