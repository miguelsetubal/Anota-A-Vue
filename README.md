# anota-ai-vue
Repositório do Projeto II de WEB
## Grupo
Alpha 
## Integrantes 
- Miguel Jonas Lima Setúbal
- Isa Raquel Costa de Freitas 
- Francisca Isabelle de Almeida Cruz
## Descrição 
O Anota aí!, site a ser desenvolvido, consiste em uma plataforma para realizar o controle de vendas no “fiado”, pensado inicialmente no contexto da lanchonete da UFC Campus Crateús. Nele é realizado o gerenciamento das fichas de alunos e servidores devedores, apenas pelos donos e funcionários. Sendo possível criar, excluir e atualizar esses cadastros, bem como, permitir a consulta detalhada das fichas por parte dos devedores. 
## Modelagem de Dados
- Usuários: id_user; Nome; Email; Senha; Nível de Acesso.
- Pessoa: id_pessoa; Nome; Matrícula/SIAPE; CPF; Celular; Curso.
- Produto: id_produto; descrição; valor.
- id_ficha; id_pessoa; id_produto; Quantidade; data_compra; Status de Pagamento.

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).
