object Q3{
    def main(args:Array[String]):Unit={
        val normalWorkingPay=250;
        val otPay=85;
        val taxRate=0.12;
        def takeHomeSalary(normalHours:Int,otHours:Int):Double={
            val salary=(normalHours*normalWorkingPay)+(otHours*otPay);
            val takeHome=salary*(1-taxRate);
            takeHome;

        }
        val normalHoursWorked = 40;
        val otHoursWorked = 30;
        val takeHome = takeHomeSalary(normalHoursWorked, otHoursWorked);

        println(s"Take home salary: Rs. $takeHome");

    }
}