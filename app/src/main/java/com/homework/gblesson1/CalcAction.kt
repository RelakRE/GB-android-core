package com.homework.gblesson1

abstract class CalcAction {

    abstract val charOperation : Char

    companion object {
        fun charIsOperation(c: Char): Boolean {
            return getArrOperationChar().contains(c)
        }
        private fun getArrOperationChar() : Array<Char>{
            //пока просто перебором
            return arrayOf('+', '-','/','*','=')
        }
    }




}