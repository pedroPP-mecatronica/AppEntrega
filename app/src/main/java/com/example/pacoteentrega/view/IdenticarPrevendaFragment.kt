package com.example.pacoteentrega.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pacoteentrega.R
import com.example.pacoteentrega.viewmodel.IdenticarPrevendaViewModel

class IdenticarPrevendaFragment : Fragment() {

    companion object {
        fun newInstance() = IdenticarPrevendaFragment()
    }

    private lateinit var viewModel: IdenticarPrevendaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.identicar_prevenda_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(IdenticarPrevendaViewModel::class.java)
    }

}