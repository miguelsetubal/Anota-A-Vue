<template>
<div class="home">
  <Seguranca/>
<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
        <h1 class="display-4">Usuários Cadastrados</h1>
       
    </div>
    <div class="container">
        <table class="table table-dark" id="alter">
            <thead class="table">
                <tr>
                   <th scope="col">ID</th>
                    <th scope="col">Nome</th>
                    <th scope="col">CPF</th>
                    <th scope="col">Telefone</th>
                    <th scope="col">Matrícula/SIAPE</th>
                    <th scope="col">Curso</th>
                    <th scope="col">Email</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="cliente in clientes" :key="cliente.id">
                   <td>{{cliente.id}}</td>
                    <th scope="row">{{cliente.nome}}</th>
                    <td>{{cliente.cpf}}</td>
                    <td>{{cliente.telefone}}</td>
                    <td>{{cliente.matricula}}</td>
                    <td>{{cliente.curso}}</td>
                    <td>{{cliente.email}}</td>
                </tr>                
            </tbody>
        </table>
        <router-link to="/home/funcionario"> <a class="btn btn-outline-color"  role="button">Voltar</a></router-link>
    
    </div>
    <br><br><br><br><br><br><br><br><br><br><br>
</div>
</template>

<script>
import Seguranca from '@/components/segurancaFuncionario.vue'
export default {
  name: "Clientes",
  components: {    
    Seguranca
  },
  data() {
    return {      
      clientes: [],
      baseURI: "http://localhost:8080/server-anotaai/api/clientes",
    };
  },
  created: function() {
    this.getAllClientes();
  },
  methods: {
    getAllClientes: function() {
      this.$http.get(this.baseURI).then((result) => {
        this.clientes = result.data;
      });
    },
  },
};
</script>

<style scoped>
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