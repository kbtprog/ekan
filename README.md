# Avaliação Ekan Desenvolvedor Backend Java

## Desenvolvimento da Aplicação
Criei o projeto da aplicação no https://start.spring.io/

Comecei o desenvolvimento pelas entidades, então construi os repositorios e as classes da camada de serviço, feito isso testei todos os métodos para ver se a implementação estava correta e funcionando, feito isso criei as classes de excessões e comecei a fazer um dev teste do ""caminho não feliz"" da aplicação.

Finalizado a etapa anterior, criei os DTO's e os controllers, e programei os comportamentos na classe de serviço para não mandar para a camada de controle entidades ou outros objetos que não deveriam sair dela, ao finalizar, efetuei novamente um dev teste dos serviços, mas agora indo pela camada de controle, e com essa etapa concluida, segui para a configuração do Swagger e por fim, finalizei um dev teste por ele, para confirmar se estava tudo funcionando normalmente

## Rodando o projeto
Para executar o projeto é necessario primeiro baixar as dependências do maven, então criei uma configuração do maven para fazer essa parte
- Maven Build
  - New Configuration
  - Apontar então o diretorio do projeto, e no campo "goals" inserir "clean install"
 
Feito isso, basta rodar o projeto, para isso no eclipse basta clicar com o botão direito no projeto e selecionar "Java Application", isto irá abrir um modal aonde você deve selecionar a classe principal do projeto, que é "AvaliacaoApplication", então basta executa-lo, a porta está com o valor padrão "8080"

Com o projeto rodando, basta clicar ir em http://localhost:8080/swagger-ui.html que irá abrir o Swagger da aplicação

## Observações e comentários
- Desenvolvi o projeto no Eclipse por preferência pessoal, em ambiente profissional trabalho tanto com ele como com o Intellij (mas ainda prefiro o Eclipse)
- Optei pelo banco H2 por praticidade
- Não optei por colocar um ENUM no TipoDocumento, preferi deixar String e String, acredito que o importante é que esteja funcionando, então evitei exagerar na perfumaria
- Já trabalhei com sistemas com autenticação mas nunca implementei do zero em projeto algum, então preferi não tentar fazer o item opcional de autenticação/autorização, me limitei a fazer o que eu sei do foi pedido
- Poderia ter implementado teste unitario mas como não foi solicitado, não o fiz

  Qualquer duvida estou à disposição: augustosouza.dev@gmail.com
