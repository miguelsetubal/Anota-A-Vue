<template>
<div class="home">
        <div class="row">
            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card card-signin my-5">
                    <div class="card-body">
                        <form class="form-signin">
                            <img class="mb-4" src="../../img/logo.png" alt="" height="75">
                            <h1 class="h3 mb-3 font-weight-normal">Login</h1>
                            <label for="inputEmail" class="sr-only">Email</label>
                            <input type="email" id="email" v-model="login" class="form-control" placeholder="Email" required autofocus>
                            <label for="inputPassword" class="sr-only">Senha</label>
                            <input type="password" v-model="password" id="senha" class="form-control" placeholder="Senha" required>
                            <button class="btn btn-lg btn-primary btn-block" type="button"
                                @click="postLogin">Entrar</button>
                                <br>
                            <router-link to="/clientes/insert">Não tem uma conta? Cadastre-se aqui!</router-link>
                            <p class="mt-5 mb-3 text-muted">Anota-aí &copy; 2020</p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>    
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      login: "",
      password: "",
      baseURI: "http://localhost:8080/server-anotaai/api/users/login",
    };
  },
  created: function() {
    if(localStorage.getItem("user")) {
        this.$router.replace("/");
    } 
  },
  methods: {
    postLogin: function() {
      let obj = {
        login: this.login,
        password: this.password,
      };

      this.$http.post(this.baseURI, obj).then((result) => {
        if (result.data != "") {
          localStorage.setItem("user", JSON.stringify(result.data)); 
          const obj = JSON.parse(localStorage.getItem("user"));
          if(obj.acesso == 1){
            this.$router.push({ name: "Home" });
          }else if(obj.acesso == 2){
            this.$router.push({ name: "HomeCliente" });
          }else{
            alert("Usuário não permitido pelo Sistema");
          }     
          
        } else {
          alert("E-mail ou Senha incorretos!");
        }
      });
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
  --input-padding-y: .75rem;
}
</style>