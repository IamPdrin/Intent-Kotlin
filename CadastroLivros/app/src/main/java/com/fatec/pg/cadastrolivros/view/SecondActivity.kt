package com.fatec.pg.cadastrolivros.view

import android.content.Intent
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fatec.pg.cadastrolivros.MainActivity
import com.fatec.pg.cadastrolivros.R
import org.w3c.dom.Text
import java.lang.System.exit
import kotlin.system.exitProcess

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val bundle = intent.extras
        val titulo = bundle?.getString("Titulo")
        val autor = bundle?.getString("Autor")

        val textTitulo = findViewById<TextView>(R.id.txtTitulo)
        val textAutor = findViewById<TextView>(R.id.txtAutor)

        val btnSair = findViewById<Button>(R.id.btnSair)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        if (titulo.toString().isEmpty() || autor.toString().isEmpty()) {
            Toast.makeText(this, "Os valores precisam ser preenchidos corretamente!", Toast.LENGTH_SHORT).show()
        } else{
            textTitulo.text = titulo
            textAutor.text = autor
        }

        btnSair.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }

        btnVoltar.setOnClickListener{
            finish()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}