package top.kanetah.kotlin.pattern.interpreterPattern

import org.junit.Test

/**
 * create by kane on 2018/4/9.
 * 解释器模式：大数计算器
 * 计算一个逆波兰式
 */
class TestInterpreter {
    private val tokenString = Reverse_Polish_Notation@ ".8908 33442e3 20909 - 18.4 + * 2 /"
    @Test
    fun test() {
        println("result: ${RPNInterpreter(tokenString)}")
    }
}
