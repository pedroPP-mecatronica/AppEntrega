package com.example.pacoteentrega.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pacoteentrega.data.constants.Navigation
import com.example.pacoteentrega.data.source.local.Cache
import com.example.pacoteentrega.data.source.remote.listener.PrevendaListener
import com.example.pacoteentrega.data.source.remote.models.mapper.DadosPreVendaModel
import com.example.pacoteentrega.data.source.remote.models.mapper.DadosUsuarioModel
import com.example.pacoteentrega.data.source.remote.repositorio.TipoEntregaOrdemEnumerador
import com.example.pacoteentrega.data.source.remote.repositorio.prevenda.PreVendaRepositorio
import java.util.*

class IdenticarPrevendaViewModel(application: Application) : AndroidViewModel(application) {

    private val mPreVendaRepositorio = PreVendaRepositorio(application)
    private val cache = Cache(application)

    private var mPreVenda = MutableLiveData<DadosPreVendaModel>()
    var preVenda: LiveData<DadosPreVendaModel> = mPreVenda

    private var mError = MutableLiveData<String>()
    var error: LiveData<String> = mError


    //Buscar de acordo com os dados Usuario
    private val dadosUsuario: DadosUsuarioModel = cache.getDadosCache(Navigation.LOGIN.DADOS_USUARIO)


    private var codigoEmpresa:String = dadosUsuario.codigoEmpresa
    private var guidFilial :String = dadosUsuario.guidFilial
    private var codigoFilial:String = dadosUsuario.codigoFilial
    var codigoPreVenda:String = ""

    //Armezanado no SharedPreferences
    private var codigoUsuario:String = cache.getString(Navigation.LOGIN.USUARIO)

    //
    private var dataHoje: Date = Calendar.getInstance().time

    private var tiposPreVenda: TipoEntregaOrdemEnumerador? = null
    private var qtdPorPagina:Int= 0
    private var paginaAtual:Int= 0


    fun buscarPreVenda() {

        val token = cache.getString(Navigation.LOGIN.TOKEN)

        mPreVendaRepositorio.buscarPreVenda(
            guidFilial,
            codigoPreVenda,
            token,
            object : PrevendaListener {
                override fun onSucessPreVenda(model: Any) {
//                    mPreVenda.value = model.codigoPreVenda?.let {
//                        DadosPreVendaModel(model.valor,
//                            it
//                        )
//                    }
                    }

                override fun onFailurePrevenda(message: String) {
                    mError.value = message
                }
            }
        )

    }

}