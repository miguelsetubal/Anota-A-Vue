<template>
  <div class="home">
      <div class="row">
   
    <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
      <h1 class="display-4">Fichas em Aberto</h1>

      <label class="sr-only" for="inlineFormInputGroup">Buscar</label>
      <div class="input-group mb-2">
        <input
          type="text"
          class="form-control"
          id="inlineFormInputGroup"
          placeholder="Buscar"
        />
      </div>
    </div>

    <div class="container">
      <div class="card-deck mb-3 text-center">        
        <div class="card mb-4 box-shadow" v-for="ficha in fichas" :key="ficha.id">
          <a href="ficha_add.html">
            <div class="card-header">
              <h4 class="my-0 font-weight-normal">Nº {{ficha.id}}</h4>
            </div>
          </a>
          <div class="card-body">
            <ul class="list-unstyled mt-3 mb-4">
              <li><strong>{{ficha.id_cliente}}</strong></li>
              <li>{{ficha.data}}</li>
              <li></li>
            </ul>
          </div>
        </div> 
      </div>
     <router-link to="/home/funcionario"> <a class="btn btn-outline-color"  role="button">Voltar</a></router-link>
      <footer class="pt-4 my-md-5 pt-md-5 border-top"></footer>
    </div>
  </div>
  </div>
</template>

<script>
import Seguranca from '@/components/segurancaFuncionario.vue'
export default {
  name: "Fichas",
  components: {    
    Seguranca
  },
  data() {
    return {      
      fichas: [],
      baseURI: "http://localhost:8080/api/fichas",
    };
  },
  created: function() {
    this.getAllFicha();
  },
  methods: {
    getAllFicha: function() {
      this.$http.get(this.baseURI).then((result) => {
        this.fichas = result.data;
      });
    },    
  },
};
</script>
<style scoped>
.container {
  max-width: 960px;
}

.pricing-header {
  max-width: 700px;
}

.card-deck .card {
  min-width: 220px;
}

.border-top { border-top: 1px solid #e5e5e5; }
.border-bottom { border-bottom: 1px solid #e5e5e5; }

.box-shadow { box-shadow: 0 .25rem .75rem rgba(0, 0, 0, .05); }

table#alter thead { /* Toda a tabela com fundo creme */
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