<template>
  <div class="home">
    <Seguranca />
    <br />
    <br />
    <br />
    <h1 class="display-4">Produtos Cadastrados</h1>
    <div class="form-group col-md-12">
          <input type="number" class="form-control"  placeholder="Limitar Exibição" v-model="qtd" />
          <button class="btn btn-outline-color" @click="fetchUserByQtd">Listar</button>
          <button class="btn btn-outline-color" @click="getAll">Todos</button>
        </div>
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
              <th scope="row">{{ produto.id }}</th>
              <td>{{ produto.descricao }}</td>
              <td>{{ produto.valor }}</td>
              <td>
                <div class="btn-group">
                  <button
                    class="btn-icon"
                    @click="deleteProdutoById(produto.id)"
                  >
                    <i class="fa fa-trash"></i>
                  </button>
                  <button
                    class="btn-icon"
                    @click="
                      $router.push({
                        name: 'ProdutoEdit',
                        params: { id: produto.id }
                      })
                    "
                  >
                    <i class="fa fa-edit"></i>
                  </button>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
        
        <router-link to="/produtos/insert">
          <a class="btn btn-outline-color" role="button"
            >Cadastrar novo produto</a
          ></router-link
        >
        <router-link to="/home/funcionario"
          ><a class="btn btn-outline-color" role="button"
            >Voltar ao menu principal</a
          ></router-link
        >

        <footer class="pt-4 my-md-5 pt-md-5 border-top"></footer>
      </div>
    </div>
  </div>
</template>


<script>
import Seguranca from "@/components/segurancaFuncionario.vue";
export default {
  name: "Produtos",
  components: {
    Seguranca
  },
  data() {
    return {
      produtos: [],
      baseURI: "http://localhost:8080/api/produtos"
    };
  },
  created: function() {
    this.getAll();
  },
  methods: {
    getAll: function() {
      this.$http.get(this.baseURI).then(result => {
        this.produtos = result.data;
      });
    },
    deleteProdutoById: function(id) {
      this.$http.delete(this.baseURI + "/" + id).then(result => {
        alert("Produto excluido com sucesso!");
        this.getAll();
      });
    },
    fetchUserByQtd: function() {
      this.$http
        .get(this.baseURI + "/search2?qtd=" + this.qtd)
        .then(result => {
          this.produtos = result.data;
        })
        .catch(function(error) {
          console.log(error);
        });
    }
  }
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