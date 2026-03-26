# Gerenciador de Biblioteca - Avaliação N1

Este projeto é um sistema de gerenciamento de biblioteca desenvolvido como parte da Avaliação N1 da disciplina de Teste de Software.

### Integrantes do Grupo
- **Felipe Jaber Andrade**
- **Marya Laura Menezes**
- **Karen Quezia de Oliveira**
- **Breno Cardoso**

### Funcionalidades do Projeto
- **Cadastro de Entidades:** Gerenciamento de Autores, Livros, Clientes, Funcionários, Vendas e Estoque.
- **Vendas:** Processamento de vendas de livros com baixa automática no estoque.
- **Estoque:** Controle de quantidade disponível de livros.
- **Dashboard Web:** Interface amigável para visualização e operação do sistema.

### Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 4.0.4**
- **Spring Data JPA** (Banco de dados H2 em memória)
- **Thymeleaf** (Templates para interface web)
- **Bootstrap 5** (Estilização responsiva)
- **MapStruct** (Mapeamento entre camadas)
- **JUnit 5 & Mockito** (Testes de unidade e mocks)

#### Requisitos
- Java 21
- Maven (ou use o `./mvnw` incluso)

#### Execução Local
1. Clone o repositório.
2. Na raiz do projeto, execute:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Acesse no navegador: `http://localhost:8080`

#### Execução com Docker
1. Construa a imagem:
   ```bash
   docker build -t gerenciador-biblioteca .
   ```
2. Inicie o container:
   ```bash
   docker run -p 8080:8080 gerenciador-biblioteca
   ```
3. Acesse: `http://localhost:8080`

### Testes
Para executar os testes de unidade:
```bash
./mvnw test
```
