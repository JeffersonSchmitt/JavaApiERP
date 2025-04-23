# ERP API — Java + Spring Boot

Sistema ERP desenvolvido em Java utilizando o framework Spring Boot. O objetivo é criar uma solução modular, escalável e de fácil manutenção para gestão empresarial.

A primeira versão simula a integração com **parceiros externos**, consumindo APIs públicas para realizar operações. Na segunda versão, as operações serão totalmente internas ao sistema, utilizando base de dados própria.

---

## 📖 Descrição

Este projeto propõe a criação de um ERP modular, onde cada funcionalidade pode ser expandida de forma independente. A versão inicial traz a integração com o serviço **FakeStoreAPI** para consulta de produtos e, posteriormente, permitirá operações completas de cadastro e gestão no próprio banco de dados interno ou um arquivo de texto json para rodar em qualquer computador.

---

## ✅ Funcionalidades Implementadas

### Produtos
- Integração com parceiro **FakeStoreAPI**
  - Consulta de produtos
  - Edição de informações dos produtos *(em desenvolvimento)*
  - Exclusão de produtos *(em desenvolvimento)*

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database** (para desenvolvimento e testes locais)
- **Swagger/OpenAPI** para documentação da API

---

## 📌 Próximos Módulos

- Cadastro de clientes
- Carrinho de compras
- Controle financeiro
- Relatórios gerenciais

---

## Documentação disponivel 
- http://localhost:8080/swagger-ui/index.html

