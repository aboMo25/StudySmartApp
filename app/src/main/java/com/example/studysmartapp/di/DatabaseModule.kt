package com.example.studysmartapp.di

import android.app.Application
import androidx.room.Room
import com.example.studysmartapp.data.local.AppDatabase
import com.example.studysmartapp.data.local.SessionDao
import com.example.studysmartapp.data.local.SubjectDao
import com.example.studysmartapp.data.local.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn (SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDataBase(
        application: Application
    ) :AppDatabase{
        return Room.databaseBuilder(
            context = application,
            klass = AppDatabase::class.java,
            name = "studysmart.db"
        ).build()
    }
    @Provides
    @Singleton
    fun provideSubjectDao(database: AppDatabase): SubjectDao {
        return database.subjectDao()
    }

    @Provides
    @Singleton
    fun provideTaskDaoDao(database: AppDatabase): TaskDao {
        return database.taskDao()
    }

    @Provides
    @Singleton
    fun provideSessionDao(database: AppDatabase): SessionDao {
        return database.sessionDao()
    }


}