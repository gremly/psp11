package edu.uniandes.ecos.logica;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase encargada de llevar a cabo los cálculos matemáticos.
 */
public class Calc {
	
	/**
	 * Atributos
	 */
	private LinkedList<Double> dataSet;
	
	/**
	 * Tamaño del pool de datos.
	 */
	private int dataSize;
	
	 /**
	 * Define el pool de datos sobre los que operará hallando su ln()
	 * @param dataSet Lista enlzazada de datos tipo double.
	 */
	public void setData(LinkedList<Double> dataSet){
		this.dataSet = new LinkedList<Double>();
		for (Double num : dataSet) {
			this.dataSet.add(Math.log(num));
		}
		this.dataSize = this.dataSet.size();
	}
	
	/**
	 * Calcula la media aritmética usando dataSet
	 * @return double con la media aritmética.
	 */
	public double calculateMean(){
		double media = 0;;
		
		for (Double  num:  this.dataSet) {
			media += num;
			
		}
		
		media = media / this.dataSize;
		return media;
	}

	/**
	 * Calcula la varianza usando dataSet
	 * @return double con la varianza
	 */
	public double calculateVariance(){
		double variance = 0;
		double media = calculateMean();
		
		for (Double num:  this.dataSet) {
			variance+= Math.pow(num - media, 2);
		}
		
		variance = variance / (this.dataSize -1);
		return variance;
	}
	
	/**
	 * Calcula la desviación estandar usando dataSet
	 * @return double con la varianza
	 */
	public double calculateStandardDeviation(){
		return Math.sqrt(calculateVariance());
	}
}
