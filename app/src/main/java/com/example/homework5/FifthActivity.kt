package com.example.homework5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.data.Data

class FifthActivity constructor() : AppCompatActivity() {
    private var TEXTVIEW_STATE_KEY = "TEXTVIEW_STATE_KEY"
    val LOG_TAG = "myLogs"
    private lateinit var deliverResultButton: Button
    private lateinit var saveButton: Button
    private lateinit var editTextOn5: EditText
    private lateinit var editText: EditText
    private lateinit var textView: TextView
    private lateinit var textOnSave: Data


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fifth_activity)
        initViews()
        initListener()
        Log.d(LOG_TAG, "onCreate")
    }

    private fun initViews() {
        deliverResultButton = findViewById(R.id.deliver_result_button)
        saveButton = findViewById(R.id.button_save_result)
        editTextOn5 = findViewById(R.id.edit_text_on_fifth)
        editText = findViewById(R.id.edit_text)
        textView = findViewById(R.id.text_view_on_fifth)
    }

    private fun dataTransfer() {
        val stringToPassBack: String = editTextOn5.getText().toString()
        val intentFifthActivity = Intent(this, ThirdActivity::class.java)
        intentFifthActivity.putExtra("keyName", stringToPassBack)
        setResult(RESULT_OK, intentFifthActivity)
        finish()
    }

    private fun initListener() {
        deliverResultButton.setOnClickListener {
            dataTransfer()
        }
        saveButton.setOnClickListener {
            textOnSave = collectUiData()
            textView.setText(textOnSave.value)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(LOG_TAG, "onSaveInstanceState")
        outState.putParcelable(TEXTVIEW_STATE_KEY, collectUiData())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        textView.text = savedInstanceState.getParcelable<Data>(TEXTVIEW_STATE_KEY)?.value.toString()
        Log.d(LOG_TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
    }

    private fun collectUiData() = Data(
        editText.text.toString()
    )
}