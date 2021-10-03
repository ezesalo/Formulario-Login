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

    val db = Firebase.firestore

//    Ver con el profe si esto puede servir para no tener que hacerlo en el fragment
//    private lateinit var auth: FirebaseAuth
//    auth = Firebase.auth
//    auth.signInWithEmailAndPassword()

    fun checkEmpty (email: String, password: String): Boolean {
       var loginCompleto = false

        if (email.isNotEmpty() && password.isNotEmpty()){
            loginCompleto = true
        }
        return loginCompleto
    }

}