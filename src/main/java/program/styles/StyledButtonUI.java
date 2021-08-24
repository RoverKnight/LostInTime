package program.styles;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class StyledButtonUI extends BasicButtonUI {

    @Override
    public void installUI (JComponent c) {
        super.installUI(c);
        c.setOpaque(false);
        c.setBorder(new EmptyBorder(5, 15, 5, 15));
        // turn off for cool effect
        c.setBorder(new BevelBorder(0));
        //c.setFont(new Font("Ubuntu Mono", Font.BOLD, 15));

    }

    @Override
    public void paint (Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
        super.paint(g, c);
    }

    private void paintBackground (Graphics g, JComponent c, int yOffset) {
        Dimension size = c.getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color color = new Color(240, 240, 240);
        g.setColor(color.darker());
        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 3, 3);
        g.setColor(color);
        g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 3, 3, 3);
    }
}
