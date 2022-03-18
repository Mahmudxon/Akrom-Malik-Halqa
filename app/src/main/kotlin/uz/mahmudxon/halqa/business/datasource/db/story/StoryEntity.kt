package uz.mahmudxon.halqa.business.datasource.db.story

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Halqa")
data class StoryEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    var story: String? = null
)