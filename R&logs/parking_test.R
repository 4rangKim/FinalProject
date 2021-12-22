byyear <- function(){
  library(sqldf);
  data <- read.csv("ran_parking_test.log",header = F,fileEncoding = "utf-8");
  names(data) <- c('Y','M','DD','hh','mm','ss','p_name','state');
  sdata <- sqldf(sprintf('select Y,M,DD,p_name,sum(state)as state from data group by Y,M,DD,p_name'));
  #print(sdata)
  cwdata <- sqldf(sprintf('select 
                          Y,M,DD
                          ,case when p_name=\'A\' then sum(state) else 0 end as A
                          ,case when p_name=\'B\' then sum(state) else 0 end as B
                          ,case when p_name=\'C\' then sum(state) else 0 end as C
                          ,case when p_name=\'D\' then sum(state) else 0 end as D
                          ,case when p_name=\'E\' then sum(state) else 0 end as E
                          ,case when p_name=\'F\' then sum(state) else 0 end as F
                          ,case when p_name=\'G\' then sum(state) else 0 end as G
                          ,case when p_name=\'H\' then sum(state) else 0 end as H
                          from sdata
                          group by Y,M,DD,p_name'));
  f_ydata <- sqldf(sprintf('select Y,sum(A) as A,sum(B) as B,sum(C) as C,sum(D) as D,sum(E) as E,sum(F) as F,sum(G) as G,sum(H) as H from cwdata group by Y '));
  print(f_ydata);
  return (f_ydata);
}


bymonth <- function(){
  
  today_year <- Sys.Date()
  
  Ftoday_year <- format(today_year, format="%Y")
  
  
  library(sqldf);
  data <- read.csv("ran_parking_test.log",header = F,fileEncoding = "utf-8");
  names(data) <- c('Y','M','DD','hh','mm','ss','p_name','state');
  sdata <- sqldf(sprintf('select Y,M,DD,p_name,sum(state)as state from data group by Y,M,DD,p_name'));
  print(sdata)
  cwdata <- sqldf(sprintf('select 
                          Y,M,DD
                          ,case when p_name=\'A\' then sum(state) else 0 end as A
                          ,case when p_name=\'B\' then sum(state) else 0 end as B
                          ,case when p_name=\'C\' then sum(state) else 0 end as C
                          ,case when p_name=\'D\' then sum(state) else 0 end as D
                          ,case when p_name=\'E\' then sum(state) else 0 end as E
                          ,case when p_name=\'F\' then sum(state) else 0 end as F
                          ,case when p_name=\'G\' then sum(state) else 0 end as G
                          ,case when p_name=\'H\' then sum(state) else 0 end as H
                          from sdata
                          group by Y,M,DD,p_name'));
  f_mdata <- sqldf(sprintf('select M,sum(A) as A,sum(B) as B,sum(C) as C,sum(D) as D,sum(E) as E,sum(F) as F,sum(G) as G,sum(H) as H from cwdata where Y=%s group by M ',Ftoday_year));
  print(f_mdata);
  return (f_mdata);
}


byday <- function(){
  
  today_year <- Sys.Date()
  today_month <- Sys.Date()
  
  Ftoday_year <- format(today_year, format="%Y")
  Ftoday_month <- format(today_month, format="%m")
  
  if(Ftoday_month<10){
    final_today_month<-gsub("0","",Ftoday_month)
  }else{
    final_today_month<-Ftoday_month
  }
  
  library(sqldf);
  data <- read.csv("ran_parking_test.log",header = F,fileEncoding = "utf-8");
  names(data) <- c('Y','M','DD','hh','mm','ss','p_name','state');
  sdata <- sqldf(sprintf('select Y,M,DD,p_name,sum(state)as state from data group by Y,M,DD,p_name'));
  #print(sdata)
  cwdata <- sqldf(sprintf('select 
                          Y,M,DD
                          ,case when p_name=\'A\' then sum(state) else 0 end as A
                          ,case when p_name=\'B\' then sum(state) else 0 end as B
                          ,case when p_name=\'C\' then sum(state) else 0 end as C
                          ,case when p_name=\'D\' then sum(state) else 0 end as D
                          ,case when p_name=\'E\' then sum(state) else 0 end as E
                          ,case when p_name=\'F\' then sum(state) else 0 end as F
                          ,case when p_name=\'G\' then sum(state) else 0 end as G
                          ,case when p_name=\'H\' then sum(state) else 0 end as H
                          from sdata
                          group by Y,M,DD,p_name'));
  f_ddata <- sqldf(sprintf('select DD,sum(A) as A,sum(B) as B,sum(C) as C,sum(D) as D,sum(E) as E,sum(F) as F,sum(G) as G,sum(H) as H from cwdata where Y=%s and M=%s group by DD',Ftoday_year,final_today_month));
  print(f_ddata);
  return (f_ddata);
}






byhour <- function(){
  
  yesday_y <- Sys.Date()-1
  yesday_m <- Sys.Date()-1
  yesday_d <- Sys.Date()-1
  
  
  Fyesday_y <- format(yesday_y, format="%Y")
  Fyesday_m <- format(yesday_m, format="%m")
  Fyesday_d <- format(yesday_d, format="%d")
  
  
  if(Fyesday_m<10){
    final_yesday_m <- gsub("0","",Fyesday_m)
  }else{
    final_yesday_m <- Fyesday_m
  }
  
  
  if(Fyesday_d<10){
    final_yesday_d <- gsub("0","",Fyesday_d)
  }else{
    final_yesday_d <- Fyesday_d
  }
  
  
  
  library(sqldf);
  data <- read.csv("ran_parking_test.log",header = F,fileEncoding = "utf-8");
  names(data) <- c('Y','M','DD','hh','mm','ss','p_name','state');
  sdata <- sqldf(sprintf('select Y,M,DD,hh,p_name,sum(state)as state from data group by Y,M,DD,hh,p_name'));
  cwdata <- sqldf(sprintf('select
                          Y,M,DD,hh
                          ,case when p_name=\'A\' then sum(state) else 0 end as A
                          ,case when p_name=\'B\' then sum(state) else 0 end as B
                          ,case when p_name=\'C\' then sum(state) else 0 end as C
                          ,case when p_name=\'D\' then sum(state) else 0 end as D
                          ,case when p_name=\'E\' then sum(state) else 0 end as E
                          ,case when p_name=\'F\' then sum(state) else 0 end as F
                          ,case when p_name=\'G\' then sum(state) else 0 end as G
                          ,case when p_name=\'H\' then sum(state) else 0 end as H
                          from sdata
                          group by Y,M,DD,hh,P_name'));
  print(cwdata)
  f_hdata <- sqldf(sprintf('select 
                           hh, sum(A) as A, sum(B) as B, sum(C) as C, 
                           sum(D) as D, sum(E) as E, sum(F) as F, sum(G) as G, sum(H) as H 
                           from cwdata 
                           where Y=%s and M=%s and DD=%s group by hh',Fyesday_y,final_yesday_m,final_yesday_d));
  #print(f_hdata)
  return(f_hdata);
  
}







AVGbyhour <- function(){
  library(sqldf);
  data <- read.csv("ran_parking_test.log",header = F,fileEncoding = "utf-8");
  names(data) <- c('Y','M','DD','hh','mm','ss','p_name','state');
  countdaydata <- sqldf(sprintf('select Y,M,DD from data group by Y,M,DD'));
  countdaydata2 <- sqldf(sprintf('select count(DD) from countdaydata'));
  
  final_count_day<-as.numeric(countdaydata2)
  
  print(final_count_day)
  
  sdata <- sqldf(sprintf('select Y,M,DD,hh,p_name,sum(state)as state from data group by Y,M,DD,hh,p_name'));
  ccwdata <- sqldf(sprintf('select
                          Y,M,DD,hh
                          ,case when p_name=\'A\' then sum(state) else 0 end as A
                          ,case when p_name=\'B\' then sum(state) else 0 end as B
                          ,case when p_name=\'C\' then sum(state) else 0 end as C
                          ,case when p_name=\'D\' then sum(state) else 0 end as D
                          ,case when p_name=\'E\' then sum(state) else 0 end as E
                          ,case when p_name=\'F\' then sum(state) else 0 end as F
                          ,case when p_name=\'G\' then sum(state) else 0 end as G
                          ,case when p_name=\'H\' then sum(state) else 0 end as H
                          from sdata
                          group by Y,M,DD,hh,P_name'));
  print(ccwdata)
  avgcountbyday <- sqldf(sprintf('select 
                           hh, sum(A)/%d as A, sum(B)/%d as B, sum(C)/%d as C, 
                           sum(D)/%d as D, sum(E)/%d as E, sum(F)/%d as F, sum(G)/%d as G, sum(H)/%d as H 
                           from ccwdata 
                           group by hh',final_count_day,final_count_day,final_count_day,final_count_day,final_count_day,final_count_day,final_count_day,final_count_day));
  
  #print(avgcountbyday)
  return(avgcountbyday)
  
}












test1 <- function(){
  

  yesday_y <- Sys.Date()-1
  yesday_m <- Sys.Date()-1
  yesday_d <- Sys.Date()-1
  
  
  Fyesday_y <- format(yesday_y, format="%Y")
  Fyesday_m <- format(yesday_m, format="%m")
  Fyesday_d <- format(yesday_d, format="%d")
  
  print(Fyesday_y)
  print(Fyesday_m)
  print(Fyesday_d)
  
  
  if(Fyesday_m<10){
    final_yesday_m <- gsub("0","",Fyesday_m)
  }else{
    final_yesday_m <- Fyesday_m
  }
  
  
  if(Fyesday_d<10){
    final_yesday_d <- gsub("0","",Fyesday_d)
    print(final_yesday_d)
  }else{
    final_yesday_d <- Fyesday_d
  }
  
  
  
  library(sqldf);
  data <- read.csv("ran_parking_test.log",header = F,fileEncoding = "utf-8");
  names(data) <- c('Y','M','DD','hh','mm','ss','p_name','state');
  print(data);
  
  FFFdata <- sqldf(sprintf('select * from data where Y=%s and M=%s and DD=%s',Fyesday_y,final_yesday_m,final_yesday_d));
  print(FFFdata);
  
  
  
  sdata <- sqldf(sprintf('select * from data where state=1'));
  text<-'9'
  ssdata <- sqldf(sprintf('select * from sdata where DD=%s',text));
  print(ssdata);
  
  text<-9
  ddata <- sqldf(sprintf('select * from sdata where DD=%d',text));
  print(ddata);
}






piepercent<- function(){
  
  library(sqldf);
  data <- read.csv("ran_parking_test.log",header = F,fileEncoding = "utf-8");
  names(data) <- c('Y','M','DD','hh','mm','ss','p_name','state');
  sdata <- sqldf(sprintf('select Y,M,DD,p_name,sum(state)as state from data group by Y,M,DD,p_name'));
  #print(sdata)
  cwdata <- sqldf(sprintf('select 
                          case when p_name=\'A\' then sum(state) else 0 end as A
                          ,case when p_name=\'B\' then sum(state) else 0 end as B
                          ,case when p_name=\'C\' then sum(state) else 0 end as C
                          ,case when p_name=\'D\' then sum(state) else 0 end as D
                          ,case when p_name=\'E\' then sum(state) else 0 end as E
                          ,case when p_name=\'F\' then sum(state) else 0 end as F
                          ,case when p_name=\'G\' then sum(state) else 0 end as G
                          ,case when p_name=\'H\' then sum(state) else 0 end as H
                          from sdata
                          group by p_name'));
  f_ydata <- sqldf(sprintf('select sum(A) as A,sum(B) as B,sum(C) as C,sum(D) as D,sum(E) as E,sum(F) as F,sum(G) as G,sum(H) as H from cwdata'));
  print(f_ydata);
  
  return(f_ydata)
}















