package com.example.examenmultimedia01

class Movie (var titulo :String, var duracion : String, var director:String, var year:String){
    override fun toString(): String {
        return "Movie(titulo='$titulo', duracion='$duracion', director='$director', year='$year')"
    }
}