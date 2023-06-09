import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TipCalc extends JFrame implements ActionListener, KeyListener {
    private JTextArea textAreaBill;
    private JLabel Bill;
    private JTextArea textAreaTip;
    private JTextArea textAreaPeople;
    private JTextArea textArea1;
    private JTextArea textAreaTotal;
    private JButton LessTip;
    private JButton MoreTip;
    private JButton LessPeople;
    private JButton MorePeople;
    private JLabel Tip;
    private JLabel Total;
    private JLabel PercentTip;
    private JLabel NumOfPeople;
    private JPanel MainPanel;
    private TipCalculator calculator;
    private double bill;
    private int percent;
    private int numOfPeople;

    public TipCalc(){
        createUIComponents();
        bill = Double.parseDouble(textAreaBill.getText());
        percent = Integer.parseInt(textAreaTip.getText());
        numOfPeople = Integer.parseInt(textAreaPeople.getText());
        calculator = new TipCalculator(bill, percent, numOfPeople);
    }
    private void createUIComponents(){
        setContentPane(MainPanel);
        setTitle("Tip Calculator GUI");
        setSize(500, 400);
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LessPeople.addActionListener(this);
        LessTip.addActionListener(this);
        MorePeople.addActionListener(this);
        MoreTip.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source instanceof JButton){
            JButton button = (JButton) source;
            String text = button.getText();
            if(text.equals("-") && percent != 0){
                calculator.setTipPercentage(percent--);
                textAreaTip.setText("" + percent);
            }else if(text.equals("+")){
                calculator.setTipPercentage(percent++);
                textAreaTip.setText("" + percent);
            }else if(text.equals("--") && numOfPeople != 0){
                calculator.setNumberOfPeople(numOfPeople--);
                textAreaPeople.setText("" + numOfPeople);
            }else if(text.equals("++")){
                calculator.setNumberOfPeople(numOfPeople++);
                textAreaPeople.setText("" + numOfPeople);
            }
        }
        bill = Double.parseDouble(textAreaBill.getText());
        calculator = new TipCalculator(bill, percent, numOfPeople);
        textArea1.setText("" + calculator.tipPerPerson());
        textAreaTotal.setText("" + calculator.totalBill());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
