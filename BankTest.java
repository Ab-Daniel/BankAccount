import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankTest 
{
	
	public static void main(String[] args) 
	{
		
		final BankAccount account = new BankAccount(INITIAL_BALANCE);
		
		JLabel amountLabel = new JLabel();
		final JTextField amountField = new JTextField(10);
		
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
		
	}
	
	private static final double INITIAL_BALANCE = 1000;
	
}