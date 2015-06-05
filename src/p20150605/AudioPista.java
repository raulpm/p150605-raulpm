package p20150605;

import java.io.File;
import java.util.Date;

public abstract class AudioPista {

	private static final int duracion_maxima = 120;

	public abstract int ExportaAFormatoDAW(Object objeto_daw);

	protected abstract int checkDatos();

	public abstract void setMetaDatos(String producto, String anunciante);

	protected File archivo;
	protected int duracion;
	/**
	 * 
	 * Contiene una descripci�n del error relaccionado con el codigo negativo devuelto
	 * 
	 */
	public String lasterrormsg;

	public AudioPista() {
		super();
	}

	/**
	 * 
	 * Establece la <b>duraci�n</b> de la cu�a
	 * @param duracion : establece la duracion de la cu�a
	 * @exception: No se permiten cu�as de mas de 120
	 */
	public void setDuracion(int duracion) throws IllegalArgumentException {
	    if (duracion<0)
	        duracion=0;
	    else if (duracion>duracion_maxima)
	        throw new IllegalArgumentException ("Duración demasiado larga");
	    this.duracion = duracion;
	}

	/**
	 * 
	 * Vincula la clase con el archivo de audio que contiene la cu�a
	 * Se asegura de que el archivo existe
	 * @param nombre_archivo : Establece el nombre del archivo y su ruta
	 * @return si el archivo existe devuelve 'true'
	 */
	public Boolean setArchivo(String nombre_archivo) {
	    this.archivo = new File(nombre_archivo);
	    return this.archivo.exists();
	}

	/**
	 * Programa la cu�a dentro de una secuencia de audio clips
	 * Comprueba que no falta ningun parametro y que el archivo existe
	 * @param fecha TODO
	 * @param : cola_reproduccion : secuencia de audio
	 * @return : -1 : si no hay establecida duraci�n, </br> 
	 * -2 : si no hay establecido nombre,</br> 
	 * -3 : Si no hay establecido anunciante,</br> 
	 * -4 si no hay archivo de audio</br>
	 * -5 si hay problemas en la introducci�n del anuncio en la cola de reproducci�n
	 * 
	 * 
	 */
	public int ProgramaEnCola(Object cola_reproduccion, Date fecha) {
	    // comprobamos previamente que no falte nada
	    int resultado = checkDatos();
	    
	    // si todo va bien, programamos
	    if (resultado==0)
	    {
	        try
	        {
	            // falta por implementar la programación en la cola_reproducción
	            lasterrormsg = "";
	            return this.duracion;
	        }
	        catch (Exception ex)
	        {
	            lasterrormsg = ex.getMessage();
	            return -5;
	        }     
	    }
	    else
	        return resultado;
	}

}