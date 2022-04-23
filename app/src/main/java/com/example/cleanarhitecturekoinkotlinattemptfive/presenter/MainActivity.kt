package com.example.cleanarhitecturekoinkotlinattemptfive.presenter


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarhitecturekoinkotlinattemptfive.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity() {




    private val vm by viewModel<MainVIewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "onCreate: Activity created" )


        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)


        vm.resultLive.observe(this, Observer {
            dataTextView.text = it
        })

        sendButton.setOnClickListener {

            val text = dataEditView.text.toString()
            vm.save(text)

        }


        receiveButton.setOnClickListener {

            vm.load()
        }
    }
}