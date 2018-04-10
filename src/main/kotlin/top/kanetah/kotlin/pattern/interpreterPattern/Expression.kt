package top.kanetah.kotlin.pattern.interpreterPattern

import java.math.BigDecimal

/**
 * create by kane on 2018/4/9.
 * 表达式
 */
abstract class Expression {
    abstract fun interpret(): BigDecimal
    abstract override fun toString(): String
}

class PlusExpression(
        private val leftExpression: Expression, private val rightExpression: Expression
) : Expression() {
    override fun interpret() = leftExpression.interpret() + rightExpression.interpret()
    override fun toString() = "+"
}

class MinusExpression(
        private val leftExpression: Expression, private val rightExpression: Expression
) : Expression() {
    override fun interpret() = leftExpression.interpret() - rightExpression.interpret()
    override fun toString() = "-"
}

class MultiplyExpression(
        private val leftExpression: Expression, private val rightExpression: Expression
) : Expression() {
    override fun interpret() = leftExpression.interpret() * rightExpression.interpret()
    override fun toString() = "*"
}

class DivideExpression(
        private val leftExpression: Expression, private val rightExpression: Expression
) : Expression() {
    override fun interpret() = leftExpression.interpret() / rightExpression.interpret()
    override fun toString() = "/"
}

class NumberExpression(
        private val number: BigDecimal = BigDecimal(0)
) : Expression() {
    constructor(value: String) : this(value.toBigDecimal())

    override fun interpret() = number
    override fun toString() = "number"
}
