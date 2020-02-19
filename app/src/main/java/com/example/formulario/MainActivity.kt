package com.example.formulario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formulario.Model.Usuario
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConfirm.setOnClickListener{ form()}
    }

    fun form(){
        var nome = txtNome.text.toString()
        var email = txtVwEmail.text.toString()
        var phone = txtPhone.text.toString()

        //Toast.makeText(this, "Nome: $nome", Toast.LENGTH_SHORT).show()
        //Toast.makeText(this, "Email: $email", Toast.LENGTH_SHORT).show()
        //Toast.makeText(this, "Telefone: $phone", Toast.LENGTH_SHORT).show()

        var intt = Intent(this, novoformulario::class.java)

        //intt.putExtra("nomeDoUsuario", "$nome")
        //intt.putExtra("emailDoUsuario", "$email")
        //intt.putExtra("phoneDoUsuario", "$phone")

        //variavel recebe os valores no formato classe Usuario
        var usuario = Usuario(nome,email,phone)

        //passa os valores na forma de classe com o nome user
        intt.putExtra("user", usuario)
        startActivity(intt)
    }

}
