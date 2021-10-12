package com.ejercicios.formulariologin.entities

import android.os.Parcelable
import java.io.Serializable

//preguntar como implementarlo con la Entidad User
class Usuario2 (var id: String?, var nombre: String, var apellido: String, var email: String, var password: String, var telefono: String,
                var esCliente: Boolean,
                var direcciones:ArrayList<String>?): Serializable

        {
            constructor():this("","","","","","", true, null){

            }


    }