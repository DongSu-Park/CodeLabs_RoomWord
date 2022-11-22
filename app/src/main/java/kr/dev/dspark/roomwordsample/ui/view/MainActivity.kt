package kr.dev.dspark.roomwordsample.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kr.dev.dspark.roomwordsample.data.model.WordEntity
import kr.dev.dspark.roomwordsample.databinding.ActivityMainBinding
import kr.dev.dspark.roomwordsample.ui.adapter.WordListAdapter
import kr.dev.dspark.roomwordsample.ui.viewmodel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainViewModel
    private lateinit var mAdapter: WordListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this).get(MainViewModel::class.java)

        // set recyclerview
        setRecyclerView()
        initObserver()
        initListener()

        vm.wordSelect()
    }

    private val activityResultCallback =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val data = it.data
                val inputWord = data?.getStringExtra("Reply") ?: ""
                val isClear = data?.getBooleanExtra("Clear", false)

                if (inputWord.isNotEmpty()) {
                    val wordEntity = WordEntity(inputWord)
                    vm.wordInsert(wordEntity)
                    vm.wordSelect()
                }

                if (isClear!!) {
                    vm.wordDeleteAll()
                    vm.wordSelect()
                }
            }
        }

    private fun initListener() {
        binding.layoutFloatingInsert.setOnClickListener {
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            activityResultCallback.launch(intent)
        }
    }

    private fun initObserver() {
        vm.allWords.observe(this) { items ->
            items.let {
                mAdapter.submitList(it)
            }
        }
    }

    private fun setRecyclerView() {
        mAdapter = WordListAdapter()
        binding.rvWordList.adapter = mAdapter
        binding.rvWordList.layoutManager = LinearLayoutManager(this)
    }
}