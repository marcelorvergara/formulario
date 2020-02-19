package com.example.formulario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formulario.Model.Usuario
import kotlinx.android.synthetic.main.activity_novoformulario.*

class novoformulario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novoformulario)

        var valores = intent.getSerializableExtra("user") as Usuario


        txtVwNome.text = valores.nome
        txtVwEmail.text = valores.email
        txtVwPhone.text = valores.telefone
    }
}
