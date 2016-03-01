import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Checkbox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;




public class launch {

	private JFrame frmMain;
	private JTextField txtPassengerName;
	private JTextField txtBookingReference;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					launch window = new launch();
					window.frmMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public launch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMain = new JFrame();
		frmMain.setResizable(false);
		frmMain.setTitle("Airline Booker 9001");
		frmMain.setBounds(100, 100, 747, 593);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(null);
		
		Button btnBookFlights = new Button("Book Flights");
		btnBookFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Hello World");
				
			}
		});
		
		JComboBox cboSeatType = new JComboBox();
		cboSeatType.setBounds(10, 252, 93, 20);
		frmMain.getContentPane().add(cboSeatType);
		btnBookFlights.setBounds(204, 523, 70, 22);
		frmMain.getContentPane().add(btnBookFlights);
		
		Button btnClear = new Button("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "This should clear all values and reset to default (including closing additional tabs)");
			}
		});
		btnClear.setBounds(280, 523, 70, 22);
		frmMain.getContentPane().add(btnClear);
		
		Button btnExit = new Button("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you wish to exit?\n(All unsaved progress will be lost!)", "Are you sure you wish to continue?", 0);
				if (result == 0)
					System.exit(0);
			}
		});
		btnExit.setBounds(356, 523, 70, 22);
		frmMain.getContentPane().add(btnExit);
		
		Button btnMaintenance = new Button("Maintenance");
		btnMaintenance.setBounds(430, 523, 75, 22);
		frmMain.getContentPane().add(btnMaintenance);
		
		Label lblDeparture = new Label("Departure");
		lblDeparture.setBounds(10, 112, 62, 22);
		frmMain.getContentPane().add(lblDeparture);
		
		Label lblPassengerName = new Label("Passenger name");
		lblPassengerName.setBounds(10, 33, 100, 22);
		frmMain.getContentPane().add(lblPassengerName);
		
		Label lblBookingReference = new Label("Booking Reference");
		lblBookingReference.setBounds(450, 33, 113, 22);
		frmMain.getContentPane().add(lblBookingReference);
		
		Label lblDestination = new Label("Destination");
		lblDestination.setBounds(450, 112, 70, 22);
		frmMain.getContentPane().add(lblDestination);
		
		Checkbox chkCarryOn = new Checkbox("Carry On Luggage");
		chkCarryOn.setBounds(17, 463, 113, 22);
		frmMain.getContentPane().add(chkCarryOn);
		
		JComboBox cboDeparture = new JComboBox();
		cboDeparture.setBounds(10, 144, 93, 20);
		frmMain.getContentPane().add(cboDeparture);
		
		JComboBox cboDestination = new JComboBox();
		cboDestination.setBounds(450, 144, 95, 20);
		frmMain.getContentPane().add(cboDestination);
		
		Label lblSeatType = new Label("Seat Type");
		lblSeatType.setBounds(10, 224, 62, 22);
		frmMain.getContentPane().add(lblSeatType);
		
		txtPassengerName = new JTextField();
		txtPassengerName.setBounds(10, 61, 217, 20);
		frmMain.getContentPane().add(txtPassengerName);
		txtPassengerName.setColumns(10);
		
		txtBookingReference = new JTextField();
		txtBookingReference.setBounds(450, 61, 142, 20);
		frmMain.getContentPane().add(txtBookingReference);
		txtBookingReference.setColumns(10);
		
		JButton btnHelp = new JButton("Help ?");
		btnHelp.setBounds(642, 11, 89, 23);
		frmMain.getContentPane().add(btnHelp);
		
		JPanel pnlFlightType = new JPanel();
		pnlFlightType.setBounds(278, 61, 107, 103);
		frmMain.getContentPane().add(pnlFlightType);
		
		JRadioButton rdoOneWay = new JRadioButton("One way");
		pnlFlightType.add(rdoOneWay);
		
		JRadioButton rdoReturn = new JRadioButton("Return");
		pnlFlightType.add(rdoReturn);
		
		JRadioButton rdoSecondLeg = new JRadioButton("Second Leg");
		pnlFlightType.add(rdoSecondLeg);
	}
}
