package com.example.jokenpo


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random



class JoKenGame : AppCompatActivity() {
    private lateinit var botaoVolta: ImageButton
    private var md3: Int = 0
    var vitoria = 0
    var derrota = 0
    var empate = 0
    var vitoriasmd3 = 0
    var derrotasmd3 = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.jokenjogo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        md3 = intent.getIntExtra("md3", 0)

        botaoVolta = findViewById(R.id.botaoVolta)

        botaoVolta.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }



        fun selecionaPedra(view: View) {
        opcaoSelecionar("pedra")
        }

        fun selecionaPapel(view: View) {
        opcaoSelecionar("papel")
        }

        fun selecionaTesoura(view: View) {
        opcaoSelecionar("tesoura")
        }

        fun selecionaSpock(view: View) {
        opcaoSelecionar("spock")
        }

        fun selecionaLagarto(view: View) {
        opcaoSelecionar("lagarto")
        }




    fun opcaoSelecionar(escolhaUsuario: String) {

        val md3resu = Intent(this, mdresultado::class.java)
        md3resu.putExtra("md3lose", derrotasmd3)
        md3resu.putExtra("md3vit", vitoriasmd3)
        val imagemResultado = findViewById<ImageView>(R.id.imagemResultado)
        val textoResultado = findViewById<TextView>(R.id.textoResultado)
        val resultadoJogador = findViewById<ImageView>(R.id.resultadoJogador)
        val opcoes = arrayOf("pedra", "papel", "tesoura", "spock", "lagarto")
        val escolhaApp = opcoes[Random.nextInt(opcoes.size)]
        val resultado = jogaJogo(escolhaApp, escolhaUsuario)

        when (resultado) {
            "Vitória" ->{
                textoResultado.text = "Você ganhou =)"
                if(md3 == 1) vitoriasmd3++ else vitoria++
            }
            "Derrota" -> {
                textoResultado.text = "Você perdeu =("
                if(md3 == 1) derrotasmd3++ else derrota++
            }
            "Empate" -> {
                textoResultado.text = "Vocês empataram =|"
                empate++
            }
        }

        if (md3 ==1){
            when {
                (vitoriasmd3 >= 2)->{
                    vitoriasmd3 = 2
                    md3resu.putExtra("md3vit", vitoriasmd3)
                    startActivity (md3resu)}
                (derrotasmd3 >= 2)->{
                    derrotasmd3 = 2
                    md3resu.putExtra("md3lose", derrotasmd3)
                    startActivity (md3resu)}
            }

        }

        when (escolhaApp) {
            "pedra" -> imagemResultado.setImageResource(R.drawable.pedra)
            "papel" -> imagemResultado.setImageResource(R.drawable.papel)
            "tesoura" -> imagemResultado.setImageResource(R.drawable.tesoura)
            "spock" -> imagemResultado.setImageResource(R.drawable.spockjokenpo)
            "lagarto" -> imagemResultado.setImageResource(R.drawable.lagartojokenpo)
        }

        when (escolhaUsuario) {
            "pedra" -> resultadoJogador.setImageResource(R.drawable.pedra)
            "papel" -> resultadoJogador.setImageResource(R.drawable.papel)
            "tesoura" -> resultadoJogador.setImageResource(R.drawable.tesoura)
            "spock" -> resultadoJogador.setImageResource(R.drawable.spockjokenpo)
            "lagarto" -> resultadoJogador.setImageResource(R.drawable.lagartojokenpo)
        }


    }


    private fun jogaJogo(escolhaApp: String, escolhaUsuario: String): String {
        return when {
            escolhaApp == "tesoura" && escolhaUsuario == "papel" ||
                    escolhaApp == "papel" && escolhaUsuario == "Pedra" ||
                    escolhaApp == "pedra" && escolhaUsuario == "tesoura" ||
                    escolhaApp == "pedra" && escolhaUsuario == "lagarto" ||
                    escolhaApp == "lagarto" && escolhaUsuario == "spock" ||
                    escolhaApp == "spock" && escolhaUsuario == "tesoura" ||
                    escolhaApp == "tesoura" && escolhaUsuario == "lagarto" ||
                    escolhaApp == "lagarto" && escolhaUsuario == "papel" ||
                    escolhaApp == "papel" && escolhaUsuario == "spock" ||
                    escolhaApp == "spock" && escolhaUsuario == "pedra"
                    -> "Derrota"

                    escolhaApp == escolhaUsuario -> "Empate"


            else -> "Vitória"
        }




    }




}








