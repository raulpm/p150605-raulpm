package p20150605;

import java.io.File;


/**
 * Gestiona cu�as de anuncios publicitarios en radio.
 * Cada objeto que se cree en esta clase ser� una cu�a diferente
 * 
 * @author	raulpm
 * @version 1.0.1
 * @see	P20150605
 * 
 */
public class AudioSpot
{
    private File archivo;       // manejador para el archivo que contiene el audio (.mp3)
    private int duracion;       // duración del audio, en segundos
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    /**
     * 
     * Contiene una descripci�n del error relaccionado con el codigo negativo devuelto
     * 
     */
    public String lasterrormsg;
    
    
    /**
     * Constructor de la clase AudioSpot
     * @param : Sin parametros
     * 
     */
    public AudioSpot ()
    {
        this.archivo = null;
        this.duracion = 0;
        this.producto = "";
        this.anunciante = "";
        this.lasterrormsg = "";
    }
    
    /**
     * 
     * Almacena metadatos sobre el <b>producto</b> y el <b>anunciante</b>
     * @param producto : establece el nombre del producto
     * @param anunciante : establece el nombre del anunciante
     * 
     */
    public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }
    
    /**
     * 
     * Establece la <b>duraci�n</b> de la cu�a
     * @param duracion : establece la duracion de la cu�a
     * @exception: No se permiten cu�as de mas de 120
     */
    public void setDuracion(int duracion) throws IllegalArgumentException
    {
        if (duracion<0)
            duracion=0;
        else if (duracion>120)
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
    public Boolean setArchivo(String nombre_archivo)
    {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }
    
    
    /**
     * Programa la cu�a dentro de una secuencia de audio clips
     * Comprueba que no falta ningun parametro y que el archivo existe
     * @param : cola_reproduccion : secuencia de audio
     * @return : -1 : si no hay establecida duraci�n, </br> 
     * -2 : si no hay establecido nombre,</br> 
     * -3 : Si no hay establecido anunciante,</br> 
     * -4 si no hay archivo de audio</br>
     * -5 si hay problemas en la introducci�n del anuncio en la cola de reproducci�n
     * 
     * 
     */
    public int ProgramaEnCola(Object cola_reproduccion)
    {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        
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
    
    /**
     * 
     * Crea un fichero .daf(Daw Audio Format) con la exportaci�n de la cu�a completa
     * @param : objeto_daw : cu�a completa a exportar
     * @return : -1 : si no hay establecida duraci�n, </br> 
     * -2 : si no hay establecido nombre,</br> 
     * -3 : Si no hay establecido anunciante,</br> 
     * -4 si no hay archivo de audio</br>
     * -5 si hay problemas en la introducci�n del anuncio en la cola de reproducci�n</br>
     * 0 si se exporta correctamente
     */
    
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        
        // si todo va bien, exportamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la exportación del audio
                lasterrormsg = "";
                return 0;
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
