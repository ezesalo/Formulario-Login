package com.ejercicios.formulariologin.Views

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegistroViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val db = Firebase.firestore

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun registrar (nombre: String, apellido: String, email: String, password: String ): Boolean{
        var registroSatisfactorio = false

        //generar usuario con datos? o directamente el registro lo puede hacer
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(){
                if (it.isSuccessful){
                    registroSatisfactorio = true
                }
            }

        return registroSatisfactorio
    }

    fun camposCompletos (nombre: String, apellido: String, telefono: String,email: String, password: String ): Boolean {
        var registroCompleto = false

        if(nombre.isNotEmpty() && apellido.isNotEmpty() && telefono.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
            registroCompleto = true
        }
        return registroCompleto
    }

}