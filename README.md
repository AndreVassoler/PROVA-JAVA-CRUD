# Spring Boot Demo Project

Este é um projeto de demonstração desenvolvido com Spring Boot, utilizando Java 17 e Maven como gerenciador de dependências.

## 🛠 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- Spring Web
- H2 Database
- Spring Boot Validation
- Maven

## 📋 Pré-requisitos

Para executar este projeto, você precisará ter instalado em sua máquina:

- Java JDK 17 ou superior
- Maven 3.6 ou superior
- IDE de sua preferência (recomendamos IntelliJ IDEA ou Eclipse)

## 🚀 Como executar o projeto

1. Clone este repositório:
```bash
git clone [url-do-repositorio]
```

2. Entre na pasta do projeto:
```bash
cd demo
```

3. Execute o projeto com Maven:
```bash
mvn spring-boot:run
```

O aplicativo estará disponível em `http://localhost:8080`

## 📦 Estrutura do Projeto

O projeto segue a estrutura padrão de aplicações Spring Boot:

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── demo/
│   └── resources/
│       └── application.properties
└── test/
    └── java/
```

## 🗄️ Banco de Dados

O projeto utiliza o H2 Database, um banco de dados em memória. 
O console do H2 pode ser acessado em: `http://localhost:8080/h2-console` (quando a aplicação estiver em execução)

## 🔍 Funcionalidades

- Implementação básica de uma API REST
- Persistência de dados com JPA
- Validação de dados
- Testes unitários

## 📝 Licença

Este projeto está sob a licença [Inserir tipo de licença]

## ✨ Contribuição

1. Faça um Fork do projeto
2. Crie uma Branch para sua Feature (`git checkout -b feature/AmazingFeature`)
3. Faça o Commit de suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Faça o Push para a Branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📫 Contato

[Seu Nome] - [seu-email@example.com]

---

⌨️ com ❤️ por [Seu Nome] 