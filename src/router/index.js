import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import HomeCliente from '../views/HomeCliente.vue'
import CadProduto from '../views/CadastrarProduto.vue'
import CadFuncionario from '../views/CadastrarFuncionario.vue'
import CadCliente from '../views/CadastrarCliente.vue'
import CadFicha from '../views/CadastrarFicha.vue'
import Login from '../views/Login.vue'
import Produtos from '../views/Produtos.vue'
import Funcionarios from '../views/Funcionarios.vue'
import Fichas from '../views/Fichas.vue'
import Clientes from '../views/Clientes.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/home/cliente',
    name: 'HomeCliente',
    component: HomeCliente
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  }, 
  {
    path: '/produtos/insert',
    name: 'CadProduto',
    component: CadProduto
  }, 
  {
    path: '/funcionarios/insert',
    name: 'CadFuncionario',
    component: CadFuncionario
  },
  {
    path: '/clientes/insert',
    name: 'CadCliente',
    component: CadCliente
  },
  {
    path: '/fichas/insert',
    name: 'CadFicha',
    component: CadFicha
  },
  {
    path: '/produtos',
    name: 'Produtos',
    component: Produtos
  },
  {
    path: '/funcionarios',
    name: 'Funcionarios',
    component: Funcionarios
  },
  {
    path: '/fichas',
    name: 'Fichas',
    component: Fichas
  },
  {
    path: '/clientes',
    name: 'Clientes',
    component: Clientes
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
