package com.ejercicios.formulariologin.Views

import android.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.concurrent.timerTask

class CheckEmailViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private var auth: FirebaseAuth = Firebase.auth


    fun enviarEmailDeVerificacion (){

        val user = auth.currentUser
        user!!.sendEmailVerification().addOnCompleteListener(){
            if (it.isSuccessful){
                //showAlert()

            }

        }
    }



//    private fun showAlert(){
//        val builder = AlertDialog.Builder(requireContext())
//        builder.setTitle("Aviso")
//        builder.setMessage("Hemos enviado un email de verificacion, por favor verifique su casilla.")
//        builder.setPositiveButton("Aceptar", null)
//        val dialog: AlertDialog = builder.create()
//        dialog.show()
//    }


}