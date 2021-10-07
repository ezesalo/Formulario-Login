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
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.ejercicios.formulariologin.R
import com.ejercicios.formulariologin.Views.LoginViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

        lateinit var v: View
        lateinit var emailLogin: EditText
        lateinit var passwordLogin: EditText
        lateinit var loginButton: Button
        private val viewModelLogin: LoginViewModel by viewModels()

        companion object {
            fun newInstance() = LoginFragment()
        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            v = inflater.inflate(R.layout.login_fragment, container, false)
            emailLogin = v.findViewById(R.id.emailLoginTxt)
            passwordLogin = v.findViewById(R.id.passwordLognTxt)
            loginButton = v.findViewById(R.id.loginButton)

            return v
        }

        override fun onActivityCreated(savedInstanceState: Bundle?) {
            super.onActivityCreated(savedInstanceState)
          //  Cambiar a nueva forma la instacia de viewModel
          //  viewModelLogin = ViewModelProvider(this).get(LoginViewModel::class.java)
            // TODO: Use the ViewModel
        }

        override fun onStart() {
            super.onStart()
            val email = emailLogin.text.toString()
            val password = passwordLogin.text.toString()

            loginButton.setOnClickListener(){
                if(viewModelLogin.camposCompletos(email, password)){

                    if (viewModelLogin.ingresar(email, password)){
                        val action =  LoginFragmentDirections.actionLoginFragmentToHomeFragment()
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

