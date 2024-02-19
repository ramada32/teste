# Sobre o projeto

Aplicação simples de transação de um cliente para o outro, ao executar o projeto, ela roda um data.sql com 2 clientes dentro, pela qual possuem numberAccout, name e valueAccount e tem 2 botões o de transação e historico,
a transação te permite ver todo o historico das transações do cliente selecionado já a transação te permite criar uma nova transação e o campo numberAccout já vem preenchido e bloqueado pois ele é o numero de conta de origem
os campos pela qual precisa ser preenchido é a data de agendamento, valor para ser transferido e numero da conta de destino caso alguma regra de negocio não seja atendida ele manda um popup na tela de erro impedindo de finalizar
o cadastro.

Existe algumas regras do tipo, caso o agendamento seja para o mesmo dia ele já envia o valor automaticamente e não te permite colocar um valor maior do que da conta, mas caso os dias de agendamento seja superior a 10 já pode 
solicitar transação maior que a conta e caso dias superior a 50 ou menor que 11 e maior que 0 ele já vai dar erro e acionar o popup, além de que numberAccount não pode ser o mesmo do numberAccountDestiny, no historico ele faz
pesquisa de lista pelo id do numberAccount.

## Layout web
Tela Inicial - Lista de Clientes da tabela customer gerada automaticamente pelo script data.sql no backend
![telaInicial-list-customer](https://github.com/ramada32/teste/assets/37840920/a642aff7-d3ae-4bf7-ba29-26790cc658df)

Transação efetuada com sucesso sendo feito no mesmo dia já fazendo os descontos de taxa e valor da conta (OBS: só faz o desconto do valor da conta se for para o mesmo dia)
![sucesso-transfer-0days](https://github.com/ramada32/teste/assets/37840920/511dcc66-e645-4078-9540-431828e335c2)

Error pois o numberAccount era o mesmo do numberAccountDestiny outros casos como datas não aderentes as regras tambem causa o mesmo erro e o popup
![error-transfer-numberDestiny-equals-numberAccount](https://github.com/ramada32/teste/assets/37840920/51dd3307-20d6-4e59-97f0-121fb614b0b5)

Lista de transferias feita pelo id do numberAccount do usuario origem
![list-transfer-customerId-equals-numberAccount](https://github.com/ramada32/teste/assets/37840920/6c46cd68-4ad6-4e27-b8de-97dd5c3a7e25)


# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- H2
  
## Front end
- HTML
- Angular

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/ramada32/teste/tree/main/backend

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run
```

## Front end web
Pré-requisitos: angular 15 
Node: 18.13.0
Package Manager: npm 10.3.0

```bash
# clonar repositório
git clone https://github.com/ramada32/teste/tree/main/frontend

baixe o node 18.13.0

npm install -g @angular/cli@15.2.10
npm install -g npm@10.3.0

# executar o projeto
ng serve

```

# Autor

Felipe Ramada Dos Santos 

https://www.linkedin.com/in/felipe-ramada/
