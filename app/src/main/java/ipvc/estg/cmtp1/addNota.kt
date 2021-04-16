package ipvc.estg.cmtp1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class addNota : AppCompatActivity() {
    private lateinit var editWordView: EditText
    private lateinit var editDescView: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_nota)
        editWordView = findViewById(R.id.edit_title)
        editDescView = findViewById(R.id.edit_desc)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {

                val word = editWordView.text.toString()
                val desc = editDescView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY_TITLE, word)
                replyIntent.putExtra(EXTRA_REPLY_DESC, desc)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
            const val EXTRA_REPLY_TITLE = "com.example.android.city"
            const val EXTRA_REPLY_DESC = "com.example.android.country"
        }

}