package ipvc.estg.cmtp1

import android.content.Intent
import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import ipvc.estg.cmtp1.entities.Notas
import ipvc.estg.cmtp1.viewModel.NotasViewModel
import androidx.lifecycle.Observer
import ipvc.estg.cmtp1.adapters.NotasAdapter


class notaEdit : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota_edit)

        lateinit var notasViewModel: NotasViewModel
        val adapter = NotasAdapter(this)

        notasViewModel = ViewModelProvider(this).get(NotasViewModel::class.java)
        notasViewModel.allNotas.observe(this, Observer { notes ->
            notes?.let { adapter.setNotas(it) }
        })

        var titulo = getIntent().getStringExtra("TITULO").toString()
        var descricao = getIntent().getStringExtra("DESC").toString()
        var idUpdate = getIntent().getStringExtra("ID")?.toInt()

        val text_box1 = findViewById(R.id.titulo) as EditText
        text_box1.setText(titulo)
        val text_box2 = findViewById(R.id.descricao) as EditText
        text_box2.setText(descricao)

        val button = findViewById<Button>(R.id.delete)
        val button2 =findViewById<Button>(R.id.update)
        button.setOnClickListener {

            if(idUpdate != 0){
                val nota =Notas(id = idUpdate, title = titulo, desc = descricao)
                notasViewModel.delete(nota)

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }

        }
        button2.setOnClickListener {
            var titleUpdate = findViewById(R.id.titulo) as EditText
            var descUpdate = findViewById(R.id.descricao) as EditText




            if(titleUpdate.text.toString() != "" && descUpdate.text.toString() != ""){



                val notaUpdate = Notas(id = idUpdate, title = titleUpdate.text.toString(), desc = descUpdate.text.toString())
                notasViewModel.update(notaUpdate)

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(
                        applicationContext,
                        R.string.empty_not_saved,
                        Toast.LENGTH_LONG
                ).show()
            }
        }

    }
}