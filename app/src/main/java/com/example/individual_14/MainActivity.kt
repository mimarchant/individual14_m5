package com.example.individual_14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.individual_14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var saldo = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonListo.setOnClickListener {
            when(binding.radioGroup.checkedRadioButtonId){
                R.id.radioButtonVerSaldo -> checkMoney()
                R.id.radioButtonIngresar -> addMoney()
                R.id.radioButtonRetirar -> withdrawMoney()
                R.id.radioButtonSalir -> finish()
            }
        }
    }
    private fun checkMoney() {
        Toast.makeText(applicationContext,"Su saldo es $saldo", Toast.LENGTH_SHORT).show()

    }

    private fun withdrawMoney() {
        val amount = binding.editTextMonto.text.toString().toInt()
        if(amount <= saldo){
            saldo -= amount
            clearAmount()
            showMessage("Su saldo ha sido retirado de manera exitosa.")
        }else{
            showMessage("No tiene saldo suficiente.")
        }
    }

    private fun clearAmount() {
        binding.editTextMonto.text.clear()
    }

    private fun addMoney() {
        saldo += binding.editTextMonto.text.toString().toInt()
        clearAmount()
        showMessage("Su saldo ha sido ingresado de manera exitosa.")
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }
}