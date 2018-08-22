package utilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomizeTableHeader extends DefaultTableCellRenderer {

    private Component component;

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setForeground(new Color(200,200,200));
        component.setBackground(new Color(0,0,0));
        component.setFont(new Font("Bookman Old Style", 1, 20));
        return component;
    }
}
