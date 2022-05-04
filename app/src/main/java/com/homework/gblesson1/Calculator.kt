package com.homework.gblesson1

import android.os.Parcel
import android.os.Parcelable
import java.text.DecimalFormat

class Calculator() : Parcelable {

    var actionLine: String = ""
    var lineBeforeLastNumber = ""
    private var lastNumber: Double = 0.0
    private var lastNumberString: String = ""
    val numberFormat =  DecimalFormat("#.#######")


    constructor(parcel: Parcel) : this() {
        actionLine = parcel.readString().toString()
        lineBeforeLastNumber = parcel.readString().toString()
        lastNumber = parcel.readDouble()
        lastNumberString = parcel.readString().toString()
    }


    fun addNumber(numberString: String) {
        lastNumberString += numberString
        lastNumber = lastNumberString.toDouble()
        actionLine = lineBeforeLastNumber + numberFormat.format(lastNumber)
    }

    fun addComm() {
        if (lastNumberString.indexOf('.') < 0) {
            lastNumberString += "."
            lastNumber = lastNumberString.toDouble()
            actionLine = lineBeforeLastNumber + numberFormat.format(lastNumber)
        }
    }

    fun addCalcAction(c: Char) {
        if (CalcAction.charIsOperation(actionLine[actionLine.length - 1])) {
            lineBeforeLastNumber = lineBeforeLastNumber.dropLast(1) + c
            actionLine = actionLine.dropLast(1) + c
        } else {
            lineBeforeLastNumber += numberFormat.format(lastNumber) + c
            actionLine = lineBeforeLastNumber
            lastNumber = 0.0
            lastNumberString = ""
        }
    }

    //    для теста
    fun addChar(string: String) {
        actionLine += string
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(actionLine)
        parcel.writeString(lineBeforeLastNumber)
        parcel.writeDouble(lastNumber)
        parcel.writeString(lastNumberString)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Calculator> {
        override fun createFromParcel(parcel: Parcel): Calculator {
            return Calculator(parcel)
        }

        override fun newArray(size: Int): Array<Calculator?> {
            return arrayOfNulls(size)
        }
    }


}