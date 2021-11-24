package com.example.pacoteentrega.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pacoteentrega.R
import com.example.pacoteentrega.databinding.ActivityLoginBinding
import com.example.pacoteentrega.viewmodel.LoginViewModel
import kotlinx.android.synthetic.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var mViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginBtnEnter.setOnClickListener(this)
        mViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.login_btn_enter) {
            login()
            observe()
        }
    }

    fun login() {
        val usuario = binding.loginEditUser.editText?.text.toString()
        val senha = binding.loginEditPassword.editText?.text.toString()
        mViewModel.autenticacao(usuario, senha)
    }

    fun observe() {
        mViewModel.login.observe(this, Observer {
            if (it) {

                startActivity(Intent(this, MainActivity::class.java))

            } else {
                Toast.makeText(this, "Falha no login", Toast.LENGTH_LONG).show()
            }
        })
    }
}