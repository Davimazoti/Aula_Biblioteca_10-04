        // ## Funções de busca assim que página abre, com base no id da URL(GET)
        // pega o Id da URL
        function paramUrl(){
            const params = new URLSearchParams(window.location.search);
            const idCliente = params.get("idCliente");

            if (idCliente) {
                getClientePorId(idCliente);
            }
        }

        function preencheCamposDoForm(data){
            document.getElementById("idCliente").value = data.idCliente;
            document.getElementById("nomeCliente").value = data.nomeCliente;
            document.getElementById("sobrenome").value = data.sobrenome;
            document.getElementById("cpf").value = data.cpf;
        }

        async function getClientePorId(idCliente) {

            try {
                let response = await fetch(`http://localhost:8080/cliente/buscar/${idCliente}`, {
                    method: "GET",
                    headers: { "Content-Type": "application/json" },
                });
    
                if(!response.ok){
                    alert("Erro do back-end " + response.status);
                    return
                }

                let data = await response.json();
                preencheCamposDoForm(data)

            } catch (error) {
                alert("Erro na requisição: " + error.message)
            }
        }

        //## Enviar cliente para salvar(POST)
        function criarObjetoJson(){
            let formData = {
                nomeCliente: document.getElementById("nome").value,
                sobrenome: document.getElementById("sobrenome").value,
                cpf: document.getElementById("cpf").value
            };
            return formData;
        }

        async function putCliente(event) {
            event.preventDefault();
            let idCliente = document.getElementById("idCliente").value;
            
            let formData = criarObjetoJson()

            try {
                let response = await fetch(`http://localhost:8080/cliente/atualizar/${idCliente}`, {
                    method: "PUT",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify(formData)
                });
    
                if(!response.ok){
                    alert("Erro do back-end " + response.status);
                    return
                }

                let data = await response.json();
                alert("Sucesso: " + JSON.stringify(data));

            } catch (error) {
                alert("Erro na requisição: " + error.message)
            }
        }

        document.addEventListener("DOMContentLoaded", () => {
            document.getElementById("clienteForm").addEventListener("submit", putCliente);
            paramUrl();
        });