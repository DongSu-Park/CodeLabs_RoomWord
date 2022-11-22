package kr.dev.dspark.roomwordsample.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import kr.dev.dspark.roomwordsample.data.model.WordEntity

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    suspend fun getAlphabetizedWords(): List<WordEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(wordEntity: WordEntity)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}