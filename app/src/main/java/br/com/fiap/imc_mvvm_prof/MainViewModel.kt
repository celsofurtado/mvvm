package br.com.fiap.imc_mvvm_prof

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class MainViewModel : ViewModel() {

    private val mPeso = MutableLiveData<Double>()
    var peso = mPeso

    private val mAltura = MutableLiveData<Double>()
    var altura = mAltura

    private val mImc = MutableLiveData<Double>()
    var imc = mImc

    init {
        mPeso.value = 0.0
        mAltura.value = 0.0
        mImc.value = 0.0
    }

    fun calculaImc() {

        val pesoNovo = peso.value!!
        Log.i("xpto", "Peso:$pesoNovo")
        val alturaNova = altura.value!! / 100.0
        Log.i("xpto", "Altura:$alturaNova")

        //mImc.value = pesoNovo / (alturaNova.pow(2))

        mImc.value = peso.value!! / (altura.value!!/100).pow(2.0)

    }

}