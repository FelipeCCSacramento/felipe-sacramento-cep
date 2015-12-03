# AddressRestAPI
Uma API Rest básica para cadastro e busca de ceps.

## Funcionalidades
Esta API é bastante simples, oferecendo as funcionalidades de busca e cadastro de endereços utilizando JSON. 
Para cadastrar, basta enviar um JSON via POST para `../AddressRestAPI/cadastro` e, para buscar, basta enviar 
um GET para `../AddressRestAPI/busca/{cepEscolhido}`,  onde `cepEscolhido` é o CEP passado por parâmetro.
Vale notar que é aceito apenas os formatos `00000-000` e `00000000`. No caso de erro, são informados o status
e uma mensagem informando o que ocorreu.

##### Exemplo de Busca

Para `../AddressRestAPI/busca/00000-000` ou `../AddressRestAPI/busca/00000000` podemos ter as seguintes respostas:
```
Caso Sucesso:
{
     "status": "SUCESSO",
     "cep": "00000-000",
     "endereco": "Rua Joao Da Silva",
     "bairro": "Vila Da Silva",
     "cidade": "Cidade do Interior",
     "estado": "SP"
}
```
```
Caso Erro "CEP não encontrado":
{
     "status": "ERRO",
     "mensagem": "O CEP informado não foi encontrado"
}
```
```
Caso Erro "CEP inválido":
{
     "status": "ERRO",
     "mensagem": "O CEP informado é inválido"
}
```

##### Exemplo de Cadastro

Enviando um JSON para `../AddressRestAPI/cadastro` no formato:
```
{
     "cep": "00000-000",
     "endereco": "Rua Joao Da Silva",
     "bairro": "Vila Da Silva",
     "cidade": "Cidade do Interior",
     "estado": "SP"
}
```
Podemos ter as seguintes respostas,
```
Caso Sucesso:
{
     "status": "SUCESSO",
     "mensagem": "O endereço foi cadastrado com sucesso."
}
```
```
Caso Erro "Endereço já cadastrado":
{
     "status": "ERRO",
     "mensagem": "O endereço informado já foi cadastrado."
}
```
## Recursos Usados
#### Java
Java foi utilizado por ser uma linguagem sólida, pragmática, de grande comunidade e com uma grande variedade de frameworks
para facilitar o desenvolvimento e mantendo o desenvolvimento focado nas regras de negócio, ao invés de detalhes infraestruturais. 

#### Spring Framework
O Spring foi utilizado como base para o desenvolvimento desta pequena API, baseada na Arquitetura MVC,
oferecendo facilidades para o manuseio da servlet, integração com banco de dados e outros frameworks 
(como o Hibernate), assim abstraindo elementos estruturais que podem ser bastante complexos e/ou verbosos.

#### Hibernate
O Hibernate é um framework ORM da especificação JPA que oferece uma interface entre o mundo da Orientação à 
Objetos e Relacional, facilitando a comunicação entre a aplicação e o seu banco de dados, atuando na camada 
de persistência. Foi utilizado para oferecer comunicação fácil com o banco de dados, gerar/atualizar a estrutura
do mesmo (baseada na estrutura em java existente) e para gerar as queries SQL, já que usa uma linguagem própria para tal (JPQL/HQL).

#### MySQL
O MySQL foi utilizado para prover um banco de dados para a aplicação apesar de, graças ao hibernate,
poder utilizar uma grande variedade de outros bancos sem precisar ou fazendo poucas mudanças na aplicação, mediante troca do driver.

#### Jackson
A proposta da aplicação é ser uma Rest API que envia e recebe JSON. Aproveitando sua integração com o Spring,
o Jackson foi usado para (de)serialização fácil de JSONs, gerando automaticamente um JSON a partir de um Objeto e vice-versa.

#### Maven
O Maven foi utilizado para gerenciar as dependências do projeto, bastando acrescentá-las no POM.xml. Além disso, o maven está configurado
com o tomcat para prover build e execução rápida e fácil do projeto. 









