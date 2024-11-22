const API_URL = "http://localhost:8080/api/usuarios"; // Ajuste a URL da sua API

// Função para listar todos os usuários
async function listarUsuarios() {
    const response = await fetch(API_URL);
    const usuarios = await response.json();

    const tabela = document.getElementById("userTable");
    tabela.innerHTML = "";

    usuarios.forEach(usuario => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${usuario.id}</td>
            <td>${usuario.name}</td>
            <td>${usuario.email}</td>
            <td class="actions">
                <button class="edit" onclick="editarUsuario(${usuario.id}, '${usuario.name}', '${usuario.email}')">Editar</button>
                <button class="delete" onclick="deletarUsuario(${usuario.id})">Excluir</button>
            </td>
        `;
        tabela.appendChild(row);
    });
}

// Função para salvar (adicionar ou editar) usuário
async function salvarUsuario(event) {
    event.preventDefault();

    const id = document.getElementById("userId").value;
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;

    const usuario = { name, email };

    if (id) {
        // Atualizar usuário
        await fetch(`${API_URL}/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(usuario)
        });
    } else {
        // Criar novo usuário
        await fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(usuario)
        });
    }

    document.getElementById("userForm").reset();
    listarUsuarios();
}

// Função para editar um usuário
function editarUsuario(id, name, email) {
    document.getElementById("userId").value = id;
    document.getElementById("name").value = name;
    document.getElementById("email").value = email;
}

// Função para excluir um usuário
async function deletarUsuario(id) {
    if (confirm("Tem certeza que deseja excluir este usuário?")) {
        await fetch(`${API_URL}/${id}`, { method: "DELETE" });
        listarUsuarios();
    }
}

// Evento de envio do formulário
document.getElementById("userForm").addEventListener("submit", salvarUsuario);

// Carregar lista de usuários ao iniciar
listarUsuarios();
