package com.bulletapps.pochce

import android.nfc.cardemulation.HostApduService

const val HEX_CHARS = "0123456789ABCDEF"
private val HEX_CHARS_ARRAY = "0123456789ABCDEF".toCharArray()

fun String.hexStringToByteArray() : ByteArray {
    val result = ByteArray(this.length / 2)

    for (i in 0 until this.length step 2) {
        val firstIndex = HEX_CHARS.indexOf(this[i]);
        val secondIndex = HEX_CHARS.indexOf(this[i + 1]);

        val octet = firstIndex.shl(4).or(secondIndex)
        result[i.shr(1)] = octet.toByte()
    }

    return result
}

fun ByteArray.toHex() : String {
    val result = StringBuffer()

    this.forEach {
        val octet = it.toInt()
        val firstIndex = (octet and 0xF0).ushr(4)
        val secondIndex = octet and 0x0F
        result.append(HEX_CHARS_ARRAY[firstIndex])
        result.append(HEX_CHARS_ARRAY[secondIndex])
    }

    return result.toString()
}

fun String.getCLA() = substring(0, 2)
fun String.getINS() = substring(2, 4)
fun String.getAID() = substring(10, 24)

fun Int.toReason() = when {
    this == HostApduService.DEACTIVATION_LINK_LOSS -> "DEACTIVATION_LINK_LOSS"
    this == HostApduService.DEACTIVATION_DESELECTED -> "DEACTIVATION_DESELECTED"
    else -> "UNKNOW"
}