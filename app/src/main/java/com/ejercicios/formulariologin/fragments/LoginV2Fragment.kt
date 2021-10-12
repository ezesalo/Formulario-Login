package com.ejercicios.formulariologin.fragments

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.ejercicios.formulariologin.R
import com.ejercicios.formulariologin.Views.CheckEmailViewModel
import com.ejercicios.formulariologin.Views.LoginV2ViewModel

class LoginV2Fragment : Fragment() {

    lateinit var v: View
    lateinit var emailLogin: EditText
    lateinit var passwordLogin: EditText
    lateinit var loginButton: Button
    lateinit var irARegistro: Button
    private val viewModelLogin: LoginV2ViewModel by viewModels()
    private val viewModelCheckEmail: CheckEmailViewModel by activityViewModels()

    companion object {
        fun newInstance() = LoginV2Fragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.login_v2_fragment, container, false)
        emailLogin = v.findViewById(R.id.emailLoginTxt)
        passwordLogin = v.findViewById(R.id.passwordLoginTxt)
        loginButton = v.findViewById(R.id.loginButton)
        irARegistro = v.findViewById(R.id.segundo_text_registro)


        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    override fun onStart() {
        super.onStart()

        loginButton.setOnClickListener(){
            val email: String = emailLogin.text.toString()
            val password: String = passwordLogin.text.toString()

            if(viewModelLogin.camposCompletos(email, password)){

                if (viewModelCheckEmail.emailconfirmado()){
                    viewModelLogin.ingresar(email, password, v, showAlert())
                }else{
                    showAlertCheckEmail()
                    val action = LoginV2FragmentDirections.actionLoginV2FragmentToCheckEmailFragment()
                    v.findNavController().navigate(action)
                }
            }else{
                showAlertEmpty()
            }
        }

        irARegistro.setOnClickListener(){
            val action = LoginV2FragmentDirections.actionLoginV2FragmentToRegistroV2Fragment()
            v.findNavController().navigate(action)
        }

    }

    fun showAlertCheckEmail(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage("Debe confirmar su email para continuar, por favor intenteló nuevamente")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

     fun showAlert(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error en el Login. Si aun no se ha registrado, por favor hágalo.")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showAlertEmpty(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error")
        builder.setMessage("Hay campos vacios, por favor asegúrese de completar todos los campos.")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}