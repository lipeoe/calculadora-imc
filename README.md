# Calculadora IMC - Projeto N1

## Aplicativo para calcular o índice de massa corporal.

Felipe Oluwaseun Santos Ojo - RA: 24026245

## Principais desafios

Modularizar o código de uma maneira que tornasse fácil lidar com as repetições das funcionalidades em diferentes activities.

## Tomada de decisões

Para gerenciar com o envio de dados referentes à cada tipo de classificação do IMC, utilizei o **Bundle**, uma classe que permite armazenar e transferir dados entre diferentes *Activities*. Para implementar a lógica de direcionamento, optei por uma estrutura condicional com `if else` e `else if`.

- Cada condição verifica o resultado do IMC e, caso o valor corresponda a alguma, uma intent especifica é criada para instanciar a *Activity* da classificação apropriada.
- Em seguida o Bundle é ligado com a intent e armazena os valores: `Peso`, `Altura` e `IMC`. Onde eles são transferidos para a nova tela.
- O usuário é direcionado diretamente para a *Activity* referente a sua classificação de IMC. 
- Implementei uma função que verifica se os campos estão preenchidos para liberar o acionamento do botão.

## Melhorias

Após desenvolvido, verifiquei uma possibilidade de melhoria no código:
- Encapsulamento da lógica de verificação do IMC, onde ele receberia o valor do resultado como parâmetro, evitando um código extenso aliado a boas práticas de desenvolvimento.



