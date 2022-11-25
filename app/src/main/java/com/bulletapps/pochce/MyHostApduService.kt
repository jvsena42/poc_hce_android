package com.bulletapps.pochce

import android.nfc.cardemulation.HostApduService
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MyHostApduService : HostApduService() {

    companion object {
        val TAG = "HOST_CARD_EMULATOR"
        val STATUS_SUCCESS = "9000"
        val STATUS_FAILED = "6F00"
        val CLA_NOT_SUPPORTED = "6E00"
        val INS_NOT_SUPPORTED = "6D00"
        val AID = "A0000002471001"
        val SELECT_INS = "A4"
        val DEFAULT_CLA = "00"
        val MIN_APDU_LENGTH = 12
    }

    //is called whenever a NFC reader sends an Application Protocol Data Unit (APDU) to your service
    override fun processCommandApdu(commandApdu: ByteArray?, extras: Bundle?): ByteArray {
        return handleResult(commandApdu)
    }


//    Android keeps forwarding new APDUs from the reader to your service, until either of the following happens:

//The NFC reader sends another SELECT AID APDU, which the OS resolves to a different service.
//The NFC link between the NFC reader and your device is broken.
//In both of these cases, your class's onDeactivated() implementation is called with an argument indicating which of the two happened.
    override fun onDeactivated(reason: Int) {
    val message = "Deactivated: " + reason.toReason()
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    Log.d(TAG, message)
    }

    private fun handleResult(commandApdu: ByteArray?): ByteArray {
        Log.d(TAG, "START")
        if (commandApdu == null) {
            Log.d(TAG, "commandApdu NULL")
            return STATUS_FAILED.hexStringToByteArray()
        }

        val hexCommandApdu = commandApdu.toHex()
//        if (hexCommandApdu.length < MIN_APDU_LENGTH) {
//            return STATUS_FAILED.hexStringToByteArray()
//        }

//        if (hexCommandApdu.getCLA() != DEFAULT_CLA) {
//            return CLA_NOT_SUPPORTED.hexStringToByteArray()
//        }
//
//        if (hexCommandApdu.getINS() != SELECT_INS) {
//            return INS_NOT_SUPPORTED.hexStringToByteArray()
//        }


        Log.d(TAG, "AID: ${hexCommandApdu.getAID()}")
//        return if (hexCommandApdu.getAID() == AID) {
//            STATUS_SUCCESS.hexStringToByteArray()
//        } else {
//            STATUS_FAILED.hexStringToByteArray()
//        }
        Toast.makeText(this, "Sucesso na leitura $STATUS_SUCCESS", Toast.LENGTH_LONG).show()
        sendResponseApdu(STATUS_SUCCESS.hexStringToByteArray())
        return STATUS_SUCCESS.hexStringToByteArray()
    }
}