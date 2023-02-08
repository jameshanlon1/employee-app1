package setu

import kotlin.math.round

class Employee(
    var fName : String, var lName : String, var gender : Char,
            var employeeID : Int, var salary : Double, var PAYE : Double,
                    var PRSI : Double, var bonus : Double, var scheme : Double)
{


    fun getFullName() = when (gender){
        'm', 'M' -> "Mr. ${fName} ${lName}"
        'f', 'F' -> "Ms. ${fName} ${lName}"
        else -> "${fName} ${lName}"
    }

    fun getMonthlySalary() = roundTwoDecimals(salary / 12)
    fun getMonthlyPRSI() = roundTwoDecimals(getMonthlySalary() * (PRSI / 100))
    fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (PAYE / 100))
    fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (bonus / 12))
    fun getTotalMonthlyDeductions() = roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() + scheme))
    fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions()))



    fun getPayslip() =
        """
        ______________________________________________________________________
         Monthly Payslip:             ${getFullName()}, ID: ${employeeID}                  
        ______________________________________________________________________    
              PAYMENT DETAILS (gross pay: ${getGrossMonthlyPay()})                                                                    
        ______________________________________________________________________
                   Salary: ${getMonthlySalary()}
                   Bonus:  ${roundTwoDecimals(bonus / 12)}            
        ______________________________________________________________________
              DEDUCTION DETAILS (total Deductions: ${getTotalMonthlyDeductions()})      
        ______________________________________________________________________
                   PAYE: ${getMonthlyPAYE()}                
                   PRSI: ${getMonthlyPRSI()}  
                   Cycle To Work: ${scheme}         
        ______________________________________________________________________
             NET PAY: ${getNetMonthlyPay()} 
        ______________________________________________________________________"""


    fun roundTwoDecimals(number: Double) = round(number * 100) / 100
    override fun toString(): String {
        return "Employee(fName='$fName', lName='$lName', gender=$gender, employeeID=$employeeID, salary=$salary, PAYE=$PAYE, PRSI=$PRSI, bonus=$bonus, scheme=$scheme)"
    }
//fun roundTwoDecimals(number: Double) = "%.2f".format(number).toDouble()



}

