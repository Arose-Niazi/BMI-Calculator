import javax.swing.*;

public class BMI extends JFrame{

    private JPanel panel1;
    private JFormattedTextField weightFormattedTextField;
    private JFormattedTextField heightFormattedTextField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton calculateButton;
    private JFormattedTextField inchesFormattedTextField;
    private JTextPane rTextArea;

    public BMI() {
        setSize(500, 500);
        setContentPane(panel1);
        setLocationRelativeTo(null);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JFormattedTextField getWeightFormattedTextField() {
        return weightFormattedTextField;
    }

    public JFormattedTextField getHeightFormattedTextField() {
        return heightFormattedTextField;
    }

    public JFormattedTextField getInchesFormattedTextField() {
        return inchesFormattedTextField;
    }


    public JRadioButton getMaleRadioButton() {
        return maleRadioButton;
    }

    public JRadioButton getFemaleRadioButton() {
        return femaleRadioButton;
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }

    public JTextPane getrTextPane() {
        return rTextArea;
    }
}
