package br.com.fiap.loja;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

import br.com.fiap.loja.repository.LojaRepository;

public class Caixa {

	protected Shell shell;
	private Text txtCodigo;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Caixa window = new Caixa();
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
		shell.setSize(450, 376);
		shell.setText("SWT Application");
		
		Label lblCdigo = new Label(shell, SWT.NONE);
		lblCdigo.setBounds(34, 29, 55, 15);
		lblCdigo.setText("C\u00F3digo");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(95, 26, 76, 21);
		
		Label lblErro = new Label(shell, SWT.NONE);
		lblErro.setBounds(34, 284, 153, 21);
		lblErro.setText("Produto n\u00E3o Cadastrado!");
		
		Button btnPesquisar = new Button(shell, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					LojaRepository rep = new LojaRepository();
					int codigo = Integer.parseInt(txtCodigo.getText());
					ProdutoTO produto = rep.buscar(codigo);
					//Limpar a tabela
					table.removeAll();
					
					// adicionar uma linha na tabela
					TableItem linha = new TableItem(table, 0);
					String[] valores = {String.valueOf(produto.getCodigo()),
										produto.getNome(),
										String.valueOf(produto.getQuantidade()),
										String.valueOf(produto.getPreco())};
					linha.setText(valores);
					
				} catch (Exception e1) {
					lblErro.setText(e1.getMessage());
				}
			}
		});
		btnPesquisar.setBounds(205, 24, 75, 25);
		btnPesquisar.setText("Pesquisar");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 71, 414, 180);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnCdigo = new TableColumn(table, SWT.NONE);
		tblclmnCdigo.setWidth(100);
		tblclmnCdigo.setText("C\u00F3digo");
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(100);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnQuantidade = new TableColumn(table, SWT.NONE);
		tblclmnQuantidade.setWidth(100);
		tblclmnQuantidade.setText("Quantidade");
		
		TableColumn tblclmnPreco = new TableColumn(table, SWT.NONE);
		tblclmnPreco.setWidth(100);
		tblclmnPreco.setText("preco");
		
		Button btnLimpar = new Button(shell, SWT.NONE);
		btnLimpar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					LojaRepository rep = new LojaRepository();
					List<ProdutoTO> lista = rep.listar();
					
					for (ProdutoTO produto : lista) {
						TableItem linha = new TableItem(table, 0);
						
						String[] valores = {String.valueOf(produto.getCodigo()),
											produto.getNome(),
											String.valueOf(produto.getQuantidade()),
											String.valueOf(produto.getPreco())};
					}
					
				} catch (Exception e2) {
					lblErro.setText(e2.getMessage());
				}
			}
		});
		btnLimpar.setBounds(309, 24, 76, 25);
		btnLimpar.setText("Limpar");

	}
}
