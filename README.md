# Exemplo de Vendas - Módulo 35

Este é um projeto **didático e de estudo**, desenvolvido como parte do Módulo 35. Seu objetivo principal foi o aprendizado prático durante o processo de **refatoração de uma arquitetura baseada puramente em JDBC para uma arquitetura utilizando ORM (JPA com Hibernate)**. 

O projeto contempla um sistema simplificado de vendas, modelando entidades como **Cliente**, **Produto** e **Venda**, operando com operações de CRUD e demonstrando, na prática, as diferenças e facilidades introduzidas pelo JPA em comparação ao acesso nativo via JDBC.

## 🚀 Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias:

- **Java 11+**
- **JDBC** (Java Database Connectivity) para comunicação direta ao banco de dados utilizando Queries Nativas.
- **JPA** (Java Persistence API) com **Hibernate** como implementação, para mapeamento objeto-relacional (ORM).
- **PostgreSQL** como banco de dados relacional.
- **JUnit 4** para testes unitários e de integração.
- IDE voltada: Projeto configurado nativamente para o **Eclipse IDE** (sem gerenciador de dependências como Maven ou Gradle no momento, as libs encontram-se na pasta `lib/`).

## ⚙️ Arquitetura e Padrões

- **Padrão DAO (Data Access Object)** para abstrair e isolar o acesso a dados.
- **DAO Genérico**: Implementação de CRUD genérico para as entidades usando Java Generics e Reflection (`GenericDAO` para JDBC e `GenericJpaDAO` para Hibernate).
- **Factory**: Padrão de projeto Factory (`ClienteFactory`, `ProdutoFactory`, etc.) para lidar com a instanciação de objetos a partir de dados resgatados do banco via `ResultSet`.
- **Camada de Serviço (Service)**: Isola regras de negócio e intermedia o sistema com os DAOs.
- **Mocking Manual**: Classes de mock como `ClienteDaoMock` para isolamento em testes de unidade.

## 📋 Pré-requisitos

Para rodar este projeto na sua máquina, você precisa das seguintes ferramentas:

1. [JDK 11+](https://adoptium.net/) instalada e configurada nas variáveis de ambiente.
2. [PostgreSQL](https://www.postgresql.org/download/) instalado e rodando.
3. Eclipse IDE (recomendado) ou IntelliJ IDEA.

### Configuração do Banco de Dados

Você precisará de um banco de dados local com o nome de `vendas_online_2`.

Crie o banco de dados e garanta que o usuário padrão é o `postgres` com a senha `1234`. (Você pode alterar isso dentro do código em `ConnectionFactory.java` ou em `META-INF/persistence.xml` caso seu setup local seja diferente).

```sql
CREATE DATABASE vendas_online_2;
```

É provável que você precisará rodar scripts manuais para criar _sequences_ e as _tabelas_ (`TB_CLIENTE`, `TB_PRODUTO`, `TB_VENDA`, e `TB_PRODUTO_QUANTIDADE`) caso execute os fluxos JDBC (o Hibernate com a propriedade `hibernate.hbm2ddl.auto = update` fará a criação automática para os testes JPA). 

Exemplo de Sequences requeridas pelas implementações JDBC:
```sql
CREATE SEQUENCE sq_cliente START 1;
CREATE SEQUENCE sq_produto START 1;
CREATE SEQUENCE sq_venda START 1;
CREATE SEQUENCE sq_produto_quantidade START 1;
```

## 🛠️ Como Clonar e Rodar

1. Importe o projeto no seu **Eclipse**:
   - Vá em `File > Import...`
   - Selecione `General > Existing Projects into Workspace` e clique em `Next >`.
   - Navegue até o diretório root deste projeto e clique em `Finish`.

2. **Configuração de Bibliotecas**:
   O projeto não utiliza Maven, ou seja, todos os arquivos `.jar` necessários estão dentro da pasta `/lib`. Caso não estejam sendo reconhecidos, será necessário adicioná-los no `Build Path`:
   - Clique com o botão direito no projeto.
   - Vá em `Build Path > Configure Build Path...`
   - Na aba `Libraries`, verifique os `.jars` da pasta `lib/junit` e adicione-os via `Add JARs...` se não estiverem mapeados.

3. **Rodando os Testes**:
   Para testar se sua integração ao banco e regras funcionam corretamente:
   - Navegue até pacote `br.com.eduardo` em `src/test/java`.
   - Clique com o botão direito na classe `AllTests.java` e vá em `Run As... > JUnit Test`.

## 🧑‍💻 Autor

Desenvolvido e refatorado por **Eduardo** (anteriormente creditado a rodrigo.pires).