package com.github.shiraji.ipgwizard.step;

import com.github.shiraji.ipgwizard.IPGWizardBuilder;
import com.github.shiraji.ipgwizard.config.IPGWizardConfig;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.util.Disposer;
import com.intellij.ui.components.JBList;

import javax.swing.*;

public class IPGWizardSupportLanguageStep extends ModuleWizardStep implements Disposable {
    private JPanel panel;
    private JBList list;
    private JComboBox<Language> languageComboBox;
    private WizardContext context;
    private IPGWizardBuilder builder;

    public enum Language {
        JAVA("Java"),
        KOTLIN("Kotlin");

        private final String name;

        Language(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static {
    }

    public IPGWizardSupportLanguageStep(WizardContext context, IPGWizardBuilder builder) {
        this.context = context;
        this.builder = builder;
        languageComboBox.setModel(new DefaultComboBoxModel<>(Language.values()));
        languageComboBox.setSelectedIndex(IPGWizardConfig.getLanguage());
    }

    @Override
    public JComponent getComponent() {
        return panel;
    }

    @Override
    public void updateDataModel() {
        int selectedIndex = languageComboBox.getSelectedIndex();
        String language = Language.values()[selectedIndex].toString().toLowerCase();
        builder.setLanguage(language);
        IPGWizardConfig.setLanguage(selectedIndex);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void disposeUIResources() {
        Disposer.dispose(this);
    }
}
