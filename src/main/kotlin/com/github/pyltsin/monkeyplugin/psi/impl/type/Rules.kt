package com.github.pyltsin.monkeyplugin.psi.impl.type

import com.github.pyltsin.monkeyplugin.psi.MonkeyExpr
import com.github.pyltsin.monkeyplugin.psi.impl.CertainMonkeyType
import com.github.pyltsin.monkeyplugin.psi.impl.MonkeyTypeResolvedResult


fun allRules(function: RulesWithClasses.() -> Unit): RulesWithClasses {
    val rulesWithClasses = RulesWithClasses()
    function.invoke(rulesWithClasses)
    return rulesWithClasses
}

@DslMarker
annotation class Marker

@Marker
class RulesWithClasses {
    private val rules = mutableListOf<RuleWithClass<*>>()
    fun <T : MonkeyExpr> rule(
        clazz: Class<T>,
        negativeResult: MonkeyTypeResolvedResult?,
        classedRules: ClassedRules<T>.() -> Unit
    ) {
        val innerRules = ClassedRules<T>()
        classedRules.invoke(innerRules)
        rules.add(RuleWithClass(clazz, negativeResult, innerRules))
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : MonkeyExpr> resolve(expr: T): MonkeyTypeResolvedResult? {
        return rules
            .filter { it.support(expr) }
            .mapNotNull { (it as RuleWithClass<T>).resolve(expr) }
            .maxOfOrNull { it }
    }
}

@Marker
data class RuleWithClass<T : MonkeyExpr>(
    private val clazz: Class<T>,
    private val negativeResult: MonkeyTypeResolvedResult?,
    private val classedRules: ClassedRules<T>
) {
    fun support(expr: MonkeyExpr): Boolean {
        return clazz.isInstance(expr)
    }

    fun resolve(expr: T): MonkeyTypeResolvedResult? {
        if (!support(expr)) {
            return null
        }
        return classedRules.resolve(expr) ?: negativeResult
    }
}

@Marker
class ClassedRules<T : MonkeyExpr> {
    private val classedRules = mutableListOf<ResolveFunctionForType<T>>()
    fun runRule(rule: (T) -> MonkeyTypeResolvedResult?) {
        classedRules.add(rule)
    }

    fun exprRule(init: TypesExprRules<T>.() -> Unit) {
        val indexRule = TypesExprRules<T>()
        init(indexRule)
        classedRules.add(indexRule.getRule())
    }

    fun resolve(expr: T): MonkeyTypeResolvedResult? {
        return classedRules
            .mapNotNull { it.invoke(expr) }
            .firstOrNull()
    }
}

typealias ResolveFunctionForType<T> = (T) -> MonkeyTypeResolvedResult?

@Marker
class TypesExprRules<T : MonkeyExpr> {
    private val rules = mutableListOf<TypesExprRule<T>>()
    fun expr(init: TypesExprRule<T>.() -> Unit) {
        val typesExprRule = TypesExprRule<T>()
        init.invoke(typesExprRule)
        rules.add(typesExprRule)
    }

    var result: MonkeyTypeResolvedResult? = null

    fun getRule(): ResolveFunctionForType<T> {
        return {
            var returnResult = result
            for (rule in rules) {
                val expr = rule.expr?.invoke(it)
                if (expr?.resolveType()?.monkeyType in rule.availableTypes) {
                    continue
                } else {
                    returnResult = null
                    break
                }
            }
            returnResult
        }
    }
}

@Marker
class TypesExprRule<T : MonkeyExpr> {
    var expr: (T.() -> MonkeyExpr?)? = null
    var availableTypes: List<CertainMonkeyType> = mutableListOf()
}

