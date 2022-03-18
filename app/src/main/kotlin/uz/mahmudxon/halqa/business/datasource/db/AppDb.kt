package uz.mahmudxon.halqa.business.datasource.db

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.mahmudxon.halqa.business.datasource.db.story.StoryDao
import uz.mahmudxon.halqa.business.datasource.db.story.StoryEntity

@Database(entities = [StoryEntity::class], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun getStoryDao(): StoryDao
}