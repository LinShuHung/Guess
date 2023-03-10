package com.suhun.guess

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.suhun.guess.databinding.ActivityMainBinding
import com.suhun.guess.databinding.LinearMainBinding
//1.ConstraintLayout
private lateinit var binding:ActivityMainBinding
//2.LinearLayout
//private lateinit var binding:LinearMainBinding


class MainActivity : AppCompatActivity() {

    val secretNumber = SecretNumber()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //1.ConstraintLayout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("MainActivity","secret_number:"+secretNumber.randomNumber.toString())
//        binding.count.text = secretNumber.randomNumber.toString()
//        binding.information.text = secretNumber.verify(88)
    }
    //2.LinearLayout
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = LinearMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.count.text = secretNumber.randomNumber.toString()
//        binding.information.text = secretNumber.verify(88)
    }*/

    fun check(view:View){
        var r=resources
        var message:String= secretNumber.verify(r, binding.userInput.text.toString().toInt())
        binding.count.text = "${secretNumber.count.toString()} times"
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this).setTitle(getString(R.string.dialog_title_guess_message))
            .setMessage(message)
            .setPositiveButton("ok",null)
            .show()

    }

}