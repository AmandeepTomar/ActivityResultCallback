package com.amandeep.activityresultcallback

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.amandeep.activityresultcallback.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


     val registerCallback =   registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback {
                it?.let {
                    val data=it.data
                    val code=it.resultCode
                   val value= data?.getStringExtra(RESULT)
                    Log.e("TAG","$value and result code is $code")
                    if (code== RESULT_CODE){
                        binding.etMain.text=value
                    }
                }
            })

        binding.button.setOnClickListener {
            val data=binding.etMain.text.toString()
            val intent = Intent(this,ResultActivity::class.java).apply {
                putExtra("data",data)
            }
            registerCallback.launch(intent)
        }

    }
}