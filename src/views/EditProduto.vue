<template>
<div class="home">  
  <Seguranca/>
<div class="row">
  <div class="container">
    <div class="card card-signin my-5">
      <div class="card-body">
        <form>
          <div class="row">
            <div class="col-md-12">
              <h4 class="no-margin">Editar Produto</h4>
              <hr />
            </div>

            <div class="form-group col-md-12">
              <label for="nome" class="control-label">Descrição*</label>
              <input
                type="text"
                id="nome"
                class="form-control"
                name="nome"
                v-model="produto.descricao"
                required
              />
            </div>
            <div class="form-group col-md-12">
              <label for="nome" class="control-label"
                >Valor*</label
              >
              <input
                type="number"
                id="cpf"
                class="form-control"
                name="cpf"
                v-model="produto.valor"
                required
              />
            </div>
          </div>

          <p class="aviso">Os dados marcados com (*) são obrigatórios.</p>

          <div class="btn1">
            <button
              class="btn btn-lg btn-block button-color"
              type="button"
              @click="editProduto"
            >
              Salvar Edição</button
            ><br />
          </div>

          <div class="btn-group div-size-large">
            <div class="div-size-small href">
              <router-link to="/produtos"
                ><a class="btn btn-lg btn-block button-color"
                  >Cancelar</a
                ></router-link
              >
            </div>

            <div class="div-size-small btn2">
              <button class="btn btn-lg btn-block button-color" type="reset">
                Limpar Campos
              </button>
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
  name: "EditProduto",
  props: ["id"],
  components: {    
    Seguranca
  },
  data: function() {
    return {
      produto: {},     
      baseURI: "http://localhost:8080/api/produtos",
    };
  },
  created: function() {
    this.$http
      .get(this.baseURI + "/" + this.id)
      .then((result) => {
        this.produto = result.data;
      })
      .catch(function(error) {
        console.log(error);
      });
  },
  methods: {
    editProduto: function() {
      let obj = {
        descricao: this.produto.descricao,
        valor: this.produto.valor,
        
      };
     if(this.produto.valor <= 0 || this.produto.descricao.length <3){
        alert("Preço não pode ser R$0 ou -R$. A descrição deve ter no minino 3 letras!");
      }else{
      this.$http.put(this.baseURI + "/" + this.id, obj).then((result) => {
          alert("Produto editado com sucesso");
        this.$router.push({ name: 'Produtos'});
      });
      }
    },
  },
};
</script>
<style>
.home{
  background-image: url(../../img/bg.jpg); 
}
.layout-form-title {
  font-size: 40px;
  color: #fff;
  line-height: 1.2;
  text-align: center;

  display: block;
  position: absolute;
  width: 100%;
  top: 0;
  left: 0;
  background-color: #8B008B;
  padding-top: 50px;
  padding-bottom: 39px;
  border-top-right-radius: 10px;
  border-top-left-radius: 10px;
}
.font-config{
  font-size: large;
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
.div-btn1 button:hover {
  background-color: #00FF7F;
}
.div-btn2 button:hover {
  background-color: #A9A9A9;
}
.div-href a:hover{
  background-color: #00CED1;
}
.form-signin {
  width: 800px;
  padding: 100px;
  height: auto;
  margin: auto;
}
.form-signin .form-control {
  position: relative;
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 18px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.card-signin {
  border: 0;
  border-radius: 1rem;
  box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
}
.card-signin .card-body {
  padding: 2rem;
}
:root {
  --input-padding-x: 1.5rem;
  --input-padding-y: .75rem;
}
</style>