//In Kotlin, a sealed class is a class that can be subclassed, but only within the same file where it is declared. This means that all subclasses of a sealed class must be defined in the same file as the sealed class itself. Sealed classes are useful for representing a restricted hierarchy of classes, where all possible subclasses are known in advance.

//Sealed classes are useful in scenarios where you have a restricted set of possible values or states for a type, and you want to ensure that all possible values or states are accounted for in your code. By using a sealed class, you can define a finite set of subclasses that represent all possible values or states, and ensure that these subclasses are the only ones that can be instantiated.

//Let's say you're building a banking application, and you need to represent the different types of accounts that a customer can have. You might have a few different types of accounts, such as:
//
//Savings account
//Checking account
//Money market account

sealed class Account {
    abstract val balance: Double
    
    class SavingsAccount(override val balance: Double) : Account()
    class CheckingAccount(override val balance: Double) : Account()
    class MoneyMarketAccount(override val balance: Double) : Account()
}

//In this example, we define a sealed class called Account with three possible subclasses, SavingsAccount, CheckingAccount, and MoneyMarketAccount. Each subclass takes a balance parameter of type Double, which represents the current balance of the account.

//By using a sealed class, we ensure that all possible account types are accounted for and that only valid account types can be created. This can help to prevent bugs and ensure that the application behaves correctly.

fun calculateInterest(account: Account): Double {
    return when (account) {
        is Account.SavingsAccount -> account.balance * 0.02
        is Account.CheckingAccount -> account.balance * 0.01
        is Account.MoneyMarketAccount -> account.balance * 0.03
    }
}

//In this example, we define a function called calculateInterest that takes an Account parameter and returns the interest earned on the account. We use a when expression to match on the type of the account and calculate the interest based on its type.
//
//By using a sealed class with when expressions, we can ensure that all possible account types are accounted for and that the function behaves correctly for all valid account types. This can help to prevent bugs and make the application more robust.


fun main(args: Array<String>) {
    val savingsAccount = Account.SavingsAccount(1000.0)
    val checkingAccount = Account.CheckingAccount(2000.0)
    val moneyMarketAccount = Account.MoneyMarketAccount(3000.0)
    
    val savingsInterest = calculateInterest(savingsAccount)
    val checkingInterest = calculateInterest(checkingAccount)
    val moneyMarketInterest = calculateInterest(moneyMarketAccount)
    
    println("Savings account interest: $savingsInterest")
    println("Checking account interest: $checkingInterest")
    println("Money market account interest: $moneyMarketInterest")
}