import org.w3c.dom.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.PixelInterleavedSampleModel;
import java.util.Stack;

import static jdk.internal.misc.OSEnvironment.initialize;

public class BSTVisulization extends JFrame {
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

            Node(int info){
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

        public void paint(Graphics g){
        super.paintComponents(g);

        g2= (Graphics2D) g;
        g2.setStroke(new BasicStroke(3.0f));

            Stack<Node> s = new Stack<>();
            Node curr = root;
            Points pts;
            int offset = topPanel.getBounds().height;

            while (!s.isEmpty() || curr != null){
                while(curr != null){
                    s.push(curr);
                    curr = curr.left;
                }
                if (!s.isEmpty())
                    curr = s.pop();
                pts = curr.p;
                g2.drawLine(pts.x1+7,pts.y1+30+offset,pts.x2+3,pts.y2+10+offset);
                curr=curr.right;
            }
        }

        public BSTVisulization(){
        initialize();
        }

        private void initialize(){
        setSize(1300,700);

        size = getBounds();
        x = size.width/2;

        topPanel = new JPanel(new BorderLayout());
        Rectangle top = topPanel.getBounds();

        topLeftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        topPanel.add(topLeftPanel,BorderLayout.WEST);

        topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topPanel.add(topRightPanel,BorderLayout.EAST);

        }
    }

