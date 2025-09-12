 export function normalizadorTour(raw = {}){
    const id = raw.id ?? raw.idTour ?? null;
    const name = raw.nombre ?? raw.name ?? '';
    const image = raw.img ?? raw.image ?? '';
    const cover = raw.imgPortada ?? raw.img_portada ?? '';
    const state = raw.estado ?? raw.state ?? '';
    const city = raw.ciudad ?? raw.city ?? '';
    const description = raw.descripcion ?? raw.description ?? '';
    const categories = Array.isArray(raw.categoria) ? raw.categoria : [raw.categoria];
    const price = Number(raw.precio ?? raw.price ?? 0);
    const priceExclusive = Number(raw.precioExclusivo ?? raw.exclusivePrice ?? 0);

    // let includes;
    // if (Array.isArray(raw.incluye)) {
    //     includes = raw.incluye;
    // } else if (typeof raw.incluye === 'string') {
    //     includes = raw.incluye.split('\n').filter(x => x.trim() !== '');
    // } else if (Array.isArray(raw.includes)) {
    //     includes = raw.includes;
    // } else {
    //     includes = [];
    // } // if includes

    let includes;
    if (Array.isArray(raw.incluye)) {
        includes = raw.incluye;
    } else if (typeof raw.incluye === 'string') {
        includes = raw.incluye.split('\n').filter(x => x.trim() !== '');
    } else if (Array.isArray(raw.includes)) {
        includes = raw.includes;
    } else if (typeof raw.includes === 'string') {
        includes = raw.includes.split('\n').filter(x => x.trim() !== '');
    } else {
        includes = [];
    } // if 2 - includes

    const info = raw.informacionTour ?? raw.info ?? {};
    const salida = info.salida ?? info.start ?? '-';
    const regresoAprox = info.regresoAprox ?? info.endApprox ?? '-';
    const frecuencia = info.frecuencia ?? info.frequency ?? '-';
    const grupos = info.grupos ?? info.groups ?? '-';

    return {
    id,
    name,
    image,
    cover,
    state,
    city,
    description,
    categories,
    price,
    priceExclusive,
    includes,
    info: { salida, regresoAprox, frecuencia, grupos },
    _raw: raw


  }; 
} // normalizadorTour 



// normalizador.js
// PROBLEMA 1: Mapear propiedades del backend a frontend
// PROBLEMA 2: Normalizador completo y correcto

// normalizador.js
// PROBLEMA 1: Mapear propiedades del backend a frontend
// PROBLEMA 2: Normalizador completo y correcto
/*
export function normalizadorTour(tour) {
    console.log("Tour original del backend:", tour); // Para debugging
    
    return {
        // IDs y propiedades básicas
        idTour: tour.idTour,
        
        // MAPEO DE NOMBRES INCONSISTENTES:
        // Backend -> Frontend
        name: tour.nombre,           // 'nombre' -> 'name'
        state: tour.estado,          // 'estado' -> 'state' 
        city: tour.ciudad,           // 'ciudad' -> 'city'
        image: tour.img,             // 'img' -> 'image'
        
        // Propiedades que coinciden
        imgPortada: tour.imgPortada,
        description: tour.descripcion,
        duration: tour.duracion,
        precio: tour.precio,
        precioExclusivo: tour.precioExclusivo,
        incluye: tour.incluye,
        
        // PROBLEMA PRINCIPAL: CATEGORÍAS
        // Backend: 'categoria' (string enum)
        // Frontend espera: 'categories' (array)
        categories: tour.categoria ? [tour.categoria] : ['Sin categoría'],
        categoria: tour.categoria, // Mantener también la original por compatibilidad
        
        // Relaciones y objetos anidados
        informacionTour: tour.informacionTour || {
            salida: "No especificado",
            regresoAprox: "No especificado", 
            frecuencia: "Consultar disponibilidad",
            grupos: "Grupos pequeños"
        },
        
        // Colecciones
        experiencias: tour.experiencias || [],
        usuarios: tour.usuarios || [],
        reservas: tour.reservas || []
    };
}

*/