import org.w3c.dom.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.PixelInterleavedSampleModel;

public class BSTVisulization extends JFrame implements ActionListener, KeyListener {
    private Node root;
    private JPanel topPanel, treePanel, infoPanel;
    private JPanel topLeftPanel, topRightPanel;
    private JButton btnAdd, btnDelete;
    private JTextField tf;
    private int x = 300, Y = 75;
    private Graphics2D g2;
    private Rectangle size;
    private JLabel labelPreoder, labelInoder, labelPostOder, labelHeight;
    private JLabel ansInoder, ansPreoder, ansPostoder, ansHeight;
    private FontMetrics fontMetrics;

    // Node Structure
    private static Class Node{
            static int TEXT_WIDTH = 40;
            static int TEXT_HEIGHT = 40;

            JLabel data;
            Node Left;
            Node right;
            Points p;

            Node( int info){
            data = new JLabel(info + "", SwingConstants.CENTER);
            data.setFont(new Font("Arial", Font.BOLD, 20));
            data.setBorder(BorderFactory.createLineBorder(Color.black));
            data.setOpaque(true);
            data.setBackground(Color.GREEN);
            p = null;
        }
    }

    //Points Structure
        private static class Points {
            int x1 = 0, x2 = 0, y1 = 0, y2 = 0;

            public Points(int x1, int x2, int y1, int y2) {
                this.x1 = x1;
                this.x2 = x2;
                this.y1 = y1;
                this.y2 = y2;
            }

            public String toString() {
                return "Points{" +
                        "x1=" + x1 +
                        ", x2=" + x2 +
                        ", y1=" + y1 +
                        ", y2=" + y2 +
                        '}';
            }
        }

        //For Storing the height of the root, left and right child height.
        private static class Height{
            int root, left, right;

            Height() {
                this.root = 0;
                this.left = 0;
                this.right = 0;
            }

            public Height(int left, int right) {
                this.left = left;
                this.right = right;
            }

            @Override
                public String toString() {
                    return Integer.toString(this.root);
            }
        }
    }

