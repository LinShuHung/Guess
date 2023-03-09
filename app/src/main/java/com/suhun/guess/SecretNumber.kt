package com.suhun.guess

import java.util.Random

class SecretNumber{
    var randomNumber:Int = Random().nextInt(100) +1
    var count:Int = 0

    /*fun verify(num:Int) = if(num>guessNumber) "Smaller!!!"
                            else if(num<guessNumber) "Bigger!!!" else "You got it!!!"*/
    fun verify(num:Int):String{
        count++
        if(num>randomNumber) {
            return "Smaller!!!"
        }else if(num<randomNumber){
            return "Bigger!!!"
        }else {
            return "You got it!!!"
        }
    }
}