# Verificação de Elegibilidade de CNPJ

## Descrição

Este projeto consiste em uma API RESTFul desenvolvida em Java que verifica a elegibilidade de um CNPJ para a abertura de conta. A verificação é realizada consultando uma tabela em um banco de dados PostgreSQL. A API retorna se o CNPJ é ou não elegível.

## Tecnologias Utilizadas

- **Java 11**
- **Spring Boot**
- **Spring Data JPA**
- **Docker e Docker Compose**
- **PostgreSQL**
- **MapStruct** (geração de mappers)
- **OpenAPI** (documentação da API e geração de classes)
- **Actuator e Prometheus** (monitoração)

## Requisitos

- Docker e Docker Compose instalados na máquina.
- IntelliJ IDEA instalado.
- Plugin do Lombok configurado no IntelliJ.
- JDK 11 configurado como SDK do projeto.
- Gradle instalado.

Aqui está a seção atualizada do README:

---

## Como Compilar e Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/scamardi/app-contas-v1.git
   ```

2. **Suba o banco de dados PostgreSQL utilizando Docker Compose:**
    - Navegue até a pasta `dockerConfig`:
      ```bash
      cd src/dockerConfig
      ```
    - Execute o comando:
      ```bash
      docker-compose up -d
      ```
   Este comando irá subir o container do PostgreSQL e executar scripts SQL para a criação do banco e das massas de dados iniciais.

3. **Configurar o IntelliJ:**
    - Abra o projeto no IntelliJ IDEA.
    - Configure o SDK do projeto para utilizar o **Java 11**.
    - Certifique-se de que o plugin **Lombok** está habilitado.
    - Execute um **clean build** do Gradle para garantir que o projeto seja compilado corretamente.
    - Configure a execução da aplicação:
        - Vá em **Run/Debug Configurations**.
        - Crie uma nova configuração com as seguintes propriedades:
            - **SDK:** Java 11
            - **Main class:** `br.com.banco.App`
            - **Use classpath of module:** `contas.main`

4. **Executar a aplicação:**
    - No IntelliJ, execute a configuração criada. Não é necessário configurar variáveis de ambiente, pois o `application.yml` já contém valores padrão para rodar localmente.

5. **Acessar a API:**
    - A API estará disponível em `http://localhost:8080/contas/v1`.
    - Para facilitar o teste dos endpoints, utilize a **collection** do Postman incluída na pasta `collection` na raiz do projeto.

## Documentação da API

A documentação da API foi gerada utilizando o OpenAPI e pode ser acessada em:

```
http://localhost:8080/swagger-ui.html
```

## Monitoramento

O projeto inclui o Actuator e Prometheus para monitoramento. Para acessar as métricas:

```
http://localhost:8080/metrics
```

---