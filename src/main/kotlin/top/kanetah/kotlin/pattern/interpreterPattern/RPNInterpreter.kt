package top.kanetah.kotlin.pattern.interpreterPattern

import java.math.BigDecimal
import java.util.*

/**
 * create by kane on 2018/4/9.
 * 此解释器中定义了对逆波兰式的解释规则
 */
object RPNInterpreter {
    operator fun invoke(rpn: String): BigDecimal = with(Stack<Expression>()) {
        val tokenList = rpn.split(" ").dropLastWhile { it.isEmpty() }.toTypedArray()
        tokenList.forEach { elem ->
            if (isOperator(elem)) {
                val (rightExpression, leftExpression) = synchronized(this) {
                    data class Expressions(val right: Expression, val left: Expression)
                    Expressions(
                            pop() alsoLog "popped from stack right",
                            pop() alsoLog "                  left"
                    )
                }
                val operator = operatorInstance(elem, leftExpression, rightExpression)
                println("operator: $operator")
                val result = operator.interpret()
                push(NumberExpression(result) alsoLog "push result to stack")
            } else {
                push(NumberExpression(elem) alsoLog "push to stack")
            }
        }
        pop().interpret()
    }

    private fun isOperator(s: String) = setOf("+", "-", "*", "/").contains(s)

    private fun operatorInstance(operator: String, left: Expression, right: Expression) = when (operator) {
        "+" -> PlusExpression(left, right)
        "-" -> MinusExpression(left, right)
        "*" -> MultiplyExpression(left, right)
        "/" -> DivideExpression(left, right)
        else -> throw IllegalArgumentException("operator: $operator has not impl.")
    }

    private infix fun Expression.alsoLog(message: Any?) = this.also { println("$message: ${interpret()}") }
}
