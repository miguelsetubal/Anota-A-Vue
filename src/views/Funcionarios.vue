<template>
  <div class="home">
   <Seguranca/>
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
                 <button class="btn-icon" @click="deleteUserById(user.id)"><i class="fa fa-trash"></i></button>
                  <button class="btn-icon" @click="$router.push({ name: 'FuncEdit', params: { id: user.id } })"><i class="fa fa-edit"></i></button>
                </div>
              </td>
            </tr>        
           
          </tbody>
        </table>
        
       <router-link to="/funcionarios/insert"> <a class="btn btn-outline-color"  role="button">Cadastrar novo funcionário</a></router-link>
       <router-link to="/home/funcionario"> <a class="btn btn-outline-color" role="button">Voltar ao menu principal</a></router-link>
     
      </div>
      <div class="form-group col-md-12">
         <br>
          <input type="text" class="form-control"  placeholder="Buscar por CPF" v-model="cpf" />
          <button class="btn btn-outline-color" @click="fetchFuncByCPF">Buscar</button>
          <button class="btn btn-outline-color" @click="getAllFuncionarios">Todos</button>
           <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br>
        </div>
    </div>
    
  </div>
  
</template>

<script>
import Seguranca from '@/components/segurancaFuncionario.vue'
export default {
  name: "Users",
  components: {    
    Seguranca
  },
  data() {
    return {      
      users: [],
      baseURI: "http://localhost:8080/api/users",
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
    deleteUserById: function(id) {
      this.$http.delete(this.baseURI + "/" + id).then((result) => {
        alert("Funcionario excluido com sucesso!")
        this.getAllFuncionarios();
      });
    },
    fetchFuncByCPF: function() {
      this.$http
        .get(this.baseURI + "/search?cpf=" + this.cpf)
        .then(result => {
          this.users = result.data;
        })
        .catch(function(error) {
          console.log(error);
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