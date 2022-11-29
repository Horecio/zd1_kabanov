package com.example.zad1_kabanov

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var sharedd: SharedPreferences
    lateinit var userName: TextView
    lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main22)
        userName=findViewById(R.id.TextViewone)
        result=findViewById(R.id.TextViewtwo)
        spinner=findViewById(R.id.sp)
        sharedd=getSharedPreferences("ACCOUNT_FILMS",MODE_PRIVATE)
        val l = sharedd.getString("MY_LOGIN_FILMS", "NONE")
        userName.setText(l).toString()


        val adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this, R.array.Films,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                val choose = resources.getStringArray(R.array.Films)
                result.setText(choose[position]).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }
}