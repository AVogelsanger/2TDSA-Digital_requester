package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import com.sun.tools.xjc.model.nav.EagerNClass;

import br.com.fiap.repository.FiapRepository;
import br.com.fiap.ws.bo.FiapBOStub;
import br.com.fiap.ws.bo.FiapBOStub.CalcularMedia;
import br.com.fiap.ws.bo.FiapBOStub.CalcularMediaResponse;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtNac;
	private Text txtPs;
	private Text txtAm;
	private Text txtResultado;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(283, 236);
		shell.setText("SWT Application");
		
		Label lblNac = new Label(shell, SWT.NONE);
		lblNac.setBounds(40, 23, 55, 15);
		lblNac.setText("NAC");
		
		Label lblPs = new Label(shell, SWT.NONE);
		lblPs.setBounds(40, 59, 55, 15);
		lblPs.setText("PS");
		
		Label lblAm = new Label(shell, SWT.NONE);
		lblAm.setBounds(40, 93, 55, 15);
		lblAm.setText("AM");
		
		txtNac = new Text(shell, SWT.BORDER);
		txtNac.setBounds(101, 20, 76, 21);
		
		txtPs = new Text(shell, SWT.BORDER);
		txtPs.setText("");
		txtPs.setBounds(101, 56, 76, 21);
		
		txtAm = new Text(shell, SWT.BORDER);
		txtAm.setText("");
		txtAm.setBounds(101, 90, 76, 21);
		
		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Clique do botão
				float nac = Float.parseFloat(txtNac.getText());
				float am = Float.parseFloat(txtAm.getText());
				float ps = Float.parseFloat(txtPs.getText());
				try {
					FiapRepository rep = new FiapRepository();
					float media = rep.calcularMedia(am, nac, ps);
					txtResultado.setText(String.valueOf(media));
				}catch(Exception ex) {
					txtResultado.setText("Erro");
				}
			}
		});
		btnCalcular.setBounds(102, 129, 75, 25);
		btnCalcular.setText("Calcular");
		
		txtResultado = new Text(shell, SWT.BORDER);
		txtResultado.setEditable(false);
		txtResultado.setBounds(101, 166, 76, 21);

	}
}
