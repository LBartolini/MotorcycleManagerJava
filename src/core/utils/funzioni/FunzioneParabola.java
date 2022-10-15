package core.utils.funzioni;

public class FunzioneParabola implements Funzione<Integer>{
	
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
	public Integer getValue(Integer x) {
		return (int) (a*Math.pow(x, 2) + b*x + c);
	}

}
