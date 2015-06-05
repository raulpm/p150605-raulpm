package p20150605;

import java.io.File;


/**
 * Gestiona cuñas de anuncios publicitarios en radio.
 * Cada objeto que se cree en esta clase será una cuña diferente
 * 
 * @author	raulpm
 * @version 1.0.1
 * @see	P20150605
 * 
 */
public class AudioSpot
{
    private File archivo;       // manejador para el archivo que contiene el audio (.mp3)
    private int duracion;       // duraciÃ³n del audio, en segundos
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    /**
     * 
     * Contiene una descripción del error relaccionado con el codigo negativo devuelto
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
     * Establece la <b>duración</b> de la cuña
     * @param duracion : establece la duracion de la cuña
     * @exception: No se permiten cuñas de mas de 120
     */
    public void setDuracion(int duracion) throws IllegalArgumentException
    {
        if (duracion<0)
            duracion=0;
        else if (duracion>120)
            throw new IllegalArgumentException ("DuraciÃ³n demasiado larga");
        this.duracion = duracion;
    }
    
    /**
     * 
     * Vincula la clase con el archivo de audio que contiene la cuña
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
     * Programa la cuña dentro de una secuencia de audio clips
     * Comprueba que no falta ningun parametro y que el archivo existe
     * @param : cola_reproduccion : secuencia de audio
     * @return : -1 : si no hay establecida duración, </br> 
     * -2 : si no hay establecido nombre,</br> 
     * -3 : Si no hay establecido anunciante,</br> 
     * -4 si no hay archivo de audio</br>
     * -5 si hay problemas en la introducción del anuncio en la cola de reproducción
     * 
     * 
     */
    public int ProgramaEnCola(Object cola_reproduccion)
    {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duraciÃ³n alguna.";
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
                // falta por implementar la programaciÃ³n en la cola_reproducciÃ³n
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
     * Crea un fichero .daf(Daw Audio Format) con la exportación de la cuña completa
     * @param : objeto_daw : cuña completa a exportar
     * @return : -1 : si no hay establecida duración, </br> 
     * -2 : si no hay establecido nombre,</br> 
     * -3 : Si no hay establecido anunciante,</br> 
     * -4 si no hay archivo de audio</br>
     * -5 si hay problemas en la introducción del anuncio en la cola de reproducción</br>
     * 0 si se exporta correctamente
     */
    
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duraciÃ³n alguna.";
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
                // falta por implementar la exportaciÃ³n del audio
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
