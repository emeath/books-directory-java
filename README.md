# :books: API Rest de livros

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=CONCLUÍDO&color=GREEN&style=for-the-badge)

API Rest que gerencia recurso "livro". Através dela pode-se se obter todos os livros cadastrados em formato paginado, obter livro por ID, atualizar, deletar e criar novo. Os dados são armazenados no banco de dados relacional Postgres.

É possível cadastrar novo livro desde que não exista livro já cadastrado com o mesmo nome.

A API possui validações simples como analisar se os campos não estão vazios ou possui quantidade de páginas maior que determinado valor.

O projeto possui arquivo sql para realizar seeding do banco de dados para que seja possível realizar operações com dados iniciais.

Toda vez que o projeto sobe, está configurado para que os dados no banco de dados sejam deletados.

## :electric_plug: Técnicas e tecnologias utilizadas

| Tech         | Badge                                                                                                                       |
|--------------|-----------------------------------------------------------------------------------------------------------------------------|
| Java 11      | ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)                      |
| Apache Maven | ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white) |
| Spring Boot  | ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)                |
| Postgres     | ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)        |
| Postman      | ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)                    |
|              |                                                                                                                             |

## :hammer_and_wrench: Instalção

Foi escolhida para desenvolvimento e testes a plataforma [Spring Tool Suite](https://spring.io/tools). Para executar o projeto, recomendo o uso da mesma.

Para testar e realizar requisições utilizou-se [Postman](https://www.postman.com/downloads/)

O banco utilizado no projeto foi [Postgres](https://www.postgresql.org/download/)

1. Download e configuração da Spring Tool Suite
2. Download e configuração do Postgres
3. Download e configuração do Postman
4. Realizar clone do projeto

```shell
git clone https://github.com/emeath/books-directory-java.git
```

5. Configurar usuário e senha (postgres, postgres) (*O usuário e senha padrão utilizados nesse projeto para conexão com o banco são postgres e postgres respectivamente. Sinta-se livre para alterar esses dados em **src/main/resources/application.properties***)
6. Criar tabela no banco de dados Postgres com nome **books-directory-api**

### Spring Tool Suite

- Importar projeto existente Maven
- No *Boot Dashboard* clicar em *Start or restart the process associated with the selected elements* 

### Postman

Importar collection

```json
{
	"info": {
		"_postman_id": "6dc2578f-28fb-48f8-93d3-3bff227abeac",
		"name": "books-directory-java",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "GET all books",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/book",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"book"
					],
					"query": [
						{
							"key": "page",
							"value": "14",
							"disabled": true
						},
						{
							"key": "size",
							"value": "1",
							"disabled": true
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "GET ONE book",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/book/10",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"book",
						"10"
					]
				}
			},
			"response": []
		},
		{
			"name": "DELETE book by id",
			"request": {
				"method": "DELETE",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/book/10",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"book",
						"10"
					]
				}
			},
			"response": []
		},
		{
			"name": "ADD book",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"name\": \"Game of Thronnes 13\",\n    \"authorName\": \"Martin\",\n    \"pages\": 222,\n    \"genre\": \"Fantasia\"\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/book",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"book"
					]
				}
			},
			"response": []
		},
		{
			"name": "UPDATE book",
			"request": {
				"method": "PUT",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n    \"name\": \"Game of Thrones 2\",\n    \"authorName\": \"Martin\",\n    \"pages\": 1213,\n    \"genre\": \"Fantasia\"\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/book/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"book",
						"1"
					]
				}
			},
			"response": []
		}
	]
}
```

## :end: :green_circle:	:green_circle:	 Endpoints

| HTTP Method | Endpoint   |
|-------------|------------|
| `GET`       | /book      |
| `GET`       | /book/{id} |
| `DELETE`    | /book/{id} |
| `POST`      | /book      |
| `PUT`       | /book/{id} |

## :mechanical_arm: Resultados

`GET` http://localhost:8080/book/50

```json
{
    "id": 50,
    "name": "Em Algum Lugar nas Estrelas",
    "authorName": "Clare Vanderpool",
    "pages": 288,
    "genre": "Livros de Fantasia e Terror para Adolescentes"
}
```

`GET` http://localhost:8080/book?page=5

```json
{
    "content": [
        {
            "id": 53,
            "name": "Um Lugar Bem Longe Daqui",
            "authorName": "Delia Owens",
            "pages": 336,
            "genre": "Drama Literatura e Ficção"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "empty": false,
            "unsorted": false
        },
        "pageNumber": 5,
        "pageSize": 3,
        "offset": 15,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 6,
    "totalElements": 16,
    "first": false,
    "size": 3,
    "number": 5,
    "sort": {
        "sorted": true,
        "empty": false,
        "unsorted": false
    },
    "numberOfElements": 1,
    "empty": false
}
```


`DELETE` http://localhost:8080/book/10

```json
Book not found!
```

`DELETE` http://localhost:8080/book/50

```json
Book deleted sucessfully!
```

`POST` http://localhost:8080/book

Request Body:
```json
{
    "name": "Game of Thronnes 13",
    "authorName": "Martin",
    "pages": 222,
    "genre": "Fantasia"
}
```
Response Body
```json
{
    "id": 1,
    "name": "Game of Thronnes 13",
    "authorName": "Martin",
    "pages": 222,
    "genre": "Fantasia"
}
```

`PUT` http://localhost:8080/book/1

Request Body

```json
{
    "name": "Game of Thrones 2",
    "authorName": "Martin",
    "pages": 1213,
    "genre": "Fantasia"
}
```
Response Body

```json
{
    "id": 1,
    "name": "Game of Thrones 2",
    "authorName": "Martin",
    "pages": 1213,
    "genre": "Fantasia"
}
```


