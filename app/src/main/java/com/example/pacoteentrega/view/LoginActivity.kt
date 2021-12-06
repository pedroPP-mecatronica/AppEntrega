package com.example.pacoteentrega.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pacoteentrega.R
import com.example.pacoteentrega.data.constants.Navigation
import com.example.pacoteentrega.databinding.ActivityLoginBinding
import com.example.pacoteentrega.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityLoginBinding? = null
    private lateinit var mViewModel: LoginViewModel
    private var message: String = Navigation.DATANULL.NULL


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        mViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
       // binding?.loginEditTextUser?.addTextChangedListener (watcher)
        listenerLogin()
        observe()
    }

//    private val watcher = object : TextWatcher{
//        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            TODO("Not yet implemented")
//        }
//
//        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            TODO("Not yet implemented")
//        }
//
//        override fun afterTextChanged(s: Editable?) {
//            TODO("Not yet implemented")
//        }
//    }

    private fun listenerLogin() {
        binding?.loginBtnEnter?.setOnClickListener(this)
    }


    private fun limpaCache() {
        binding?.loginEditUser?.editText?.text?.clear()
        binding?.loginEditPassword?.editText?.text?.clear()
        message = Navigation.DATANULL.NULL
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.login_btn_enter -> enter()

        }
    }

    fun enter() {
        val usuario = binding?.loginEditUser?.editText?.text.toString()
        val senha = binding?.loginEditPassword?.editText?.text.toString()
        mViewModel.autenticacao(usuario, senha)
    }

    private fun exibeErro(mensagem: String) {
        if (mensagem != Navigation.DATANULL.NULL) {
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
        }
    }


    fun observe() {
        mViewModel.login.observe(this, {
            if (!it.status() || message != Navigation.DATANULL.NULL) {
                exibeErro(it.message())
                limpaCache()
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        })
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}