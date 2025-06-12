# 📝 Task Manager API

Projeto de estudo e portfólio para desenvolvimento backend com **Spring Boot**.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot 3.5.0
- Spring Web
- Spring Data JPA
- PostgreSQL
- Bean Validation (Jakarta Validation)
- Swagger OpenAPI 3 (springdoc-openapi)
- Exception Handling global com Response Wrapper
- Maven

---

## 📂 Descrição

API RESTful completa para gerenciamento de tarefas (CRUD) com:

- Cadastro de tarefas
- Atualização de tarefas
- Listagem de tarefas
- Exclusão de tarefas
- Validação de dados com mensagens customizadas
- Tratamento de erros padronizado
- Documentação automática com Swagger

---

## 🗄 Banco de Dados

O projeto utiliza **PostgreSQL**.  
No arquivo `src/main/resources/application.properties` está configurada a conexão.

Exemplo:
spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanager
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

---

## 🎯 Como executar o projeto localmente

1️⃣ Clone o projeto:
git clone https://github.com/luanbenitess/taskmanager.git

2️⃣ Execute o projeto:
.\mvnw spring-boot:run

3️⃣ Acesse o Swagger para testar a API:
http://localhost:8080/swagger-ui.html

🎯 Endpoints principais
POST /tasks — cria tarefa

GET /tasks — lista todas tarefas

GET /tasks/{id} — busca por id

PUT /tasks/{id} — atualiza tarefa

DELETE /tasks/{id} — deleta tarefa