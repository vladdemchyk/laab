import java.lang.Exception

class PasswordMismatchException(message: String) : Exception(message)

fun main() {
    print("Введіть логін: ")
    val loginInput = readLine()

    print("Введіть пароль: ")
    val password1 = readLine()

    print("Повторіть пароль: ")
    val password2 = readLine()

    val login = loginInput ?: "guest"
    val password = password1 ?: "123456"
    val repeatedPassword = password2 ?: "123456"

    try {
        if (password != repeatedPassword) {
            throw PasswordMismatchException("Паролі не збігаються!")
        }

        if (password.length < 8) {
            println("Пароль має містити щонайменше 8 символів.")
            return
        }
        if (!password.contains(Regex("[A-Z]"))) {
            println("Пароль має містити хоча б одну велику літеру.")
            return
        }
        if (!password.contains(Regex("[0-9]"))) {
            println("Пароль має містити хоча б одну цифру.")
            return
        }

        println("Користувача \"$login\" зареєстровано успішно!")

    } catch (e: PasswordMismatchException) {
        println("Помилка: ${e.message}")
    }
}

