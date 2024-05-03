package com.example.tresenraya_v2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GameActivity : AppCompatActivity() {

    lateinit var b1: Button
    lateinit var b2: Button
    lateinit var b3: Button
    lateinit var b4: Button
    lateinit var b5: Button
    lateinit var b6: Button
    lateinit var b7: Button
    lateinit var b8: Button
    lateinit var b9: Button
    lateinit var textplayer1: TextView
    lateinit var textplayer2: TextView
    lateinit var tv_score_player1: TextView
    lateinit var tv_score_player2: TextView

    var currentPlayer: Int = 1

    var scoreplayer1: Int = 0
    var scoreplayer2: Int = 0
    var gameFinishhed: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        InitUI()
    }

    private fun InitUI() {
        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)
        b3 = findViewById(R.id.b3)
        b4 = findViewById(R.id.b4)
        b5 = findViewById(R.id.b5)
        b6 = findViewById(R.id.b6)
        b7 = findViewById(R.id.b7)
        b8 = findViewById(R.id.b8)
        textplayer1 = findViewById(R.id.textplayer1)
        textplayer2 = findViewById(R.id.textplayer2)
        tv_score_player1 = findViewById(R.id.tv_score_player1)
        tv_score_player2 = findViewById(R.id.tv_score_player2)

        textplayer1.text = intent?.extras?.getString("player1").toString()
        textplayer2.text = intent?.extras?.getString("player2").toString()
    }

    fun play(btn: View) {
        val myBtn: Button = btn as Button
        if (!gameFinishhed && myBtn.text.toString().isEmpty()) {
            if (currentPlayer == 1) {
                myBtn.text = "X"
                ValidateWinner()
                currentPlayer = 2
            } else {
                myBtn.text = "O"
                ValidateWinner()
                currentPlayer = 1
            }
        }
    }

    fun ValidateWinner() {
        var b1Val = b1.text.toString().trim()
        var b2Val = b2.text.toString().trim()
        var b3Val = b3.text.toString().trim()
        var b4Val = b4.text.toString().trim()
        var b5Val = b5.text.toString().trim()
        var b6Val = b6.text.toString().trim()
        var b7Val = b7.text.toString().trim()
        var b8Val = b8.text.toString().trim()
        var b9Val = b9.text.toString().trim()

        if (!b1Val.isEmpty() && b1Val.equals(b2Val) && b1Val.equals(b3Val)) {
            if (currentPlayer == 1) {
                scoreplayer1++
                tv_score_player1.text = "$scoreplayer1"
                Toast.makeText(
                    applicationContext,
                    "${textplayer1.text} Ganaste !!",
                    Toast.LENGTH_LONG
                ).show()
                textplayer1
            } else {
                scoreplayer2++
                tv_score_player2.text = "$scoreplayer2"
                Toast.makeText(
                    applicationContext,
                    "${textplayer2.text} Ganaste !!",
                    Toast.LENGTH_LONG
                ).show()
            }

            gameFinishhed = true
        }
    }
}