import org.w3c.dom.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.image.PixelInterleavedSampleModel;

public class BSTVisulization extends JFrame {
    private Node root;
    private JPanel topPanel,treePanel,infoPanel;
    private    JPanel topLeftPanel,topRightPanel;
    private  JButton btnAdd, btnDelete;
    private JTextField tf;
    private int x=300, Y=75;
    private Graphics2D g2;
    private Rectangle size;
    private JLabel labelPreoder,labelInoder,labelPostOder,labelHeight;
    private JLabel ansInoder,ansPreoder,ansPostoder,ansHeight;
    private FontMetrics fontMetrics;

    // Node Structure
    private static Class Node{
        static int TEXT_WIDTH =40;
        static int TEXT_HEIGHT=40;

        JLabel  data;
        Node Left;
        Node right;
        Points p;

        Node(int info) {
            data = new JLabel(info + "" , SwingConstants.CENTER);
            data.setFont(new Font("Arial",Font.BOLD,20));
            data.setBorder(BorderFactory.createLineBorder(Color.black));
            data.setOpaque(true);
            data.setBackground(Color.GREEN);
            p = null;
        }

    }

}
