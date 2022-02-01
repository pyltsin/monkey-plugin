package com.github.pyltsin.monkeyplugin.runconfig

import com.intellij.openapi.options.SettingsEditor
import javax.swing.JComponent
import javax.swing.JPanel

class MonkeyRunConfigurationEditorForm : SettingsEditor<MonkeyRunConfiguration>() {

    private lateinit var mainPanel: JPanel;
    private lateinit var programArguments: com.intellij.ui.RawCommandLineEditor;
    private lateinit var workDirectory: com.intellij.ui.RawCommandLineEditor;

    override fun resetEditorFrom(configuration: MonkeyRunConfiguration) {
        programArguments.text = configuration.pathToGo;
        workDirectory.text = configuration.pathToMonkey;
    }

    override fun applyEditorTo(configuration: MonkeyRunConfiguration) {
        configuration.pathToGo = programArguments.text
        configuration.pathToMonkey = workDirectory.text
    }

    override fun createEditor(): JComponent {
        return mainPanel
    }
}
