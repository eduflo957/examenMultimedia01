package com.example.examenmultimedia01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examenmultimedia01.databinding.ActivityMovieDetailsBinding
import com.example.examenmultimedia01.databinding.ActivityMovieDisplayBinding

class MovieDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_display)

        val binding = ActivityMovieDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titulo = intent.getStringExtra("titulo").toString()
        val duracion = intent.getStringExtra("duracion").toString()
        val director = intent.getStringExtra("director").toString()
        val year = intent.getStringExtra("year").toString()

        val pelicula = Movie("","","","")

        pelicula.titulo = titulo
        pelicula.duracion = duracion
        pelicula.director = director
        pelicula.year = year

        val listaPelis = mutableListOf<Movie>()
        val indices = 0
        listaPelis.add(indices, pelicula)

        binding.btBuscar.setOnClickListener {
            val findNombre = binding.findNombre.text.toString()
            if (pelicula.titulo == findNombre) {
                binding.textresultado.text = pelicula.toString()
            } else {
                Toast.makeText(this, "Comprueba el nombre, el que has introducido al principio es: ${pelicula.titulo}", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btAtras.setOnClickListener {
            val intent = Intent(this, MovieDetailsActivity::class.java)
            intent.putExtra("titulo", titulo)
            intent.putExtra("duracion", duracion)
            startActivity(intent)
        }

    }
}