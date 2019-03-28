import java.rmi.*;

public class FourCalculation extends java.rmi.server.UnicastRemoteObject  implements FourCalculationInterface{

	float result;

	public FourCalculation()throws RemoteException{
		result = 0;
	}

	public FourCalculation(float n)throws RemoteException{
		result = n;
	}


	public float add(float num) throws RemoteException{
		result += num;
		return result;
	}

	public float subtruct(float num) throws RemoteException{
		result -= num;
		return result;
	}

	public float multiply(float num) throws RemoteException{
		result *= num;
		return result;
	}

	public float divide(float num) throws RemoteException{
		if(num != 0){
			return result/num;
		}
		return result;
	}

}
