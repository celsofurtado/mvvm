package br.com.fiap.imc_mvvm_prof

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import br.com.fiap.imc_mvvm_prof.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        mainViewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)

        binding.sliderPeso.addOnChangeListener { slider, value, fromUser ->
            mainViewModel.peso.value = value.toDouble()
        }

        binding.sliderAltura.addOnChangeListener { slider, value, fromUser ->
            mainViewModel.altura.value = value.toDouble()
        }

        mainViewModel.peso.observe(this) {
            mainViewModel.calculaImc()
            binding.tvImc.text = String.format("%.2f", mainViewModel.imc.value)
        }

        mainViewModel.altura.observe(this) {
            mainViewModel.calculaImc()
            binding.tvImc.text = String.format("%.2f", mainViewModel.imc.value)
        }

        binding.textViewNumber.addTextChangedListener {
            Log.i("xpto", binding.editTextNumber.text.toString())
        }

    }
}