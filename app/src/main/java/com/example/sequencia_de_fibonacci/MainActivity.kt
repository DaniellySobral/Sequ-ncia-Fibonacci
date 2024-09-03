package com.example.sequencia_de_fibonacci

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botaoVerificar = findViewById<Button>(R.id.botaoVerificar)
        val textoEntrada = findViewById<EditText>(R.id.textoEntrada)
        val textoResultado = findViewById<TextView>(R.id.textoResultado)

        botaoVerificar.setOnClickListener{

           val validacao = textoEntrada.text.toString()
            if(validacao.isEmpty() ){
                textoResultado.text = "Por favor digite um número"
            }else {
                try {
                    val numeroInteiro = validacao.toInt()

                    if (numeroInteiro < 0){

                        textoResultado.text = "Por favor digite um número positivo"

                    }else{

                        fun validacaoFibonacci(numeroInteiro: Int): Boolean {

                            val x1 = 5 * numeroInteiro * numeroInteiro + 4
                            val x2 = 5 * numeroInteiro * numeroInteiro - 4

                            return (Math.sqrt(x1.toDouble())% 1 == 0.0) || (Math.sqrt(x2.toDouble())% 1 == 0.0)

                        }

                        if (validacaoFibonacci(numeroInteiro)){

                            textoResultado.text = "Faz parte da sequência de Fibonacci"

                        }else{

                            textoResultado.text = "Não faz parte da sequência de Fibonacci"
                        }
                    }
                }catch (e: NumberFormatException){
                    textoResultado.text = "Por favor digite um número inteiro válido"
                }
            }

            }
        }
    }
