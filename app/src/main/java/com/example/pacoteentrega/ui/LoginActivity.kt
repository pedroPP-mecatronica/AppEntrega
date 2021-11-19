package com.example.pacoteentrega.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.get
import com.example.pacoteentrega.R
import com.example.pacoteentrega.databinding.ActivityLoginBinding
import com.example.pacoteentrega.infra.LoginService
import com.example.pacoteentrega.infra.RetrofitClient
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginBtnEnter.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val id = view?.id
        if (id == R.id.login_btn_enter) {
            login()
        }
    }

    fun login() {
        val usuario = binding.loginEditUser.editText?.text.toString()
        val senha = binding.loginEditPassword.editText?.text.toString()
        loginViewModel.autenticacao(usuario, senha)
    }

}