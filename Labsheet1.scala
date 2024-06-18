//Question1
def area_of_disk(r: Double)=math.Pi*r*r;
 
//Question2
def convert_temp(t:Double)=t*1.8000+32;

//Question3
def volume_sphere(r:Double)=(4.0/3.0)*math.Pi*r*r*r;

//Question4
def bookPrice(x:Double)=x*24.95;
def discount(x:Double)=x*0.4;
def shippingCost(x:Double)=if(x<=50) 3 else 3+(x-50)*0.75;
val totalcost=bookPrice(60)+shippingCost(60)-discount(60);


//Question5
def easy(k:Int)=8*k;
def tempo(k:Int)=7*k;
val total_running_time=easy(2)+tempo(3)+easy(2);

    

  

