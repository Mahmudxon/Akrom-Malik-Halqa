package uz.mahmudxon.halqa.presentation.ui.chapter

import dagger.hilt.android.lifecycle.HiltViewModel
import uz.mahmudxon.halqa.business.interactors.story.GetChapter
import uz.mahmudxon.halqa.business.interactors.story.UpdateChapter
import javax.inject.Inject

@HiltViewModel
class ChapterViewModel
@Inject constructor(
    private val getChapter: GetChapter,
    private val updateChapter: UpdateChapter
)
{

}