import java.text.DecimalFormat

fun main() {
    println("Pay Slip Printer")
    println(getFullName())
    printer()

    println("Monthly Salary: ${getMonthlySalary()}")
    println("Monthly PRSI: ${getMonthlyPRSI()}")
    println("Monthly PAYE: ${getMonthlyPAYE()}")
    println("Monthly Gross Pay: ${getGrossMonthlyPay()}")
    println("Monthly Deductions: ${getTotalMonthlyDeductions()}")
    println("Monthly Pay: ${getNetMonthlyPay()}")



}

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


fun printer(){



    println("""    ________________________________________________________________________
    |                            Monthly Payslip                           |
    |______________________________________________________________________|
    |                                                                      |
    |      Employee Name: ${getFullName()}          Employee ID: ${employeeId}              |
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

fun getFullName() =
    when (gender) {
        "m" -> "Mr. $fName $lName"

        else -> {
            "Ms. $fName $lName"
        }
    }

fun getMonthlySalary() = df.format(salary/12)

fun getMonthlyPRSI() = df.format((salary/12)*PRSI)

fun getMonthlyPAYE() = df.format((salary/12)*PAYE)

fun getGrossMonthlyPay() = df.format((salary/12) + bonus/12)

fun getTotalMonthlyDeductions() = df.format(((salary/12)*PRSI)+((salary/12)*PAYE)+scheme)

fun getNetMonthlyPay() = df.format(netpay)

