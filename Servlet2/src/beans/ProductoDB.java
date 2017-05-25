package beans;

import java.util.LinkedList;
import java.util.List;

public class ProductoDB {
	 private static List<Producto> catalogo;

	    public ProductoDB() {
	        catalogo = new LinkedList<>(); 
	        // Instanciamos 4 objetos "Producto" que podrían ser recuperados desde una base de datos.
	        Producto p1= new Producto(1);
	        p1.setCategoria("Informatica");
	        p1.setNombre("Portatil Asus");
	        p1.setPrecio(400);
	        
	        Producto p2= new Producto(2);
	        p2.setCategoria("Imagen y Sonido");
	        p2.setNombre("Televisor Sony");
	        p2.setPrecio(600);
	        
	        Producto p3= new Producto(3);
	        p3.setCategoria("Telefonia movil");
	        p3.setNombre("IPhone 5s");
	        p3.setPrecio(350);
	        
	        Producto p4= new Producto(4);
	        p4.setCategoria("Telefonia movil");
	        p4.setNombre("LG G4");
	        p4.setPrecio(180);
	        
	        //Agregamos los objetos a una lista para recorerla desde la tabla
	        catalogo.add(p1);
	        catalogo.add(p2);
	        catalogo.add(p3);
	        catalogo.add(p4);
	    }
	    
	    public List<Producto> getAll(){
	        return catalogo;
	    }	

}
