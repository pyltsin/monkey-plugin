package com.github.pyltsin.monkeyplugin.psi

import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiNameIdentifierOwner

interface MonkeyNamedElement : MonkeyCompositeElement, PsiNameIdentifierOwner, NavigatablePsiElement
