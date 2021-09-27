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
import androidx.navigation.findNavController
import com.ejercicios.formulariologin.R
import com.ejercicios.formulariologin.Views.RegistroViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class RegistroFragment : Fragment() {

    lateinit var v: View
    lateinit var nombreRegistro: EditText
    lateinit var apellidoRegistro: EditText
    lateinit var userNameRegistro: EditText
    lateinit var emailRegistro: EditText
    lateinit var passwordRegistro: EditText
    lateinit var registroButton: Button

    companion object {
        fun newInstance() = RegistroFragment()
    }

    private lateinit var viewModel: RegistroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.registro_fragment, container, false)
        nombreRegistro = v.findViewById(R.id.nombreRegistroTxt)
        apellidoRegistro = v.findViewById(R.id.apellidoRegistroTxt)
        userNameRegistro = v.findViewById(R.id.userNameRegistroTxt)
        emailRegistro = v.findViewById(R.id.emailRegistroTxt)
        passwordRegistro = v.findViewById(R.id.passwordRegistroTxt)
        registroButton = v.findViewById(R.id.RegistroButton)

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegistroViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()

        registroButton.setOnClickListener(){
            if (nombreRegistro.text.isNotEmpty() && apellidoRegistro.text.isNotEmpty() && userNameRegistro.text.isNotEmpty() &&
                emailRegistro.text.isNotEmpty() && passwordRegistro.text.isNotEmpty()){

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailRegistro.text.toString(), passwordRegistro.text.toString())
                    .addOnCompleteListener{
                        if(it.isSuccessful){
                       val action =  RegistroFragmentDirections.actionRegistroFragmentToHomeFragment()
                            v.findNavController().navigate(action)
                        }else{
                            Snackbar.make(v, "Error en el Registro. Por favor verifique sus datos", Snackbar.LENGTH_LONG).show()
                        }
                    }

        }
        }
    }

//    private fun showAlert(){
//        val builder = AlertDialog.Builder(context)
//        builder.setTitle("Error")
//        builder.setMessage("Se ha producido un error en el Registro")
//        builder.setPositiveButton("Aceptar", null)
//        val dialog: AlertDialog = builder.create()
//        dialog.show()
//    }

}