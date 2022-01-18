package com.amandeep.activityresultcallback

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amandeep.activityresultcallback.databinding.ActivityResultBinding

const val RESULT="result"
const val RESULT_CODE=1001

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnResult.setOnClickListener {
            val data=binding.etResult.text.toString();
            val intent=Intent()
            intent.putExtra(RESULT,data)
            setResult(RESULT_CODE,intent)
            super.onBackPressed()
        }
    }
}