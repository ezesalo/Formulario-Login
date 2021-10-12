package com.ejercicios.formulariologin.Views

import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.ejercicios.formulariologin.fragments.LoginV2FragmentDirections
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthSettings
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginV2ViewModel : ViewModel() {

    val db = Firebase.firestore
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun ingresar (email: String, password: String, v: View, showAlert: Unit) {

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(){
                if (it.isSuccessful){
                    val action2 = LoginV2FragmentDirections.actionLoginV2FragmentToHomeFragment()
                    v.findNavController().navigate(action2)
                   Log.d(TAG, "Login completado")
                }else{
                    showAlert
                    Log.d(TAG, "No se completo el Login")
                }
            }

    }

    fun camposCompletos (email: String, password: String): Boolean {
        var loginCompleto = false

        if (email.isNotEmpty() && password.isNotEmpty()){
            loginCompleto = true
        }
        return loginCompleto
    }


}