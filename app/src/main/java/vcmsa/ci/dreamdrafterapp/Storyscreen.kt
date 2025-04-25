package vcmsa.ci.dreamdrafterapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Storyscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_storyscreen)
        val storyview = findViewById<TextView>(R.id.storyview)
        val backbutton = findViewById<Button>(R.id.backbutton)
        val exitbutton = findViewById<Button>(R.id.exitbutton)

        val noun = intent.getStringExtra("noun")
        val adjective = intent.getStringExtra("adjective")
        val pronoun = intent.getStringExtra("pronoun")
        val food = intent.getStringExtra("food")
        val game = intent.getStringExtra("game")

        val story = "Once upon a time, a $noun who was $adjective decided to play $game. $pronoun went to the kitchen and made $food for a snack. And that’s how the adventure began!"

        storyview.text = story

        backbutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        exitbutton.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}