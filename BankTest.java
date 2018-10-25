import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BankTest 
{
	
	public static void main(String[] args) 
	{
		
		final BankAccount account = new BankAccount(INITIAL_BALANCE);
		
		JLabel amountLabel = new JLabel("Amount: ");
		final JTextField amountField = new JTextField(10);
		final JTextArea textArea = new JTextArea(10, 30);
		
		//all the stuff for the transaction frame
		JFrame transactionFrame = new JFrame("Transaction Window");
		JPanel controlPanel = new JPanel();
		JButton withdrawButton = new JButton("Withdraw");
		JButton depositButton = new JButton("Deposit");
		
		class WithdrawListener implements ActionListener
		{
			
			public void actionPerformed (ActionEvent event)
			{
				
				double amount = Double.parseDouble(amountField.getText( ));
				account.withdraw(amount);
				textArea.append("Withdraw: " + (String.format("$%,1.2f%n", amount)));
				textArea.append("Balance: " + (String.format("$%,1.2f%n%n", account.getBalance( ))));
			}
			
		}
		
		ActionListener withdrawListener = new WithdrawListener();
		withdrawButton.addActionListener(withdrawListener);
		
		class DepositListener implements ActionListener
		{
			
			public void actionPerformed (ActionEvent event)
			{
				
				double amount = Double.parseDouble(amountField.getText());
				account.deposit(amount);
				textArea.append("Deposit: " + (String.format("$%,1.2f%n", amount)));
				textArea.append("Balance" + (String.format("$%,1.2f%n%n", account.getBalance( ))));
				
			}
			
		}
		
		ActionListener depositListener = new DepositListener();
		depositButton.addActionListener(depositListener);
		
		controlPanel.add(amountLabel);
		controlPanel.add(amountField);
		controlPanel.add(withdrawButton);
		controlPanel.add(depositButton);
		
		transactionFrame.add(controlPanel);
		transactionFrame.pack();
		transactionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		transactionFrame.setVisible(true);
		
		//all the stuff for the test frame
		JFrame testFrame = new JFrame();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.append("Beginning Balance: "         
		+ String.format("$%,1.2f%n%n", account.getBalance( )));
		testFrame.add(scrollPane);
		testFrame.setVisible(true);
		
	}
	
	private static final double INITIAL_BALANCE = 1000;
	
}
