document.addEventListener('DOMContentLoaded', function() {
    // Inicialização do sistema
    initSidebarNavigation();
    initQuickActions();
    setupThemeSwitcher();
    
    // Simulação de dados
    simulateDataLoading();
});

function initSidebarNavigation() {
    const navItems = document.querySelectorAll('.sidebar-nav li');
    
    navItems.forEach(item => {
        item.addEventListener('click', function() {
            // Remove a classe active de todos os itens
            navItems.forEach(navItem => navItem.classList.remove('active'));
            
            // Adiciona a classe active ao item clicado
            this.classList.add('active');
            
            // Obtém a seção correspondente
            const sectionId = this.getAttribute('data-section') + '-section';
            
            // Atualiza o título da seção
            updateSectionTitle(this.textContent.trim());
            
            // Mostra a seção correspondente
            showContentSection(sectionId);
            
            // Simula o carregamento de conteúdo
            loadSectionContent(sectionId);
        });
    });
}

function updateSectionTitle(title) {
    document.getElementById('section-title').textContent = title;
}

function showContentSection(sectionId) {
    // Esconde todas as seções
    document.querySelectorAll('.content-section').forEach(section => {
        section.classList.remove('active');
    });
    
    // Mostra a seção selecionada
    document.getElementById(sectionId).classList.add('active');
}

function loadSectionContent(sectionId) {
    // Em uma aplicação real, aqui seria uma chamada AJAX para carregar os dados
    console.log(`Carregando conteúdo para: ${sectionId}`);
    
    // Simulação de tempo de carregamento
    setTimeout(() => {
        document.getElementById(sectionId).innerHTML = `
            <div class="section-content">
                <h3>${sectionId.replace('-section', '').toUpperCase()}</h3>
                <p>Conteúdo específico desta seção será carregado aqui.</p>
            </div>
        `;
    }, 300);
}

function initQuickActions() {
    const actionButtons = document.querySelectorAll('.action-btn');
    
    actionButtons.forEach(button => {
        button.addEventListener('click', function() {
            const formId = this.getAttribute('data-form') + '-form';
            showModalForm(formId);
        });
    });
}

function showModalForm(formId) {
    // Em uma aplicação real, carregaríamos o formulário apropriado
    console.log(`Mostrando formulário: ${formId}`);
    
    const formTitles = {
        'livro-form': 'Cadastrar Novo Livro',
        'cliente-form': 'Cadastrar Novo Cliente',
        'emprestimo-form': 'Registrar Novo Empréstimo'
    };
    
    const formContent = {
        'livro-form': getBookFormHTML(),
        'cliente-form': getClientFormHTML(),
        'emprestimo-form': getLoanFormHTML()
    };
    
    document.getElementById(formId).innerHTML = `
        <div class="modal-header">
            <h3>${formTitles[formId]}</h3>
            <button class="close-modal"><i class="fas fa-times"></i></button>
        </div>
        <div class="modal-body">
            ${formContent[formId]}
        </div>
    `;
    
    // Mostra o modal
    document.getElementById(formId).classList.add('active');
    
    // Configura o botão de fechar
    document.querySelector(`#${formId} .close-modal`).addEventListener('click', () => {
        hideModalForm(formId);
    });
}

function hideModalForm(formId) {
    document.getElementById(formId).classList.remove('active');
}

function getBookFormHTML() {
    return `
        <form id="formLivro">
            <div class="form-group">
                <label for="titulo">Título do Livro</label>
                <input type="text" id="titulo" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="autor">Autor</label>
                <input type="text" id="autor" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="isbn">ISBN</label>
                <input type="text" id="isbn" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="anoPublicacao">Ano de Publicação</label>
                <input type="number" id="anoPublicacao" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary mt-3">Cadastrar</button>
        </form>
    `;
}

function getClientFormHTML() {
    return `
        <form id="formCliente">
            <div class="form-group">
                <label for="nome">Nome</label>
                <input type="text" id="nome" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="sobrenome">Sobrenome</label>
                <input type="text" id="sobrenome" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="cpf">CPF</label>
                <input type="text" id="cpf" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="email">E-mail</label>
                <input type="email" id="email" class="form-control">
            </div>
            <button type="submit" class="btn btn-success mt-3">Cadastrar</button>
        </form>
    `;
}

function getLoanFormHTML() {
    return `
        <form id="formEmprestimo">
            <div class="form-group">
                <label for="cliente">Cliente</label>
                <select id="cliente" class="form-control" required>
                    <option value="">Selecione um cliente</option>
                    <option value="1">João Silva</option>
                    <option value="2">Maria Santos</option>
                </select>
            </div>
            <div class="form-group">
                <label for="livro">Livro</label>
                <select id="livro" class="form-control" required>
                    <option value="">Selecione um livro</option>
                    <option value="1">Dom Casmurro</option>
                    <option value="2">1984</option>
                </select>
            </div>
            <div class="form-group">
                <label for="dataEmprestimo">Data do Empréstimo</label>
                <input type="date" id="dataEmprestimo" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="dataDevolucao">Data de Devolução</label>
                <input type="date" id="dataDevolucao" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-info mt-3 text-white">Registrar</button>
        </form>
    `;
}

function setupThemeSwitcher() {
    const themeSwitcher = document.querySelector('.theme-switcher');
    
    themeSwitcher.addEventListener('click', function() {
        document.body.classList.toggle('dark-theme');
        
        if (document.body.classList.contains('dark-theme')) {
            this.innerHTML = '<i class="fas fa-sun"></i>';
        } else {
            this.innerHTML = '<i class="fas fa-moon"></i>';
        }
    });
}

function simulateDataLoading() {
    // Simula o carregamento inicial de dados
    setTimeout(() => {
        console.log('Dados carregados com sucesso!');
    }, 1000);
}

// Configura os formulários quando são carregados
function setupForms() {
    // Event delegation para forms dinâmicos
    document.addEventListener('submit', function(e) {
        if (e.target.id === 'formLivro') {
            e.preventDefault();
            handleBookFormSubmit();
        }
        
        if (e.target.id === 'formCliente') {
            e.preventDefault();
            handleClientFormSubmit();
        }
        
        if (e.target.id === 'formEmprestimo') {
            e.preventDefault();
            handleLoanFormSubmit();
        }
    });
}

function handleBookFormSubmit() {
    alert('Livro cadastrado com sucesso!');
    hideModalForm('livro-form');
}

function handleClientFormSubmit() {
    alert('Cliente cadastrado com sucesso!');
    hideModalForm('cliente-form');
}

function handleLoanFormSubmit() {
    alert('Empréstimo registrado com sucesso!');
    hideModalForm('emprestimo-form');
}