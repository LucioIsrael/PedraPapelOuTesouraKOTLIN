package br.com.treino.pedrapapeltesourakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random as Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun selecionaPedra(view: View) {
        opcaoSelecionada("Pedra")
    }

    fun selecionaPapel(view: View) {
        opcaoSelecionada("Papel")
    }

    fun selecionaTesoura(view: View) {
        opcaoSelecionada("Tesoura")
    }

    fun opcaoSelecionada(escolhaUsuario: String) {
        var imageResult: ImageView = findViewById(R.id.imageResult)
        var textoResultado: TextView = findViewById(R.id.TextResultado)

        var opcoes = arrayOf("Pedra", "Papel", "Tesoura")
        var numero: Int = Random.nextInt(3)
        var escolhaApp = opcoes[numero]


        when (escolhaApp) {
            "Pedra" -> imageResult.setImageResource(R.drawable.pedra)
            "Papel" -> imageResult.setImageResource(R.drawable.papel)
            "Tesoura" -> imageResult.setImageResource(R.drawable.tesoura)
        }

        if (
            (escolhaApp == "Tesoura" && escolhaUsuario == "Papel") ||
            (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
            (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura")
        ) {

            textoResultado.setText("Você perdeu :(")

        } else if (
            (escolhaUsuario == "Tesoura" && escolhaApp == "Papel") ||
            (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ||
            (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura")
        ) {

            textoResultado.setText("Você ganhou :)")

        } else {

            textoResultado.setText("Temos um empate")

        }
    }
}

