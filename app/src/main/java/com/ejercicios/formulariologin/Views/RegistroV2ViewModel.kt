package com.ejercicios.formulariologin.Views

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.ejercicios.formulariologin.entities.Usuario2
import com.ejercicios.formulariologin.fragments.RegistroV2FragmentDirections
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegistroV2ViewModel : ViewModel() {

    private val db = Firebase.firestore
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun registrar (nombre: String, apellido: String, telefono: String, email: String, password: String, v: View, showAlert: Unit ){

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    val user = auth.currentUser
                    crearUsuario(user!!.uid, nombre, apellido, telefono, email, password)
                    val action = RegistroV2FragmentDirections.actionRegistroV2FragmentToCheckEmailFragment()
                    v.findNavController().navigate(action)
                    Log.d("Auth", "Se pudo registrar")
                }else{
                    showAlert
                    Log.d("Auth", "No se ha podido registrar")
                }
            }

    }

    fun crearUsuario (idUsuario: String, nombre: String, apellido: String, telefono: String, email: String, password: String ){

        var usuarioNuevo: Usuario2 = Usuario2(idUsuario, nombre, apellido, email, password, telefono, true, null)

        db.collection("usuarios").document(usuarioNuevo.id!!).set(usuarioNuevo)
            .addOnSuccessListener {
                Log.d("DB", "Se guardo el usuario en la DB")
            }
            .addOnFailureListener{
                Log.d("DB", "No se guardo el usuario en la DB")
            }

    }

    fun camposCompletos (nombre: String, apellido: String, telefono: String,email: String, password: String ): Boolean {
        var registroCompleto = false

        if(nombre.isNotEmpty() && apellido.isNotEmpty() && telefono.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
            registroCompleto = true
        }
        return registroCompleto
    }
}