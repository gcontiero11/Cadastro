package com.example.projeto_cadastro

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        val etNome = findViewById<EditText>(R.id.etNome)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etTelefone = findViewById<EditText>(R.id.etTelefone)
        val etEndereco = findViewById<EditText>(R.id.etEndereco)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        // Define o comportamento do botão Salvar
        btnSalvar.setOnClickListener {
            // Cria um objeto Formulario com os dados preenchidos
            val formulario = Formulario(
                nome = etNome.text.toString(),
                email = etEmail.text.toString(),
                telefone = etTelefone.text.toString(),
                endereco = etEndereco.text.toString()
            )
            // Exibe os dados utilizando um Toast
            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }

        // Define o comportamento do botão Limpar
        btnLimpar.setOnClickListener {
            etNome.text.clear()
            etEmail.text.clear()
            etTelefone.text.clear()
            etEndereco.text.clear()
        }
    }
}