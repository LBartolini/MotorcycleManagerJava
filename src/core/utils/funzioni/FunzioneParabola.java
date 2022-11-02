package core.utils.funzioni;

public class FunzioneParabola<T extends Number> implements Funzione<T>{
	
	private double a, b, c;
	
	public FunzioneParabola(double xVertex, double yVertex, double xPoint, double yPoint) {
		if(xPoint == xVertex) xPoint++;
		
		this.a = (yPoint - yVertex)/Math.pow((xPoint - xVertex), 2);
		this.b = -2*a*xVertex;
		this.c = a*Math.pow(xVertex, 2) + yVertex;
	}
	
	public FunzioneParabola(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public Number getValue(T x) {
		Number ret = a*Math.pow(x.doubleValue(), 2) + b*x.doubleValue() + c;
		return ret;
	}

}
