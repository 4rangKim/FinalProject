#include <LiquidCrystal.h>
#include <Servo.h>
LiquidCrystal lcd(A11, A10, A4, A5, A6, A7);
Servo motor;
int TOTAL = 4;
int count;
int empty;

void setup() {
  Serial.begin(9600);
  lcd.begin(16,2);
  motor.attach(A9);
  motor.write(90);
  lcd.clear();
  count = 0;
  empty = TOTAL - count;
}

void loop() {
  lcd.clear();
  lcd.print("Total: ");
  lcd.print(TOTAL);
  lcd.setCursor(0,1);
  lcd.print("Empty: ");
  lcd.print(empty);
  if(Serial.available()){
    count = Serial.read();
    if(count == 0 || empty != 0){
      if(count == 1){
        empty--;
        delay(500);
        for(int i=90; i>=0; i--){
        motor.write(i);
        delay(5);
        }
        delay(6000);
        for(int i=0; i<=90; i++){
          motor.write(i);
          delay(7);
        }
     }else if(count == 0){
      empty++;
     }
     if(empty > 4){
      empty = 4;
     } 
    }
  }  
  delay(1000);
}
