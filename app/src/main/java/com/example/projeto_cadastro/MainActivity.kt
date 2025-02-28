package com.example.projeto_cadastro

import Formulario
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val etNomeCompleto = findViewById<EditText>(R.id.etNomeCompleto)
        val etTelefone = findViewById<EditText>(R.id.etTelefone)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val cbListaEmails = findViewById<CheckBox>(R.id.cbListaEmails)
        val rgSexo = findViewById<RadioGroup>(R.id.rgSexo)
        val etCidade = findViewById<EditText>(R.id.etCidade)
        val spinnerUF = findViewById<Spinner>(R.id.spinnerUF)

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btnSalvar.setOnClickListener {
            val sexoSelecionado = when (rgSexo.checkedRadioButtonId) {
                R.id.rbMasculino -> "Masculino"
                R.id.rbFeminino -> "Feminino"
                else -> "Não informado"
            }

            val formulario = Formulario(
                nomeCompleto = etNomeCompleto.text.toString(),
                telefone = etTelefone.text.toString(),
                email = etEmail.text.toString(),
                listaEmails = cbListaEmails.isChecked,
                sexo = sexoSelecionado,
                cidade = etCidade.text.toString(),
                uf = spinnerUF.selectedItem.toString()
            )

            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }

        btnLimpar.setOnClickListener {
            etNomeCompleto.text.clear()
            etTelefone.text.clear()
            etEmail.text.clear()
            cbListaEmails.isChecked = false
            rgSexo.clearCheck()
            etCidade.text.clear()
            spinnerUF.setSelection(0)
        }
    }
}
