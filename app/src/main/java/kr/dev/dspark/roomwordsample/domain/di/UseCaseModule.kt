package kr.dev.dspark.roomwordsample.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.dev.dspark.roomwordsample.data.repository.WordRepository
import kr.dev.dspark.roomwordsample.domain.usecase.GetWordDeleteAllUseCase
import kr.dev.dspark.roomwordsample.domain.usecase.GetWordInsertUseCase
import kr.dev.dspark.roomwordsample.domain.usecase.GetWordSelectUseCase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetWordInsertUseCase(wordRepository: WordRepository) : GetWordInsertUseCase {
        return GetWordInsertUseCase(wordRepository)
    }

    @Provides
    @Singleton
    fun provideGetWordSelectUseCase(wordRepository: WordRepository) : GetWordSelectUseCase {
        return GetWordSelectUseCase(wordRepository)
    }

    @Provides
    @Singleton
    fun provideGetWordDeleteAllUseCase(wordRepository: WordRepository) : GetWordDeleteAllUseCase {
        return GetWordDeleteAllUseCase(wordRepository)
    }
}