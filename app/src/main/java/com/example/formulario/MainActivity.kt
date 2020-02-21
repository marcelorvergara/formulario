package com.example.formulario

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.formulario.Model.Usuario
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConfirm.setOnClickListener{ form()}
        imageView.setOnClickListener{ selectImg()}

    }

    fun selectImg(){
        var meuInttimg = Intent(this,imgSelect::class.java)
        meuInttimg.putExtra("imagem","")
        //startActivity(meuIntt)
        startActivityForResult(meuInttimg, 11)

    }

    fun form(){
        var nome = txtNome.text.toString()
        var email = txtVwEmail.text.toString()
        var phone = txtPhone.text.toString()

        //Toast.makeText(this, "Nome: $nome", Toast.LENGTH_SHORT).show()
        //Toast.makeText(this, "Email: $email", Toast.LENGTH_SHORT).show()
        //Toast.makeText(this, "Telefone: $phone", Toast.LENGTH_SHORT).show()

        var meuIntt = Intent(this, novoformulario::class.java)

        //intt.putExtra("nomeDoUsuario", "$nome")
        //intt.putExtra("emailDoUsuario", "$email")
        //intt.putExtra("phoneDoUsuario", "$phone")

        //variavel recebe os valores no formato classe Usuario
        var usuario = Usuario(nome,email,phone)

        //passa os valores na forma de classe com o nome user
        meuIntt.putExtra("user", usuario)
        //startActivity(meuIntt)
        startActivityForResult(meuIntt, 10)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            when(requestCode){
                10 -> {
                    var retorno = data!!.getStringExtra("resultado")
                    Toast.makeText(this, "Nome: $retorno", Toast.LENGTH_SHORT).show()
                }
                11 ->{
                    var retorno = data!!.getStringExtra("resultado")
                    if ("$retorno" == "Avatar1"){
                        imageView.setImageDrawable(getDrawable(R.drawable.avatar1))
                    }else if("$retorno" == "Avatar2"){
                        imageView.setImageDrawable(getDrawable(R.drawable.avatar2))
                    }//setimageresource
                }

            }
        }
    }

}
