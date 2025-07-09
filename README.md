# Projeto Spring WebFlux: Integração Reativa Simulada com Múltiplas Entidades

## Descrição do Projeto

Este projeto é uma aplicação Spring Boot que utiliza **Spring WebFlux** para construir uma API reativa.  
Embora utilize classes locais como exemplos para representar diferentes serviços (`PersonService`, `AddressService`, `CarService`, etc.), a ideia principal é demonstrar a **integração reativa e a composição de dados de múltiplas fontes** de forma não bloqueante.

A aplicação combina informações de várias entidades relacionadas a uma pessoa para montar uma resposta agregada e também demonstra consumo reativo de APIs externas via `WebClient`.

---

## Estrutura Principal

- **`ProcessService`**: Serviço que orquestra chamadas para múltiplos serviços internos e externos, combinando os dados de forma reativa.
- **`PersonController`**: Controlador REST que expõe endpoints para consumir os serviços reativos.

---

## Funcionamento

### 1. `ProcessService`

- Injeta dependências de serviços (`PersonService`, `AddressService`, etc.) e o `WebClient`.
- Usa `Mono.zip` para combinar assincronamente várias chamadas que retornam dados relacionados a uma pessoa.
- Oferece métodos que retornam:
    - `Mono<PersonResponse>` — resultado combinado dos dados da pessoa.
    - `Flux<Person>` — lista reativa de pessoas.
## Como Executar

1. Pegar a collection no diretório [postman collection](postman%20collection)


- Métodos de exemplo:
    - `findZip()`: recupera e combina dados relacionados a `Person` com endereço, carro, empresa e papel.
    - `findUsingJust(id)`: retorna um `Mono` simples com a pessoa, ou vazio.
    - `findFull(id)`: chama `findZip` para o ID 1, caso contrário vazio.
    - `findAPI()`: busca um objeto `PersonResponse` de um endpoint configurado externamente.
    - `listPeople()`: retorna um `Flux` com várias pessoas simuladas.
2. Acessar os endpoints usando navegador, Postman ou outra ferramenta REST:

   - `GET http://localhost:8080/person/find`
   - `GET http://localhost:8080/person/find-just/1`
   - `GET http://localhost:8080/person/find-map/1`
   - `GET http://localhost:8080/person/find-api`
   - `GET http://localhost:8080/person/flux`
- 
### 2. `PersonController`

Define os endpoints:

| Método         | Endpoint                 | Descrição                                       |
|----------------|--------------------------|------------------------------------------------|
| `find()`       | `/person/find`           | Retorna os dados combinados da pessoa 1 via `findZip()` |
| `findJust(id)` | `/person/find-just/{id}` | Retorna pessoa simples pelo ID usando `findUsingJust` |
| `findMap(id)`  | `/person/find-map/{id}`  | Retorna dados completos da pessoa com resposta HTTP adequada (404 se não encontrada) |
| `findApi()`    | `/person/find-api`       | Chama API externa reativa para obter `PersonResponse` |
| `flux()`       | `/person/flux`           | Retorna uma lista reativa (`Flux`) de pessoas |

---

## Fluxo Reativo

- **Mono** é usado para representar 0 ou 1 resultado assíncrono, como `PersonResponse`.
- **Flux** é usado para representar múltiplos resultados, como uma lista de pessoas.
- A combinação de múltiplas chamadas é feita com `Mono.zip`, garantindo que as chamadas sejam feitas concorrentemente e os resultados agregados de forma eficiente.

---

## Versão

1.0

## Autor
Cícero Ednilson - ciceroednilson@gmail.com



