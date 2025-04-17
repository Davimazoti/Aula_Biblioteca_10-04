// ## Funções para enviar Cliente(POST)
function criarObjetoParaEnviar(){
    let formData = {
        nomeCliente: document.getElementById("nome").value,
        sobrenome: document.getElementById("sobrenome").value,
        cpf: document.getElementById("cpf").value,
    };

    return formData
}

async function postCliente(event) {
    event.preventDefault();
    
    let formData = criarObjetoParaEnviar();
    
  
    try {
        let response = await fetch("http://localhost:8080/cliente/adicionar", {
        method: "POST",
            headers: { "Content-Type": "application/json" },
            
            body: JSON.stringify(formData)
            
        });
        console.log(formData); 

        if(!response.ok){
            alert("Erro do back-end" + response.status)
            return
        }

        let data = await response.json()

        alert("Sucesso: " + JSON.stringify(data));
        getClientes();
    } catch (error) {
        alert("Erro na requisição: " + error.message)
        
    }
}

// ## Funções para buscar Clientes(GET)
function criarListaDeClientes(data){
    let lista = document.getElementById("listaClientes");
    lista.innerHTML = "";
    data.forEach(cliente => {
        let item = document.createElement("li");
        item.textContent = `ID: ${cliente.idCliente} - Nome: ${cliente.nomeCliente} - Sobrenome: ${cliente.sobrenome} - CPF: ${cliente.cpf}`;
        
        // botão de editar
        let btnLink = document.createElement("button");
        btnLink.textContent = "Editar";
        btnLink.target = "_blank";
        btnLink.style.marginLeft = "10px";
        btnLink.onclick = function() {
            window.open(`indexClienteEdit.html?id=${cliente.idCliente}`, '_blank');
        };
        item.appendChild(btnLink);

        // botão de deletar
        let btnDeletar = document.createElement("button")
        btnDeletar.textContent = "Deletar";
        btnDeletar.style.marginLeft = "10px";
        btnDeletar.onclick = function(){
            deletarCliente(cliente.idCliente)
        }
        item.appendChild(btnDeletar);

        lista.appendChild(item);
    });
}

async function getClientes() {

    try {
        let response = await fetch("http://localhost:8080/cliente/buscar", {
        method: "GET",
            headers: { "Content-Type": "application/json" },
        });

        if(!response.ok){
            alert("Erro do back-end" + response.status)
            return
        }

        let data = await response.json()
        criarListaDeClientes(data)
    } catch (error) {
        alert("Erro na requisição: " + error.message)
    }
}

// ## Funções para deletar Cliente(DELETE)
async function deletarCliente(idCliente) {
    if (confirm("Tem certeza que deseja deletar este cliente?")) {
        try {
            let response = await fetch(`http://localhost:8080/cliente/deletar/${idCliente}`, {
            method: "DELETE",
                headers: { "Content-Type": "application/json" },
            });

            if(!response.ok){
                alert("Erro do back-end" + response.status)
                return
            }
            alert("Cliente deletado com sucesso!");
            getClientes();
        } catch (error) {
            alert("Erro na requisição: " + error.message)
        }
    }
}

document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("clienteForm").addEventListener("submit", postCliente);
    document.getElementById("carregarClientes").addEventListener("click", getClientes);
});