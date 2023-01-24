import java.text.DecimalFormat

fun main() {
    println("Pay Slip Printer")
    printer()

}




fun printer(){

    val fName = "Joe"
    val lName = "Soap"
    val gender = "m"
    val employeeId = 6143
    val salary = 67543.21
    val PAYE = 38.5 //percentage
    val PRSI = 5.2 //percentage
    val bonus = 1450.50
    val scheme = 54.33
    val gross = (salary/12)+bonus/12
    val totalDeductions = ((salary/12)*.385)+((salary/12)*.052)+scheme
    val netpay = gross-totalDeductions
    val df = DecimalFormat("#.##")

    println("________________________________________________________________________")
    println("|                            Monthly Payslip                           |")
    println("|______________________________________________________________________|")
    println("|                                                                      |")
    println("|      Employee Name: ${fName} ${lName}          Employee ID: ${employeeId}              |")
    println("|                                                                      |")
    println("|______________________________________________________________________|")
    println("|                                                                      |")
    println("|         PAYMENT DETAILS                  DEDUCTION DETAILS           |")
    println("|______________________________________________________________________|")
    println("|         Salary: ${df.format(salary/12)}                    PAYE: ${df.format((salary/12)*.385)}              |")
    println("|         Bonus:  ${df.format(bonus/12)}                    PRSI:${df.format((salary/12)*.052)}                |")
    println("|                                       Cycle To Work: ${df.format(scheme)}           |")
    println("|______________________________________________________________________|")
    println("|         Gross: ${df.format(gross)}                Total Deductions: ${df.format(totalDeductions)}      |")
    println("|______________________________________________________________________|")
    println("|                            NET PAY: ${df.format(netpay)}                          |")
    println("|______________________________________________________________________|")

}
