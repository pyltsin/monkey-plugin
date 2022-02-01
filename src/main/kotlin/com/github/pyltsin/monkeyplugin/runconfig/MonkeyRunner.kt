package com.github.pyltsin.monkeyplugin.runconfig

import com.intellij.execution.configurations.RunProfile
import com.intellij.execution.executors.DefaultRunExecutor
import com.intellij.execution.runners.DefaultProgramRunner

class MonkeyRunner : DefaultProgramRunner() {
    private val MONKEY_RUNNER_ID = "MonkeyRunner"

    override fun getRunnerId(): String {
        return MONKEY_RUNNER_ID
    }

    override fun canRun(executorId: String, profile: RunProfile): Boolean {
        return DefaultRunExecutor.EXECUTOR_ID == executorId &&
                (profile is MonkeyRunConfiguration)
    }
}
