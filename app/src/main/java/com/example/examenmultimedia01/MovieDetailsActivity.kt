package com.example.examenmultimedia01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examenmultimedia01.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        var titulo = intent.getStringExtra("titulo")
        var duracion = intent.getStringExtra("duracion")

        val binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btContinuar.setOnClickListener {
            val director = binding.editDirector.text.toString()
            val year = binding.editYear.text.toString()

            val intent = Intent(this, MovieDisplayActivity::class.java)
            intent.putExtra("titulo", titulo)
            intent.putExtra("duracion", duracion)
            intent.putExtra("director", director)
            intent.putExtra("year", year)

            if (director.isEmpty() || year.isEmpty()) {
                Toast.makeText(this, "Datos vacíos, volver a intentar", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(intent)
            }

        }

        binding.btAtras.setOnClickListener {
            val intent = Intent(this, MovieTitleActivity::class.java)
            startActivity(intent)
        }
    }
}

