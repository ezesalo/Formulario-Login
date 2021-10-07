package com.ejercicios.formulariologin.fragments

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.ejercicios.formulariologin.R
import com.ejercicios.formulariologin.Views.RegistroViewModel
import com.google.firebase.auth.FirebaseAuth

class RegistroFragment : Fragment() {

    lateinit var v: View
    lateinit var nombreRegistro: EditText
    lateinit var apellidoRegistro: EditText
    lateinit var telefonoRegistro: EditText
    lateinit var emailRegistro: EditText
    lateinit var passwordRegistro: EditText
    lateinit var registroButton: Button
    private val  viewModelRegistro: RegistroViewModel by viewModels()

    companion object {
        fun newInstance() = RegistroFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.registro_fragment, container, false)
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
        //Cambiar forma de instanciar al view model
       // viewModelRegistro = ViewModelProvider(this).get(RegistroViewModel::class.java)
        // TODO: Use the ViewModel
    }


    override fun onStart() {
        super.onStart()

        val nombre = nombreRegistro.text.toString()
        val apellido = apellidoRegistro.text.toString()
        val telefono = telefonoRegistro.text.toString()
        val email =  emailRegistro.text.toString()
        val password = passwordRegistro.text.toString()

        registroButton.setOnClickListener(){
            if ( viewModelRegistro.camposCompletos(nombre, apellido, telefono, email, password)){

                if (viewModelRegistro.registrar(nombre, apellido, email, password)){
                    val action =  RegistroFragmentDirections.actionRegistroFragmentToHomeFragment()
                    v.findNavController().navigate(action)
                }else{
                    showAlert()
                }
            }else{
             showAlertEmpty()
            }
        }
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error en el Registro")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showAlertEmpty(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error en el Registro")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}