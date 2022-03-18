package uz.mahmudxon.halqa.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.mahmudxon.halqa.business.datasource.db.AppDb

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    fun provideAppDb(@ApplicationContext context: Context): AppDb =
        Room.databaseBuilder(context, AppDb::class.java, "music.mp3")
            .createFromAsset("halqa.db")
            .allowMainThreadQueries()
            .build()

}