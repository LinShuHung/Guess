package com.suhun.guess

import android.content.Context
import android.content.res.Resources
import java.util.Random

class SecretNumber{
    var randomNumber:Int = Random().nextInt(100) +1
    var count:Int = 0

    /*fun verify(num:Int) = if(num>guessNumber) "Smaller!!!"
                            else if(num<guessNumber) "Bigger!!!" else "You got it!!!"*/
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
}