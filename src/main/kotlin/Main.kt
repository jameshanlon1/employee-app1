import java.text.DecimalFormat

fun main(args: Array<String>) {
    println("Pay Slip Printer")
    println(getFullName())

    var input : Int

    do {
        input = menu()
        when (input) {


            1 ->     println("Monthly Salary: ${getMonthlySalary()}")
            2 ->     println ("Monthly PRSI: ${getMonthlyPRSI()}")
            3 ->     println ("Monthly PAYE: ${getMonthlyPAYE()}")
            4 ->     println ("Monthly Gross Pay: ${getGrossMonthlyPay()}")
            5 ->     println ("Monthly Deductions: ${getTotalMonthlyDeductions()}")
            6 ->     println ("Monthly Pay: ${getNetMonthlyPay()}")
            7 ->     println(getPayslip())
            -1 ->    println("Exiting App")
            else ->  println("Invalid Option")
        }
    } while (input != -1)




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


fun getPayslip()=
    """
    ________________________________________________________________________
    |                            Monthly Payslip                           |
    |______________________________________________________________________|
    |                                                                      |
    |      Employee Name: ${getFullName()}          Employee ID: ${employeeId}          |
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
    |______________________________________________________________________|"""



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

fun menu() : Int {
    print("""
        Employee Menu for ${getFullName()}
            1. Monthly Salary
            2. Monthly PRSI
            3.Monthly PAYE
            4. Monthly Gross Pay
            5. Monthly Total Deductions
            6. Monthly Net Pay
            7. Full Payslip
           -1. Exit
          Enter Option : """)
    return readLine()!!.toInt()
}