#include <LiquidCrystal.h>
#include <Servo.h>

LiquidCrystal lcd(2,3,4,5,6,7);
Servo motor;


void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  lcd.begin(16,2);
  lcd.clear();
  motor.attach(8);
  motor.write(90);  
}

void loop() {
  // put your main code here, to run repeatedly:
  int count = 0;
  lcd.clear();
  int exitGate = analogRead(A0);
  if(analogRead(A0) < 100){
    Serial.println("0");
    do{
      lcd.print("Please Wait. . .");
      delay(500);
      lcd.clear();
      lcd.print("Please Wait . . ");
      delay(500);
      lcd.clear();
      count++;
      if(count == 10){
        break;
      }
    }while(Serial.available()==0);
    
    if(Serial.available()>0){
      int fee1 = Serial.read();
      int fee2 = Serial.read();
      int totalFee = fee1*255+fee2;
      Serial.println(fee1);
      lcd.clear();
      lcd.print("Amount: ");
      lcd.print(totalFee);

      while(Serial.available()==0){
        count++;
        delay(1000);
        if(count > 15){
          break;
        }
      }
      if(Serial.read()==0){
        lcd.setCursor(0,1);
        lcd.print("All Paid");
        for(int i=90; i>=0; i--){
          motor.write(i);
          delay(7);
        }
        delay(5000);
        for(int i=0; i<=90; i++){
          motor.write(i);
          delay(7);
        } 
      }
   }      
  }
  delay(500);
}
