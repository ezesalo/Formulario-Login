package com.ejercicios.formulariologin.fragments

import android.app.AlertDialog
import android.content.ContentValues.TAG
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.ejercicios.formulariologin.R
import com.ejercicios.formulariologin.Views.RegistroV2ViewModel

class RegistroV2Fragment : Fragment() {

    lateinit var v: View
    lateinit var nombreRegistro: EditText
    lateinit var apellidoRegistro: EditText
    lateinit var telefonoRegistro: EditText
    lateinit var emailRegistro: EditText
    lateinit var passwordRegistro: EditText
    lateinit var registroButton: Button
    private val viewModelRegistro: RegistroV2ViewModel by viewModels()

    companion object {
        fun newInstance() = RegistroV2Fragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.registro_v2_fragment, container, false)
        nombreRegistro = v.findViewById(R.id.nombreRegistroTxt)
        apellidoRegistro = v.findViewById(R.id.apellidoRegistroTxt)
        telefonoRegistro = v.findViewById(R.id.telefonoRegistroTxt)
        emailRegistro = v.findViewById(R.id.emailRegistroTxt)
        passwordRegistro = v.findViewById(R.id.passwordRegistroTxt)
        registroButton = v.findViewById(R.id.RegistroButton)

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onStart() {
        super.onStart()

        registroButton.setOnClickListener(){
            val nombre: String = nombreRegistro.text.toString()
            val apellido: String = apellidoRegistro.text.toString()
            val telefono: String = telefonoRegistro.text.toString()
            val email: String =  emailRegistro.text.toString()
            val password: String = passwordRegistro.text.toString()

            if ( viewModelRegistro.camposCompletos(nombre, apellido, telefono, email, password)){

                    viewModelRegistro.registrar(nombre, apellido, telefono, email, password, v, showAlert())

            }else{
             showAlertEmpty()
            }
        }
    }

    fun showAlert(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error en el Registro")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    fun showAlertEmpty(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error en el Registro")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}