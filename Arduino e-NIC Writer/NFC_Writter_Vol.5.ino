#define SDA  (A4) //PN532 board pins to Arduino UNO board
#define SCL  (A5)
#define VCC  (5v)
#define GND  (GND)

#include <Wire.h>
#include <PN532_I2C.h>
#include <PN532.h>
#include <NfcAdapter.h>

PN532_I2C pn532_i2c(Wire);
NfcAdapter nfc = NfcAdapter(pn532_i2c);  // Indicates the Shield you are using

//Vaccination details of candidate
String ID = ""; 
String Age = ""; 
String VAC = ""; 
String NOTV = ""; //Name of the vaccine 
String POV = ""; //Place of vaccination
String DOV = ""; // Date of Vaccination
String Remarks = "";



void setup() {
    Serial.begin(9600);
    nfc.begin();
    Serial.println("-------------------------\n");
    Serial.println("NFC Vaccination Details\n"); // Serial Monitor Message
    
    Serial.println("Candidate NIC No : \n");  // Serial Monitor Message
    while (Serial.available() == 0)  {} 
    ID = Serial.readString();  
    Serial.println("Candidate Age : \n");  // Serial Monitor Message
    while (Serial.available() == 0)  {} 
    Age = Serial.readString();   
    Serial.println("COVID-19 Vaccine Dose : \n");  
    while (Serial.available() == 0) {}  
    VAC = Serial.readString();  
    Serial.println("Name Of The Vaccine : \n");  
    while (Serial.available() == 0) {}  
    NOTV = Serial.readString(); 
    Serial.println("Place Of Vaccination : \n");  
    while (Serial.available() == 0) {}  
    POV = Serial.readString(); 
    Serial.println("Date Of Vaccination : \n");  
    while (Serial.available() == 0) {}  
    DOV = Serial.readString(); 
    Serial.println("Remarks : \n");  
    while (Serial.available() == 0) {}  
    Remarks = Serial.readString(); 


    
    Serial.println("-------------------------"); //Showing the details   

    Serial.print("NIC No:" + ID); 
    Serial.print("Age:" + Age);    
    Serial.print("Dose Of Vaccine:" + VAC);
    Serial.print("Vaccine:" + NOTV);
    Serial.print("Place Of Vaccination:" + POV);
    Serial.print("Date Of Vaccination:" + DOV);
    Serial.print("Remarks:" + Remarks); 

    Serial.println("\nPlace the NFC tag on the module board to record data!");
    
}

void loop() {
    
    if (nfc.tagPresent()) {
        NdefMessage message = NdefMessage();
        
        message.addTextRecord ("Age :" + Age + "Vaccine Dose:" + VAC + "Vaccine:" + NOTV + "Place Of Vaccination:" + POV); 
        message.addTextRecord ("Date Of Vaccination:" + DOV + "Remarks:" + Remarks);
        message.addTextRecord ("NIC No:" + ID);
   
        boolean success = nfc.write(message);
    
        if (success) {
       //  NfcTag tag = nfc.read();
       //  Serial.println(tag.getTagType());
       //  Serial.print("UID: ");Serial.println(tag.getUidString()); //NFC Tag Unique ID
         

            Serial.println("Information Stored Successfully"); // If it works you will see this message 
        } else {
            Serial.println("Write failed"); // If the write failed you will see this message
        }
    }

    delay(1000);
}
