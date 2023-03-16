package com.suhun.guess

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.snackbar.Snackbar
import com.suhun.guess.databinding.ActivityMaterialBinding
import com.suhun.guess.databinding.ContentMaterialBinding

class MaterialActivity : AppCompatActivity() {

    val tag = MaterialActivity::class.simpleName
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var activity_material_binding: ActivityMaterialBinding
    private lateinit var binding: ActivityMaterialBinding
    val secretNumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity_material_binding = ActivityMaterialBinding.inflate(layoutInflater)
        binding = ActivityMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(tag, "Secret number is:${secretNumber.randomNumber}")
        binding.fab.setOnClickListener { view->
            AlertDialog.Builder(this)
                .setTitle("Replay Game")
                .setMessage("Are you sure")
                .setPositiveButton("ok", { dialog, which->
                    secretNumber.resetAll()
                    binding.contentLayout.userInput.text = null
                    binding.contentLayout.userInput.hint = "0"
                    binding.contentLayout.count.text = "0"
                    Toast.makeText(this, "Success", Toast.LENGTH_LONG)
                        .show()
                })
                .setNeutralButton("Cancel", null)
                .show()
        }
    }
    fun check(view: View){
        var r=resources
        var message:String= secretNumber.verify(r, binding.contentLayout.userInput.text.toString().toInt())
        binding.contentLayout.count.text = "${secretNumber.count.toString()} times"
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this).setTitle(getString(R.string.dialog_title_guess_message))
            .setMessage(message)
            .setPositiveButton("ok",null)
            .show()
    }

}