<template>
  <div class="home" >  
      <NavBar/> 
     <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
        <h1 class="display-4" >Bem Vindo!!!</h1>
        <p class="lead">A partir dessa aba, você poderá acessar todas as funcionalidades do sistema!</p>
   

    <div class="container">
        <div class="card-deck mb-3 text-center">
            <div class="card mb-4 box-shadow">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Produtos</h4>
                </div>
                <div class="card-body">
                    <ul class="list-unstyled mt-3 mb-4">
                        <li><router-link to="/produtos/insert">Cadastrar Produto</router-link></li>
                        <li><router-link to="/produtos">Lista de Produtos</router-link></li>
                    </ul>
                </div>
            </div>
            <div class="card mb-4 box-shadow">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Funcionários</h4>
                </div>
                <div class="card-body">
                    <ul class="list-unstyled mt-3 mb-4">
                       <li><router-link to="/funcionarios/insert">Cadastrar Funcionário</router-link></li>
                        <li><router-link to="/funcionarios">Lista de Funcionários</router-link></li>
                    </ul>
                </div>
            </div>
            <div class="card mb-4 box-shadow">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Fichas</h4>
                </div>
                <div class="card-body">
                    <ul class="list-unstyled mt-3 mb-4">
                        <li><router-link to="/fichas/insert">Abrir Nova Ficha</router-link></li>
                        <li><router-link to="/fichas">Fichas em Aberto</router-link></li>
                    </ul>
                </div>
            </div>
            <div class="card mb-4 box-shadow">
                <div class="card-header">
                    <h4 class="my-0 font-weight-normal">Clientes</h4>
                </div>
                <div class="card-body">
                    <ul class="list-unstyled mt-3 mb-4">
                        <li><router-link to="/clientes">Lista de  Clientes</router-link></li>
                        
                    </ul>
                </div>
            </div>
        </div>
        <Footer/>
        
    </div> 
  </div>
   </div>
</template>

<script>
// @ is an alias to /src
import NavBar from '@/components/navbar.vue'
import Footer from '@/components/Footer.vue'
export default {
  name: 'Home',
  components: {
    NavBar,
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
