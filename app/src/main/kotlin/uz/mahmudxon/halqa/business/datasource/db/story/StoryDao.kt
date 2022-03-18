package uz.mahmudxon.halqa.business.datasource.db.story

import androidx.room.Dao
import androidx.room.Query
import uz.mahmudxon.halqa.business.datasource.db.BaseDao

@Dao
interface StoryDao : BaseDao<StoryEntity> {
    @Query("select id, title, description from Halqa")
    suspend fun getChapters(): List<StoryEntity>

    @Query("select * from Halqa where id = :id")
    suspend fun getChapterById(id: Int): StoryEntity
}