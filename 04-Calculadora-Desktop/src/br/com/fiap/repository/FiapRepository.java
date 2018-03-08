package br.com.fiap.repository;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.com.fiap.ws.bo.FiapBOStub;
import br.com.fiap.ws.bo.FiapBOStub.CalcularMedia;
import br.com.fiap.ws.bo.FiapBOStub.CalcularMediaResponse;

public class FiapRepository {
	
	
	private FiapBOStub stub;
	
	public FiapRepository() throws AxisFault {
		stub = new FiapBOStub();
	}

	public float calcularMedia(float am, float nac, float ps) throws RemoteException {
		
		CalcularMedia valores = new CalcularMedia();
		valores.setAm(am);
		valores.setNac(nac);
		valores.setPs(ps);
		
		CalcularMediaResponse resp = stub.calcularMedia(valores);
		
		return resp.get_return();
	}

}
