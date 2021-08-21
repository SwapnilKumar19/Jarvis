package com.androiddev.jarvis.utils

import com.androiddev.jarvis.utils.Constants.OPEN_GOOGLE
import com.androiddev.jarvis.utils.Constants.OPEN_SEARCH
import java.lang.Exception
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {
    fun basicResponses(_message: String) : String{
        val random = (0..2).random()
        val message = _message.toLowerCase()

        return when{
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if(r==0) "heads" else "tails"
                "It's $result"
            }
            message.contains("solve") -> {
                val equation : String? = message.substringAfterLast("solve")
                return try{
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"
                }catch (e:Exception){
                    "Sorry, I can't solve that."
                }
            }
            message.contains("hello")->{
                when(random){
                    0 -> "Hello there!"
                    1 -> "Yo!"
                    2 -> "Namaste!"
                    else -> "error"
                }
            }
            message.contains("hi")->{
                when(random){
                    0 -> "Hello there!"
                    1 -> "Yo!"
                    2 -> "Namaste!"
                    else -> "error"
                }
            }
            message.contains("how are you")->{
                when(random){
                    0 -> "I'm fine"
                    1 -> "In a good mood"
                    2 -> "I'm always hungry"
                    else -> "error"
                }
            }
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "Idk"
                    else -> "error"
                }
            }

        }
    }
}