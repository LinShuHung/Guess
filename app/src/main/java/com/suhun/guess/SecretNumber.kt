package com.suhun.guess

import android.content.Context
import android.content.res.Resources
import android.util.Log
import java.util.Random

class SecretNumber{
    var tag = SecretNumber::class.simpleName
    var randomNumber:Int
    var count:Int = 0

    init{
        randomNumber = Random().nextInt(100) +1
        Log.d(tag, "secret number is:$randomNumber")

    }
    fun verify(r:Resources, num:Int):String{
        count++
        if(num>randomNumber) {
            return r.getString(R.string.smaller)
        }else if(num<randomNumber){
            return r.getString(R.string.bigger)
        }else {
            return r.getString(R.string.you_got_it)
        }
    }

    fun resetAll(){
        count = 0
        randomNumber = Random().nextInt(100) + 1
        Log.d(tag, "Reset secret number is:$randomNumber")
    }
}