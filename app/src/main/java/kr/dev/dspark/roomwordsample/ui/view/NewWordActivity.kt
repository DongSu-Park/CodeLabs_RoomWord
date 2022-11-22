package kr.dev.dspark.roomwordsample.ui.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kr.dev.dspark.roomwordsample.databinding.ActivityNewWordBinding

@AndroidEntryPoint
class NewWordActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNewWordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            if (binding.etWord.text.isEmpty()) {
                Toast.makeText(this, "단어를 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                val replyIntent = Intent()
                replyIntent.putExtra("Reply", binding.etWord.text.toString())
                setResult(RESULT_OK, replyIntent)
                finish()
            }
        }

        binding.btnClear.setOnClickListener {
            val clearIntent = Intent()
            clearIntent.putExtra("Clear", true)
            setResult(RESULT_OK, clearIntent)
            finish()
        }
    }
}