
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;


public class BMIC implements WindowListener {
    private JPanel panel1;
    private JFormattedTextField weightFormattedTextField;
    private JFormattedTextField heightFormattedTextField;
    private JFormattedTextField inchesFormattedTextField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton calculateButton;
    private JTextPane rTextArea;

    private ButtonGroup sexbuttons = new ButtonGroup();
    private BMI b;


    public BMIC() {
        CreateBMISetup();
        SetupActions();
    }

    private void CreateBMISetup() {
        b = new BMI();

        panel1 = b.getPanel1();
        b.addWindowListener(this);
        weightFormattedTextField = b.getWeightFormattedTextField();
        heightFormattedTextField = b.getHeightFormattedTextField();
        inchesFormattedTextField = b.getInchesFormattedTextField();
        maleRadioButton = b.getMaleRadioButton();
        femaleRadioButton = b.getFemaleRadioButton();
        calculateButton = b.getCalculateButton();
        rTextArea = b.getrTextPane();
        rTextArea.setContentType("text/html");


        sexbuttons.add(femaleRadioButton);
        sexbuttons.add(maleRadioButton);


    }

    private void SetupActions() {
        calculateButton.addActionListener(new calculate());
    }

    public void Show() {
        b.setVisible(true);
    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    public void windowOpened(WindowEvent e) {
    }
    public void windowClosed(WindowEvent e) {
    }
    public void windowIconified(WindowEvent e) {
    }
    public void windowDeiconified(WindowEvent e) {
    }
    public void windowActivated(WindowEvent e) {
    }
    public void windowDeactivated(WindowEvent e) {
    }

    public class calculate implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            String Text="";
            Double weight;
            try {
                String c = weightFormattedTextField.getText();
                weight = Double.parseDouble(c);
                if (weight > 0.0) {
                    Text += "<html><center><font color=white>"+ "Weight: "+ weight + " KG<br>" ;
                }
                else throw new NumberFormatException(null);
            }
            catch (NumberFormatException e) {

                rTextArea.setText("<html><nobr><font color=\"#ff0000\"><b>ERROR: Invalid weight.</b></font></nobr></html>");
                return;
            }
            Integer height;
            try {
                String c = heightFormattedTextField.getText();
                height = Integer.parseInt(c);
                if (height > 0) {
                    Text += "Height: " + height + "'" ;
                }
                else throw new NumberFormatException(null);
            }
            catch (NumberFormatException e) {
                rTextArea.setText("<html><nobr><font color=\"#ff0000\"><b>ERROR: Invalid height in feet.</b></font></nobr></html>");
                return;
            }
            Integer height2;
            try {
                String c = inchesFormattedTextField.getText();
                height2 = Integer.parseInt(c);
                if (height2 >= 0) {
                    Text += height2 + "''<br>" ;
                }
                else throw new NumberFormatException(null);
            }
            catch (NumberFormatException e) {
                rTextArea.setText("<html><nobr><font color=\"#ff0000\"><b>ERROR: Invalid height in inches.</b></font></nobr></html>");
                return;
            }

            Double heightm = Double.valueOf(height) /  3.281;
            heightm += Double.valueOf(height2) / 39.37;
            heightm *= heightm;
            Double bmi = weight / heightm;
            if(bmi >= 18.5) {
                if (bmi >= 25.0)
                    if (bmi >= 30.0)
                        Text += "<nobr><font color=red><b>" + "***You are TOO FAT***\n";
                    else Text += "<nobr><font color=Fuchsia><b>" + "***You are FAT***\n";
                else Text += "</font><nobr><font color=green><b>" + "***You are PERFECT***<br>";
            }
            else Text += "<nobr><font color=red><b>"+"***You are UNDERWEIGHT***\n" ;

            Text+="</b></font></nobr></center><</html>" ;

            rTextArea.setText(Text);
        }
    }
}