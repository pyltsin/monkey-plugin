package com.github.pyltsin.monkeyplugin.runconfig

import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.KillableColoredProcessHandler
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.project.Project

class MonkeyApplicationCommandLineState(
    environment: ExecutionEnvironment,
    private val monkeyRunConfiguration: MonkeyRunConfiguration
) :
    CommandLineState(environment) {
    override fun startProcess(): ProcessHandler {
        val project: Project = monkeyRunConfiguration.getProject()
        val commandLine = GeneralCommandLine()
        commandLine.exePath = monkeyRunConfiguration.pathToGo
        val parametersList = commandLine.parametersList
        parametersList.add(monkeyRunConfiguration.pathToMonkey)
        val handler = KillableColoredProcessHandler(commandLine, true)
        ProcessTerminatedListener.attach(handler)
        return handler

    }
}
