package com.ejercicios.formulariologin.Views

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import com.ejercicios.formulariologin.entities.Usuario2
import com.ejercicios.formulariologin.fragments.LoginFragment
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegistroViewModel : ViewModel() {


    private val db = Firebase.firestore
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

//    Implementar AppCompatActivity() para movernos entre fragments o hacerlo con navgraph? otra opcion intent?
//    private val transaction = supportFragmentManager.beginTransaction()
//    private val loginFragment = LoginFragment()

    fun registrar (nombre: String, apellido: String, telefono: String, email: String, password: String ){

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(){
                if (it.isSuccessful){
                    val user = auth.currentUser
                    crearUsuario(user!!.uid, nombre, apellido, telefono, email, password)
                    Log.d("Auth", "Se pudo registrar")
                }else{
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

    fun crearUsuario2 (idUsuario: String, nombre: String, apellido: String, telefono: String, email: String, password: String ): Boolean{
        var creacionExistosa = false

        var usuarioNuevo: Usuario2 = Usuario2(idUsuario, nombre, apellido, email, password, telefono, true, null)

        db.collection("usuarios").document(usuarioNuevo.id!!).set(usuarioNuevo)
            .addOnSuccessListener { documentReference ->
                creacionExistosa = true
                Log.d("DB", "Se guardo el usuario en la DB")
            }
            .addOnFailureListener{
                Log.d("DB", "No se guardo el usuario en la DB")
            }
        return creacionExistosa
    }


    fun registrar2 (nombre: String, apellido: String, telefono: String, email: String, password: String ): Boolean{
        var registroSatisfactorio = false

        //preguntar como implementarlo con la Entidad Usre
//        val user = hashMapOf(
//            "nombre" to nombre,
//            "apellido" to apellido,
//            "email" to email,
//            "password" to password,
//            "telefono" to telefono,
//            "escliente" to true
//        )

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(){
                        if (it.isSuccessful){
                            val user = auth.currentUser
                            registroSatisfactorio = crearUsuario2(user!!.uid, nombre, apellido, telefono, email, password)
                            Log.d("Auth", "Se pudo registrar")
                        }else{
                            Log.d("Auth", "No se ha podido registrar")
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