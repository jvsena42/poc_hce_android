package com.bulletapps.pochce

import android.nfc.cardemulation.HostApduService
import android.os.Bundle

class MyHostApduService : HostApduService() {

    //is called whenever a NFC reader sends an Application Protocol Data Unit (APDU) to your service
    override fun processCommandApdu(p0: ByteArray?, p1: Bundle?): ByteArray {
        TODO("Not yet implemented")
    }


//    Android keeps forwarding new APDUs from the reader to your service, until either of the following happens:

//The NFC reader sends another SELECT AID APDU, which the OS resolves to a different service.
//The NFC link between the NFC reader and your device is broken.
//In both of these cases, your class's onDeactivated() implementation is called with an argument indicating which of the two happened.
    override fun onDeactivated(p0: Int) {
        TODO("Not yet implemented")
    }
}