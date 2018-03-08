package com.fiap.loja.view;

import java.util.Arrays;
import java.util.List;

import com.fiap.loja.bo.EstoqueBOStub;
import com.fiap.loja.bo.EstoqueBOStub.Listar;
import com.fiap.loja.bo.EstoqueBOStub.ListarResponse;
import com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class ListarView {

	//Listar todos os produtos do web service
	public static void main(String[] args) {
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			Listar valores = new Listar();
			ListarResponse resp = stub.listar(valores);
			ProdutoTO[] array = resp.get_return();
			//Transforma o array em lista
			List<ProdutoTO> lista = Arrays.asList(array);
			for (ProdutoTO produtoTO : lista) {
				System.out.println(produtoTO.getNome());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}


