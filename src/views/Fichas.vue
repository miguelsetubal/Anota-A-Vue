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
        <div class="card mb-4 box-shadow">
          <a href="ficha_add.html">
            <div class="card-header">
              <h4 class="my-0 font-weight-normal">Nº 01</h4>
            </div>
          </a>
          <div class="card-body">
            <ul class="list-unstyled mt-3 mb-4">
              <li><strong>Miguel Jonas Lima Setúbal</strong></li>
              <li>Curso: SI</li>
              <li>Matricula: 010101</li>
            </ul>
          </div>
        </div>
        <div class="card mb-4 box-shadow">
          <div class="card-header">
            <a href="ficha_add.html"
              ><h4 class="my-0 font-weight-normal">Nº 02</h4></a
            >
          </div>
          <div class="card-body">
            <ul class="list-unstyled mt-3 mb-4">
              <li><strong>Isa Raquel Costa de Freitas</strong></li>
              <li>Curso: SI</li>
              <li>Matricula: 020202</li>
            </ul>
          </div>
        </div>
        <div class="card mb-4 box-shadow">
          <div class="card-header">
            <a href="ficha_add.html"
              ><h4 class="my-0 font-weight-normal">Nº 03</h4></a
            >
          </div>
          <div class="card-body">
            <ul class="list-unstyled mt-3 mb-4">
              <li><strong>Francisca Isabelle de Alemida Cruz</strong></li>
              <li>Curso: SI</li>
              <li>Matricula: 030303</li>
            </ul>
          </div>
        </div>
      </div>
     <router-link to="/"> <a class="btn btn-outline-color"  role="button">Voltar</a></router-link>
      <footer class="pt-4 my-md-5 pt-md-5 border-top"></footer>
    </div>
  </div>
  </div>
</template>
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