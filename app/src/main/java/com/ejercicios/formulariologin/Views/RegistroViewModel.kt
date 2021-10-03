package com.ejercicios.formulariologin.Views

import androidx.lifecycle.ViewModel

class RegistroViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    fun checkEmpty (nombre: String, apellido: String, email: String, password: String ): Boolean {
        var registroCompleto = false

        if(nombre.isNotEmpty() && apellido.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
            registroCompleto = true
        }
        return registroCompleto
    }

}