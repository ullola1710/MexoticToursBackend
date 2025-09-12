// Variables
// import { normalizadorTour } from "./normalizador.js";
const API_EXP = "http://localhost:8080/mexotic/experiencia/"; 
const PLACEHOLDER_IMG = "./assets/bellasartes.jpg";

async function fetchExperiencias() {
	const res = await fetch(API_EXP, {
		headers: { "Accept": "application/json" },
	});
	if (!res.ok) {
		const msg = await safeText(res);
		throw new Error(`Error ${res.status} al obtener experiencias: ${msg || res.statusText}`);
	}
	return await res.json(); // ya es lista de experiencias DTO
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
		comentario: exp.comentario ?? "",
		calificacion: Number(exp.calificacion ?? 0),
		fecha: exp.fecha ?? "",
		usuario: exp.usuario ?? "Anónimo",
		imagen: exp.imgExperiencia ?? PLACEHOLDER_IMG,
		tourName: exp.tourName ?? "Tour"
	};
} // normalizador

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
		const experienciasRaw = await fetchExperiencias();
		const experiencias = experienciasRaw.map(normalizeExperiencia);

		experiencias.sort((a, b) => parseDateSmart(b.fecha) - parseDateSmart(a.fecha));
		
		if (experiencias.length === 0) {
		    inner.innerHTML = emptySlideHTML("No hay experiencias disponibles");
		    indicator.innerHTML = "";
		    return;
		}

		inner.innerHTML = "";   // limpiar la slide de "Cargando…"
		indicator.innerHTML = "";

		const slides = contenido(experiencias, 2); // 2 por slide
		slides.forEach((slideExperiencias, index) => {
		    const active = index === 0 ? "active" : "";
		    const slideDiv = document.createElement("div");
		    slideDiv.className = `carousel-item ${active}`;
		    
		    slideDiv.innerHTML = `<div class="row">${slideExperiencias.map(cardHTML).join("")}</div>`;
			
		    inner.appendChild(slideDiv);
		    
		    const button = document.createElement("button");
		    button.type = "button";
		    button.setAttribute("data-bs-target", "#carouselExampleIndicators");
		    button.setAttribute("data-bs-slide-to", index);
		    if (active) button.classList.add("active");
		    button.setAttribute("aria-label", `Slide ${index + 1}`);
		    indicator.appendChild(button);
		});
		
	} catch (e) {
		console.error(e);
		inner.innerHTML = emptySlideHTML("Error al cargar experiencias");
		indicator.innerHTML = "";
	} // try - catch
} // initExperiences
