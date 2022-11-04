package core.utils.funzioni;

public class FunzioneParabola implements Funzione{
	
	public static FunzioneParabola createFunzioneFromVertexAndPoint(Number xVertex, Number yVertex, Number xPoint,
			Number yPoint) {
		return new FunzioneParabola(xVertex, yVertex, xPoint, yPoint);
	}

	public static FunzioneParabola createFunzioneFromCoef(Number a, Number b, Number c) {
		return new FunzioneParabola(a, b, c);
	}

	private double a, b, c;
	
	private FunzioneParabola(Number xVertex, Number yVertex, Number xPoint, Number yPoint) {
		double xPointLocal = xPoint.doubleValue();
		if(xPointLocal == xVertex.doubleValue()) xPointLocal++;
		
		this.a = (yPoint.doubleValue() - yVertex.doubleValue())/Math.pow((xPointLocal - xVertex.doubleValue()), 2);
		this.b = -2*a*xVertex.doubleValue();
		this.c = a*Math.pow(xVertex.doubleValue(), 2) + yVertex.doubleValue();
	}
	
	private FunzioneParabola(Number a, Number b, Number c) {
		this.a = a.doubleValue();
		this.b = b.doubleValue();
		this.c = c.doubleValue();
	}

	@Override
	public Number getValue(Number x) {
		Number ret = a*Math.pow(x.doubleValue(), 2) + b*x.doubleValue() + c;
		return ret;
	}

}
