package ie.setu

import kotlin.math.round

val firstName = "Joe"
val surname = "Soap"
val gender = 'm'
val employeeID = 6143
val grossSalary = 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonus = 1450.50
val cycleToWorkMonthlyDeduction = 54.33

fun main(args: Array<String>){
    println("Payslip Printer")
    println(getFullName())
    getPayslip()
}

fun getPayslip(){

    val monthlySalary = (grossSalary/12)
    val monthlyPrsi = monthlySalary * (prsiPercentage / 100)
    val monthlyPaye = monthlySalary * (payePercentage / 100)
    val grossPay = (monthlySalary + (annualBonus/12))
    val totalDeductions = (monthlyPrsi + monthlyPrsi + cycleToWorkMonthlyDeduction)

    println ("""                       
    |_______________________________________________________________________                                                                 
    |     Monthly Payslip:             ${getFullName()}, ID: $employeeID                                                                                  
    |_______________________________________________________________________                                                                 
    |     PAYMENT DETAILS (gross pay: ${getGrossMonthlyPay()})     
    |          Salary: ${getMonthlySalary()}
    |          Bonus:  ${getMonthlyBonus()}
    |_______________________________________________________________________
    |     DEDUCTION DETAILS (total Deductions: ${getTotalMonthlyDeductions()})    
    |          PAYE: ${getMonthlyPAYE()}
    |          PRSI: ${getMonthlyPRSI()}
    |          Cycle To Work: $cycleToWorkMonthlyDeduction
    |_______________________________________________________________________
    |    NET PAY:${getNetMonthlyPay()}
    |_______________________________________________________________________""".trimMargin("|"))
}

fun getFullName() = when (gender){
    'm', 'M' -> "Mr. $firstName $surname"
    'f', 'F' -> "Ms. $firstName $surname"
    else -> "$firstName $surname"
}

fun getMonthlySalary() = roundTwoDecimals(grossSalary / 12)
fun getMonthlyPRSI() = roundTwoDecimals(getMonthlySalary() * (prsiPercentage / 100))
fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (payePercentage / 100))
fun getMonthlyBonus() = roundTwoDecimals((annualBonus / 12))
fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (annualBonus / 12))
fun getTotalMonthlyDeductions() = roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkMonthlyDeduction))
fun getNetMonthlyPay() = roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions())


fun roundTwoDecimals(number: Double) = round(number * 100) / 100
