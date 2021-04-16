package ipvc.estg.cmtp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class begin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_begin)

        val fab = findViewById<Button>(R.id.notas)
        fab.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }


    }
}