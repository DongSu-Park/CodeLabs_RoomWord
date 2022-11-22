package kr.dev.dspark.roomwordsample.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kr.dev.dspark.roomwordsample.data.model.WordEntity
import kr.dev.dspark.roomwordsample.domain.usecase.GetWordDeleteAllUseCase
import kr.dev.dspark.roomwordsample.domain.usecase.GetWordInsertUseCase
import kr.dev.dspark.roomwordsample.domain.usecase.GetWordSelectUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWordInsertUseCase: GetWordInsertUseCase,
    private val getWordSelectUseCase: GetWordSelectUseCase,
    private val getWordDeleteAllUseCase: GetWordDeleteAllUseCase
): ViewModel() {
    private val _allWords = MutableLiveData<List<WordEntity>>()
    val allWords : LiveData<List<WordEntity>> get() = _allWords

    fun wordInsert(wordEntity: WordEntity) {
        viewModelScope.launch {
            getWordInsertUseCase.execute(wordEntity)
        }
    }

    fun wordSelect() {
        viewModelScope.launch {
            val items = getWordSelectUseCase.execute()

            _allWords.postValue(items)
        }
    }

    fun wordDeleteAll() {
        viewModelScope.launch {
            getWordDeleteAllUseCase.execute()
        }
    }
}