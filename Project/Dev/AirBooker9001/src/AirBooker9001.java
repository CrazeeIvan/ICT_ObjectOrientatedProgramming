import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AirBooker9001 {
	private static Text txtPassengerName;
	private static Text txtReferenceID;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

Display display = new Display();
Shell shlAirbooker = new Shell(display);
shlAirbooker.setSize(602, 561);
shlAirbooker.setText("AirBooker9001");
Combo cboDeparture = new Combo(shlAirbooker, SWT.NONE);
cboDeparture.setBounds(26, 72, 91, 23);
Combo cboDestination = new Combo(shlAirbooker, SWT.NONE);
cboDestination.setBounds(396, 72, 91, 23);
Composite composite = new Composite(shlAirbooker, SWT.NONE);
composite.setBounds(215, 72, 100, 83);
Button btnSecondLeg = new Button(composite, SWT.RADIO);
btnSecondLeg.setText("Second Leg");
btnSecondLeg.setBounds(10, 54, 90, 16);
Button btnReturn = new Button(composite, SWT.RADIO);
btnReturn.setText("Return");
btnReturn.setBounds(10, 32, 90, 16);
Button btnOneway = new Button(composite, SWT.RADIO);
btnOneway.setText("One-way");
btnOneway.setBounds(10, 10, 90, 16);
Label lblDeparture = new Label(shlAirbooker, SWT.NONE);
lblDeparture.setBounds(26, 46, 55, 15);
lblDeparture.setText("Departure");
Label lblDestination = new Label(shlAirbooker, SWT.NONE);
lblDestination.setBounds(396, 46, 60, 15);
lblDestination.setText("Destination");
Combo cboSeatType = new Combo(shlAirbooker, SWT.NONE);
cboSeatType.setBounds(26, 132, 91, 23);
Label lblSeatType = new Label(shlAirbooker, SWT.NONE);
lblSeatType.setBounds(26, 111, 55, 15);
lblSeatType.setText("Seat Type");
txtPassengerName = new Text(shlAirbooker, SWT.BORDER);
txtPassengerName.setBounds(26, 294, 76, 21);
Label lblNewLabel = new Label(shlAirbooker, SWT.NONE);
lblNewLabel.setBounds(26, 273, 91, 15);
lblNewLabel.setText("Passenger Name");
txtReferenceID = new Text(shlAirbooker, SWT.BORDER);
txtReferenceID.setBounds(396, 294, 76, 21);
Label lblReferenceId = new Label(shlAirbooker, SWT.NONE);
lblReferenceId.setBounds(396, 273, 76, 15);
lblReferenceId.setText("Reference ID");
Button btnBook = new Button(shlAirbooker, SWT.NONE);
btnBook.setBounds(26, 456, 75, 25);
btnBook.setText("Book");
Button btnClear = new Button(shlAirbooker, SWT.NONE);
btnClear.setBounds(151, 456, 75, 25);
btnClear.setText("Clear");
Button btnExit = new Button(shlAirbooker, SWT.NONE);
btnExit.addSelectionListener(new SelectionAdapter() {
	@Override
	public void widgetSelected(SelectionEvent e) {
	}
});
btnExit.setBounds(307, 456, 75, 25);
btnExit.setText("Exit");
Button btnMaintenance = new Button(shlAirbooker, SWT.NONE);
btnMaintenance.setBounds(454, 456, 75, 25);
btnMaintenance.setText("Maintenance");
shlAirbooker.open();
while (!shlAirbooker.isDisposed()) {
if (!display.readAndDispatch()) display.sleep();
}
display.dispose();
	}
}
