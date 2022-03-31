package uz.mahmudxon.halqa.business.interactors.story

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.mahmudxon.halqa.business.datasource.db.story.StoryDao
import uz.mahmudxon.halqa.business.datasource.db.story.StoryEntityMapper
import uz.mahmudxon.halqa.business.domain.data.DataState
import uz.mahmudxon.halqa.business.domain.model.Chapter


class GetChapterList(
    private val dao: StoryDao,
    private val storyEntityMapper: StoryEntityMapper
) {
    fun execute(): Flow<DataState<List<Chapter>>> = flow {
        emit(DataState.loading())

        // just to show loading, cache is fast
        delay(timeMillis = 1000)
        try {
            val cacheStories = dao.getChapters()
            emit(DataState.success(cacheStories.map { storyEntityMapper.mapToDomainModel(it) }))
        } catch (e: Exception) {
            emit(DataState.error(e.message ?: "Unknown Error"))
        }
    }
}