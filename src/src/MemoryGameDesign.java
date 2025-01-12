import javax.swing.*;
import java.awt.*;

public class MemoryGameDesign {

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
        leftControls.setBackground(new Color(34,49,34));//Bg color - dark green
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

        String[] levels = {"Easy", "Medium", "Hard"};
        for (String level: levels) {
            JButton levelButton = createUniformButton(level);
            levelButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Selected Level:" + level));
            rightControls.add(levelButton);
            rightControls.add(Box.createVerticalStrut(10));
        }
        frame.add(rightControls, BorderLayout.EAST);


        //Main Panel for the cards, 2.row 2.column
        JPanel cardPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                int side = Math.min(getParent().getWidth(), getParent().getHeight());
                return new Dimension(side - 200, side - 200);
            }
        };
        cardPanel.setLayout(new GridLayout(3, 4, 10 ,10));
        cardPanel.setBackground(new Color(34, 49, 34));
        cardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (int a = 0; a < 12; a++) {
            JButton cardButton = new JButton();
            cardButton.setPreferredSize(new Dimension(100, 100));
            cardButton.setBackground(new Color(46, 77, 46));
            cardButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            cardPanel.add(cardButton);
        }
        frame.add(cardPanel, BorderLayout.CENTER);

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

    public static void main(String[] args) {
        new MemoryGameDesign();
    }
}
