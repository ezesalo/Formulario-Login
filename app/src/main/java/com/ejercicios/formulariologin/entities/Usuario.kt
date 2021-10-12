package com.ejercicios.formulariologin.entities

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter.writeString

//preguntar como implementarlo con la Entidad Usre
//class Usuario (nombre: String, apellido: String, email: String, password: String, telefono: String, escliente: Boolean, direcciones:List<String>?) :
//    Parcelable {
//
//    var nombre: String
//    var apellido: String
//    var email: String
//    var password: String
//    var telefono: String
//    var escliente: Boolean
//    var direcciones: List<String>

//    constructor(parcel: Parcel) : this("","","","","",true, null ) {
//    }

//    constructor(): this("", "", "", "", "", true, null)

//    init {
//        this.nombre = nombre!!
//        this.apellido = apellido!!
//        this.email = email!!
//        this.password = password!!
//        this.telefono = telefono!!
//        this.escliente = true
//        this.direcciones = direcciones!!
//    }

//    @RequiresApi(Build.VERSION_CODES.Q)
//    constructor(source: Parcel) : this(
//        source.readString()!!,
//        source.readString()!!,
//        source.readString()!!,
//        source.readString()!!,
//        source.readString()!!,
//        source.readBoolean()!!
//    )

//    constructor (parcel: Parcel) : this(
//        parcel.readString()!!,
//        parcel.readString()!!,
//        parcel.readString()!!,
//        parcel.readString()!!,
//        parcel.readString()!!,
//        parcel.readBoolean(),
//        parcel.readArrayList()!!
//
//    )

    //override fun writeToParcel(parcel: Parcel, flags: Int)

//    @RequiresApi(Build.VERSION_CODES.Q)
//    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
//        writeString(nombre)
//        writeString(apellido)
//        writeString(email)
//        writeString(password)
//        writeString(telefono)
//        writeBoolean(escliente)
//        writeList(direcciones)
//
//    }

//    override fun describeContents(): Int {
//        return 0
//    }

//    Funcion que viene por defecto
//    companion object CREATOR : Parcelable.Creator<Usuario> {
//
//        override fun createFromParcel(parcel: Parcel): Usuario {
//            return Usuario(parcel)
//        }
//
//        override fun newArray(size: Int): Array<Usuario?> {
//            return arrayOfNulls(size)
//        }
//    }



    //Funcion del profe. Da error en Usuario
//    companion object{
//        @JvmField
//        val CREATOR: Parcelable.Creator<Usuario> = object : Parcelable.Creator<Usuario>{
//            override fun createFromParcel(source: Parcel): Usuario = Usuario(source)
//            override fun newArray(size: Int): Array<Usuario?> = arrayOfNulls(size)
//        }
//
//    }
//
//
//}
