package com.example.examenmultimedia01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.example.examenmultimedia01.databinding.ActivityMovieTitleBinding

class MovieTitleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_title)

        val binding = ActivityMovieTitleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btContinuar.setOnClickListener {
            val titulo = binding.editTitulo.text.toString()
            val duracion = binding.editDuracion.text.toString()

            val intent = Intent(this, MovieDetailsActivity::class.java)
            intent.putExtra("titulo", titulo)
            intent.putExtra("duracion", duracion)

            if (titulo.isEmpty() || duracion.isEmpty()) {
                Toast.makeText(this, "Datos vacíos, volver a intentar", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(intent)
            }
        }

    }
}