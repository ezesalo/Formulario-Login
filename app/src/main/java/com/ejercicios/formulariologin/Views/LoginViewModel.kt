package com.ejercicios.formulariologin.Views

import android.app.DirectAction
import android.app.Notification
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



class LoginViewModel : ViewModel() {

    //usar db para agregar usuario o se agrega automaticamente?
    val db = Firebase.firestore

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun ingresar (email: String, password: String): Boolean {
        var loginSatisfactorio = false

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(){
                if (it.isSuccessful){
                    loginSatisfactorio = true
                }
            }
        return loginSatisfactorio
    }

    fun camposCompletos (email: String, password: String): Boolean {
       var loginCompleto = false

        if (email.isNotEmpty() && password.isNotEmpty()){
            loginCompleto = true
        }
        return loginCompleto
    }

}