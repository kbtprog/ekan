# Avaliação Ekan Desenvolvedor Backend Java

## Desenvolvimento da Aplicação
Criei o projeto da aplicação no https://start.spring.io/

Comecei o desenvolvimento pelas entidades, então construi os repositorios e as classes da camada de serviço, feito isso testei todos os métodos para ver se a implementação estava correta e funcionando, feito isso criei as classes de excessões e comecei a fazer um dev teste do ""caminho não feliz"" da aplicação.

Finalizado a etapa anterior, criei os DTO's e os controllers, e programei os comportamentos na classe de serviço para não mandar para a camada de controle entidades ou outros objetos que não deveriam sair dela, ao finalizar, efetuei novamente um dev teste dos serviços, mas agora indo pela camada de controle, e com essa etapa concluida, segui para a configuração do Swagger e por fim, finalizei um dev teste por ele, para confirmar se estava tudo funcionando normalmente

## Observações e comentários
- Optei pelo banco H2 por praticidade
- Não optei por colocar um ENUM no TipoDocumento, preferi deixar String e String, acredito que o importante é que esteja funcionando, então evitei exagerar na perfumaria
- Já trabalhei com sistemas com autenticação mas nunca implementei do zero em projeto algum, então preferi não tentar fazer o item opcional de autenticação/autorização, me limitei a fazer o que eu sei do foi pedido
- Poderia ter implementado teste unitario mas como não foi solicitado, não o fiz

  Qualquer duvida estou à disposição: augustosouza.dev@gmail.com
