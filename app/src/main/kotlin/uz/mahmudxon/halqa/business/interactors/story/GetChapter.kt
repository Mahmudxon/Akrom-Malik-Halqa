package uz.mahmudxon.halqa.business.interactors.story

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.mahmudxon.halqa.business.datasource.db.story.StoryDao
import uz.mahmudxon.halqa.business.datasource.db.story.StoryEntityMapper
import uz.mahmudxon.halqa.business.domain.data.DataState
import uz.mahmudxon.halqa.business.domain.model.Chapter

class GetChapter(
    private val dao: StoryDao,
    private val storyEntityMapper: StoryEntityMapper
) {
    fun execute(chapterNumber: Int): Flow<DataState<Chapter>> = flow {
        emit(DataState.loading())

        // just to show loading, cache is fast
        delay(timeMillis = 1000)
        try {
            val cacheStory = dao.getChapterById(id = chapterNumber)
            emit(DataState.success(storyEntityMapper.mapToDomainModel(cacheStory)))
        } catch (e: Exception) {
            emit(DataState.error(e.message ?: "Unknown Error"))
        }
    }
}