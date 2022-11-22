package kr.dev.dspark.roomwordsample.data.repository

import android.util.Log
import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.*
import kr.dev.dspark.roomwordsample.data.db.WordDao
import kr.dev.dspark.roomwordsample.data.model.WordEntity
import javax.inject.Inject

class WordRepositoryImpl @Inject constructor(private val wordDao: WordDao) : WordRepository {
    override suspend fun wordInsert(wordEntity: WordEntity) {
        wordDao.insert(wordEntity)
    }

    override suspend fun wordSelect(): List<WordEntity> {
        return wordDao.getAlphabetizedWords()
    }

    override suspend fun wordDeleteAll() {
        wordDao.deleteAll()
    }
}