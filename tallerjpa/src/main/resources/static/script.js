const apiUrl = 'http://localhost:8080/api/propiedades';

// Cargar todas las propiedades al iniciar
document.addEventListener("DOMContentLoaded", loadProperties);

// Manejo del formulario para agregar o actualizar una propiedad
document.getElementById("propertyForm").addEventListener("submit", async function(event) {
    event.preventDefault(); // Evitar recarga de la página

    const id = document.getElementById("propertyId").value; // Capturar ID si existe
    const propiedad = {
        address: document.getElementById("address").value,
        price: parseFloat(document.getElementById("price").value),
        size: parseFloat(document.getElementById("size").value),
        description: document.getElementById("description").value
    };

    if (id) {
        // Si hay un ID, es una actualización
        await updatePropiedad(id, propiedad);
    } else {
        // Si no hay ID, es una nueva propiedad
        await createPropiedad(propiedad);
    }

    loadProperties(); // Recargar lista de propiedades
    this.reset(); // Limpiar formulario
    document.getElementById("propertyId").value = ""; // Resetear ID oculto
});

// Obtener todas las propiedades y mostrarlas en la interfaz
async function loadProperties() {
    try {
        const response = await fetch(apiUrl);
        if (!response.ok) throw new Error('Error al obtener propiedades');
        const propiedades = await response.json();
        const propertyList = document.getElementById("propertyList");
        propertyList.innerHTML = ""; // Limpiar antes de agregar

        propiedades.forEach(propiedad => {
            const div = document.createElement("div");
            div.innerHTML = `
                <p><strong>Dirección:</strong> ${propiedad.address}</p>
                <p><strong>Precio:</strong> $${propiedad.price}</p>
                <p><strong>Tamaño:</strong> ${propiedad.size} m²</p>
                <p><strong>Descripción:</strong> ${propiedad.description}</p>
                <button onclick="editPropiedad(${propiedad.id}, '${propiedad.address}', ${propiedad.price}, ${propiedad.size}, '${propiedad.description}')">Editar</button>
                <button onclick="deletePropiedad(${propiedad.id})">Eliminar</button>
                <hr>
            `;
            propertyList.appendChild(div);
        });
    } catch (error) {
        console.error(error);
    }
}

// Obtener una propiedad por ID
async function getPropiedadById(id) {
    try {
        const response = await fetch(`${apiUrl}/${id}`);
        if (!response.ok) throw new Error('Propiedad no encontrada');
        const propiedad = await response.json();
        return propiedad;
    } catch (error) {
        console.error(error);
    }
}

// Crear una nueva propiedad
async function createPropiedad(propiedad) {
    try {
        const response = await fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(propiedad),
        });
        if (!response.ok) throw new Error('Error al crear propiedad');
        const newPropiedad = await response.json();
        console.log('Propiedad creada:', newPropiedad);
    } catch (error) {
        console.error(error);
    }
}

// Actualizar una propiedad existente
async function updatePropiedad(id, propiedad) {
    try {
        const response = await fetch(`${apiUrl}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(propiedad),
        });
        if (!response.ok) throw new Error('Error al actualizar propiedad');
        const updatedPropiedad = await response.json();
        console.log('Propiedad actualizada:', updatedPropiedad);
    } catch (error) {
        console.error(error);
    }
}

// Eliminar una propiedad
async function deletePropiedad(id) {
    try {
        const response = await fetch(`${apiUrl}/${id}`, {
            method: 'DELETE',
        });
        if (!response.ok) throw new Error('Error al eliminar propiedad');
        console.log('Propiedad eliminada con éxito');
        loadProperties(); // Recargar lista después de eliminar
    } catch (error) {
        console.error(error);
    }
}

// Función para editar una propiedad (cargar datos en el formulario)
function editPropiedad(id, address, price, size, description) {
    document.getElementById("propertyId").value = id;
    document.getElementById("address").value = address;
    document.getElementById("price").value = price;
    document.getElementById("size").value = size;
    document.getElementById("description").value = description;
}
