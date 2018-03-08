package br.com.fiap.ws.view;

import java.util.Scanner;

import org.apache.axis2.AxisFault;

import br.com.fiap.ws.bo.FiapBOStub;
import br.com.fiap.ws.bo.FiapBOStub.CalcularPs;
import br.com.fiap.ws.bo.FiapBOStub.CalcularPsResponse;

public class TestePsView {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite a média de nac: ");
		float nac = sc.nextFloat();
		
		System.out.print("Digite a nota do am: ");
		float am = sc.nextFloat();
		
		FiapBOStub stub = new FiapBOStub();
		
		//Parametros para o ws
		CalcularPs params = new CalcularPs();
		params.setAm(am);
		params.setNac(nac);
		
		CalcularPsResponse resposta = stub.calcularPs(params);
		
		System.out.println("Você precisa de : " + resposta.get_return());
		
		
		sc.close();
	}
	
}
