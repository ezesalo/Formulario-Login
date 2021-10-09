package com.ejercicios.formulariologin.entities

import android.os.Parcel
import android.os.Parcelable

class User (nombre: String, apellido: String, email: String, password: String, telefono: String, escliente: Boolean, direcciones:MutableList<String>) :
    Parcelable {

    var nombre: String
    var apellido: String
    var email: String
    var password: String
    var telefono: String
    var escliente: Boolean
    var direcciones: MutableList<String>

    constructor(parcel: Parcel) : this(
        TODO("nombre"),
        TODO("apellido"),
        TODO("email"),
        TODO("password"),
        TODO("telefono"),
        TODO("escliente"),
        TODO("direcciones")
    ) {
    }

    init {
        this.nombre = nombre!!
        this.apellido = apellido!!
        this.email = email!!
        this.password = password!!
        this.telefono = telefono!!
        this.escliente = true
        this.direcciones = direcciones!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }


}
