package vcmsa.ci.dreamdrafterapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val app_name = findViewById<TextView>(R.id.app_name)
        val appboost = findViewById<TextView>(R.id.appboost)
        val noun_box = findViewById<EditText>(R.id.noun_box)
        val adjective_box = findViewById<EditText>(R.id.adjective_box)
        val pronoun_box = findViewById<EditText>(R.id.pronoun_box)
        val food_box = findViewById<EditText>(R.id.food_box)
        val game_box = findViewById<EditText>(R.id.game_box)
        val clearbutton = findViewById<Button>(R.id.clearbutton)
        val createbutton = findViewById<Button>(R.id.createbutton)

        clearbutton.setOnClickListener {
            noun_box.text.clear()
            adjective_box.text.clear()
            pronoun_box.text.clear()
            food_box.text.clear()
            game_box.text.clear()
        }

        createbutton.setOnClickListener {
            val noun = noun_box.text.toString()
            val adjective = adjective_box.text.toString()
            val pronoun = pronoun_box.text.toString()
            val food = food_box.text.toString()
            val game = game_box.text.toString()

            if (noun.isNotEmpty() && adjective.isNotEmpty() && pronoun.isNotEmpty() && food.isNotEmpty() && game.isNotEmpty()) {
                val intent = Intent(this, Storyscreen::class.java)
                intent.putExtra("noun", noun)
                intent.putExtra("adjective", adjective)
                intent.putExtra("pronoun", pronoun)
                intent.putExtra("food", food)
                intent.putExtra("game", game)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please fill in all the boxes!", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}