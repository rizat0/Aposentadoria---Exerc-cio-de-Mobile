package com.example.aposentadoria_atividade2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aposentadoria_atividade2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var screen: ActivityMainBinding
    private lateinit var idade: EditText
    private lateinit var escolha: Spinner
    private lateinit var textoFinal: TextView
    private var resultado: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        screen = ActivityMainBinding.inflate(layoutInflater)
        setContentView(screen.root)


        val sexos = listOf("Mulher", "Homem")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, sexos)
        screen.spinnerSexo.adapter = adaptador


        screen.buttonEnviar.setOnClickListener {
            val idadetexto = screen.editTextIdade.text.toString()

            if (idadetexto != "") {

                val sexo = screen.spinnerSexo.selectedItem as String
                var idade = idadetexto.toLong()
                var resultado: Long

                if (sexo.trim() == "Homem") {
                    resultado = 65 - idade

                    if (idade < 65) { screen.textViewAposentadoria.text = "Faltam $resultado anos para você se aposentar!" }
                    else { screen.textViewAposentadoria.text = "Você já pode se aposentar!" }
                }

                else if (sexo.trim() == "Mulher") {
                    resultado = 62 - idade

                    if (idade < 62) { screen.textViewAposentadoria.text = "Faltam $resultado anos para você se aposentar!" }
                    else { screen.textViewAposentadoria.text = "Você já pode se aposentar!" }
                }

                else { screen.textViewAposentadoria.text = "Opção inválida!" }

            }
            else {
                Toast.makeText(this, "Digite sua idade", Toast.LENGTH_SHORT).show()
            }

        }

    }

}
