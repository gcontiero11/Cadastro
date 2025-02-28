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

        // Infla o layout XML com os campos do formulário
        setContentView(R.layout.activity_main)

        // Referências para as Views do XML
        val etNomeCompleto = findViewById<EditText>(R.id.etNomeCompleto)
        val etTelefone = findViewById<EditText>(R.id.etTelefone)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val cbListaEmails = findViewById<CheckBox>(R.id.cbListaEmails)
        val rgSexo = findViewById<RadioGroup>(R.id.rgSexo)
        val rbMasculino = findViewById<RadioButton>(R.id.rbMasculino)
        val rbFeminino = findViewById<RadioButton>(R.id.rbFeminino)
        val etCidade = findViewById<EditText>(R.id.etCidade)
        val spinnerUF = findViewById<Spinner>(R.id.spinnerUF)

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        // Clique do botão Salvar
        btnSalvar.setOnClickListener {
            // Verifica qual opção de sexo está marcada
            val sexoSelecionado = when (rgSexo.checkedRadioButtonId) {
                R.id.rbMasculino -> "Masculino"
                R.id.rbFeminino -> "Feminino"
                else -> "Não informado"
            }

            // Cria um objeto Formulario com os dados preenchidos
            val formulario = Formulario(
                nomeCompleto = etNomeCompleto.text.toString(),
                telefone = etTelefone.text.toString(),
                email = etEmail.text.toString(),
                listaEmails = cbListaEmails.isChecked,
                sexo = sexoSelecionado,
                cidade = etCidade.text.toString(),
                uf = spinnerUF.selectedItem.toString()
            )

            // Exibe os dados utilizando um Toast
            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }

        // Clique do botão Limpar
        btnLimpar.setOnClickListener {
            etNomeCompleto.text.clear()
            etTelefone.text.clear()
            etEmail.text.clear()
            cbListaEmails.isChecked = false
            rgSexo.clearCheck()          // Desmarca os RadioButtons
            etCidade.text.clear()
            spinnerUF.setSelection(0)    // Retorna o Spinner para a 1ª opção
        }
    }
}
