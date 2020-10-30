<template>
  <div class="home">
<div class="row">
    <div class="container">     
        <div class="card card-signin my-5">
          <div class="card-body">
            <form>
              <div class="row">
                <div class="col-md-12">
                  <h4 class="no-margin">Cadastro de Usuário</h4>
                  <hr />
                </div>

                <div class="form-group col-md-2">
                  <label for="cpf" class="control-label">CPF*</label>
                  <input
                    type="text"
                    id="cpf"
                    class="form-control"
                    name="cpf"
                    v-model="cpf"
                    required
                  />
                </div>

                <div class="form-group col-md-7 ">
                  <label for="nome" class="control-label">Nome Completo*</label>
                  <input
                    type="text"
                    id="nome"
                    class="form-control"
                    name="nome"
                    v-model="nome"
                    required
                  />
                </div>

                <div class="form-group col-md-3 ">
                  <label for="celular" class="control-label"
                    >Telefone Celular*</label
                  >
                  <input
                    type="text"
                    id="celular"
                    class="form-control"
                    name="celular"
                    v-model="telefone"
                    required
                  />
                </div>
              </div>

              <div class="row">
                <div class="form-group col-md-2 ">
                  <label for="matricula" class="control-label"
                    >Matrícula/SEAPE*
                  </label>
                  <input
                    type="text"
                    class="form-control"
                    name="matricula"
                    id="matricula"
                    v-model="matricula"
                    required
                  />
                </div>

                <div class="form-group col-md-4 ">
                  <label for="curso" class="control-label">Curso*</label>
                  <select
                    name="curso"
                    class="form-control"
                    id="curso"
                    v-model="curso"
                    required
                  >
                    <option></option>
                    <option value="Ciências da Computação"
                      >Ciências da Computação</option
                    >
                    <option value="Engenharia Ambiental"
                      >Engenharia Ambiental</option
                    >
                    <option value="Engenharia Civil">Engenharia Civil</option>
                    <option value="Engenharia de Minas"
                      >Engenharia de Minas</option
                    >
                    <option value="Sistemas de Informação"
                      >Sistemas de Informação</option
                    >
                    <option value="Sem curso"
                      >Sem curso</option
                    >
                  </select>
                </div>
                <div class="form-group col-md-4">
                  <label for="periodo" class="control-label">Periodo (sem curso, informe 99)* </label>
                  <input
                    type="number"
                    class="form-control"
                    name="periodo"
                    id="periodo"
                    v-model="periodo"
                    required
                  />
                </div>
              </div>

              <div class="row">
                <div class="form-group col-md-6 ">
                  <label for="email" class="control-label">Email*</label>
                  <input
                    type="text"
                    class="form-control"
                    name="email"
                    id="email"
                    v-model="email"
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
                    v-model="senha"
                    required
                  />
                </div>
                <div class="form-group col-md-3 ">
                  <label for="conf_senha" class="control-label"
                    >Confirme a senha*
                  </label>
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
                  @click="insertUsuario"
                >
                  Cadastrar</button
                ><br />
              </div>

              <div class="btn-group div-size-large">
                <div class="div-size-small href">
                <router-link to="/login"><a href="" class="btn btn-lg btn-block button-color">Login</a></router-link>
                </div>

                <div class="div-size-small btn2">
                  <button
                    class="btn btn-lg btn-block button-color"
                    type="reset"
                  >
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
export default {
  name: "CadUsuario",
  data: function() {
    return {
      nome: "",
      email: "",
      senha: "",
      senha: "",
      acesso: 2,
      cpf: "",
      telefone: "",
      matricula: "",
      curso: "",
      periodo: "",

      baseURI: "http://localhost:8080/api/clientes"
    };
  },
  methods: {
    insertUsuario: function() {
      let users = {
        nome: this.nome,
        email: this.email,
        senha: this.senha,
        acesso: this.acesso,
        cpf: this.cpf
      };
      let obj = {        
        telefone: this.telefone,
        matricula: this.matricula,
        curso: this.curso,
        periodo: this.periodo,
        user: users
      };
      if (this.nome.length < 10) {
        alert("Nome muito curto! Deve ter no minino 10 letras!");
      } else if (this.senha.length < 8) {
        alert("Senha muito curta, minimo 8 digitos");
      } else if(this.telefone.length < 11){
      alert("Telefone inválido! Ex de Formato: 88955555555");
      }else if(this.matricula == "" || this.periodo =="" || this.curso == ""){
        alert("Informações obrigatórias não foram preenchidas!");
      } else if (this.senha != this.csenha) {
        alert(
          "Senhas não coincidem! Assegure-se de que os campos Senha e Confirmar senha coincidem exatamente"
        );
      } else if (
        this.cpf == "" ||
        this.cpf.length < 11 ||
        this.cpf == "00000000000" ||
        this.cpf == "11111111111" ||
        this.cpf == "22222222222" ||
        this.cpf == "33333333333" ||
        this.cpf == "44444444444" ||
        this.cpf == "55555555555" ||
        this.cpf == "66666666666" ||
        this.cpf == "77777777777" ||
        this.cpf == "88888888888" ||
        this.cpf == "99999999999"
      ) {
        alert("CPF Inválido");
        add = 0;
        for (i = 0; i < 9; i++) {
          add += parseInt(this.cpf.charAt(i)) * (10 - i);
        }
        dig1 = (add * 10) % 11;
        add = 0;
        for (i = 0; i < 10; i++) {
          add += parseInt(this.cpf.charAt(i)) * (11 - i);
        }
        dig2 = (add * 10) % 11;
        if (this.cpf.charAt("9") != dig1 && this.cpf.charAt("10") != dig2) {
          alert("CPF inválido.");
        }
      } else if (this.email.length == 0 || this.email.indexOf("@") == -1) {
        alert("Preencha o campo E-mail corretamente");
      } else {
        this.$http.post(this.baseURI, obj).then(result => {
           if (result.data != "") {
          alert("Cadastro realizado com sucesso!");
            this.$router.push({ name: "Login" });
           }
        });
      }
    }
  }
};
</script>

<style >
.home {
  background-image: url(../../img/bg.jpg);
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