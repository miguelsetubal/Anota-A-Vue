<script>
export default {
created: function() {
    if(localStorage.getItem("user") == null) {
        alert("Para acessar essa pagina é necessario realizar autenticação! Você sera redirecionado para a pagina de Login.");
        this.$router.push({ name: "Login" });
    } 
    const obj = JSON.parse(localStorage.getItem("user"));
    if(obj.acesso != 1){
        alert("Você não tem autorização para acessar essa pagina!");
        localStorage.removeItem("user");
        this.$router.push({ name: "Login" });
    }
  },
}
</script>