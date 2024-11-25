package com.example.jokenpo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.ImageView

class mdresultado : AppCompatActivity() {
    private lateinit var botaoVolta: ImageButton
    private var md3vit: Int = 0
    private var md3lose: Int = 0
    private lateinit var textVitJog : TextView
    private lateinit var textVitMaq : TextView
    private lateinit var imageGanhador : ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mdresultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        md3vit = intent.getIntExtra("md3vit", 0)
        md3lose = intent.getIntExtra("md3lose", 0)
        botaoVolta = findViewById(R.id.botaoVoltaresu)

        botaoVolta.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        textVitJog = findViewById(R.id.textVitJog)
        textVitJog.text = "$md3vit"


        textVitMaq = findViewById(R.id.textVitMaq)
        textVitMaq.text = "$md3lose"

        imageGanhador = findViewById(R.id.imageGanhador)


        if (md3vit>md3lose) {
            imageGanhador.setImageResource(R.drawable.parabensvcganhoudamaquina)
        }else
            imageGanhador.setImageResource(R.drawable.voceperdeutreinemais)
    }
}