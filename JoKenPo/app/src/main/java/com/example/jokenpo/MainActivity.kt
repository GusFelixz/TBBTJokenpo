package com.example.jokenpo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {
    private lateinit var botaoJogar: ImageButton
    private lateinit var md3Botao: ImageButton
    private lateinit var placarBotao: ImageButton
    private lateinit var ajudaBotao: ImageButton
    private var md3 = 0


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        botaoJogar = findViewById(R.id.botaoJogar)

        botaoJogar.setOnClickListener {

            val intent = Intent(this, JoKenGame::class.java)
            startActivity(intent)
        }
        md3Botao = findViewById(R.id.md3Botao)

        md3Botao.setOnClickListener{
            md3 = 1
            val md3ir = Intent(this, JoKenGame::class.java)
            md3ir.putExtra("md3", md3)
            startActivity(md3ir)
        }
        placarBotao = findViewById(R.id.placarBotao)

        placarBotao.setOnClickListener {
            //val placar = Intent(this, )
            //startActivity(placar)
        }
        ajudaBotao = findViewById(R.id.ajudaBotao)

        ajudaBotao.setOnClickListener {
            val ajuda = Intent(this, ajuda::class.java)
            startActivity(ajuda)
        }
    }
}










