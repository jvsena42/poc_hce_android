package com.bulletapps.pochce

import android.nfc.cardemulation.HostApduService
import android.os.Bundle
import android.util.Log

class MyHostApduService : HostApduService() {

    companion object {
        val TAG = "Host Card Emulator"
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
        TODO("Not yet implemented")
    }


//    Android keeps forwarding new APDUs from the reader to your service, until either of the following happens:

//The NFC reader sends another SELECT AID APDU, which the OS resolves to a different service.
//The NFC link between the NFC reader and your device is broken.
//In both of these cases, your class's onDeactivated() implementation is called with an argument indicating which of the two happened.
    override fun onDeactivated(reason: Int) {
        Log.d(TAG, "Deactivated: " + reason)
    }
}