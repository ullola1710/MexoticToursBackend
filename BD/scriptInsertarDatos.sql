-- DROP DATABASE IF EXISTS mexotictours;

USE mexotictours;
SHOW TABLES ;

SELECT * FROM Usuario;


-- usuario
INSERT INTO Usuario(idUsuario,nombre,apellido,email,telefono,contrasena, admin , imgUsuario)
VALUES
(null, 'Brandy', 'Medina','medina@gmail.com','3358796542','Password_1',1,'brandy.jpg'),
(null, 'Jade', 'Ullola','ullola@gmail.com','3325469875','Password_2',1,'jade.jpg'),
(null, 'Abigail', 'Ramírez','ramirez@gmail.com','3387564123','Password_3',1,'abigail.jpg'),
(null, 'Isabel', 'Romero','romero@gmail.com','3398325469','Password_4',1,'isabel.jpg'),
(null, 'Marian', 'Tejeda','tejeda@gmail.com','3354870213','Password_5',1,'marian.jpg'),
(null, 'Mariana', 'González','gonzalez@gmail.com','3325146987','Password_6',1,'mariana.jpg'),
(null, 'Maritere', 'Montiel','montiel@gmail.com','3325469872','Password_7',1,'maritere.jpg'),
(null, 'Miriam', 'Vega','vega@gmail.com','3303259710','Password_8',1,'miriam.jpg'),
(null,'Miguel', 'R.', 'miguelr@example.com', '5512345678', 'Password_9', 0, 'miguel.jpg'),
(null,'Ana', 'L.', 'anal@example.com', '5523456789', 'Password_10', 0, 'ana.jpg'),
(null,'Roberto', 'G.', 'robertog@example.com', '5534567890', 'Password_11', 0, 'roberto.jpg'),
(null,'Sofía', 'M.', 'sofiam@example.com', '5545678901', 'Password_12', 0, 'sofia.jpg'),
(null,'Carlos', 'P.', 'carlosp@example.com', '5556789012', 'Password_13', 0, 'carlos.jpg');
SELECT * FROM Usuario;
-- tours
SELECT * FROM Tour;
INSERT INTO Tour (nombre, estado, ciudad, imgPortada, img, descripcion, duracion, precio, precioExclusivo, incluye, categoria)
VALUES (
		'Palacio Postal (La Quinta Casa de correo)', 
        'CDMX',
		'Ciudad de México', 
        'https://revistaaventurero.com.mx/wp-content/uploads/2020/06/PALACIO-DE-CORREOS-2-1280x720.jpg',
        './assets/PalacioPostal.jpeg', 
        'Es ícono emblemático del Centro Histórico dadas sus características y cualidades artísticas, además de continuar con su propósito original de ser la Administración #1 del servicio de Correos en nuestro país', 
        '2-3 horas', 
        350.0, 
        250.0, 
        '["Recorrerás los pasillos del edificion con un guía que explica su historia, arquitectura y crecretos", "Exposiciones permanentes y temporales: Relacionada con el correo de México", "Acceso a la biblioteca: Un rincón poco conocido dentro del palacio", "Historia del edificio: Construido en 1907 por el ingeniero Gonzalo Garita y el arquitecto Adamo Boari", "Museo Postal: Desde 1920, el edificio alberga un museo con piezas historicas del servicio postal mexicano", "Kit de bienvenida (agua embotellada y un aperitivo)"]',
        'Cultura'),
        --
        (
        'Tour de Leyendas',
        'Queretaro',
        'Queretaro', 
        'https://traveler.marriott.com/es/wp-content/uploads/sites/2/2024/09/GI-656814104_QuertaroAqueduct.jpg',
        'https://cloudfront-us-east-1.images.arcpublishing.com/eluniversal/7DE2GCCVEJG7DHSDLNJRV4L7QQ.jpg',
        'Recorrido interactivo por las principales calles de nuestra hermosa ciudad de Querétaro teatralizando las leyendas como: el Marqués, la celda de Satanás, La Carambada, Chucho El Roto, la Llorona o la Zacatecana',
        '1-2 horas',
        225.0,
        125.0,
        '["Las más aterradoras historias que han sucedido en Querétaro te serán relatadas.","El tour comenzara aproximadamente a las 8:45.","Kit de bienvenida.","Tansporte de ida y regreso del punto medio."]',
        'Cultura'),
        --
        (
        'Tour Tequila',
        'Jalisco',
        'Tequila/Guadalajara',
        'https://visitmexico.com/media/usercontent/67fd7d33baf74-Tequila-2_gmxdot_jpeg',
        'https://panoramex.com.mx/wp-content/uploads/2014/11/tequila_pueblo_magico-768x532.jpg',
        'Descubra el origen de la bebida nacional por excelencia, explora sus antiguas destilerías, admira su paisaje agavero declarado Patrimonio Natural de la Humanidad por la UNESCO.',
        'Dia completo',
        2000.0,
        1500.0,
        '["Viaje redondo","Box Lunch","Seguro de Viajero a bordo de la unidad","Coordinador de viaje","Conociendo la elaboración y proceso de esta gran bebida. cava y capilla subterránea, campos de agave","Degustación de Tequilas","Visita Pueblo Mágico de Tequila","Visita a Cantaritos de Amatitlan","Comida tradicional jalisciense","Fotógrafo durante el viaje"]',
        'Cultura'),
        --
        (
        'Tour Cervecero',
        'CDMX',
        'Ciudad de México',
        'https://i0.wp.com/foodandwineespanol.com/wp-content/uploads/2019/08/turicervecero.webp?fit=2560%2C1439&ssl=1',
        'https://guiaturibus.com/cdn/shop/products/C3_Turicervecero_720x.jpg?v=1643214939',
        'Vive la experiencia única en su género.Para pasar un momento de diversión y degustación de tu bebida favorita',
        '3-4 horas',
        650.0,
        550.0,
        '["Transportación en Turibus","Guía turístico","Visita 3 cervecerías en la CDMX","Seguro viajero","Punto de partida Reforma 222"]',
        'Cultura'),
        --
        (
        'Ruta del Vino',
        'Queretaro',
        'Queretaro',
        'https://tiempolibreqro.com/wp-content/uploads/2020/11/Gastrofeset-Vin%CC%83edos-Azteca.jpg',
        'https://www.bromoturismo.com/wp-content/uploads/2016/05/5427140736_e9e077fb8f.jpg',
        '¿Eres amante del vino? Entonces, ¡Este tour es para ti! Vive la increíble experiencia de visitar dos increíbles viñedos, además de realizar una deliciosa degustación de vinos',
        '9 horas',
        1800.0,
        1700.0,
        '["Transporte redondo desde nuestro punto de partida que sera el Museo Regional de Querétaro","Tour guiado en Finca Sala Vivé","En tu visita estará guiada por el viñedo a bordo de un tranvía","Recorrido por la cava que se encuentra a 25 metros de profundidad con la explicación de la elaboracion de los vinos espumosos y tranquilos","Al finalizar se realizará una cata de tres vinos en un salón con puerta cerrada acompañados de tapas","Después visitaremos el Viñedo Azteca","Incluirá recorrido por la bodega","Explicación de como se elaboran los vinos artesanales","Copa grabada","Tres degustaciones con cata guiada de nuestros vinos tintos premiados en Baja Califonrnia y Bruselas","Maridaje con quesos, carnes frías, y frutas","Seguro de viajero"]',
        'Gastronomia'),
        --
        (
        'Mercado San Juan de Dios',
        'Jalisco',
        'Guadalajara',
        'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/15/36/50/bc/fruta-fresca-endemica.jpg?w=1200&h=-1&s=1',
        'https://visitjalisco.mx/wp-content/uploads/2025/04/sjd-25-scaled.jpg',
        'Aproximadamente 4000 puestos con comida y artesanías',
        '6 horas',
        650.0,
        520.0,
        '["Transporte redondo desde punto de encuentro (Reforma/Centro Histórico)","Guía gastronómico certificado","Degustación en 5 paradas (antojitos, comida corrida, postres, bebidas típicas)","Entrada y explicación cultural en mercado tradicional","Agua embotellada y kit de bienvenida","Seguro de viajero"]',
        'Gastronomia'),
        --
        (
        'Café y Música en Vivo',
        'CDMX',
        'Ciudad de México',
        'https://media.foodandtravel.mx/wp-content/uploads/2020/02/MuskaMesas.jpg',
        'https://media.foodandtravel.mx/wp-content/uploads/2020/02/MuskaMixologia.jpg',
        'Descubre los rincones más exquisitos para disfrutar de una velada romántica o con amigos, acompañado de una buena taza de café',
        '8 hrs',
        1600.0,
        1300.0,
        '["Entrada a exposición inmersiva","Degustación guiada en cafetería Musak de especialidad","Cena ligera en restaurante con música en vivo","Transporte todo el día","Guía cultural","Seguro de viajero"]',
        'Gastronomia'),
        --
        (
        'Viaje a Peña de Bernal',
        'Queretaro',
        'Bernal / Tequisquiapan',
        'https://i.pinimg.com/736x/47/4f/13/474f134c693636cd65bc17215a08d6ec.jpg',
        'https://culturestraveled.com/wp-content/uploads/2023/01/pena-de-bernal-queretaro-736x1024.jpg',
        'Si tienes poco tiempo para conocer el Pueblo Mágico de Bernal, esta es una increíble opción, además visitarás uno de los viñedos más importantes del bajío',
        '8 a 10 horas',
        960.0,
        800.0,
        '["Transporte redondo desde nuestro punto de encuentro","Tour guiado en el viñedo","Degustación de una copa de vino","Una copa de cristal de recuerdo","Entrada al viñedo","Guía cultural","Seguro de viajero"]',
        'Cultura'),
        --
        (
        'Noche de Antros: Zona Rosa & Polanco',
        'CDMX',
        'Ciudad de México',
        'https://media.timeout.com/images/105243507/750/422/image.jpg',
        'https://offloadmedia.feverup.com/cdmxsecreta.com/wp-content/uploads/2022/04/28132232/antros-gay-cdmx-1024x683.jpg',
        'Disfruta de tres noches de fiesta inolvidables en la CDMX',
        '6 horas',
        1500.0,
        1200.0,
        '["Transporte seguro redondo","Cover en 3 bares/antros","1 bebida de cortesía por lugar (cóctel o cerveza doméstica)","Host/anfitrión durante todo el recorrido","Fotografías digitales del evento"]',
        'Fiesta'),
        --
        (
        'Visita al Museo Nacional de Arte (MUNAL)',
        'CDMX',
        'Ciudad de México',
        'https://www.mexicoescultura.com/galerias/espacios/fotogalerias/munal4.png',
        'https://www.diariocultura.mx/wp-content/uploads/2013/04/Munal.jpg',
        'Uno de los recintos culturales más importantes de México, albergando una amplia colección de arte mexicano desde el siglo XVI hasta la primera mitad del siglo XX',
        '"5 horas',
        620.0,
        540.0,
        '["Entrada al museo","Recorrido guiado por un historiador del arte","Visita a exposiciones temporales y permanentes","Material de apoyo impreso","Seguro de viajero"]',
        'Arte');
        
        
SELECT * FROM Tour; 
   -- informacionTours
INSERT  INTO InformacionTour 
VALUES (null,
		'11:00 pm', 
        '2:30 pm', 
        'Sábado - Domingo (Si gustas algún dia en especifico puedes personalizar el tour)', 
        'Apto para cualquier edad, interesado por conocer un poco mas de la historia y arquitectura que nuestra bella Ciudad de México tiene.', 
        1),
        --
        (null,
        '7:30 pm', 
        '10:30 pm', 
        'Martes, Jueves,Viernes,Sábado', 
        'Apto para cualquier edad, que tenga interés por conocer las leyendas de Querétaro', 
        2),
        --
        (null,
        '9:00 am',
        '8:00 pm',
        'Viernes,Sábado,Domingo; también dias festivos y vacaciones (consulta disponibilidad)',
        'Grupos pequeños para atención personalizada. ¡Reserva con anticipación!',
        3),
        --
        (null,
        '6:30 pm',
        '10:30 pm',
        'Viernes,Sábado',
        'Personas que esten interesadas en la degustación de la cerveza artesanal, No apto para niños',
        4),
        (null,
        '9:00 am',
        '7:00 pm',
        'Viernes y Sábado',
        'Apto para cualquier persona que tenga un amor por el vino, No apto para menores de edad',
        5),
        (null,
        '8:30 am',
        '3:00 pm"',
        'Opera todo el año; en feriados puede haber variaciones de aforo en mercados.',
        'Para personas interesas en una degustación de la comida y antojitos tradicionales.',
        6),
        (null,
        '11:00 am',
        '19:00 pm',
        'Mejor disponibilidad en temporada baja (enero–marzo). Itinerario puede variar por agenda de la exposición y disponibilidad del venue musical',
        'Apto para todas las edades; menores acompañados.',
        7),
        (null,
        '8:00 am',
        '6:00 pm',
        'Todos los sábados y domingos de acuerdo a la disponibilidad de cupo.',
        'Mayores de edad con identificación oficial.',
        8),
        (null,
        '7:00 pm',
        '1:00 am',
        'Los dos últimos jueves, viernes y sábados de cada fin de mes.',
        'Mayores de edad con identificación oficial.',
        9),
        (null,
        '10:00 am',
        '2:00 pm',
        'De martes a domingo, excepto días festivos oficiales.',
        'Recomendado para amantes del arte, estudiantes y familias.',
        10);
        
SELECT * FROM InformacionTour;

SELECT * FROM Usuario_has_Tour;
-- Usuario has tour
INSERT  INTO Usuario_has_Tour(id,fk_idUsuario,fk_idTour)
VALUES
(null,9,2),
(null,10,3),
(null,11,5),
(null,12,10),
(null,13,4);
SELECT * FROM Usuario_has_Tour;

SELECT * FROM Experiencia;
-- Experiencias
INSERT INTO Experiencia (idExperiencia, comentario, calificacion, fecha, fk_idTour, fk_idUsuario)
VALUES
(null,'¡Una noche mágica llena de misterios! El recorrido por las calles de Querétaro con las leyendas del Marqués y la Celda de Satanás fue escalofriante y fascinante. El guía lo hizo tan vivo que parecía estar en el pasado. ¡Recomendado para amantes de la historia!', 5, '2024-07-12', 2, 9),
(null,'Increíble aventura en las tierras agaveras. Explorar las antiguas destilerías y probar el tequila auténtico fue inolvidable. El paisaje declarado Patrimonio de la UNESCO es de ensueño, y el tour incluyó catas que nos transportaron a otro mundo. ¡No te lo pierdas!', 5, '2024-08-05', 3, 10),
(null,'Para los amantes del vino, este tour es perfecto. Visitamos viñedos increíbles, degustamos vinos exquisitos y aprendimos sobre la producción local. La combinación de paisajes y sabores fue espectacular, ideal para una escapada romántica. ¡Volveremos!', 5, '2024-09-10', 5, 11),
(null,'Una joya cultural en el corazón de México. La colección desde el siglo XVI hasta el XX es impresionante, con obras maestras que te dejan sin aliento. El edificio histórico añade magia al recorrido. ¡Esencial para cualquier visitante a CDMX!', 5, '2024-10-18', 10, 12),
(null,'Una experiencia única para amantes de la cerveza. Probar diferentes estilos y aprender sobre su elaboración en un ambiente relajado fue increíble. El guía fue muy amable y el tour incluyó momentos perfectos para compartir con amigos. ¡Altamente recomendado!', 5, '2024-11-22', 4, 13);
SELECT * FROM Experiencia;



SELECT * FROM Reserva;
-- Reserva
INSERT INTO Reserva 
VALUES (null, 2, 9),
(null, 4, 10),
(null, 1, 11),
(null, 3, 12),
(null, 5, 13);
SELECT * FROM Reserva;

SELECT * FROM Reserva_has_Tour;
-- Reserva_has_Tours
INSERT INTO Reserva_has_Tour
VALUES
(null,2,1,2),
(null,3,2,3),
(null,4,3,5),
(null,10,4,10),
(null,1,5,4);
SELECT * FROM Reserva_has_Tour;

-- Pago 
SELECT * FROM Pago;
INSERT INTO Pago (monto, fechaPago, metodoPago, fk_idReserva) 
VALUES
(350.0, '2025-08-01 14:30:00', 'Tarjeta Credito',1),
(225.0, '2025-08-05 10:15:00', 'Tarjeta Credito',2),
(2000.0, '2025-08-10 16:45:00', 'Comisionista',3),
(650.0, '2025-08-15 09:00:00', 'Tarjeta Credito',4),
(1800.0, '2025-08-20 18:20:00', 'Transferencia',5);
SELECT * FROM Pago;