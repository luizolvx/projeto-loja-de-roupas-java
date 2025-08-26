# LojaRoupaApp - Sistema de Gestão para Loja de Roupas

## Sobre o Projeto

**LojaRoupaApp** é uma aplicação desktop de código aberto que simula um sistema de gerenciamento para uma loja de roupas. Desenvolvido como um projeto acadêmico, ele demonstra a aplicação prática de conceitos de Programação Orientada a Objetos (POO), a construção de interfaces gráficas com **Java Swing** e a persistência de dados em um banco de dados **MySQL** via JDBC.

O sistema oferece um fluxo completo, desde a autenticação de usuários (clientes e funcionários) até operações CRUD (Criar, Ler, Atualizar, Excluir) para entidades essenciais como Produtos, Categorias, Clientes e Pedidos.

---

## Funcionalidades Principais

O sistema é dividido em dois perfis de acesso principais: **Administrador** e **Cliente**.

### Módulo Administrativo
*   **Autenticação Segura**: Login para funcionários com acesso a funcionalidades restritas.
*   **Gestão de Produtos**: CRUD completo para produtos, incluindo nome, marca, preço, estoque e status (ativo/inativo).
*   **Gestão de Categorias**: CRUD completo para organizar os produtos.
*   **Gestão de Clientes**: Visualização, cadastro e exclusão de clientes.
*   **Gestão de Pedidos**: Acompanhamento e processamento de pedidos realizados pelos clientes.

### Módulo do Cliente
*   **Autenticação de Cliente**: Login para clientes acessarem sua área pessoal.
*   **Catálogo de Produtos**: Visualização dos produtos disponíveis para compra.
*   **Realização de Pedidos**: Funcionalidade para o cliente montar e finalizar um pedido de compra.

---

## Tecnologias Utilizadas

*   **Linguagem**: Java 8+
*   **Interface Gráfica (GUI)**: Java Swing
*   **Banco de Dados**: MySQL
*   **Driver de Conexão**: MySQL Connector/J
*   **IDE de Desenvolvimento**: Eclipse IDE

---

## ⚙️ Estrutura do Banco de Dados

O sistema utiliza um banco de dados relacional chamado `lojaroupa`, composto por 11 tabelas interligadas para gerenciar todas as operações da loja.

**Tabelas Principais:**
*   `produtos`
*   `categorias`
*   `clientes`
*   `funcionarios`
*   `pedidos`
*   `itemspedido`
*   `estoque`
*   `pagamentos`
*   `nivelusuarios`
*   `logisticapedidos`
*   `movimentacaoestoque`

O modelo de dados completo e os relacionamentos estão detalhados na documentação do projeto.

---

## Como Executar o Projeto

Para executar o LojaRoupaApp em seu ambiente local, siga os passos abaixo:

1.  **Pré-requisitos:**
    *   JDK (Java Development Kit) 8 ou superior instalado.
    *   Servidor MySQL em execução.
    *   Uma IDE Java, como Eclipse ou IntelliJ IDEA.

2.  **Configuração do Banco de Dados:**
    *   Crie um banco de dados no MySQL com o nome `lojaroupa`.
    *   Importe o arquivo `lojaroupa.sql` (disponível no repositório) para criar as tabelas e a estrutura necessária.
    *   Abra a classe `ConexaoDB.java` no pacote `com.lojaroupa.conexao`.
    *   Altere as credenciais de conexão (URL, usuário e senha) para corresponder à sua configuração local do MySQL.

3.  **Execução:**
    *   Importe o projeto para a sua IDE.
    *   Localize a classe `MainApp.java` (ponto de entrada da aplicação).
    *   Execute o método `main` para iniciar a aplicação. A tela de login será exibida.

**Credenciais de Teste:**
*   **Administrador:** `admin` (ou o e-mail de um funcionário cadastrado)
*   **Senha:** `1234` (ou a senha correspondente no banco)

---
