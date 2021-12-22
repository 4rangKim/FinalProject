int pinA[4] = {A3, A2, A1, A0};
int parkA[4];

void setup() {
  Serial.begin(9600);
  for(int i=8; i<=11; i++){
    pinMode(i ,OUTPUT);  
  }
}

void loop() {  
  for(int i=0; i<4; i++){
    parkA[i] = analogRead(pinA[i]);
    String location;
    String parking = String(i+1);
    if(parkA[i] < 140){
      digitalWrite(11-i, LOW);
      location = "A"+parking+"1";
      Serial.print(location);
    }else{
      digitalWrite(11-i, HIGH);
      location = "A"+parking+"0";
      Serial.print(location);
    }
    delay(500);
  }  
}
