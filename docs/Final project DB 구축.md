# DB 구축

> 테이블 생성

- member 테이블

  CREATE TABLE MEMBER(
  MEM_ID VARCHAR2(20) PRIMARY KEY,
  MEM_PWD VARCHAR2(20),
  MEM_NAME VARCHAR2(20),
  MEM_TEL VARCHAR2(20),
  MEM_MONEY NUMBER,

  MEM_CAR1 VARCHAR2(20),

  MEM_CAR2 VARCHAR2(20)

  );

  

- car 테이블

  - sequence생성  :  create sequence car_seq increment by 1 start with 1;

  CREATE TABLE CAR(
  CAR_NUM VARCHAR2(20),
  MEM_ID VARCHAR2(20),
  IN_TIME DATE,
  OUT_TIME DATE,
  IN_PHOTO VARCHAR2(20),
  OUT_PHOTO VARCHAR2(20),
  P_ID VARCHAR2(10),
  CAR_SEQ VARCHAR2(20) PRIMARY KEY,
  PAYMENT VARCHAR2(20)
  );

  

- manager 테이블

  CREATE TABLE MANAGER(
  MGR_ID VARCHAR2(20) PRIMARY KEY,
  MGR_PWD VARCHAR2(20),
  MGR_NAME VARCHAR2(20),
  MGR_TEL VARCHAR2(20)
  );

  

- p_area 테이블

  CREATE TABLE P_AREA(
  AREA_ID VARCHAR2(10) PRIMARY KEY,
  P_ID VARCHAR2(10),
  STATE NUMBER,
  CONSTRAINT FK_P_AREA FOREIGN KEY(P_ID)
  REFERENCES PARKING(P_ID)
  );



> 샘플 데이터

- manager 샘플

  insert into manager values('admin','admin','강동원','010-1234-5678');



- p_area 샘플

  insert into p_area values('A01','A',0);
  insert into p_area values('A02','A',0);
  insert into p_area values('A03','A',0);
  insert into p_area values('A04','A',0);
  insert into p_area values('A05','A',0);
  insert into p_area values('A06','A',0);
  insert into p_area values('A07','A',0);
  insert into p_area values('A08','A',0);
  insert into p_area values('A09','A',0);
  insert into p_area values('A10','A',0);
  insert into p_area values('A11','A',0);
  insert into p_area values('A12','A',0);
  insert into p_area values('A13','A',0);
  insert into p_area values('A14','A',0);
  insert into p_area values('A15','A',0);
  insert into p_area values('A16','A',0);
  insert into p_area values('A17','A',0);
  insert into p_area values('A18','A',0);
  insert into p_area values('A19','A',0);
  insert into p_area values('A20','A',0);

  insert into p_area values('B01','B',0);
  insert into p_area values('B02','B',0);
  insert into p_area values('B03','B',0);
  insert into p_area values('B04','B',0);
  insert into p_area values('B05','B',0);
  insert into p_area values('B06','B',0);
  insert into p_area values('B07','B',0);
  insert into p_area values('B08','B',0);
  insert into p_area values('B09','B',0);
  insert into p_area values('B10','B',0);
  insert into p_area values('B11','B',0);
  insert into p_area values('B12','B',0);
  insert into p_area values('B13','B',0);
  insert into p_area values('B14','B',0);
  insert into p_area values('B15','B',0);
  insert into p_area values('B16','B',0);
  insert into p_area values('B17','B',0);
  insert into p_area values('B18','B',0);
  insert into p_area values('B19','B',0);
  insert into p_area values('B20','B',0);

  insert into p_area values('C01','C',0);
  insert into p_area values('C02','C',0);
  insert into p_area values('C03','C',0);
  insert into p_area values('C04','C',0);
  insert into p_area values('C05','C',0);
  insert into p_area values('C06','C',0);
  insert into p_area values('C07','C',0);
  insert into p_area values('C08','C',0);
  insert into p_area values('C09','C',0);
  insert into p_area values('C10','C',0);
  insert into p_area values('C11','C',0);
  insert into p_area values('C12','C',0);
  insert into p_area values('C13','C',0);
  insert into p_area values('C14','C',0);
  insert into p_area values('C15','C',0);
  insert into p_area values('C16','C',0);
  insert into p_area values('C17','C',0);
  insert into p_area values('C18','C',0);
  insert into p_area values('C19','C',0);
  insert into p_area values('C20','C',0);

  insert into p_area values('D01','D',0);
  insert into p_area values('D02','D',0);
  insert into p_area values('D03','D',0);
  insert into p_area values('D04','D',0);
  insert into p_area values('D05','D',0);
  insert into p_area values('D06','D',0);
  insert into p_area values('D07','D',0);
  insert into p_area values('D08','D',0);
  insert into p_area values('D09','D',0);
  insert into p_area values('D10','D',0);
  insert into p_area values('D11','D',0);
  insert into p_area values('D12','D',0);
  insert into p_area values('D13','D',0);
  insert into p_area values('D14','D',0);
  insert into p_area values('D15','D',0);
  insert into p_area values('D16','D',0);
  insert into p_area values('D17','D',0);
  insert into p_area values('D18','D',0);
  insert into p_area values('D19','D',0);
  insert into p_area values('D20','D',0);

  insert into p_area values('E01','E',0);
  insert into p_area values('E02','E',0);
  insert into p_area values('E03','E',0);
  insert into p_area values('E04','E',0);
  insert into p_area values('E05','E',0);
  insert into p_area values('E06','E',0);
  insert into p_area values('E07','E',0);
  insert into p_area values('E08','E',0);
  insert into p_area values('E09','E',0);
  insert into p_area values('E10','E',0);
  insert into p_area values('E11','E',0);
  insert into p_area values('E12','E',0);
  insert into p_area values('E13','E',0);
  insert into p_area values('E14','E',0);
  insert into p_area values('E15','E',0);
  insert into p_area values('E16','E',0);
  insert into p_area values('E17','E',0);
  insert into p_area values('E18','E',0);
  insert into p_area values('E19','E',0);
  insert into p_area values('E20','E',0);


  insert into p_area values('F01','F',0);
  insert into p_area values('F02','F',0);
  insert into p_area values('F03','F',0);
  insert into p_area values('F04','F',0);
  insert into p_area values('F05','F',0);
  insert into p_area values('F06','F',0);
  insert into p_area values('F07','F',0);
  insert into p_area values('F08','F',0);
  insert into p_area values('F09','F',0);
  insert into p_area values('F10','F',0);
  insert into p_area values('F11','F',0);
  insert into p_area values('F12','F',0);
  insert into p_area values('F13','F',0);
  insert into p_area values('F14','F',0);
  insert into p_area values('F15','F',0);
  insert into p_area values('F16','F',0);
  insert into p_area values('F17','F',0);
  insert into p_area values('F18','F',0);
  insert into p_area values('F19','F',0);
  insert into p_area values('F20','F',0);

  insert into p_area values('G01','G',0);
  insert into p_area values('G02','G',0);
  insert into p_area values('G03','G',0);
  insert into p_area values('G04','G',0);
  insert into p_area values('G05','G',0);
  insert into p_area values('G06','G',0);
  insert into p_area values('G07','G',0);
  insert into p_area values('G08','G',0);
  insert into p_area values('G09','G',0);
  insert into p_area values('G10','G',0);
  insert into p_area values('G11','G',0);
  insert into p_area values('G12','G',0);
  insert into p_area values('G13','G',0);
  insert into p_area values('G14','G',0);
  insert into p_area values('G15','G',0);
  insert into p_area values('G16','G',0);
  insert into p_area values('G17','G',0);
  insert into p_area values('G18','G',0);
  insert into p_area values('G19','G',0);
  insert into p_area values('G20','G',0);

  insert into p_area values('H01','H',0);
  insert into p_area values('H02','H',0);
  insert into p_area values('H03','H',0);
  insert into p_area values('H04','H',0);
  insert into p_area values('H05','H',0);
  insert into p_area values('H06','H',0);
  insert into p_area values('H07','H',0);
  insert into p_area values('H08','H',0);
  insert into p_area values('H09','H',0);
  insert into p_area values('H10','H',0);
  insert into p_area values('H11','H',0);
  insert into p_area values('H12','H',0);
  insert into p_area values('H13','H',0);
  insert into p_area values('H14','H',0);
  insert into p_area values('H15','H',0);
  insert into p_area values('H16','H',0);
  insert into p_area values('H17','H',0);
  insert into p_area values('H18','H',0);
  insert into p_area values('H19','H',0);
  insert into p_area values('H20','H',0);

  

- car 샘플

  insert into car values('01가1234', 'lee', sysdate, sysdate,null,null, 'A',car_seq.nextval, 3000);
  insert into car values('01가1234', 'lee', sysdate, sysdate,null,null, 'A',car_seq.nextval, 3000);
  insert into car values('01가1234', 'lee', sysdate, sysdate,null,null, 'A',car_seq.nextval, 3000);
  insert into car values('01가1234', 'lee', sysdate, sysdate,null,null, 'A',car_seq.nextval, 3000);
  insert into car values('01가1234', 'lee', sysdate, sysdate,null,null, 'A',car_seq.nextval, 3000);
  insert into car values('01가1234', 'lee', sysdate, sysdate,null,null, 'A',car_seq.nextval, 3000);







