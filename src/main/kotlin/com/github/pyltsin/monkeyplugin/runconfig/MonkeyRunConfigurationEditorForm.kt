package com.github.pyltsin.monkeyplugin.runconfig

import com.intellij.openapi.options.SettingsEditor
import javax.swing.JComponent
import javax.swing.JPanel

class MonkeyRunConfigurationEditorForm : SettingsEditor<MonkeyRunConfiguration>() {

    private lateinit var mainPanel: JPanel
    private lateinit var pathToGo: com.intellij.ui.RawCommandLineEditor
    private lateinit var pathToFile: com.intellij.ui.RawCommandLineEditor

    override fun resetEditorFrom(configuration: MonkeyRunConfiguration) {
        if (configuration.pathToGo.isNotBlank()) {
            pathToGo.text = configuration.pathToGo
        }
        pathToFile.text = configuration.pathToFile
    }

    override fun applyEditorTo(configuration: MonkeyRunConfiguration) {
        configuration.pathToGo = pathToGo.text
        configuration.pathToFile = pathToFile.text
    }

    override fun createEditor(): JComponent {
        return mainPanel
    }
}
