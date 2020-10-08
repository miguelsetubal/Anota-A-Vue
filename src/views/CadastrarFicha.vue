<template>
<div class="home">
    <Seguranca/>
<div class="row">
<div class="container">
    <br><br><br><br><br>
        <div class="card card-signin my-5">
            <div class="card-body">
                <form>
                    <div class="row">
                        <div class="col-md-12">
                            <h4 class="no-margin">Abrir Ficha</h4>
                            <hr />
                        </div>                       

                    </div>
                   
                    <div class="row">                       

                        <div class="form-group col-md-12 ">
                            <label for="cliente" class="control-label">Cliente*</label>
                            <select name="cliente" class="form-control" id="cliente" required>
                                <option>-----------Escolha um Cliente-----------</option>
                                <option v-for="cliente in clientes" :key="cliente.id" v-bind:value="cliente.id">{{cliente.nome}}</option>
                               
                                
                            </select>
                        </div>
                    </div>                    
                    <p class="aviso">Os dados marcados com (*) são obrigatórios.</p>


                    <div class="btn1">
                        <button class="btn btn-lg btn-block button-color" type="button"
                            onclick="abrir_ficha()">Abrir Ficha</button>
                    </div>

                    <div class="btn-group div-size-large">
                        <div class="div-size-small href">
                             <router-link to="/home/funcionario"><a class="btn btn-lg btn-block button-color">Menu Principal</a></router-link>
                        </div>

                        <div class="div-size-small btn2">
                            <button class="btn btn-lg btn-block button-color" type="reset">Limpar Campos</button>
                        </div>
                    </div>

                    <p class="mt-5 mb-3 text-muted">&copy; 2020</p>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
</template>

<script>
import Seguranca from '@/components/segurancaFuncionario.vue'
export default {
  name: "CadastrarFicha",
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
.home{
  background-image: url(../../img/bg.jpg); 
}
.aviso{
    color: rgb(180, 25, 25);
}

.btn1 button:hover {
    background-color: #00FF7F;
}

.btn2 button:hover {
    background-color: #A9A9A9;
}

.href a:hover{
    background-color: #00CED1;
}

.div-size-small {
    width: 50%;
}

.div-size-large {
    width: 100%;
}

.button-color {
    background-color: #8B008B;
    color: #fff;
}
</style>