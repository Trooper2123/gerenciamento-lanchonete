# gerenciamento-lanchonete
Api de gerenciamento de lanchonete.

baixe o projeto e rode na ide de sua preferencia

Antes de rodar o projeto verifique se as credenciais constantes em src/main/resources/application.properties estão conforme sua instalação do PostgreSQL.

Para acesso a documentação:  http://localhost:8080/swagger-ui/#/  com o program já inicialicado

## Particulariadade 

O primiero usuário a ser cadastrado será atribuida a ROLE de MANAGER;
Ao realizar uma compra o esto que do item será atualizado;
Um item com estoque não pode ser deletado;
A cada request de atualização de pedido o status será modificado, junto com a data da ultima atualização;

### TO DO ####

- Implementação de filiais
- Implementação de módulo de segurança 
- Melhorar erros mostrados ao usuário
- Compra poder aceitar mais de um iten
- Join de iten ao pesquisar compra
- travar compras de itens insuficientes;
- Testes!!!
