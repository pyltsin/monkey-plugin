package com.github.pyltsin.monkeyplugin.psi.impl


data class MonkeyTypeResolvedResult(
    val monkeyType: MonkeyType,
    //for simplification - error explanation. It is better to show type error, and then create message in caller.
    val error: MonkeyTypeResolvedError?
) : Comparable<MonkeyTypeResolvedResult> {
    override fun compareTo(other: MonkeyTypeResolvedResult): Int {
        return if ((error == null && other.error == null) || (error != null && other.error != null)) {
            if (monkeyType != UNKNOWN_TYPE && other.monkeyType == UNKNOWN_TYPE) {
                1
            } else if (monkeyType == UNKNOWN_TYPE && other.monkeyType != UNKNOWN_TYPE) {
                -1
            } else {
                0
            }
        } else if (error == null) {
            1
        } else {
            -1
        }
    }
}

data class MonkeyTypeResolvedError(val explanation: String)

interface MonkeyType {
}

data class MonkeyErrorType(val explanation: String);


class CertainMonkeyType(private val builtInType: MonkeyBuiltInType) : MonkeyType {
    fun getType(): MonkeyBuiltInType {
        return builtInType
    }
}


val STRING_TYPE = CertainMonkeyType(MonkeyBuiltInType.STRING)
val INT_TYPE = CertainMonkeyType(MonkeyBuiltInType.INT)
val BOOLEAN_TYPE = CertainMonkeyType(MonkeyBuiltInType.BOOLEAN)
val MAP_TYPE = CertainMonkeyType(MonkeyBuiltInType.MAP)
val ARRAY_TYPE = CertainMonkeyType(MonkeyBuiltInType.ARRAY)
val FUNCTION_TYPE = CertainMonkeyType(MonkeyBuiltInType.FUNCTION)
val NOTHING_TYPE = CertainMonkeyType(MonkeyBuiltInType.NOTHING)
val UNKNOWN_TYPE = CertainMonkeyType(MonkeyBuiltInType.UNKNOWN)

enum class MonkeyBuiltInType {
    STRING, INT, BOOLEAN, MAP, ARRAY, FUNCTION, NOTHING, UNKNOWN
}
