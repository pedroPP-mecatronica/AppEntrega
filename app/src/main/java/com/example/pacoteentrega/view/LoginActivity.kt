package com.example.pacoteentrega.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pacoteentrega.R
import com.example.pacoteentrega.data.constants.ConstantsNavigation
import com.example.pacoteentrega.databinding.ActivityLoginBinding
import com.example.pacoteentrega.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityLoginBinding? = null
    private lateinit var mViewModel: LoginViewModel
    private var message: String = ConstantsNavigation.DATAERROR.NULL


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        mViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        listenerLogin()
        observe()
    }

    private fun listenerLogin() {
        binding?.loginBtnEnter?.setOnClickListener(this)
    }


    private fun limpaCache() {
        binding?.loginEditUser?.editText?.text?.clear()
        binding?.loginEditPassword?.editText?.text?.clear()
        message = ConstantsNavigation.DATAERROR.NULL
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.login_btn_enter -> enter()

        }
    }

    fun enter() {
        val usuario = binding?.loginEditUser?.editText?.text.toString()
        val senha = binding?.loginEditPassword?.editText?.text.toString()

        if (validationOK(usuario, senha)) {
            mViewModel.autenticacao(usuario, senha)
        } else {
            Toast.makeText(
                this,
                ConstantsNavigation.MENSAGEM_USUARIO.FALTA_DADOS,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun exibeErro(mensagem: String) {
        if (mensagem != ConstantsNavigation.DATAERROR.NULL) {
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }
    }

    private fun validationOK(usuario: String, senha: String): Boolean {
        if (usuario != ConstantsNavigation.DATAERROR.NULL && senha != ConstantsNavigation.DATAERROR.NULL)
            return true

        return false
    }

    fun observe() {
        mViewModel.login.observe(this, Observer {
            if (!it.status() || message != ConstantsNavigation.DATAERROR.NULL) {
                exibeErro(it.message())
                limpaCache()
            } else {
               startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
        })
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}