<template>
<div class="home">
<div class="row">
<div class="container">
    <br><br><br><br><br>
        <div class="card card-signin my-5">
            <div class="card-body">
                <form>
                    <div class="row">
                        <div class="col-md-12">
                            <h4 class="no-margin">Abrir Ficha</h4>
                            <hr />
                        </div>                       

                    </div>
                   
                    <div class="row">                       

                        <div class="form-group col-md-12 ">
                            <label for="cliente" class="control-label">Cliente*</label>
                            <select name="cliente" class="form-control" id="cliente" required>
                                <option></option>
                                <option value='Miguel Jonas Lima Setúbal'>Miguel Jonas Lima Setúbal</option>
                                <option value='Isa Raquel Costas de Freitas'>Isa Raquel Costas de Freitas</option>
                                <option value='Francisca Isabelle de Almeida Cruz'>Francisca Isabelle de Almeida Cruz</option>
                                
                            </select>
                        </div>
                    </div>                    
                    <p class="aviso">Os dados marcados com (*) são obrigatórios.</p>


                    <div class="btn1">
                        <button class="btn btn-lg btn-block button-color" type="button"
                            onclick="abrir_ficha()">Abrir Ficha</button>
                    </div>

                    <div class="btn-group div-size-large">
                        <div class="div-size-small href">
                             <router-link to="/"><a class="btn btn-lg btn-block button-color">Menu Principal</a></router-link>
                        </div>

                        <div class="div-size-small btn2">
                            <button class="btn btn-lg btn-block button-color" type="reset">Limpar Campos</button>
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

<style scoped>
.home{
  background-image: url(../../img/bg.jpg); 
}
.aviso{
    color: rgb(180, 25, 25);
}

.btn1 button:hover {
    background-color: #00FF7F;
}

.btn2 button:hover {
    background-color: #A9A9A9;
}

.href a:hover{
    background-color: #00CED1;
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
</style>