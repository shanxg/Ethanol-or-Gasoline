package com.lucasrivaldo.ethanolorgascalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculate(view: View){

        //val textResult = findViewById<TextView>(R.id.textViewResult)


        if (textViewResult.visibility!=View.VISIBLE){
            textViewResult.visibility = View.VISIBLE
        }

        val ethanolPrice = editEthanolValue.text.toString()
        val gasPrice = editGasValue.text.toString()

        if (validateText(ethanolPrice)) {
            if(validateText(gasPrice)) {
               calcPrice(ethanolPrice, gasPrice)

            }else textViewResult.text = getString(R.string.text_empty_gas)
        }else textViewResult.text = getString(R.string.text_empty_ethan)



    }

    private fun calcPrice(ethanolPrice:String, gasPrice:String) {
        val bestOption = ethanolPrice.toDouble() / gasPrice.toDouble()
        var textResult: String

        textResult =
            if (bestOption>=0.7)
            "Gasoline is the best option."
            else
            "Ethanol is the best option."

        textViewResult.text = textResult
    }

    private fun validateText(text:String) : Boolean{

        return (text!=null && text.isNotEmpty())
    }
}
