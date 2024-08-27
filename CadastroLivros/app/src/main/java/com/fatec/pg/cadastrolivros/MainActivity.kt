package com.fatec.pg.cadastrolivros

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fatec.pg.cadastrolivros.view.SecondActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtTitulo = findViewById<EditText>(R.id.edtTitulo)
        val edtAutor = findViewById<EditText>(R.id.edtAutor)
        val btnCadastro = findViewById<Button>(R.id.btnCadastrar)

        btnCadastro.setOnClickListener {
            if (edtTitulo.text.toString().isEmpty() || edtAutor.text.toString().isEmpty()) {
                Toast.makeText(this, "Preencha os valores corretamente!", Toast.LENGTH_SHORT).show()
            }
            else{
                val titulo = edtTitulo.text.toString()
                val autor = edtAutor.text.toString()

                val intent = Intent(this, SecondActivity::class.java)

                val bundle = Bundle()
                bundle.putString("Titulo", titulo)
                bundle.putString("Autor", autor)
                intent.putExtras(bundle)

                startActivity(intent)

            }
        }

    }
}
