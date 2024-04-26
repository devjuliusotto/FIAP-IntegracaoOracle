# Sistema FINTECH - Gestão de Operações Financeiras

Este projeto consiste em uma aplicação Java que interage com um banco de dados Oracle para gerenciar diversas operações financeiras. O sistema permite a inserção, consulta e gerenciamento de dados relacionados a operações, operadores, transações e políticas de senha, entre outros.

## Funcionalidades

- **Cadastro e Consulta de Operações**: Permite inserir novas operações financeiras e consultar todas as operações cadastradas.
- **Gerenciamento de Operadores**: Administra operadores, incluindo inserção e consulta.
- **Transações Financeiras**: Registra e consulta transações realizadas.
- **Controle de Políticas de Senha**: Gerencia políticas de senha para operadores.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação usada para desenvolver a aplicação.
- **Oracle Database**: Sistema de gerenciamento de banco de dados onde as informações são armazenadas e gerenciadas.
- **JDBC**: Java Database Connectivity, utilizado para conectar-se ao banco de dados Oracle e executar SQLs.

## Configuração

### Pré-requisitos

- Java JDK 11 ou superior.
- Oracle Database com as tabelas e sequences apropriadas configuradas.
- Driver JDBC para Oracle.

### Configuração do Banco de Dados

Assegure-se de que o banco de dados Oracle está configurado corretamente com todas as tabelas e sequences necessárias. As definições das tabelas podem ser encontradas nos scripts SQL inclusos no diretório `sql/`.

### Execução

Para rodar a aplicação:

1. Clone o repositório para sua máquina local:
   ```bash
   git clone URL_DO_REPOSITORIO


## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](https://github.com/devjuliusotto/FIAP-IntegracaoOracle/blob/main/LICENSE.md) para mais detalhes.
