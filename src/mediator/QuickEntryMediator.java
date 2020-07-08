package mediator;

import javax.swing.*;
import javax.swing.text.html.ListView;
import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/// <summary>
/// QuickEntryMediator. This class takes a TextBox and a
/// ListBox. It assumes that the user will type
/// characters into the TextBox that are prefixes of
/// entries in the ListBox. It automatically selects the
/// first item in the ListBox that matches the current
/// prefix in the TextBox.
///
/// If the TextField is null, or the prefix does not
/// match any element in the ListBox, then the ListBox
/// selection is cleared.
///
/// There are no methods to call for this object. You
/// simply create it, and forget it. (But don't let it
/// be garbage collected...)
///
/// Example:
///
/// TextBox t = new TextBox();
/// ListBox l = new ListBox();
///
/// QuickEntryMediator qem = new QuickEntryMediator(t,l);
/// // that's all folks.
///
/// Originally written in Java
/// by Robert C. Martin, Robert S. Koss
/// on 30 Jun, 1999 2113 (SLAC)
/// Translated to C# by Micah Martin
/// on May 23, 2005 (On the Train)
/// </summary>
public class QuickEntryMediator {
    private TextField itsTextBox;
    private JList<String> itsList;

    public QuickEntryMediator(TextField t, JList<String> l) {
        itsTextBox = t;
        itsList = l;
        itsTextBox.addTextListener(this::textFieldChanged);
    }

    private void textFieldChanged(TextEvent e) {
        String prefix = itsTextBox.getText();
        if (prefix.length() == 0) {
            itsList.clearSelection();
            return;
        }

        Component[] listItems = itsList.getComponents();
        boolean found = false;
        for (int i = 0; !found && i < listItems.length; i++) {
            Object o = listItems[i];
            String s = o.toString();
            if (s.startsWith(prefix)) {
                itsList.setSelectedIndex(i);
                found = true;
            }
        }
        if (!found) {
            itsList.clearSelection();
        }
    }
}
