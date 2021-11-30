package com.example.pacoteentrega.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pacoteentrega.databinding.ActivityMainBinding
import com.example.pacoteentrega.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.nav_header_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        mViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mViewModel.buscardados()
        observe()
    }


    fun observe() {
        mViewModel.usuario.observe(this, {
            codigo_usuario.text = it.usuario
            nome_usuario.text = it.nome
            filial_usuario.text = it.filial
        })
        mViewModel.error.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }


    override fun onBackPressed() {}
}