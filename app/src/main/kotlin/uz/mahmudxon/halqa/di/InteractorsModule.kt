package uz.mahmudxon.halqa.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.mahmudxon.halqa.business.datasource.db.story.StoryDao
import uz.mahmudxon.halqa.business.datasource.db.story.StoryEntityMapper
import uz.mahmudxon.halqa.business.interactors.story.GetChapter
import uz.mahmudxon.halqa.business.interactors.story.GetChapterList
import uz.mahmudxon.halqa.business.interactors.story.UpdateChapter

@Module
@InstallIn(ViewModelComponent::class)
object InteractorsModule {

    @Provides
    fun provideGetChapterList(
        storyDao: StoryDao,
        storyEntityMapper: StoryEntityMapper
    ): GetChapterList = GetChapterList(storyDao, storyEntityMapper)


    @Provides
    fun provideGetChapter(storyDao: StoryDao, storyEntityMapper: StoryEntityMapper): GetChapter =
        GetChapter(storyDao, storyEntityMapper)

    @Provides
    fun provideUpdateChapter(storyDao: StoryDao, storyEntityMapper: StoryEntityMapper): UpdateChapter =
        UpdateChapter(storyDao, storyEntityMapper)

}