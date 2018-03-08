package br.com.fiap.loja.repository;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.apache.axis2.AxisFault;

import com.fiap.loja.bo.EstoqueBOStub;
import com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import com.fiap.loja.bo.EstoqueBOStub.Listar;
import com.fiap.loja.bo.EstoqueBOStub.ListarResponse;
import com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class LojaRepository {

	private EstoqueBOStub stub;

	public LojaRepository() throws AxisFault {

		stub = new EstoqueBOStub();
	}


	public ProdutoTO buscar(int codigo) throws RemoteException {
		ConsultarProduto valores = new ConsultarProduto();
		valores.setCodigo(codigo);
		ConsultarProdutoResponse resp = stub.consultarProduto(valores);
		return resp.get_return();
	}
	
	public List<ProdutoTO> listar() throws RemoteException{
		Listar valores = new Listar();
		ListarResponse resp = stub.listar(valores);
		return Arrays.asList(resp.get_return());
	}
	
}
