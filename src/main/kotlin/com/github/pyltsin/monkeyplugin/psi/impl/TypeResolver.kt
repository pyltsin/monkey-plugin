package com.github.pyltsin.monkeyplugin.psi.impl

import com.github.pyltsin.monkeyplugin.psi.*
import com.github.pyltsin.monkeyplugin.psi.impl.type.allRules

private const val CAN_T_RESOLVE_TYPE = "Can't resolve type"
val negativeResult = MonkeyTypeResolvedResult(UNKNOWN_TYPE, MonkeyTypeResolvedError(CAN_T_RESOLVE_TYPE))

object TypeResolver {

    private val RULES = allRules {
        rule(
            clazz = MonkeyParenExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                runRule {
                    it.expr?.resolveType() ?: negativeResult
                }
            }
        )
        rule(
            clazz = MonkeyFuncExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                runRule {
                    MonkeyTypeResolvedResult(FUNCTION_TYPE, null)
                }
            }
        )
        rule(
            clazz = MonkeyLiteralExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                runRule {
                    if ((it.boolLiteral) != null) {
                        MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                    } else if (((it.numericLiteral) != null)) {
                        MonkeyTypeResolvedResult(INT_TYPE, null)
                    } else if (((it.stringLiteral) != null)) {
                        MonkeyTypeResolvedResult(STRING_TYPE, null)
                    } else {
                        negativeResult
                    }
                }
            }
        )
        rule(
            clazz = MonkeyIndexExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                exprRule {
                    expr {
                        expr = { exprList[0] }
                        availableTypes = listOf(ARRAY_TYPE, MAP_TYPE, UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(UNKNOWN_TYPE, null)
                }
            }
        )
        rule(
            clazz = MonkeyCallExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                exprRule {
                    expr {
                        expr = { expr }
                        availableTypes = listOf(FUNCTION_TYPE, UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(UNKNOWN_TYPE, null)
                }
            }
        )
        rule(
            clazz = MonkeySimpleRefExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                runRule { expr: MonkeySimpleRefExpr ->
                    val resolved = expr.resolve()
                    if (resolved is MonkeyLetStatement) {
                        resolved.expr?.resolveType()
                    } else {
                        MonkeyTypeResolvedResult(UNKNOWN_TYPE, null)
                    }
                }
            }
        )
        rule(
            clazz = MonkeyUnaryNotExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                exprRule {
                    expr {
                        expr = { expr!! }
                        availableTypes = listOf(BOOLEAN_TYPE, UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
            }
        )
        rule(
            clazz = MonkeyUnaryMinExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                exprRule {
                    expr {
                        expr = { expr }
                        availableTypes = listOf(INT_TYPE, UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(INT_TYPE, null)
                }
            }
        )
        rule(
            clazz = MonkeyMulExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(INT_TYPE, UNKNOWN_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(INT_TYPE, UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(INT_TYPE, null)
                }
            }
        )
        rule(
            clazz = MonkeyDivExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(INT_TYPE, UNKNOWN_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(INT_TYPE, UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(INT_TYPE, null)
                }
            }
        )
        rule(
            clazz = MonkeyMinusExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(INT_TYPE, UNKNOWN_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(INT_TYPE, UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(INT_TYPE, null)
                }
            }
        )
        rule(
            clazz = MonkeyPlusExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(INT_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(INT_TYPE, UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(INT_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(STRING_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(STRING_TYPE, UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(STRING_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(UNKNOWN_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(UNKNOWN_TYPE, INT_TYPE, STRING_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(UNKNOWN_TYPE, null)
                }
            }
        )
        rule(
            clazz = MonkeyLessExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(INT_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(INT_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(STRING_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(STRING_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
            }
        )
        rule(
            clazz = MonkeyMoreExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(INT_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(INT_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(STRING_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(STRING_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
            }
        )
        rule(
            clazz = MonkeyEqualExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(INT_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(INT_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(STRING_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(STRING_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(BOOLEAN_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(BOOLEAN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
            }
        )
        rule(
            clazz = MonkeyNotEqualExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(INT_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(INT_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(STRING_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(STRING_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(BOOLEAN_TYPE)
                    }
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(BOOLEAN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(0) }
                        availableTypes = listOf(UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
                exprRule {
                    expr {
                        expr = { exprList.getOrNull(1) }
                        availableTypes = listOf(UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(BOOLEAN_TYPE, null)
                }
            }
        )
        rule(
            clazz = MonkeyIfExpr::class.java,
            negativeResult = negativeResult,
            classedRules = {
                exprRule {
                    expr {
                        expr = { ifCond?.expr }
                        availableTypes = listOf(BOOLEAN_TYPE, UNKNOWN_TYPE)
                    }
                    result = MonkeyTypeResolvedResult(UNKNOWN_TYPE, null)
                }
            }
        )
    }

    @JvmStatic
    fun resolveType(expr: MonkeyExpr): MonkeyTypeResolvedResult? {
        return RULES.resolve(expr)
    }
}
