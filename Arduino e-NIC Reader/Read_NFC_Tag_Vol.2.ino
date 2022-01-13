#include <Wire.h>
#include <PN532_I2C.h>
#include <PN532.h>
#include <NfcAdapter.h>

PN532_I2C pn532_i2c(Wire);
NfcAdapter nfc = NfcAdapter(pn532_i2c);

String Age = ""; 
String VAC = ""; 
String NOTV = ""; //Name of the vaccine 
String POV = ""; //Place of vaccination
String DOV = ""; // Date of Vaccination
String Remarks = "";

void setup(void) {
  Serial.begin(9600);
  Serial.println("NFC Tag Reader");
  nfc.begin();
  Serial.println("\nScan NFC tag on the NFC Shield\n");  

 // Serial.println("CLEARDATA");
//  Serial.println("LABEL,Date,Time,Age");
 // delay(1000);
}

void loop(void) {
   
  if (nfc.tagPresent())
  {
    
     
    NfcTag tag = nfc.read();
  //  Serial.println(tag.getTagType());
    Serial.print("Unique ID: ");
    Serial.println(tag.getUidString()); // Retrieves the Unique Identification from NFC tag
    Serial.print("\n");

    if (tag.hasNdefMessage()) // If NFC tag has a message
    {
      NdefMessage message = tag.getNdefMessage();
    //  Serial.print("NFC Tag Records \n");
      
      // If you have more than 1 Message then it wil cycle through them
      int recordCount = message.getRecordCount();
      for (int i = 0; i < recordCount; i++)
      {
       // Serial.print("\nNDEF Record ");
      //  Serial.println(i+1);
        NdefRecord record = message.getRecord(i);

        int payloadLength = record.getPayloadLength();
        byte payload[payloadLength];
        record.getPayload(payload);

        String payloadAsString = ""; // Processes the message as a string vs as a HEX value
        for (int c = 0; c < payloadLength; c++) {
          payloadAsString += (char)payload[c];

          
        }
      
        Serial.println(payloadAsString);
        Serial.print("\n");
        
      }//Serial.println( (String) "DATA,DATE,TIME," + Age );
    }
  }
  delay(1000);
}
