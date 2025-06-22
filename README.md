# Sistema CRUD com Spring Boot

Este projeto é parte de um teste técnico para a vaga de Analista de Sistemas Pleno. Ele implementa um sistema de cadastro com operações CRUD completas utilizando Spring Boot, Maven, banco de dados em memória H2 e arquitetura RESTful. Também inclui testes unitários, um front-end com Bootstrap e um
Robo Python inteligente para análise de dados.

---

## ✅ Funcionalidades

- Cadastro de Estudantes (/students)
- Cadastro de Professores (/professors)
- Cadastro de Endereços (/addresses)
- Operações:
  - Criação (POST)
  - Consulta (GET)
  - Atualização (PUT)
  - Exclusão (DELETE)

---

## 🛠 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Maven
- Banco de dados H2 (em memória)
- Lombok
- Bootstrap 5 (front-end simples)
- Python + Pandas (validação de dados)

---

## 🚀 Como executar o projeto

1. Clonar o repositório:

git clone https://github.com/DiegoValH/springboot-crud-test.git  
cd springboot-crud-test

2. Executar com Maven:

No Linux/Mac:
./mvnw spring-boot:run

No Windows:
mvnw spring-boot:run

3. Acessar no navegador:

API: http://localhost:8080/students  
Console H2: http://localhost:8080/h2-console

Configurações do H2:
- JDBC URL: jdbc:h2:mem:cruddb
- Usuário: sa
- Senha: (deixe em branco)

---

## 🔁 Endpoints disponíveis

Recurso     | Verbo HTTP | Endpoint
------------|-------------|---------
Estudantes  | GET         | /students
Estudantes  | POST        | /students
Estudantes  | GET         | /students/{id}
Estudantes  | PUT         | /students/{id}
Estudantes  | DELETE      | /students/{id}
Professores | (idem)      | /professors/...
Endereços   | (idem)      | /addresses/...

---

## 🧪 Testes Unitários

Foram implementados testes para validar entidades principais:
- StudentTest
- ProfessorTest
- AddressTest

Executar testes com:
mvn test

---

## 📊 Script Python para análise de dados

Arquivo: data/dados.py

O Robo conecta-se ao banco H2, analisa as tabelas principais (student, professor, address) e gera um relatório .xlsx com possíveis inconsistências e estatísticas.
Com acesso a uma base de dados robusta, posso realizar análises estatísticas avançadas e desenvolver dashboards personalizados em Python, voltados à visualização de métricas financeiras, operacionais ou educacionais, integrando fontes diversas com foco em performance e estratégia.

Requisitos:
- Python 3
- Pandas
- JayDeBeAPI
- Driver JDBC do H2

## 📊 Arquitetura de processamento e análise de dados em nuvem
https://lucid.app/lucidspark/f024b593-f07d-4b97-9a08-904ac5c4f306/edit?invitationId=inv_be6f880c-5b18-4431-bc99-865f9536f9c2&page=0_0



## 📄 Status do Projeto

✅ CRUD funcional com Spring Boot  
✅ Projeto Maven  
✅ API REST + Console H2  
✅ Front-end com Bootstrap  
✅ Testes unitários  
✅ Robo Python de análise automatizada
