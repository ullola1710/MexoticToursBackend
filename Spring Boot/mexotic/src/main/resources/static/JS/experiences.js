// Variables
// import { normalizadorTour } from "./normalizador.js";
const API_EXP = "/mexotic/experiencia/"; 
const PLACEHOLDER_IMG = "./assets/bellasartes.jpg";

async function fetchTours() {
	const res = await fetch(API_EXP, {
		headers: { "Accept": "application/json" },
	});
	if (!res.ok) {
		const msg = await safeText(res);
		throw new Error(`Error ${res.status} al obtener tours: ${msg || res.statusText}`);
	}
	const data = await res.json();

	// lista directa, pageable, o wrapper
	if (Array.isArray(data)) return data;
	if (Array.isArray(data?.content)) return data.content;
	if (Array.isArray(data?.tours)) return data.tours;
	throw new Error("La respuesta del backend no es una lista de tours reconocible.");
}

async function safeText(res) {
	try { return await res.text(); } catch { return ""; }
} // safeText

// Normalizador
function normalizeTour(raw = {}) {
	return {
		id: raw.id ?? raw.idTour ?? null,
		name: raw.nombre ?? raw.name ?? "Tour",
		img: raw.img ?? raw.image ?? "",
		imgPortada: raw.imgPortada ?? raw.img_portada ?? "",
		state: raw.estado ?? raw.state ?? "",
		city: raw.ciudad ?? raw.city ?? "",
		experiencias: Array.isArray(raw.experiencia)
			? raw.experiencia
			: Array.isArray(raw.experiencias)
				? raw.experiencias
				: Array.isArray(raw.experiences)
					? raw.experiences
					: [],
	};
} // normalizador

function normalizeExperiencia(exp = {}) {
	return {
		comentario: exp.comentario ?? exp.comment ?? "",
		calificacion: Number(exp.calificacion ?? exp.rating ?? 0),
		fecha: exp.fecha ?? exp.date ?? "",
		usuario: exp.usuario ?? exp.user ?? "Anónimo",
		imgExperiencia: exp.imgExperiencia ?? exp.image ?? "",
	};
} // // normalizador

//----------------------------

function emptySlideHTML(message) {
	return `<div class="carousel-item active">
                <div class="p-5 text-center">
                    <h5 class="text-white">${message}</h5>
                </div>
            </div>`;
} // emptySlideHTML

function cardHTML(exp) {
	const {
		comentario, calificacion, fecha, usuario, imagen, tourName
	} = exp;
	return `<div class="col-12 col-md-6 mb-5">
                <div class="card p-4 text-center h-100">
                    <div class="stars">${stars(calificacion)}</div>
                    <div class="date">${fecha ? formatDateMx(fecha) : ''}</div>
					<img class="carruselImg mt-2" src="${imagen}" alt="${tourName}"
					     loading="lazy"
					     onerror="this.onerror=null; this.src='${PLACEHOLDER_IMG}'">
                    <p class="mt-3">"${comentario}"</p>
                    <small class="text-muted d-block">— ${usuario}
                    <small class="text-muted">📍 ${tourName}</small>
                    </small>
                </div>
            </div>`;
} // cardHTML

// estrellas
function stars(rate) {
	const n = Number(rate) || 0;
	const full = Math.floor(n);
	const half = n - full >= 0.5 ? 1 : 0;
	const empty = 5 - full - half;

	const estrella = '<i class="bi bi-star-fill" style="font-size: 1.5rem"></i>';
	const mitad = '<i class="bi bi-star-half" style="font-size: 1.5rem"></i>';
	const vacia = '<i class="bi bi-star" style="font-size: 1.5rem"></i>';

	return estrella.repeat(full) + (half ? mitad : '') + vacia.repeat(empty);
} // stars


// para el contenido a desplegar
function contenido(array, size) {
	const out = [];
	for (let i = 0; i < array.length; i += size) out.push(array.slice(i, i + size));
	return out;
} // contenido

// Formato para fechas
function parseDateSmart(s) {
	if (!s) return 0;
	const str = String(s).trim();

	const m1 = str.match(/^(\d{2})-(\d{2})-(\d{4})$/); // dd-mm-yyyy
	if (m1) {
		const [, dd, mm, yyyy] = m1;
		return new Date(`${yyyy}-${mm}-${dd}T00:00:00`).getTime();
	}
	const t = Date.parse(str);
	return isNaN(t) ? 0 : t;
} // parseDateSmart

// Mostrar dd/mm/aaaa
function formatDateMx(s) {
	const ts = parseDateSmart(s);
	if (!ts) return '';
	const d = new Date(ts);
	const dd = String(d.getDate()).padStart(2, '0');
	const mm = String(d.getMonth() + 1).padStart(2, '0');
	const yyyy = d.getFullYear();
	return `${dd}/${mm}/${yyyy}`;
} // formatDateMx

document.addEventListener("DOMContentLoaded", initExperiences);

async function initExperiences() {
	const carousel = document.getElementById("carouselExampleIndicators");
	const inner = carousel?.querySelector(".carousel-inner");
	const indicator = carousel?.querySelector(".carousel-indicators");
	if (!inner || !indicator) return;

	inner.innerHTML = emptySlideHTML("Cargando…");
	indicator.innerHTML = "";

	try {
		const toursRaw = await fetchTours(); 
		const tours = toursRaw.map(normalizeTour);
		const experiencias = tours.flatMap(t => {
			const backup = t.img || t.imgPortada || "";
			return t.experiencias.map(e => {
				const ne = normalizeExperiencia(e);
				return {
					comentario: ne.comentario,
					calificacion: ne.calificacion,
					fecha: ne.fecha,
					usuario: ne.usuario,
					imagen: ne.imgExperiencia || backup || PLACEHOLDER_IMG,
					tourName: t.nombre || t.name || "Tour"
				};
			});
		});

		experiencias.sort((a, b) => parseDateSmart(b.fecha) - parseDateSmart(a.fecha));
	} catch (e) {
		console.error(e);
		inner.innerHTML = emptySlideHTML("Error al cargar experiencias");
		indicator.innerHTML = "";
	} // try - catch
} // initExperiences
