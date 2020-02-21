package com.example.formulario

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formulario.Model.Usuario
import kotlinx.android.synthetic.main.activity_novoformulario.*
import java.util.*

class novoformulario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novoformulario)

        var valores = intent.getSerializableExtra("user") as Usuario


        txtVwNome.text = valores.nome.toUpperCase(Locale.FRENCH)
        txtVwEmail.text = valores.email.toUpperCase(Locale.FRENCH)
        txtVwPhone.text = valores.telefone.toUpperCase(Locale.FRENCH)

        //retornando para o primeiro formulario

        var meuinttReult = Intent()
        meuinttReult.putExtra(
            "resultado",
            "Usuário Cadastrado com Sucesso")

        setResult(Activity.RESULT_OK,meuinttReult)

        bntVoltar.setOnClickListener() {
            finish()
        }
    }
}
