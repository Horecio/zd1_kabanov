package com.example.zad1_kabanov

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    private lateinit var login: EditText
    private lateinit var password: EditText
    private lateinit var shared: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login = findViewById(R.id.editText1)
        password = findViewById(R.id.editText2)
        shared = getSharedPreferences("Account_FILMS", MODE_PRIVATE)
        if (shared.contains("MY_LOGIN_FILM") && shared.contains("MY_PASSWORD_FILM")){
            val log = shared.getString("MY_LOGIN_FILM", "NONE")
            val pass = shared.getString("MY_PASSWORD_FILM", "NONE")
            login.setText(log)
            password.setText(pass)
        }
    }
    fun clicable() {
        if(!shared.contains("MY_LOGIN_FILM") && !shared.contains("MY_PASSWORD_FILM")) {
            if (login.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
                val editing = shared.edit()
                editing.putString("MY_LOGIN_FILM", login.text.toString())
                editing.putString("MY_PASSWORD_FILM", password.text.toString())
                editing.apply()
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
            else {
                AlertDialog.Builder(this)
                    .setTitle("Error").setMessage("Поля не заполнены!")
                    .setPositiveButton("ok", null)
                    .create()
                    .show()
            }
        }
        else {
            val Logins = shared.getString("MY_LOGIN_FILM", "NONE")
            val pass = shared.getString("MY_PASSWORD_FILM", "NONE")
            login.setText(Logins)
            password.setText(pass)
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    fun clickable(view: View) {}
}

