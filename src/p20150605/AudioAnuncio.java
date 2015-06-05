package p20150605;



/**
 * Gestiona cuñas de anuncios publicitarios en radio.
 * Cada objeto que se cree en esta clase será una cuña diferente
 * 
 * @author	raulpm
 * @version 1.0.1
 * @see	P20150605
 * 
 */


public class AudioAnuncio extends AudioPista
{
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    /**
     * Constructor de la clase AudioSpot
     * @param : Sin parametros
     * 
     */
    public AudioAnuncio ()
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
    @Override
	public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }
    
    @Override
	protected int checkDatos() {
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
    
    @Override
	public int ExportaAFormatoDAW(Object objeto_daw)
    {
        int resultado = checkDatos();
        
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
