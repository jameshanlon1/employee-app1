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
    val PAYE = .385 //percentage
    val PRSI = .052 //percentage
    val bonus = 1450.50
    val scheme = 54.33
    val gross = (salary/12)+bonus/12
    val totalDeductions = ((salary/12)*PAYE)+((salary/12)*PRSI)+scheme
    val netpay = gross-totalDeductions
    val df = DecimalFormat("#.##")

    println("""    ________________________________________________________________________
    |                            Monthly Payslip                           |
    |______________________________________________________________________|
    |                                                                      |
    |      Employee Name: ${fName} ${lName}          Employee ID: ${employeeId}              |
    |                                                                      |
    |______________________________________________________________________|
    |                                                                      |
    |         PAYMENT DETAILS                  DEDUCTION DETAILS           |
    |______________________________________________________________________|
    |         Salary: ${df.format(salary/12)}                    PAYE: ${df.format((salary/12)*PAYE)}              |
    |         Bonus:  ${df.format(bonus/12)}                    PRSI:${df.format((salary/12)*PRSI)}                |
    |                                       Cycle To Work: ${df.format(scheme)}           |
    |______________________________________________________________________|
    |         Gross: ${df.format(gross)}                Total Deductions: ${df.format(totalDeductions)}      |
    |______________________________________________________________________|
    |                            NET PAY: ${df.format(netpay)}                          |
    |______________________________________________________________________|""")

}
