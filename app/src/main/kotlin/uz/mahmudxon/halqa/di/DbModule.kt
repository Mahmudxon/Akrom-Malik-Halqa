package uz.mahmudxon.halqa.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.mahmudxon.halqa.business.datasource.db.AppDb
import uz.mahmudxon.halqa.business.datasource.db.story.StoryDao
import uz.mahmudxon.halqa.business.datasource.db.story.StoryEntityMapper

@InstallIn(SingletonComponent::class)
@Module
object DbModule {

    @Provides
    fun provideAppDb(@ApplicationContext context: Context): AppDb =
        Room.databaseBuilder(context, AppDb::class.java, "music.mp3")
            .createFromAsset("halqa.db")
            .allowMainThreadQueries()
            .build()

    @Provides
    fun provideStoryDao(db: AppDb): StoryDao = db.getStoryDao()


    @Provides
    fun provideStoryMapper() = StoryEntityMapper()
}