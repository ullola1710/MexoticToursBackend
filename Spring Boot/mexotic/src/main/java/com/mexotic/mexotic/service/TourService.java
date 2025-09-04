package com.mexotic.mexotic.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mexotic.mexotic.model.Categoria;
import com.mexotic.mexotic.model.Estado;
import com.mexotic.mexotic.model.Tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {
    
    private final ArrayList<Tour> tourList = new ArrayList<Tour>();

    @Autowired
    public TourService(){
        /* Tour(
            String nombre, 
            Estado estado, 
            String ciudad, 
            String imgPortada, 
            String img, 
            String descripcion, 
            String duracion, 
            Double precio, 
            Double precioExclusivo, 
            String incluye, 
            Categoria categoria)
        */ 
        // 1
        tourList.add(new Tour(
            "Palacio Postal (La Quinta Casa de correo)",
            Estado.CDMX,
            "Ciudad de México",
            "https://revistaaventurero.com.mx/wp-content/uploads/2020/06/PALACIO-DE-CORREOS-2-1280x720.jpg",
            "./assets/PalacioPostal.jpeg",
            "Es ícono emblemático del Centro Histórico dadas sus características y cualidades artísticas, además de continuar con su propósito original de ser la Administración #1 del servicio de Correos en nuestro país",
            "2-3 horas",
            350.0,
            250.0,
            "Recorrerás los pasillos del edificion con un guía que explica su historia, arquitectura y crecretos"
            + "\nExposiciones permanentes y temporales: Relacionada con el correo de México"
            + "\nAcceso a la biblioteca: Un rincón poco conocido dentro del palacio"
            + "\nHistoria del edificio: Construido en 1907 por el ingeniero Gonzalo Garita y el arquitecto Adamo Boari"
            + "\nMuseo Postal: Desde 1920, el edificio alberga un museo con piezas historicas del servivio postal mexicano"
            + "\nKit de bienvenida (agua embotellada y un aperitivo)",
            Categoria.Cultura
        ));
        // 2
        tourList.add(new Tour(
            "Tour de Leyendas", 
            Estado.Queretaro, 
            "Querétaro", 
            "https://traveler.marriott.com/es/wp-content/uploads/sites/2/2024/09/GI-656814104_QuertaroAqueduct.jpg", 
            "https://cloudfront-us-east-1.images.arcpublishing.com/eluniversal/7DE2GCCVEJG7DHSDLNJRV4L7QQ.jpg", 
            "Recorrido interactivo por las principales calles de nuestra hermosa ciudad de Querétaro teatralizando las leyendas como: el Marqués, la celda de Satanás, La Carambada, Chucho El Roto, la Llorona o la Zacatecana", 
            "1-2 horas", 
            225.0, 
            125.0, 
            "Las más aterradoras historias que han sucedido en Querétaro te serán relatadas"
            + "\nEl tour comenzara aproximadamente a las 8:45"
            + "\nKit de bienvenida"
            + "\nTansporte de ida y regreso del punto medio.", 
            Categoria.Cultura
        ));
        // 3
        tourList.add(new Tour(
            "Tour Tequila",
            Estado.Jalisco,
            "Tequila/Guadalajara",
            "https://visitmexico.com/media/usercontent/67fd7d33baf74-Tequila-2_gmxdot_jpeg",
            "https://panoramex.com.mx/wp-content/uploads/2014/11/tequila_pueblo_magico-768x532.jpg",
            "Descubra el origen de la bebida nacional por excelencia, explora sus antiguas destilerías, admira su paisaje agavero declarado Patrimonio Natural de la Humanidad por la UNESCO",
            "Día completo",
            2000.0,
            1500.0,
            "Viaje redondo"
            + "\nBox Lunch"
            + "\nSeguro de Viajero a bordo de la unidad"
            + "\nCoordinador de viaje"
            + "\nConociendo la elaboración y proceso de esta gran bebida, cava y capilla subterránea, campos de agave"
            + "\nDegustación de Tequilas"
            + "\nVisita Pueblo Mágico de Tequila"
            + "\nVisita a Cantaritos de Amatitlan"
            + "\nComida tradicional jalisciense"
            + "\nFotógrafo durante el viaje",
            Categoria.Cultura
        ));
        // 4
        tourList.add(new Tour(
            "Tour Cervecero",
            Estado.CDMX,
            "Ciudad de México",
            "https://i0.wp.com/foodandwineespanol.com/wp-content/uploads/2019/08/turicervecero.webp?fit=2560%2C1439&ssl=1",
            "https://guiaturibus.com/cdn/shop/products/C3_Turicervecero_720x.jpg?v=1643214939",
            "Vive la experiencia única en su género. Para pasar un momento de diversión y degustación de tu bebida favorita",
            "3-4 horas",
            650.0,
            550.0,
            "Transportación en Turibus"
            + "\nGuía turístico"
            + "\nVisita 3 cervecerías en la CDMX"
            + "\nSeguro viajero"
            + "\nPunto de partida Reforma 222",
            Categoria.Cultura
        ));

        // 5
        tourList.add(new Tour(
            "Ruta del Vino", 
            Estado.Queretaro, 
            "Querétaro", 
            "https://tiempolibreqro.com/wp-content/uploads/2020/11/Gastrofeset-Vin%CC%83edos-Azteca.jpg", 
            "https://www.bromoturismo.com/wp-content/uploads/2016/05/5427140736_e9e077fb8f.jpg", 
            "¿Eres amante del vino? Entonces, ¡Este tour es para ti! Vive la increíble experiencia de visitar dos increíbles viñedos, además de realizar una deliciosa degustación de vinos.", 
            "9 horas", 
            1800.0, 
            1700.0, 
            "Transporte redondo desde nuestro punto de partida que sera el Museo Regional de Querétaro" 
            + "\nTour guiado en Finca Sala Vivé"
            + "\nEn tu visita estará guiada por el viñedo a bordo de un tranvía"
            + "\nRecorrido por la cava que se encuentra a 25 metros de profundidad con la explicación de la elaboracion de los vinos espumosos y tranquilos"
            + "\nAl finalizar se realizará una cata de tres vinos en un salón con puerta cerrada acompañados de tapas"
            + "\nDespués visitaremos el Viñedo Azteca"
            + "\nIncluirá recorrido por la bodega"
            + "\nExplicación de como se elaboran los vinos artesanales"
            + "\nCopa grabada"
            + "\nTres degustaciones con cata guiada de nuestros vinos tintos premiados en Baja Califonrnia y Bruselas"
            + "\nMaridaje con quesos, carnes frías, y frutas"
            + "\nSeguro de viajero", 
            Categoria.Gastronomia
        ));
        // 6
        tourList.add(new Tour(
            "Mercado San Juan de Dios", 
            Estado.Jalisco, 
            "Guadalajara", 
            "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/15/36/50/bc/fruta-fresca-endemica.jpg?w=1200&h=-1&s=1", 
            "https://visitjalisco.mx/wp-content/uploads/2025/04/sjd-25-scaled.jpg", 
            "Aproximadamente 4000 puestos con comida y artesanías", 
            "6 horas", 
            650.0, 
            520.0, 
            "Transporte redondo desde punto de encuentro (Reforma/Centro Histórico)"
            + "\nGuía gastronómico certificado"
            + "\nDegustación en 5 paradas (antojitos, comida corrida, postres, bebidas típicas)"
            + "\nEntrada y explicación cultural en mercado tradicional"
            + "\nAgua embotellada y kit de bienvenida"
            + "\nSeguro de viajero", 
            Categoria.Gastronomia
        ));
        // 7
        tourList.add(new Tour(
            "Café y Música en Vivo", 
            Estado.CDMX, 
            "Ciudad de México", 
            "https://media.foodandtravel.mx/wp-content/uploads/2020/02/MuskaMesas.jpg", 
            "https://media.foodandtravel.mx/wp-content/uploads/2020/02/MuskaMixologia.jpg", 
            "Descubre los rincones más exquisitos para disfrutar de una velada romántica o con amigos, acompañado de una buena taza de café.", 
            "8 hrs", 
            1600.0, 
            1300.0, 
            "Entrada a exposición inmersiva"
            + "\nDegustación guiada en cafetería Musak de especialidad"
            + "\nCena ligera en restaurante con música en vivo"
            + "\nTransporte todo el día"
            + "\nGuía cultural"
            + "\nSeguro de viajero", 
            Categoria.Gastronomia
        ));
        // 8
        tourList.add(new Tour(
            "Viaje a Peña de Bernal", 
            Estado.Queretaro, 
            "Bernal / Tequisquiapan", 
            "https://i.pinimg.com/736x/47/4f/13/474f134c693636cd65bc17215a08d6ec.jpg", 
            "https://culturestraveled.com/wp-content/uploads/2023/01/pena-de-bernal-queretaro-736x1024.jpg", 
            "Si tienes poco tiempo para conocer el Pueblo Mágico de Bernal, esta es una increíble opción, además visitarás uno de los viñedos más importantes del bajío", 
            "8 a 10 horas", 
            960.0, 
            800.0, 
            "Transporte redondo desde nuestro punto de encuentro"
            + "\nTour guiado en el viñedo"
            + "\nDegustación de una copa de vino"
            + "\nUna copa de cristal de recuerdo"
            + "\nEntrada al viñedo"
            + "\nGuía cultural"
            + "\nSeguro de viajero", 
            Categoria.Cultura
        ));
        // 9
        tourList.add(new Tour(
            "Noche de Antros: Zona Rosa & Polanco", 
            Estado.CDMX, 
            "Ciudad de México", 
            "https://media.timeout.com/images/105243507/750/422/image.jpg", 
            "https://offloadmedia.feverup.com/cdmxsecreta.com/wp-content/uploads/2022/04/28132232/antros-gay-cdmx-1024x683.jpg", 
            "Disfruta de tres noches de fiesta inolvidables en la CDMX.", 
            "6 horas", 
            1500.0, 
            1200.0, 
            "Transporte seguro redondo"
            + "\nCover en 3 bares/antros"
            + "\n1 bebida de cortesía por lugar (cóctel o cerveza doméstica)"
            + "\nHost/anfitrión durante todo el recorrido"
            + "\nFotografías digitales del evento", 
            Categoria.Fiesta
        ));
        // 10
        tourList.add(new Tour(
            "Visita al Museo Nacional de Arte (MUNAL)", 
            Estado.CDMX, 
            "Ciudad de México", 
            "https://www.mexicoescultura.com/galerias/espacios/fotogalerias/munal4.png", 
            "https://www.diariocultura.mx/wp-content/uploads/2013/04/Munal.jpg", 
            "Uno de los recintos culturales más importantes de México, albergando una amplia colección de arte mexicano desde el siglo XVI hasta la primera mitad del siglo XX", 
            "5 horas", 
            620.0, 
            540.0, 
            "Entrada al museo"
            + "\nRecorrido guiado por un historiador del arte"
            + "\nVisita a exposiciones temporales y permanentes"
            + "\nMaterial de apoyo impreso"
            + "\nSeguro de viajero", 
            Categoria.Arte
        ));
    } // Constructor

	public List<Tour> getTours() {
		return tourList;
	} // getTours

	public Tour getTour(Long idTour) {
		Tour tmpTour = null;
		for (Tour t : tourList) {
			if(t.getIdTour() == idTour) {
				tmpTour = t;
				break;
			} // if
		} // foreach
		return tmpTour;
	} // getTour

	public Tour deleteTour(Long idTour) {
		Tour tmpTour = null;
		for (Tour t : tourList) {
			if(t.getIdTour() == idTour) {
				tmpTour = t;
				tourList.remove(t);
				break;
			} // if
		} // foreach
		return tmpTour;
	} // deleteTour

	public Tour addTour(Tour tour) {
		tourList.add(tour);
		return tour;
	} // addTour

	public Tour updateTour(Long idTour, String nombre, Estado estado, String ciudad, String imgPortada, String img,
			String descripcion, String duracion, Double precio, Double precioExclusivo, String incluye,
			Categoria categoria) {
		Tour tmpTour = null;
		for (Tour t : tourList) {
			if(t.getIdTour() == idTour) {
				if(nombre != null) t.setNombre(nombre);
				if(estado != null) t.setEstado(estado);
				if(ciudad != null) t.setCiudad(ciudad);
				if(imgPortada != null) t.setImgPortada(imgPortada);
				if(img != null) t.setImg(img);
				if(descripcion != null) t.setDescripcion(descripcion);
				if(duracion != null) t.setDuracion(duracion);
				if(precio != null) t.setPrecio(precio);
				if(precioExclusivo != null) t.setPrecioExclusivo(precioExclusivo);
				if(incluye != null) t.setIncluye(incluye);
				if(categoria != null) t.setCategoria(categoria);
				tmpTour = t;
				break;
			} // if
		} // foreach
		return tmpTour;
	} // updateTour


} // class TourService

