// Variables
import { normalizadorTour } from "./normalizador.js";

const detalleUrl = (tour) => `tours.html?id=${tour.id}`;

let allTours = [];
let currentPage = 0;
const toursPerPage = 12;

function getParam(param) {
	const urlParams = new URLSearchParams(window.location.search);
	return urlParams.get(param);
}

function quitarAcentos(texto) {
	return texto.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
} // quitarAcentos

// Agregar card
function addItem(tour) {
	const container = document.getElementById('tours-container');
	if (!container) return;
	const card = document.createElement('div');

	card.classList.add("col-md-4");
	card.dataset.place = tour.state;
	card.dataset.category = tour.categories.join(' y ').toLowerCase();

	card.innerHTML = `
	<div class="card h-100 shadow-sm d-flex flex-column">
	    <img src="${tour.image}" class="card-img-top" alt="${tour.name}">
	    <div class="card-body d-flex flex-column">
	        <h3 class="card-title clamp-2">${tour.name}</h3>
	        <p class="card-category">${tour.categories.join(' y ')}</p>
	        <p class="card-estado">${tour.state}</p>
	        <p class="card-text mt-2 clamp-5 flex-grow-1">${tour.description}</p>
	        <div class="card-footer bg-transparent border-0 mt-auto">
	            <a href="${detalleUrl(tour)}" class="btn-custom">Más información</a>
	        </div>
	    </div>
	</div>
	`;

	container.appendChild(card);
}

// Función para filtrar tours
function filterTours() {
	const activePlaceButton = document.querySelector('.placeFilter.active');
	const activeCategoryButton = document.querySelector('.category-btn.active');

	let selectedPlaces = [];
	if (activePlaceButton) {
		selectedPlaces = activePlaceButton.dataset.place
			.split(',')
			.map(p => quitarAcentos(p.toLowerCase()));
	}

	let selectedCategories = Array.from(document.querySelectorAll('.category-option input:checked'))
		.map(checkbox => quitarAcentos(checkbox.dataset.category.toLowerCase()));

	if (activeCategoryButton && activeCategoryButton.dataset.category === 'all') {
		selectedCategories = ['all'];
	} else if (selectedCategories.length === 0) {
		selectedCategories = [];
	}

	let filteredTours = allTours;

	// Filtrar por lugar si hay un lugar activo
	if (selectedPlaces.length > 0) {
		filteredTours = filteredTours.filter(tour =>
			selectedPlaces.includes(quitarAcentos(tour.state.toLowerCase()))
		);
	}

	if (selectedCategories.length > 0 && !selectedCategories.includes('all')) {
		filteredTours = filteredTours.filter(tour => {
			const tourCategories = tour.categories.map(c => quitarAcentos(c.toLowerCase()));
			return tourCategories.some(tc => selectedCategories.includes(tc));
		});
	}

	return filteredTours;
}

function renderTours() {
	const container = document.getElementById('tours-container');
	if (!container) return;
	container.innerHTML = '';

	const toursToRender = filterTours();

	if (!Array.isArray(toursToRender) || toursToRender.length === 0) {
		container.innerHTML = '<p class="text-center w-100">No se encontraron tours con los filtros seleccionados.</p>';
		return;
	}
	toursToRender.forEach(addItem);
} // renderTours

function loadTourById(id) {
    fetch(`http://localhost:8080/mexotic/tours/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Tour no encontrado');
            }
            return response.json();
        })
        .then(tourData => {
            const tour = normalizadorTour(tourData);
            displayTourDetail(tour);
        })
        .catch(error => {
            console.error("Error al cargar el tour:", error);
            const container = document.getElementById('tour-detail-container');
            if (container) {
                container.innerHTML = '<p class="text-center">Error al cargar el tour. Por favor, intenta de nuevo más tarde.</p>';
            }
        });
} // loadTourById

function displayTourDetail(tour) {
    if (!tour) return;
    document.getElementById('tour-title').textContent = tour.name;
    document.getElementById('tour-price').textContent = `$${tour.price} MXN por persona`;
    document.getElementById('tour-image').src = tour.image;
    document.getElementById('tour-image').alt = tour.name;

    if (tour.cover) {
        document.getElementById('tour-header').style.backgroundImage = `url("${tour.cover}")`;
    }

    const includesList = document.getElementById('tour-includes');
    includesList.innerHTML = "";

    const includes = tour.includes || [];
    const ul = document.createElement('ul');
    ul.classList.add('list-includes');

    includes.forEach(item => {
        const li = document.createElement('li');
        li.textContent = item;
        ul.appendChild(li);
    });
    includesList.appendChild(ul);

    const info = tour.info || {};
    const infoHTML = `
        <p><i class="bi bi-alarm" style="margin-right: 0.5rem;"></i>Salida: ${info.salida || "-"}<br>Regreso aproximado: ${info.regresoAprox || "-"}</p>
        <p><i class="bi bi-calendar-event" style="margin-right: 0.5rem;"></i>${info.frecuencia || "-"}</p>
        <p><i class="bi bi-people" style="margin-right: 0.5rem;"></i>${info.grupos || "-"}</p>
    `;
    document.getElementById("tour-info").innerHTML = infoHTML;
    
    // Para carrito
    const btnReserva = document.getElementById('btn-reserva');
    if (btnReserva) {
        btnReserva.onclick = function() {
            addToCart({
                id: tour.id,
                name: tour.name,
                price: parseFloat(tour.price),
                img: tour.image,
            });
            Swal.fire({
                icon: 'success',
                title: '¡Genial!',
                text: `¡${tour.name} agregado al carrito!`,
                confirmButtonText: 'Aceptar'
            });
        };
    }
} // displayTourDetail


// Promesa para cargar productos
function loadProducts(page = 0) {
	return new Promise((resolve, reject) => {
		fetch(`http://localhost:8080/mexotic/tours/`)
			// fetch(`http://localhost:8080/mexotic/tours?page=${page}&size=${toursPerPage}`) // Para paginación
			.then(res => res.json())
			.then(data => {
				allTours = (data.content || data).map(normalizadorTour);
				resolve(allTours);
			})
			.catch(reject);
	}); // Promise
} // loadProducts


// Botones
function goToNextPage() {
	currentPage++;  
	loadProducts(currentPage)
		.then(() => {
			renderTours();
		})
		.catch(err => console.error("Error al cargar la siguiente página", err));
} // goToNextPage

function goToPreviousPage() {
	if (currentPage > 0) {
		currentPage--; 
		loadProducts(currentPage)  
			.then(() => {
				renderTours(); 
			})
			.catch(err => console.error("Error al cargar la página anterior", err));
	}
} // goToPreviousPage


document.addEventListener("DOMContentLoaded", () => {
    const tourId = getParam('id');
    if (tourId) {
        loadTourById(tourId);
        return;
    }

    loadProducts(currentPage)
        .then(tours => {
            renderTours();

            const nextPageBtn = document.getElementById('next-page');
            const prevPageBtn = document.getElementById('previous-page');
            
            if (nextPageBtn) {
                nextPageBtn.addEventListener('click', goToNextPage);
            }
            
            if (prevPageBtn) {
                prevPageBtn.addEventListener('click', goToPreviousPage);
            }

            // Event Listeners para filtros de lugar
            document.querySelectorAll('.placeFilter').forEach(button => {
                button.addEventListener('click', () => {
                    document.querySelectorAll('.placeFilter').forEach(btn => btn.classList.remove('active'));
                    button.classList.add('active');
                    renderTours();
                });
            });

            // Event Listeners para filtros de categoría
            document.querySelectorAll('.category-option input[type="checkbox"]').forEach(checkbox => {
                checkbox.addEventListener('change', () => {
                    const allButton = document.querySelector('.category-btn[data-category="all"]');
                    if (checkbox.checked) {
                        allButton?.classList.remove('active');
                    } else {
                        const anyChecked = document.querySelectorAll('.category-option input:checked').length > 0;
                        if (!anyChecked) {
                            allButton?.classList.add('active');
                        }
                    }
                    renderTours();
                });
            });
        })
        .catch(err => {
            console.error("Error al cargar producto ", err);
            const container = document.getElementById('tours-container');
            if (container) {
                container.innerHTML = '<p class="text-center w-100">Error al cargar los tours. Por favor, inténtalo de nuevo más tarde.</p>';
            }
        });
});