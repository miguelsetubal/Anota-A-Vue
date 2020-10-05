<template>
<div class="home">
     <NavBarCliente/> 
<div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
        <h1 class="display-4">Bem Vindo!!!</h1>
        <p class="lead">A partir dessa aba, você poderá acessar todas as funcionalidades do sistema!</p>
    </div>

    <div class="container">
        <div class="card-deck mb-3 text-center">
            <div class="card mb-4 box-shadow">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Ficha</h4>
                </div>
                <div class="card-body">
                    <ul class="list-unstyled mt-3 mb-4">
                        <li><a href="visualizar_ficha.html">Visualizar Ficha</a></li>                       
                    </ul>                    
                </div>
            </div>
            <div class="card mb-4 box-shadow">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Perfil</h4>
                </div>
                <div class="card-body">
                    <ul class="list-unstyled mt-3 mb-4">
                        <li><a href="editar_user.html">Alterar Dados</a></li>                        
                    </ul>
                </div>
            </div>            
        </div>    
       <Footer/>
    </div>
    <br> <br>
</div>

</template>
<style scoped>
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
<script>
// @ is an alias to /src
import NavBarCliente from '@/components/NavBarCliente.vue'
import Footer from '@/components/Footer.vue'

export default {
  name: 'HomeCliente',
  components: {
    NavBarCliente,
    Footer
  }
}
</script>
<style>
.home{
    background-image: url(../../img/bg.jpg); 
}
h1,p{
    color:white
}
</style>