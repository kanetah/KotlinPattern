package top.kanetah.kotlin.pattern.interpreterPattern

import java.util.*

/**
 * create by kane on 2018/4/9.
 * 此解释器中定义了对逆波兰式的解释规则
 */
object RPNInterpreter {
    operator fun invoke(rpn: String) = with(Stack<Expression>()) {
        val tokenList = rpn.split(" ").dropLastWhile { it.isEmpty() }.toTypedArray()
        tokenList.forEach { elem ->
            if (isOperator(elem)) {
                val rightExpression = pop() alsoLog "popped from stack left"
                val leftExpression = pop() alsoLog "                 right"
                val operator = getOperatorInstance(elem, leftExpression, rightExpression)
                println("operator: $operator")
                val result = operator.interpret()
                push(NumberExpression(result) alsoLog "push result to stack")
            } else {
                push(NumberExpression(elem) alsoLog "push to stack")
            }
        }
        return@with pop().interpret()
    }

    private fun isOperator(s: String) = setOf("+", "-", "*", "/").contains(s)

    private fun getOperatorInstance(s: String, left: Expression, right: Expression) = when (s) {
        "+" -> PlusExpression(left, right)
        "-" -> MinusExpression(left, right)
        "*" -> MultiplyExpression(left, right)
        "/" -> DivideExpression(left, right)
        else -> throw IllegalArgumentException("this operator has not impl.")
    }

    private infix fun Expression.alsoLog(message: String) = this.also { println("$message: ${this.interpret()}") }
}
