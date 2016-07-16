package com.github.shiraji.ipgwizard.step;

import com.github.shiraji.ipgwizard.IPGWizardBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.util.Disposer;
import com.intellij.ui.components.JBList;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class IPGWizardSupportLanguageStep extends ModuleWizardStep implements Disposable {
    private JPanel panel;
    private JBList list;
    private JComboBox languageComboBox;
    private WizardContext context;
    private IPGWizardBuilder builder;

    public enum Language {
        JAVA("Java"),
        KOTLIN("Kotlin");

        private final String name;

        Language(String name) {
            this.name = name;
        }
    }

    static {
    }

    public IPGWizardSupportLanguageStep(WizardContext context, IPGWizardBuilder builder) {
        this.context = context;
        this.builder = builder;
        for (Language language : Language.values()) {
            languageComboBox.addItem(language);
        }
    }

    @Override
    public JComponent getComponent() {
        return panel;
    }

    @Override
    public void updateDataModel() {
        builder.setLanguage(Language.values()[languageComboBox.getSelectedIndex()].name);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void disposeUIResources() {
        Disposer.dispose(this);
    }
}
