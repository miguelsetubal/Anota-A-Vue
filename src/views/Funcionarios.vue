<template>
  <div class="home">
    <br/>
    <br/>
    <br/>
    <h1 class="display-4">Funcionários Cadastrados</h1>
    <div class="row">
      <div class="container">
        <table class="table table-dark" id="alter">
          <thead class="table">
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Nome</th>
              <th scope="col">Email</th>
              <th scope="col">CPF</th>
              <th scope="col">Ações</th>
            </tr>
          </thead>
          <tbody >
            <tr v-for="user in users" :key="user.id"> 
              <td>{{user.id}}</td>
              <th scope="row">{{user.nome}}</th>
              <td>{{user.email}}</td>
              <td>{{user.cpf}}</td>
              <td>
                <div class="btn-group">
                  <a class="btn-icon" href="#"><i class="fa fa-trash"></i></a>
                  <a class="btn-icon" href="home_editar_func.html"
                    ><i class="fa fa-edit"></i
                  ></a>
                </div>
              </td>
            </tr>        
           
          </tbody>
        </table>
       <router-link to="/funcionarios/insert"> <a class="btn btn-outline-color"  role="button">Cadastrar novo funcionário</a></router-link>
       <router-link to="/"> <a class="btn btn-outline-color" role="button">Voltar ao menu principal</a></router-link>
        <br><br><br><br><br><br><br><br><br><br><br>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Users",
  data() {
    return {      
      users: [],
      baseURI: "http://localhost:8080/server-anotaai/api/users",
    };
  },
  created: function() {
    this.getAllFuncionarios();
  },
  methods: {
    getAllFuncionarios: function() {
      this.$http.get(this.baseURI).then((result) => {
        this.users = result.data;
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
    background: #8b008b;
    color: #fff;
} 
.btn-outline-color{
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