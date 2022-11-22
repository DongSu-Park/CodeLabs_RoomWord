package kr.dev.dspark.roomwordsample.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dev.dspark.roomwordsample.data.db.WordDatabase
import kr.dev.dspark.roomwordsample.data.repository.WordRepository
import kr.dev.dspark.roomwordsample.data.repository.WordRepositoryImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideWordRepository(wordDatabase: WordDatabase) : WordRepository {
        return WordRepositoryImpl(wordDatabase.wordDao())
    }
}