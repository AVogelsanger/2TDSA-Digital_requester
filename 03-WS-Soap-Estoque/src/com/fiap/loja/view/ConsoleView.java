package com.fiap.loja.view;

import java.util.Scanner;

import org.apache.axis2.AxisFault;

import com.fiap.loja.bo.EstoqueBOStub;
import com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class ConsoleView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o código: ");
		int codigo = sc.nextInt();
		
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			//Valores para o ws
			ConsultarProduto valores = new ConsultarProduto();
			valores.setCodigo(codigo);
			//Chama o ws
			ConsultarProdutoResponse resp = stub.consultarProduto(valores);
			//Recupera as informações do ws
			ProdutoTO to = resp.get_return();
			System.out.println(to.getNome());
			System.out.println(to.getMarca());
			System.out.println(to.getPreco());
			System.out.println(to.getQuantidade());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
	}
	
}
