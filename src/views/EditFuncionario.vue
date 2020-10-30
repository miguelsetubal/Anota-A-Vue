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
              <h4 class="no-margin">Editar Funcionário</h4>
              <hr />
            </div>

            <div class="form-group col-md-8">
              <label for="nome" class="control-label">Nome Completo*</label>
              <input
                type="text"
                id="nome"
                class="form-control"
                name="nome"
                v-model="func.nome"
                required
              />
            </div>
            <div class="form-group col-md-4">
              <label for="nome" class="control-label"
                >CPF (Somente Numeros)*</label
              >
              <input
                type="text"
                id="cpf"
                class="form-control"
                name="cpf"
                v-model="func.cpf"
                required
              />
            </div>
          </div>

          <div class="row">
            <div class="form-group col-md-6 ">
              <label for="email" class="control-label">Email*</label>
              <input
                type="email"
                class="form-control"
                name="email"
                id="email"
                v-model="func.email"
                required
              />
            </div>
            <div class="form-group col-md-3 ">
              <label for="senha" class="control-label">Senha* </label>
              <input
                type="password"
                class="form-control"
                name="senha"
                id="senha"
                v-model="func.senha"
                required
              />
            </div>
            <div class="form-group col-md-3 ">
              <label for="conf_senha" class="control-label"
                >Confirme a senha</label
              >
              <input
                type="password"
                class="form-control"
                name="conf_senha"
                id="conf_senha"
                v-model="csenha"
                required
              />
            </div>
          </div>
          <p class="aviso">Os dados marcados com (*) são obrigatórios.</p>

          <div class="btn1">
            <button
              class="btn btn-lg btn-block button-color"
              type="button"
              @click="editFuncionario"
            >
              Salvar</button
            ><br />
          </div>

          <div class="btn-group div-size-large">
            <div class="div-size-small href">
              <router-link to="/funcionarios"
                ><a class="btn btn-lg btn-block button-color"
                  >Voltar</a
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
  name: "EditFuncionario",
   props: ["id"],
  components: {    
    Seguranca
  },
  data: function() {
    return {
      func: {},
      baseURI: "http://localhost:8080/api/users"
    };
  },
  created: function() {
    this.$http
      .get(this.baseURI + "/" + this.id)
      .then((result) => {
        this.func = result.data;
      })
      .catch(function(error) {
        console.log(error);
      });
  },
   methods: {
    editFuncionario: function() {
      let obj = {
        nome: this.func.nome,
        cpf: this.func.cpf,
        email: this.func.email,
        senha: this.func.senha,
        acesso: 1,
        
      };

      if (this.func.nome.length < 10) {
        alert("Nome muito curto! Deve ter no minino 10 letras!");
      } else if (this.func.senha.length < 8) {
        alert("Senha muito curta, minimo 8 digitos");
      } else if (this.func.senha != this.csenha) {
        alert(
          "Senhas não coincidem! Assegure-se de que os campos Senha e Confirmar senha coincidem exatamente"
        );
      } else if (
        this.func.cpf.length < 11 ||
        this.func.cpf == "00000000000" ||
        this.func.cpf == "11111111111" ||
        this.func.cpf == "33333333333" ||
        this.func.cpf == "44444444444" ||
        this.func.cpf == "55555555555" ||
        this.func.cpf == "66666666666" ||
        this.func.cpf == "77777777777" ||
        this.func.cpf == "88888888888" ||
        this.func.cpf == "99999999999") {
        alert("CPF Inválido");
        add = 0;
        for (i = 0; i < 9; i++) {
          add += parseInt(this.func.cpf.charAt(i)) * (10 - i);
        }
        dig1 = (add * 10) % 11;
        add = 0;
        for (i = 0; i < 10; i++) {
          add += parseInt(this.func.cpf.charAt(i)) * (11 - i);
        }
        dig2 = (add * 10) % 11;
        if (this.func.cpf.charAt("9") != dig1 && this.cpf.charAt("10") != dig2) {
          alert("CPF inválido.");
        }
        }else if(this.func.email.length == 0 || this.func.email.indexOf('@') == -1){
           alert("Preencha o campo E-mail corretamente")
        }else{

      this.$http.put(this.baseURI + "/" + this.id, obj).then((result) => {
          alert("Funcionário editado com sucesso");
        this.$router.push({ name: 'Funcionarios'});
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
.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}
.form-signin .checkbox {
  font-weight: 400;
}
.form-signin .form-control {
  position: relative;
  box-sizing: border-box;
  height: auto;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
.card-signin {
  border: 0;
  border-radius: 1rem;
  box-shadow: 0 0.5rem 1rem 0 rgba(0, 0, 0, 0.1);
}

.card-signin .card-title {
  margin-bottom: 2rem;
  font-weight: 300;
  font-size: 1.5rem;
}

.card-signin .card-body {
  padding: 2rem;
}
:root {
  --input-padding-x: 1.5rem;
  --input-padding-y: 0.75rem;
}
.aviso {
  color: rgb(180, 25, 25);
}

.btn1 button:hover {
  background-color: #00ff7f;
}

.btn2 button:hover {
  background-color: #a9a9a9;
}

.href a:hover {
  background-color: #00ced1;
}

.div-size-small {
  width: 50%;
}

.div-size-large {
  width: 100%;
}

.button-color {
  background-color: #8b008b;
  color: #fff;
}
</style>