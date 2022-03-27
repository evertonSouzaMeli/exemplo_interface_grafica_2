package br.com.fiap.exemplointerfacegrafica2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tipoTelefone = arrayListOf<String>("Telefone", "Celular")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tipoTelefone)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTipoTelefone.adapter = adapter

        btnMensagem.setOnClickListener {

            var mensagem = """
                    |Nome: ${editTextNome.text}
                    |Telefone: ${editTextTelefone.text}
                    |Email : ${editTextEmail.text}
                    |Preferencia Contato: ${preferenciaContato()}
                """.trimMargin("|")


            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Boas Vindas")
            alertDialog.setPositiveButton("OK", null)
            alertDialog.setMessage(mensagem)

            alertDialog.create().show()
        }
    }

    fun preferenciaContato() : String{
        var mensagem = ""
        if(checkBoxEmail.isChecked){
            mensagem += " Email "
        }
        if(checkBoxTelefone.isChecked){
            mensagem += " Telefone "
        }
        return mensagem
    }
}