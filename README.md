# Sistema de Biblioteca

Este sistema visa gerenciar o processo de empréstimo de livros em uma biblioteca. O projeto envolve o relacionamento de três classes principais: Cliente, Empréstimo e Livro. O sistema deve permitir o cadastro, edição, remoção e visualização dessas entidades, além de oferecer uma funcionalidade bônus para filtrar livros por gênero.

## Entidades

### Cliente
- **id** (único): Identificador único do cliente.
- **nome**: Nome do cliente.
- **sobrenome**: Sobrenome do cliente.
- **cpf** (único): CPF do cliente, que deve ser único em todo o sistema.

### Empréstimo
- **id** (único): Identificador único do empréstimo.
- **data_inicial**: Data de início do empréstimo.
- **data_final**: Data final do empréstimo.

### Livro
- **id** (único): Identificador único do livro.
- **nome**: Nome do livro.
- **autor**: Autor do livro.
- **isbn** (único): ISBN do livro, que deve ser único.
- **gênero**: Gênero literário do livro (por exemplo, ficção, fantasia, romance, etc.).

## Relacionamentos

- **Cliente** 1 --- 1 **Empréstimo**: Cada cliente pode realizar apenas um empréstimo de livros por vez.
- **Empréstimo** 1 --- N **Livro**: Um empréstimo pode incluir múltiplos livros.

## Atividades

### 1. Diagrama UML
Desenvolva um **Diagrama UML** para representar as entidades e seus relacionamentos. O diagrama deve ilustrar claramente as classes **Cliente**, **Empréstimo** e **Livro**, com seus atributos e os relacionamentos entre elas.

### 2. Rotas
Implemente as seguintes rotas para gerenciar as entidades:

- **Cliente**:
  - `POST /clientes`: Adicionar um novo cliente.
  - `DELETE /clientes/:id`: Remover um cliente pelo ID.
  - `PUT /clientes/:id`: Editar as informações de um cliente.
  - `GET /clientes`: Buscar todos os clientes.

- **Empréstimo**:
  - `POST /emprestimos`: Adicionar um novo empréstimo.
  - `DELETE /emprestimos/:id`: Remover um empréstimo pelo ID.
  - `PUT /emprestimos/:id`: Editar as informações de um empréstimo.
  - `GET /emprestimos`: Buscar todos os empréstimos.

- **Livro**:
  - `POST /livros`: Adicionar um novo livro.
  - `DELETE /livros/:id`: Remover um livro pelo ID.
  - `PUT /livros/:id`: Editar as informações de um livro.
  - `GET /livros`: Buscar todos os livros.

### 3. Telas
Implemente as seguintes interfaces para as operações no sistema:

- **Cadastro**: Tela para cadastrar um novo cliente, empréstimo ou livro.
- **Edição**: Tela para editar as informações de um cliente, empréstimo ou livro existente.
- **Listagem**: Tela para listar todos os registros de clientes, empréstimos e livros, com a opção de remover qualquer um deles.

### 4. Funcionalidade Bônus
Implemente a funcionalidade de **filtro por gênero** para os livros. O usuário deve poder filtrar a lista de livros com base no gênero literário.

## Tecnologias Utilizadas

- **Backend**: (Exemplo: Node.js, Express, Django, Flask, etc.)
- **Frontend**: (Exemplo: React, Vue.js, Angular, etc.)
- **Banco de Dados**: (Exemplo: MongoDB, PostgreSQL, MySQL, etc.)

## Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/usuario/projeto.git
