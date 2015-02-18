package edu.uniandes.ecos.logica;

import java.util.HashMap;
import java.util.LinkedList;

public class Operator {

	/*
	 * Listado de datos para operar
	 */
	private LinkedList<Double> dataSet;
		
	public void setData(String datas){
		this.dataSet = new LinkedList<Double>();
		for (String d : datas.split(",")) {
			this.dataSet.add(Double.parseDouble(d.trim()));
		}

	}
	
	/**
	 * Calcula los rangos relativos de tamaño dado un listado de
	 * datos históricos usando desviación estándar.
	 * @return HashMap contiene los rangos calculados donde la llave es el nombre del
	 * rango y la clave su valor calculado..
	 */
	public HashMap<String, Double> calcRelativeSize(){
		HashMap<String, Double> relSize = new HashMap<String, Double>();
		Calc calc = new Calc();
		calc.setData(this.dataSet);
		
		double avg = calc.calculateMean();
		double std = calc.calculateStandardDeviation();
		
		relSize.put("vs",  Math.exp(avg - 2*std));
		relSize.put("s",  Math.exp(avg - std));
		relSize.put("m",  Math.exp(avg));
		relSize.put("l",  Math.exp(avg + std));
		relSize.put("vl",  Math.exp(avg + 2*std));
		
		return relSize;
	}
	
}
