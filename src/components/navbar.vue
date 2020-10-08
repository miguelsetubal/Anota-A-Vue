<template>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
        <router-link to="/home/funcionario" class="my-0 mr-md-auto font-weight-normal"><img  src="../../img/logo.png" height="45"></router-link> 
        <nav class="my-2 my-md-0 mr-md-3">
        </nav>
        <a class="btn btn-outline-primary"  @click="logout">Sair</a>
    </div>
</template>
<script>
export default {
  data() {
    return {};
  }, 
  methods: {
    logout: function() {
      localStorage.removeItem("user");
      this.$router.push({ name: "Login" });
    },
  },
};
</script>

   