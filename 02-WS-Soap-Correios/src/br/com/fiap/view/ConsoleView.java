package br.com.fiap.view;

import java.util.Scanner;

import org.apache.axis2.AxisFault;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CServico;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class ConsoleView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
			
			//Valores para enviar para o web service
			CalcPrazo valores = new CalcPrazo();
			valores.setNCdServico("4014"); //SEDEX
			System.out.print("CEP de Origem: ");
			valores.setSCepOrigem(sc.next() + sc.nextLine());
			System.out.print("CEP de Destino: ");
			valores.setSCepDestino(sc.next() + sc.nextLine());
			
			//Chama o web service
			CalcPrazoResponse resp = stub.calcPrazo(valores);
			
			//Recuperar as informações
			CServico servico = resp.getCalcPrazoResult()
								.getServicos().getCServico()[0];
			
			System.out.println("Prazo: " + servico.getPrazoEntrega());
			System.out.println("Data máxima: " + servico.getDataMaxEntrega());
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
	}
	
}



