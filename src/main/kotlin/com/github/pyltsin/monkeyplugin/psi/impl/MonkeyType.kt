package com.github.pyltsin.monkeyplugin.psi.impl

interface MonkeyType {
}

class MaybeMonkeyType(private val builtInTypes: List<MonkeyBuiltInType>) : MonkeyType {
    fun getType(): List<MonkeyBuiltInType> {
        return builtInTypes
    }
}

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
