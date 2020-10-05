<template>
  <div class="home">
      <br>
      <br>
      <br>
    <h1 class="display-4">Produtos Cadastrados</h1>
    <div class="row">
      <div class="container">
        <table class="table table-dark" id="alter">
          <thead class="table">
            <tr>
              <th scope="col">Id</th>
              <th scope="col">Produto</th>
              <th scope="col">Preço (R$)</th>
              <th scope="col">Ações</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="produto in produtos" :key="produto.id"> 
              <th scope="row">{{produto.id}}</th>
              <td>{{produto.descricao}}</td>
              <td>{{produto.valor}}</td>
              <td>
                <div class="btn-group">
                  <a class="btn-icon" href="#"><i class="fa fa-trash"></i></a>
                  <a class="btn-icon" href="editar_produto.html"
                    ><i class="fa fa-edit"></i
                  ></a>
                </div>
              </td>
            </tr>            
          </tbody>
        </table>
       <router-link to="/produtos/insert"> <a class="btn btn-outline-color" role="button">Cadastrar novo produto</a></router-link>
       <router-link to="/"><a class="btn btn-outline-color" role="button">Voltar ao menu principal</a></router-link>

        <footer class="pt-4 my-md-5 pt-md-5 border-top"></footer>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  name: "Produtos",
  data() {
    return {      
      produtos: [],
      baseURI: "http://localhost:8080/server-anotaai/api/produtos",
    };
  },
  created: function() {
    this.getAll();
  },
  methods: {
    getAll: function() {
      this.$http.get(this.baseURI).then((result) => {
        this.produtos = result.data;
      });
    },
  },
};
</script>

<style scoped>
.home {
  background-image: url(../../img/bg.jpg);
}
table#alter thead {
  /* Toda a tabela com fundo creme */
   color: #fff;
}
.btn-outline-color {
  border-radius: 5px;
  border-color: white;
  color: white;
}
.btn-icon {
  background-color: transparent;
  color: #8b008b;
  padding: 8px 12px;
  font-size: 18px;
  border-color: transparent;
}
</style>