import javax.swing.*;
import java.awt.*;

public class MemoryGameDesign {
    private JPanel cardPanel;
    private int currentCardCount = 6; //default - easy level 6 cards
    private int rows = 2;
    private int cols = 3;

    public MemoryGameDesign() {
        //Creating main frame
        JFrame frame = new JFrame("Pair Pressure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700);
        frame.setLayout(new BorderLayout());

        //center frame on screen
        frame.setLocationRelativeTo(null);

        //Center Title 1.row
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(34, 49, 34));
        titlePanel.setPreferredSize(new Dimension(0, 80));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        JLabel titleLabel = new JLabel("Pair Pressure");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);

        //left controls
        JPanel leftControls = new JPanel();
        leftControls.setLayout(new BoxLayout(leftControls, BoxLayout.Y_AXIS));
        leftControls.setBackground(new Color(34, 49, 34));//Bg color - dark green
        leftControls.setPreferredSize(new Dimension(150, 150));
        leftControls.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //Start Button
        JButton startButton = createUniformButton("Start Game");
        startButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Game Starting. . ."));
        leftControls.add(startButton);

        leftControls.add(Box.createVerticalStrut(10));

        //Reset Button
        JButton resetButton = createUniformButton("Reset Game");
        resetButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Game Resetting. . ."));
        leftControls.add(resetButton);

        frame.add(leftControls, BorderLayout.WEST);

        //right controls
        JPanel rightControls = new JPanel();
        rightControls.setLayout(new BoxLayout(rightControls, BoxLayout.Y_AXIS));
        rightControls.setBackground(new Color(34, 49, 34));
        rightControls.setPreferredSize(new Dimension(150, 0));
        rightControls.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton easyButton = createUniformButton("Easy");
        easyButton.addActionListener(e -> {
            currentCardCount = 6;
            rows = 2;
            cols = 3;
            resetCards(currentCardCount, rows, cols);
        });
        rightControls.add(easyButton);

        JButton mediumButton = createUniformButton("Medium");
        mediumButton.addActionListener(e -> {
            currentCardCount = 8;
            rows = 2;
            cols = 4;
            resetCards(currentCardCount, rows, cols);
        });
        rightControls.add(mediumButton);

        JButton hardButton = createUniformButton("Hard");
        hardButton.addActionListener(e -> {
            currentCardCount = 12;
            rows = 3;
            cols = 4;
            resetCards(currentCardCount, rows, cols);
        });
        rightControls.add(hardButton);

        frame.add(rightControls, BorderLayout.EAST);


        //Main Panel for the cards, 2.row 2.column
        cardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int panelWidth = getWidth();
                int panelHeight = getHeight();

                int cardWidth = panelWidth / cols;
                int cardHeight = panelHeight / rows;
                int cardSize = Math.min(cardWidth, cardHeight);

                int xOffset = (panelWidth - (cardSize * cols)) / 2;
                int yOffset = (panelHeight - (cardSize * rows)) / 2;

                g.setColor(new Color(46, 77, 46));
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        if (row * cols + col >= currentCardCount) break;
                        int x = xOffset + col * cardSize;
                        int y = yOffset + row * cardSize;
                        g.fillRect(x, y, cardSize - 10, cardSize - 10);
                        g.setColor(Color.BLACK);
                        g.drawRect(x, y, cardSize - 10, cardSize - 10);
                    }
                }
            }
        };
        cardPanel.setBackground(new Color(34, 49, 34));
        frame.add(cardPanel, BorderLayout.CENTER);

        resetCards(currentCardCount, rows, cols);

        //PARDIIIIIS INSERT INITIALIZE CARDS HERE!!

        //Display frame
        frame.setVisible(true);

    }

    private JButton createUniformButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Times New Roman", Font.BOLD, 14));
        button.setBackground(new Color(46, 77, 46));
        button.setForeground(Color.WHITE);

        Dimension buttonSize = new Dimension(120, 40);
        button.setPreferredSize(buttonSize);
        button.setMaximumSize(buttonSize);
        button.setMinimumSize(buttonSize);

        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        return button;
    }

    private void resetCards(int cardCount, int rows, int cols) {
        cardPanel.repaint();
    }

    public static void main(String[] args) {
        new MemoryGameDesign();
    }
}
