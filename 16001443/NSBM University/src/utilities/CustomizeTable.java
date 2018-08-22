package utilities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomizeTable extends DefaultTableCellRenderer {

    private Component component;

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        component.setFont(new Font("Bookman Old Style", 0, 22));
        component.setForeground(Color.BLACK);
        component.setBackground(Color.WHITE);
        if (isSelected) {
            //component.setBackground(new Color(255,191,5));
            //component.setBackground(new Color(8,119,255));
            component.setBackground(new Color(200,200,200));
        }       
        return component;
    }
}
