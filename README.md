# Sample API REST CRUD Project - produtos-apirest

Este projeto contém um CRUD simples de uma API REST para produto.

## Tecnologias:
- Spring Boot
- JPA 
- Open API Doc + Swagger
- Hibernate
- Postgres (No caso utilizei um container Docker)
- Maven
- Heroku

## Ambiente:
- Heroku.
- Postgres
- Tomcat Embarcado pelo Spring Boot.

## Deploy Aplicação Spring Boot no Heroku:
- Seguir os passos [Contidos Aqui](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku) 

## Instruções para Teste da Api:
- Acessar a API publicada no Heroku [Clicando Aqui](https://product-api-rest-app.herokuapp.com/enterprise/swagger-ui.html): Swagger que contém os métodos para execução e testes de funcionamento da API (Testes podem ser realizados pelo próprio Swagger).
- Teste pelo Postman:
  + Em resources há também uma Collection para teste local chamando os Endpoints da API no Heroku no Postman [Contido Aqui](https://github.com/chagasfelipe/produtos-apirest/blob/master/src/main/resources/postman/produtos-collection-heroku.postman_collection.json): Basta realizar a importação da Collection no Postman.

## Teste Local com Postman:
- Em resources há também uma Collection para teste local no Postman [Contido Aqui](https://github.com/chagasfelipe/produtos-apirest/blob/master/src/main/resources/postman/produtos-collection.postman_collection.json): Basta realizar a importação da Collection no Postman.

## Próximos Passos (Melhorias)
- Implementação de Teste Unitário e de Integração.
- Implementação de Autenticação e Autorização (JWT + Spring Security).
